package org.gemoc.execution.engine.core;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.capabilitites.ModelExecutionTracingCapability;
import org.gemoc.execution.engine.commons.deciders.CcslSolverDecider;
import org.gemoc.execution.engine.commons.dsa.DefaultClockController;
import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.commons.dsa.IAliveClockController;
import org.gemoc.execution.engine.core.impl.GemocModelDebugger;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngineCapability;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.dsa.IClockController;
import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponent;
import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponentExtension;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.When;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.IDSLDebugger;

/**
 * Basic abstract implementation of the ExecutionEngine, independent from the
 * technologies used for the solver, the executor and the feedback protocol. It
 * can display the runtime execution information to its registered observers.
 * 
 * There are two phases of initializations for this entity:
 * <ul>
 * <li>the constructor sets the language-specific elements such as
 * DomainSpecificEvents, Solver, EventExecutor, FeedbackPolicy</li>
 * <li>the initialize method sets the model-specific elements such as Model and
 * ModelLoader.</li>
 * </ul>
 * From the Model, we can derive :
 * <ul>
 * <li>the Model of Execution (using the DomainSpecificEvents)</li>
 * <li>the Higher-order-transformation (TODO)) and the Solver Input (using the
 * Model of Execution and the Solver Input Builder provided by the Solver).</li>
 * </ul>
 * 
 * There are a few elements that could enter the ExecutionEngine, maybe after
 * being reified as their own data structures:
 * <ul>
 * <li>{@link #scheduledSteps} is the FIFO of LogicalSteps. We use a FIFO
 * because sometimes we may want to memorize steps in order to go back in the
 * past and replay given steps. When the engine seeks to reach the next step of
 * execution, it will first check if there is something in this FIFO. If there
 * is not, then a new step is requested from the solver.</li>
 * <li>{@link #schedulingTrace} is a map recording the order in which the steps
 * of the solver have been used.</li>
 * <li>{@link #scheduledEventsMap} records which step is linked to which list of
 * MSEs. It is to be noticed that not all the MSEs were executed. Indeed, some
 * may have been illegal at the time (with regards to the MoC) and thus
 * discarded during the execution of this step.</li>
 * <li>{@link #executionTrace} records the steps and the actual MSEs that were
 * actually executed.</li>
 * </ul>
 * 
 * @see GemocExecutionEngine
 * 
 * @author flatombe
 * @author didier.vojtisek@inria.fr
 * @param <T>
 * 
 */
public class ObservableBasicExecutionEngine extends Observable implements GemocExecutionEngine {

	private IDSLDebugger _debugger;

	private IGemocModelAnimator 	animator;

	private boolean _started = false;
	private boolean terminated = false;

	protected EngineStatus engineStatus = new EngineStatus();

	/**
	 * used to detect
	 */
	protected ArrayDeque<LogicalStep> _lastStepsRun;

	/**
	 * Given at the language-level initialization.
	 */

	protected ILogicalStepDecider _logicalStepDecider = null;

	public ILogicalStepDecider getLogicalStepDecider() {
		return _logicalStepDecider;
	}

	private IExecutionContext _executionContext;

	private IAliveClockController _clockController;
	
	/**
	 * The constructor takes in all the language-specific elements. Creates the
	 * internal map of Domain-Specific Events and initializes the languages used
	 * for execution.
	 * 
	 * @param domainSpecificEventsResource
	 *            cannot be null
	 * @param solver
	 *            cannot be null
	 * @param executor
	 *            cannot be null
	 * @param feedbackPolicy
	 *            can be null (for now).
	 * @param isTraceActive 
	 * @param _executionContext
	 */
	public ObservableBasicExecutionEngine(ILogicalStepDecider decider, ModelExecutionContext executionContext) {
		//		if (decider == null)
		//			throw new IllegalArgumentException("decider");
		if (executionContext == null)
			throw new IllegalArgumentException("executionContext");

		_executionContext = executionContext;
		_lastStepsRun = new ArrayDeque<LogicalStep>(getDeadlockDetectionDepth());
		_executionContext.getEventExecutor().initialize();
		_logicalStepDecider = decider;
		if (_logicalStepDecider == null) 
		{
			_logicalStepDecider = new CcslSolverDecider();
		}

		for(IClockController clockController: _executionContext.getClockControllers())
		{
			if (clockController instanceof IAliveClockController)
				addClockController((IAliveClockController)clockController);
		}
		_clockController = new DefaultClockController();
		addClockController(_clockController);

		if (_executionContext.getRunConfiguration().isTraceActive())
			activateTrace();

		try {
			initialize();
		} catch (CoreException e) {
			throw new EngineNotCorrectlyInitialized(e.getMessage(), e);
		}
	}
	
