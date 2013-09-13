/**
 */
package newTfsm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see newTfsm.NewTfsmFactory
 * @model kind="package"
 * @generated
 */
public interface NewTfsmPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "newTfsm";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://org.gemoc.execution.engine.example.tfsm";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "org.gemoc.execution.engine.example";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    NewTfsmPackage eINSTANCE = newTfsm.impl.NewTfsmPackageImpl.init();

    /**
     * The meta object id for the '{@link newTfsm.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.NamedElementImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getNamedElement()
     * @generated
     */
    int NAMED_ELEMENT = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT__NAME = 0;

    /**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link newTfsm.impl.TFSMImpl <em>TFSM</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.TFSMImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getTFSM()
     * @generated
     */
    int TFSM = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TFSM__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Owned States</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TFSM__OWNED_STATES = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Initial State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TFSM__INITIAL_STATE = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Local Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TFSM__LOCAL_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Local Clock</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TFSM__LOCAL_CLOCK = NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Owned Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TFSM__OWNED_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>TFSM</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TFSM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The number of operations of the '<em>TFSM</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TFSM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link newTfsm.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.StateImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getState()
     * @generated
     */
    int STATE = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Owning FSM</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE__OWNING_FSM = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE__OUTGOING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE__INCOMING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>On Enter</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE___ON_ENTER = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>On Leave</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE___ON_LEAVE = NAMED_ELEMENT_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

    /**
     * The meta object id for the '{@link newTfsm.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.TransitionImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getTransition()
     * @generated
     */
    int TRANSITION = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__SOURCE = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__TARGET = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Owned Guard</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__OWNED_GUARD = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Generated Events</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__GENERATED_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Action</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__ACTION = NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Fire</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION___FIRE = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link newTfsm.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.GuardImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getGuard()
     * @generated
     */
    int GUARD = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUARD__NAME = NAMED_ELEMENT__NAME;

    /**
     * The number of structural features of the '<em>Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUARD_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUARD_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link newTfsm.impl.TemporalGuardImpl <em>Temporal Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.TemporalGuardImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getTemporalGuard()
     * @generated
     */
    int TEMPORAL_GUARD = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEMPORAL_GUARD__NAME = GUARD__NAME;

    /**
     * The feature id for the '<em><b>On Clock</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEMPORAL_GUARD__ON_CLOCK = GUARD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>After Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEMPORAL_GUARD__AFTER_DURATION = GUARD_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Temporal Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEMPORAL_GUARD_FEATURE_COUNT = GUARD_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Temporal Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEMPORAL_GUARD_OPERATION_COUNT = GUARD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link newTfsm.impl.EventGuardImpl <em>Event Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.EventGuardImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getEventGuard()
     * @generated
     */
    int EVENT_GUARD = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_GUARD__NAME = GUARD__NAME;

    /**
     * The feature id for the '<em><b>Triggering Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_GUARD__TRIGGERING_EVENT = GUARD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Event Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_GUARD_FEATURE_COUNT = GUARD_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Event Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_GUARD_OPERATION_COUNT = GUARD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link newTfsm.impl.FSMEventImpl <em>FSM Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.FSMEventImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getFSMEvent()
     * @generated
     */
    int FSM_EVENT = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FSM_EVENT__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Solliciting Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FSM_EVENT__SOLLICITING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>FSM Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FSM_EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>FSM Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FSM_EVENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link newTfsm.impl.FSMClockImpl <em>FSM Clock</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.FSMClockImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getFSMClock()
     * @generated
     */
    int FSM_CLOCK = 8;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FSM_CLOCK__NAME = NAMED_ELEMENT__NAME;

    /**
     * The number of structural features of the '<em>FSM Clock</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FSM_CLOCK_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Ticks</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FSM_CLOCK___TICKS = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>FSM Clock</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FSM_CLOCK_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link newTfsm.impl.SystemImpl <em>System</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.SystemImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getSystem()
     * @generated
     */
    int SYSTEM = 9;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Tfsms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM__TFSMS = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Global Clocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM__GLOBAL_CLOCKS = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Global Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM__GLOBAL_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>System</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>System</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link newTfsm.impl.EvaluateGuardImpl <em>Evaluate Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see newTfsm.impl.EvaluateGuardImpl
     * @see newTfsm.impl.NewTfsmPackageImpl#getEvaluateGuard()
     * @generated
     */
    int EVALUATE_GUARD = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVALUATE_GUARD__NAME = GUARD__NAME;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVALUATE_GUARD__CONDITION = GUARD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Evaluate Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVALUATE_GUARD_FEATURE_COUNT = GUARD_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Evaluate</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVALUATE_GUARD___EVALUATE = GUARD_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Evaluate Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVALUATE_GUARD_OPERATION_COUNT = GUARD_OPERATION_COUNT + 1;


    /**
     * Returns the meta object for class '{@link newTfsm.TFSM <em>TFSM</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>TFSM</em>'.
     * @see newTfsm.TFSM
     * @generated
     */
    EClass getTFSM();

    /**
     * Returns the meta object for the containment reference list '{@link newTfsm.TFSM#getOwnedStates <em>Owned States</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned States</em>'.
     * @see newTfsm.TFSM#getOwnedStates()
     * @see #getTFSM()
     * @generated
     */
    EReference getTFSM_OwnedStates();

    /**
     * Returns the meta object for the reference '{@link newTfsm.TFSM#getInitialState <em>Initial State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Initial State</em>'.
     * @see newTfsm.TFSM#getInitialState()
     * @see #getTFSM()
     * @generated
     */
    EReference getTFSM_InitialState();

    /**
     * Returns the meta object for the containment reference list '{@link newTfsm.TFSM#getLocalEvents <em>Local Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Local Events</em>'.
     * @see newTfsm.TFSM#getLocalEvents()
     * @see #getTFSM()
     * @generated
     */
    EReference getTFSM_LocalEvents();

    /**
     * Returns the meta object for the containment reference '{@link newTfsm.TFSM#getLocalClock <em>Local Clock</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Local Clock</em>'.
     * @see newTfsm.TFSM#getLocalClock()
     * @see #getTFSM()
     * @generated
     */
    EReference getTFSM_LocalClock();

    /**
     * Returns the meta object for the containment reference list '{@link newTfsm.TFSM#getOwnedTransitions <em>Owned Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Transitions</em>'.
     * @see newTfsm.TFSM#getOwnedTransitions()
     * @see #getTFSM()
     * @generated
     */
    EReference getTFSM_OwnedTransitions();

    /**
     * Returns the meta object for class '{@link newTfsm.State <em>State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>State</em>'.
     * @see newTfsm.State
     * @generated
     */
    EClass getState();

    /**
     * Returns the meta object for the reference '{@link newTfsm.State#getOwningFSM <em>Owning FSM</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Owning FSM</em>'.
     * @see newTfsm.State#getOwningFSM()
     * @see #getState()
     * @generated
     */
    EReference getState_OwningFSM();

    /**
     * Returns the meta object for the reference list '{@link newTfsm.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
     * @see newTfsm.State#getOutgoingTransitions()
     * @see #getState()
     * @generated
     */
    EReference getState_OutgoingTransitions();

    /**
     * Returns the meta object for the reference list '{@link newTfsm.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
     * @see newTfsm.State#getIncomingTransitions()
     * @see #getState()
     * @generated
     */
    EReference getState_IncomingTransitions();

    /**
     * Returns the meta object for the '{@link newTfsm.State#onEnter() <em>On Enter</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>On Enter</em>' operation.
     * @see newTfsm.State#onEnter()
     * @generated
     */
    EOperation getState__OnEnter();

    /**
     * Returns the meta object for the '{@link newTfsm.State#onLeave() <em>On Leave</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>On Leave</em>' operation.
     * @see newTfsm.State#onLeave()
     * @generated
     */
    EOperation getState__OnLeave();

    /**
     * Returns the meta object for class '{@link newTfsm.Transition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transition</em>'.
     * @see newTfsm.Transition
     * @generated
     */
    EClass getTransition();

    /**
     * Returns the meta object for the reference '{@link newTfsm.Transition#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see newTfsm.Transition#getSource()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_Source();

    /**
     * Returns the meta object for the reference '{@link newTfsm.Transition#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see newTfsm.Transition#getTarget()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_Target();

    /**
     * Returns the meta object for the containment reference '{@link newTfsm.Transition#getOwnedGuard <em>Owned Guard</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Owned Guard</em>'.
     * @see newTfsm.Transition#getOwnedGuard()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_OwnedGuard();

    /**
     * Returns the meta object for the reference list '{@link newTfsm.Transition#getGeneratedEvents <em>Generated Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Generated Events</em>'.
     * @see newTfsm.Transition#getGeneratedEvents()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_GeneratedEvents();

    /**
     * Returns the meta object for the attribute '{@link newTfsm.Transition#getAction <em>Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Action</em>'.
     * @see newTfsm.Transition#getAction()
     * @see #getTransition()
     * @generated
     */
    EAttribute getTransition_Action();

    /**
     * Returns the meta object for the '{@link newTfsm.Transition#fire() <em>Fire</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Fire</em>' operation.
     * @see newTfsm.Transition#fire()
     * @generated
     */
    EOperation getTransition__Fire();

    /**
     * Returns the meta object for class '{@link newTfsm.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see newTfsm.NamedElement
     * @generated
     */
    EClass getNamedElement();

    /**
     * Returns the meta object for the attribute '{@link newTfsm.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see newTfsm.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
    EAttribute getNamedElement_Name();

    /**
     * Returns the meta object for class '{@link newTfsm.Guard <em>Guard</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Guard</em>'.
     * @see newTfsm.Guard
     * @generated
     */
    EClass getGuard();

    /**
     * Returns the meta object for class '{@link newTfsm.TemporalGuard <em>Temporal Guard</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Temporal Guard</em>'.
     * @see newTfsm.TemporalGuard
     * @generated
     */
    EClass getTemporalGuard();

    /**
     * Returns the meta object for the reference '{@link newTfsm.TemporalGuard#getOnClock <em>On Clock</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>On Clock</em>'.
     * @see newTfsm.TemporalGuard#getOnClock()
     * @see #getTemporalGuard()
     * @generated
     */
    EReference getTemporalGuard_OnClock();

    /**
     * Returns the meta object for the attribute '{@link newTfsm.TemporalGuard#getAfterDuration <em>After Duration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>After Duration</em>'.
     * @see newTfsm.TemporalGuard#getAfterDuration()
     * @see #getTemporalGuard()
     * @generated
     */
    EAttribute getTemporalGuard_AfterDuration();

    /**
     * Returns the meta object for class '{@link newTfsm.EventGuard <em>Event Guard</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Guard</em>'.
     * @see newTfsm.EventGuard
     * @generated
     */
    EClass getEventGuard();

    /**
     * Returns the meta object for the reference '{@link newTfsm.EventGuard#getTriggeringEvent <em>Triggering Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Triggering Event</em>'.
     * @see newTfsm.EventGuard#getTriggeringEvent()
     * @see #getEventGuard()
     * @generated
     */
    EReference getEventGuard_TriggeringEvent();

    /**
     * Returns the meta object for class '{@link newTfsm.FSMEvent <em>FSM Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>FSM Event</em>'.
     * @see newTfsm.FSMEvent
     * @generated
     */
    EClass getFSMEvent();

    /**
     * Returns the meta object for the reference list '{@link newTfsm.FSMEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Solliciting Transitions</em>'.
     * @see newTfsm.FSMEvent#getSollicitingTransitions()
     * @see #getFSMEvent()
     * @generated
     */
    EReference getFSMEvent_SollicitingTransitions();

    /**
     * Returns the meta object for class '{@link newTfsm.FSMClock <em>FSM Clock</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>FSM Clock</em>'.
     * @see newTfsm.FSMClock
     * @generated
     */
    EClass getFSMClock();

    /**
     * Returns the meta object for the '{@link newTfsm.FSMClock#ticks() <em>Ticks</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Ticks</em>' operation.
     * @see newTfsm.FSMClock#ticks()
     * @generated
     */
    EOperation getFSMClock__Ticks();

    /**
     * Returns the meta object for class '{@link newTfsm.System <em>System</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>System</em>'.
     * @see newTfsm.System
     * @generated
     */
    EClass getSystem();

    /**
     * Returns the meta object for the containment reference list '{@link newTfsm.System#getTfsms <em>Tfsms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Tfsms</em>'.
     * @see newTfsm.System#getTfsms()
     * @see #getSystem()
     * @generated
     */
    EReference getSystem_Tfsms();

    /**
     * Returns the meta object for the containment reference list '{@link newTfsm.System#getGlobalClocks <em>Global Clocks</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Global Clocks</em>'.
     * @see newTfsm.System#getGlobalClocks()
     * @see #getSystem()
     * @generated
     */
    EReference getSystem_GlobalClocks();

    /**
     * Returns the meta object for the containment reference list '{@link newTfsm.System#getGlobalEvents <em>Global Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Global Events</em>'.
     * @see newTfsm.System#getGlobalEvents()
     * @see #getSystem()
     * @generated
     */
    EReference getSystem_GlobalEvents();

    /**
     * Returns the meta object for class '{@link newTfsm.EvaluateGuard <em>Evaluate Guard</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Evaluate Guard</em>'.
     * @see newTfsm.EvaluateGuard
     * @generated
     */
    EClass getEvaluateGuard();

    /**
     * Returns the meta object for the attribute '{@link newTfsm.EvaluateGuard#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Condition</em>'.
     * @see newTfsm.EvaluateGuard#getCondition()
     * @see #getEvaluateGuard()
     * @generated
     */
    EAttribute getEvaluateGuard_Condition();

    /**
     * Returns the meta object for the '{@link newTfsm.EvaluateGuard#evaluate() <em>Evaluate</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Evaluate</em>' operation.
     * @see newTfsm.EvaluateGuard#evaluate()
     * @generated
     */
    EOperation getEvaluateGuard__Evaluate();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    NewTfsmFactory getNewTfsmFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link newTfsm.impl.TFSMImpl <em>TFSM</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.TFSMImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getTFSM()
         * @generated
         */
        EClass TFSM = eINSTANCE.getTFSM();

        /**
         * The meta object literal for the '<em><b>Owned States</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TFSM__OWNED_STATES = eINSTANCE.getTFSM_OwnedStates();

        /**
         * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TFSM__INITIAL_STATE = eINSTANCE.getTFSM_InitialState();

        /**
         * The meta object literal for the '<em><b>Local Events</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TFSM__LOCAL_EVENTS = eINSTANCE.getTFSM_LocalEvents();

        /**
         * The meta object literal for the '<em><b>Local Clock</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TFSM__LOCAL_CLOCK = eINSTANCE.getTFSM_LocalClock();

        /**
         * The meta object literal for the '<em><b>Owned Transitions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TFSM__OWNED_TRANSITIONS = eINSTANCE.getTFSM_OwnedTransitions();

        /**
         * The meta object literal for the '{@link newTfsm.impl.StateImpl <em>State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.StateImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getState()
         * @generated
         */
        EClass STATE = eINSTANCE.getState();

        /**
         * The meta object literal for the '<em><b>Owning FSM</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATE__OWNING_FSM = eINSTANCE.getState_OwningFSM();

        /**
         * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATE__OUTGOING_TRANSITIONS = eINSTANCE.getState_OutgoingTransitions();

        /**
         * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATE__INCOMING_TRANSITIONS = eINSTANCE.getState_IncomingTransitions();

        /**
         * The meta object literal for the '<em><b>On Enter</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation STATE___ON_ENTER = eINSTANCE.getState__OnEnter();

        /**
         * The meta object literal for the '<em><b>On Leave</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation STATE___ON_LEAVE = eINSTANCE.getState__OnLeave();

        /**
         * The meta object literal for the '{@link newTfsm.impl.TransitionImpl <em>Transition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.TransitionImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getTransition()
         * @generated
         */
        EClass TRANSITION = eINSTANCE.getTransition();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

        /**
         * The meta object literal for the '<em><b>Owned Guard</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__OWNED_GUARD = eINSTANCE.getTransition_OwnedGuard();

        /**
         * The meta object literal for the '<em><b>Generated Events</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__GENERATED_EVENTS = eINSTANCE.getTransition_GeneratedEvents();

        /**
         * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRANSITION__ACTION = eINSTANCE.getTransition_Action();

        /**
         * The meta object literal for the '<em><b>Fire</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation TRANSITION___FIRE = eINSTANCE.getTransition__Fire();

        /**
         * The meta object literal for the '{@link newTfsm.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.NamedElementImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getNamedElement()
         * @generated
         */
        EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

        /**
         * The meta object literal for the '{@link newTfsm.impl.GuardImpl <em>Guard</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.GuardImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getGuard()
         * @generated
         */
        EClass GUARD = eINSTANCE.getGuard();

        /**
         * The meta object literal for the '{@link newTfsm.impl.TemporalGuardImpl <em>Temporal Guard</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.TemporalGuardImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getTemporalGuard()
         * @generated
         */
        EClass TEMPORAL_GUARD = eINSTANCE.getTemporalGuard();

        /**
         * The meta object literal for the '<em><b>On Clock</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TEMPORAL_GUARD__ON_CLOCK = eINSTANCE.getTemporalGuard_OnClock();

        /**
         * The meta object literal for the '<em><b>After Duration</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEMPORAL_GUARD__AFTER_DURATION = eINSTANCE.getTemporalGuard_AfterDuration();

        /**
         * The meta object literal for the '{@link newTfsm.impl.EventGuardImpl <em>Event Guard</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.EventGuardImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getEventGuard()
         * @generated
         */
        EClass EVENT_GUARD = eINSTANCE.getEventGuard();

        /**
         * The meta object literal for the '<em><b>Triggering Event</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EVENT_GUARD__TRIGGERING_EVENT = eINSTANCE.getEventGuard_TriggeringEvent();

        /**
         * The meta object literal for the '{@link newTfsm.impl.FSMEventImpl <em>FSM Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.FSMEventImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getFSMEvent()
         * @generated
         */
        EClass FSM_EVENT = eINSTANCE.getFSMEvent();

        /**
         * The meta object literal for the '<em><b>Solliciting Transitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FSM_EVENT__SOLLICITING_TRANSITIONS = eINSTANCE.getFSMEvent_SollicitingTransitions();

        /**
         * The meta object literal for the '{@link newTfsm.impl.FSMClockImpl <em>FSM Clock</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.FSMClockImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getFSMClock()
         * @generated
         */
        EClass FSM_CLOCK = eINSTANCE.getFSMClock();

        /**
         * The meta object literal for the '<em><b>Ticks</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation FSM_CLOCK___TICKS = eINSTANCE.getFSMClock__Ticks();

        /**
         * The meta object literal for the '{@link newTfsm.impl.SystemImpl <em>System</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.SystemImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getSystem()
         * @generated
         */
        EClass SYSTEM = eINSTANCE.getSystem();

        /**
         * The meta object literal for the '<em><b>Tfsms</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM__TFSMS = eINSTANCE.getSystem_Tfsms();

        /**
         * The meta object literal for the '<em><b>Global Clocks</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM__GLOBAL_CLOCKS = eINSTANCE.getSystem_GlobalClocks();

        /**
         * The meta object literal for the '<em><b>Global Events</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM__GLOBAL_EVENTS = eINSTANCE.getSystem_GlobalEvents();

        /**
         * The meta object literal for the '{@link newTfsm.impl.EvaluateGuardImpl <em>Evaluate Guard</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see newTfsm.impl.EvaluateGuardImpl
         * @see newTfsm.impl.NewTfsmPackageImpl#getEvaluateGuard()
         * @generated
         */
        EClass EVALUATE_GUARD = eINSTANCE.getEvaluateGuard();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVALUATE_GUARD__CONDITION = eINSTANCE.getEvaluateGuard_Condition();

        /**
         * The meta object literal for the '<em><b>Evaluate</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EVALUATE_GUARD___EVALUATE = eINSTANCE.getEvaluateGuard__Evaluate();

    }

} //NewTfsmPackage