	private void initialize() throws CoreException {

		for (IAliveClockController injector : _clockControllers)
		{
			EventInjectionContext context = new EventInjectionContext(_executionContext.getSolver());
			injector.initialize(context);
			injector.start();
		}	

		for (IDataProcessingComponentExtension extension : _executionContext.getRunConfiguration().getActivatedComponentExtensions())
		{
			IDataProcessingComponent component = extension.instanciateComponent();
			_executionComponents.add(component);
			component.initialize(this);
		}	

		Activator.getDefault().info("*** Engine initialization done. ***");
	}

	private ArrayList<IDataProcessingComponent> _executionComponents = new ArrayList<>();

	private void activateTrace() {
		ModelExecutionTracingCapability capability = capability(ModelExecutionTracingCapability.class);
		capability.setModelExecutionContext(_executionContext);
	}

	
	private EngineRunnable _runnable;
	@Override
	public void start() 
	{
		if (!_started) 
		{
			for (IEngineHook hook : _executionContext.getHooks()) 
			{
				hook.preStartEngine(this);
			}
			engineStatus.setNbLogicalStepRun(0);
			_runnable = new EngineRunnable();
			Thread mainThread = new Thread(_runnable, "Gemoc engine " + _executionContext.getRunConfiguration().getModelURIAsString());
			mainThread.start();
		}

	}

	@Override
	public void stop() 
	{
		_logicalStepDecider.dispose();
		terminated = true;
		for (IEngineHook hook : _executionContext.getHooks()) 
		{
			hook.postStopEngine(this);
		}
	}

	private void clean() {
		if (_executionContext.getDebuggerViewModelPath() != null
				&& !_executionContext.getDebuggerViewModelPath().toString().equals(""))
		{
			URI uri = URI.createPlatformResourceURI(_executionContext.getDebuggerViewModelPath().toOSString(), true);
			Session session = SessionManager.INSTANCE.getSession(uri, new NullProgressMonitor());			
			session.close(new NullProgressMonitor());
			SessionManager.INSTANCE.remove(session);
		}
		for (IAliveClockController injector : _clockControllers)
		{
			injector.stop();
		}
		_clockControllers.clear();		
		_executionContext.dispose();
		_logicalStepDecider.dispose();

		if (animator != null) {
			animator.clear(this);
		}

		for (IDataProcessingComponent component : _executionComponents)
		{
			component.dispose();
		}

		getEngineStatus().getCurrentLogicalStepChoice().clear();
		getEngineStatus().setChosenLogicalStep(null);
	}

	public EngineStatus getEngineStatus() {
		return engineStatus;
	}

	private static boolean areLogicalStepSimilar(LogicalStep ls1, LogicalStep ls2) {
		if (ls1 == ls2)
			return true;

		List<String> ls1TickedEventOccurences = new ArrayList<String>();
		for (Event event : LogicalStepHelper.getTickedEvents(ls1)) {
			ls1TickedEventOccurences.add(event.getName());
		}
		List<String> ls2TickedEventOccurences = new ArrayList<String>();
		for (Event event : LogicalStepHelper.getTickedEvents(ls2)) {
			ls2TickedEventOccurences.add(event.getName());
		}

		if (ls1TickedEventOccurences.size() == ls2TickedEventOccurences.size()) {
			if (ls1TickedEventOccurences.containsAll(ls2TickedEventOccurences)) {
				return true;
			}
		}
		return false;
	}

	class EngineRunnable implements Runnable {
		
		public void run() {
			// register this engine using a unique name
			String engineName = Thread.currentThread().getName();
			engineName = Activator.getDefault().gemocRunningEngineRegistry.registerEngine(engineName, ObservableBasicExecutionEngine.this);

			if (_debugger != null) {
				// connect the debugger to the model being executed (including
				// dynamic data)
				_debugger.spawnRunningThread(Thread.currentThread().getName(), _executionContext.getResourceModel().getContents().get(0));
			}
			engineStatus.setRunningStatus(EngineStatus.RunStatus.Running);
			setChanged();
			notifyObservers("Starting " + engineName);
			long count = 0;
			
			try 
			{
				while (!terminated) 
				{
					switchDeciderIfNecessary();
					if (hasCapability(ModelExecutionTracingCapability.class))
						updateTraceModelBeforeAskingSolver(count);
									
					computePossibleLogicalSteps();
					updatePossibleLogicalSteps();
					// 2- select one solution from available logical step /
					// select interactive vs batch
					int selectedLogicalStepIndex;
					if (_possibleLogicalSteps.size() == 0) {
						Activator.getDefault().debug("No more LogicalStep to run");
						terminated = true;
					} else {
						Activator.getDefault().debug("\t\t ---------------- LogicalStep " + count);
						engineStatus.setRunningStatus(EngineStatus.RunStatus.WaitingLogicalStepSelection);
						notifyEngineHasChanged();
						selectedLogicalStepIndex = _logicalStepDecider.decide(ObservableBasicExecutionEngine.this, _possibleLogicalSteps);
						count++;

						if (selectedLogicalStepIndex == -1) {
							if (hasRewindHappened()) {
								//								getCapability(ModelExecutionTracingCapability.class).getLastChoice();
								Activator.getDefault().debug("Back to past happened --> let the engine ignoring current steps.");
							} else {
								Activator.getDefault().debug("Engine cannot continue because decider did not decide anything.");
								terminated = true;
							}
						} else {
							engineStatus.setChosenLogicalStep(_possibleLogicalSteps.get(selectedLogicalStepIndex));
							engineStatus.setRunningStatus(EngineStatus.RunStatus.Running);
							if (hasCapability(ModelExecutionTracingCapability.class))
								updateTraceModelAfterDeciding(selectedLogicalStepIndex);

							notifyEngineHasChanged();
							for (IEngineHook hook : _executionContext.getHooks()) 
							{
								hook.postLogicalStepSelection(ObservableBasicExecutionEngine.this);
							}

							// 3 - run the selected logical step
							final LogicalStep logicalStepToApply = _possibleLogicalSteps.get(selectedLogicalStepIndex);
							// inform the solver that we will run this step
							_executionContext.getSolver().applyLogicalStepByIndex(selectedLogicalStepIndex);
							// run all the event occurrences of this logical
							// step
							executeLogicalStep(logicalStepToApply);
							// if not debugging wait if needed
							applyAnimationTime();
							terminateIfLastStepsSimilar(logicalStepToApply);
						}
					}

					notifyEngineHasChanged();
					engineStatus.incrementNbLogicalStepRun();
				} 
			} catch (Throwable e) {
				Activator.getDefault().error("Exception received " + e.getMessage() + ", stopping engine.", e);
				terminated = true;
			}
			finally {
				clean();
			}

			// inform the debugger UI that the thread is terminated
			if (_debugger != null && !_debugger.isTerminated(Thread.currentThread().getName())) {
				_debugger.terminated(Thread.currentThread().getName());
				setDebugger(null); // make sure to release handles
			}

			engineStatus.setRunningStatus(EngineStatus.RunStatus.Stopped);
			ObservableBasicExecutionEngine.this.setChanged();
			ObservableBasicExecutionEngine.this.notifyObservers("Stopping " + engineName);
		}



		private void applyAnimationTime() throws InterruptedException {
			int animationDelay = _executionContext.getRunConfiguration().getAnimationDelay();								
			if (animationDelay != 0) 
			{
				Thread.sleep(animationDelay);
			}
		}

		private boolean hasRewindHappened() {
			if (hasCapability(ModelExecutionTracingCapability.class)) {
				return capability(ModelExecutionTracingCapability.class).hasRewindHappened(true);
			}
			return false;
		}

		private void terminateIfLastStepsSimilar(final LogicalStep logicalStepToApply) {
			// if all lastStepsRun are the same, then we may have reached the
			// end of the simulation
			_lastStepsRun.add(logicalStepToApply);
			boolean allLastLogicalStepAreTheSame = true;
			for (LogicalStep logicalStep : _lastStepsRun) {
				allLastLogicalStepAreTheSame = allLastLogicalStepAreTheSame && areLogicalStepSimilar(logicalStep, logicalStepToApply);
			}
			if ((_lastStepsRun.size() >= getDeadlockDetectionDepth()) && allLastLogicalStepAreTheSame) {
				Activator.getDefault().debug("Detected " + getDeadlockDetectionDepth() + " identical LogicalStep, stopping engine");
				terminated = true;
			}
			// if queue is full, remove one
			if (_lastStepsRun.size() > getDeadlockDetectionDepth())
				_lastStepsRun.poll();
		}

	}

	private void notifyEngineHasChanged() {
		ObservableBasicExecutionEngine.this.setChanged();
		ObservableBasicExecutionEngine.this.notifyObservers(); 
	}

	private int getDeadlockDetectionDepth() 
	{
		return _executionContext.getRunConfiguration().getDeadlockDetectionDepth();
	}
	/**
	 * run all the event occurrences of this logical step
	 * 
	 * @param logicalStepToApply
	 */
	private void executeLogicalStep(LogicalStep logicalStepToApply) {
		// = step in debug mode, goes to next logical step
		// -> run all event occurrences of the logical step
		// step into / open internal thread and pause them
		// each concurrent event occurrence is presented as a separate
		// thread in the debugger
		// execution feedback is sent to the solver so it can take internal
		// event into account

		if (_debugger != null) {
			terminated = !_debugger.control(Thread.currentThread().getName(), logicalStepToApply);
		}

		if (animator != null) {
			animator.activate(this, logicalStepToApply);
		}

		ArrayList<ModelSpecificEvent> mses = new ArrayList<ModelSpecificEvent>();
		for (Event event : LogicalStepHelper.getTickedEvents(logicalStepToApply))
		{
			for (ModelSpecificEvent mse : _executionContext.getFeedbackModel().getEvents())
			{
				if (mse.getName().replace("MSE_", "").equals(event.getName().replace("evt_", "")))
				{
					mses.add(mse);
					break;
				}
			}
		}
		
		for (final ModelSpecificEvent mse : mses) 
		{
			if (_debugger != null) 
			{
				terminated = !_debugger.control(Thread.currentThread().getName(), mse.getCaller());
			}
			executeAssociatedActions(mse);
			executeModelSpecificEvent(mse);
		}
	}
	
	private void executeAssociatedActions(ModelSpecificEvent mse)
	{
		synchronized(_futureActionsLock)
		{
			ArrayList<IFutureAction> actionsToRemove = new ArrayList<IFutureAction>();
			for (IFutureAction action : _futureActions)
			{
				if (action.getTriggeringMSE() == mse)
				{
					actionsToRemove.add(action);
					action.perform();
				}
			}
			_futureActions.removeAll(actionsToRemove);
		}
	}
	
	private void executeModelSpecificEvent(ModelSpecificEvent mse)
	{
		if (mse.getAction() != null) 
		{			
			ActionModel feedbackModel = _executionContext.getFeedbackModel();
			ArrayList<When> whenStatements = new ArrayList<When>();
			for (When w : feedbackModel.getWhenStatements())
			{
				if (w.getSource() == mse)
				{
					whenStatements.add(w);
				}
			}	
			OperationExecution execution = null;
			if (whenStatements.size() == 0)
			{
				execution = new SynchroneExecution(mse, this);				
			}
			else
			{
				execution = new ASynchroneExecution(mse, whenStatements, _clockController, this);
			}
			execution.run();
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + _executionContext.getEventExecutor() + " ; Solver=" + _executionContext.getSolver() + " ; ModelResource=" + _executionContext.getResourceModel()+ "]";
	}

	public void setDebugger(GemocModelDebugger debugger) {
		_debugger = debugger;
	}

	public void setAnimator(IGemocModelAnimator animator) {
		this.animator = animator;
	}

	private ArrayList<IAliveClockController> _clockControllers = new ArrayList<IAliveClockController>();
	private void addClockController(IAliveClockController controller) 
	{
		_clockControllers.add(controller);
	}

	private ArrayList<IExecutionEngineCapability> _capabilities = new ArrayList<IExecutionEngineCapability>();

	public <T extends IExecutionEngineCapability> boolean hasCapability(Class<T> type) {
		for (IExecutionEngineCapability c : _capabilities) {
			if (c.getClass().equals(type))
				return true;
		}
		return false;
	}

	@SuppressWarnings("all")
	public <T extends IExecutionEngineCapability> T getCapability(Class<T> type) {
		for (IExecutionEngineCapability c : _capabilities) {
			if (c.getClass().equals(type))
				return (T) c;
		}
		return null;
	}

	public <T extends IExecutionEngineCapability> T capability(Class<T> type) {
		T capability = getCapability(type);
		if (capability == null) {
			try {
				capability = type.newInstance();
				capability.initialize(this);
				_capabilities.add(capability);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return capability;
	}

	public ArrayList<IAliveClockController> get_clockControllers() {
		return _clockControllers;
	}

	@Override
	public IExecutionContext getExecutionContext() {
		return _executionContext;
	}


	private ILogicalStepDecider _newDecider;

	@Override
	public void changeLogicalStepDecider(ILogicalStepDecider newDecider) 
	{
		_newDecider = newDecider;
	}

	private void switchDeciderIfNecessary()
	{
		if (_newDecider != null)
		{
			_logicalStepDecider = _newDecider;
			_newDecider = null;
		}
	}

	private List<LogicalStep> _possibleLogicalSteps;
	private void computePossibleLogicalSteps() 
	{
		_possibleLogicalSteps = _executionContext.getSolver().computeAndGetPossibleLogicalSteps();
	}

	@Override
	public List<LogicalStep> getPossibleLogicalSteps() 
	{
		return _possibleLogicalSteps;
	}
	
	private void updatePossibleLogicalSteps()
	{
		for(IAliveClockController cc : _clockControllers)
		{
			cc.makeClocksTickOrNotTick();
		}
		_possibleLogicalSteps = _executionContext.getSolver().updatePossibleLogicalSteps();
		engineStatus.updateCurrentLogicalStepChoice(_possibleLogicalSteps);
		updateTraceModelBeforeDeciding(_possibleLogicalSteps);			
		notifyEngineHasChanged();
		for (IEngineHook hook : _executionContext.getHooks()) 
		{
			hook.preLogicalStepSelection(ObservableBasicExecutionEngine.this);
		}
	}
	
	public void recomputePossibleLogicalSteps()
	{
		_executionContext.getSolver().revertForceClockEffect();
		updatePossibleLogicalSteps();
	}
	
	private void updateTraceModelAfterDeciding(final int selectedLogicalStepIndex) 
	{
		if (hasCapability(ModelExecutionTracingCapability.class))
			capability(ModelExecutionTracingCapability.class).updateTraceModelAfterDeciding(selectedLogicalStepIndex);
	}

	private void updateTraceModelBeforeAskingSolver(final long count) 
	{
		if (hasCapability(ModelExecutionTracingCapability.class))
			capability(ModelExecutionTracingCapability.class).updateTraceModelBeforeAskingSolver(count);
	}

	private void updateTraceModelBeforeDeciding(final List<LogicalStep> possibleLogicalSteps) 
	{
		if (hasCapability(ModelExecutionTracingCapability.class))
			capability(ModelExecutionTracingCapability.class).updateTraceModelBeforeDeciding(possibleLogicalSteps);
	}

	
	private ArrayList<IFutureAction> _futureActions = new ArrayList<>();
	private Object _futureActionsLock = new Object();
	@Override
	public void addFutureAction(IFutureAction action) 
	{
		synchronized(_futureActionsLock)
		{
			_futureActions.add(action);
		}
	}

}
