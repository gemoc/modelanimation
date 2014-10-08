package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Point;

import swing2swt.layout.FlowLayout;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Button;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction.CreateDomainModelAction;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.PojoProperties;

/*
 * IMPORTANT : this file has been edited using Windows builder.
 * This is why the structure is quite "unstructured" and use long methods.
 * The data binding is also managed via Windows Builder.
 */

public class GemocXDSMLFormComposite extends Composite {
	private DataBindingContext m_bindingContext;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtLanguageName;
	private Text txtEMFProject;
	private Text txtRootContainerModelElement;
	private Text txtXTextEditorProject;
	private Text txtSiriusEditorProject;
	private Text txtDSAProject;
	private Text txtDSEProject;
	private Text txtMoCCProject;
	private Text txtSiriusAnimationProject;
	private Text txtGenmodel;
	
	
	GemocLanguageWorkbenchConfiguration rootModelElement;
	AdapterFactoryEditingDomain editingDomain;
	
	protected XDSMLModelWrapper xdsmlWrappedObject = new XDSMLModelWrapper();
	

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public GemocXDSMLFormComposite(Composite parent, int style) {
		super(parent, SWT.NONE);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new ColumnLayout());

		Group grpLanguageDefinition = new Group(this, SWT.NONE);
		grpLanguageDefinition.setText("Language definition");
		toolkit.adapt(grpLanguageDefinition);
		toolkit.paintBordersFor(grpLanguageDefinition);
		grpLanguageDefinition.setLayout(new GridLayout(2, false));

		Label lblThisSectionDescribes = new Label(grpLanguageDefinition,
				SWT.WRAP);
		lblThisSectionDescribes.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				false, false, 2, 1));
		toolkit.adapt(lblThisSectionDescribes, true, true);
		lblThisSectionDescribes
				.setText("This section describes general information about this language.");

		Label lblNewLabel = new Label(grpLanguageDefinition, SWT.NONE);
		toolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("Language name");

		txtLanguageName = new Text(grpLanguageDefinition, SWT.BORDER);		
		txtLanguageName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1));
		toolkit.adapt(txtLanguageName, true, true);
		new Label(grpLanguageDefinition, SWT.NONE);
		new Label(grpLanguageDefinition, SWT.NONE);

		Group grpDomainModelDefinition = new Group(this, SWT.NONE);
		grpDomainModelDefinition.setText("Domain Model");
		toolkit.adapt(grpDomainModelDefinition);
		toolkit.paintBordersFor(grpDomainModelDefinition);
		grpDomainModelDefinition.setLayout(new GridLayout(3, false));

		Link linkEMFProject = new Link(grpDomainModelDefinition, SWT.NONE);
		linkEMFProject.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		linkEMFProject.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkEMFProject, true, true);
		linkEMFProject.setText("<a>EMF project</a>");
		linkEMFProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				/*
				 * IProject updatedGemocLanguageProject = context.getXdsmlFile()
				 * .getProject(); CreateDomainModelWizardContextAction action =
				 * new CreateDomainModelWizardContextAction(
				 * updatedGemocLanguageProject); action.actionToExecute =
				 * CreateDomainModelAction.CREATE_NEW_EMF_PROJECT;
				 * action.execute();
				 */
				if (!txtEMFProject.getText().isEmpty()) {
					// open the ecore or the project ?
				}
			}
		});

		txtEMFProject = new Text(grpDomainModelDefinition, SWT.BORDER);
		GridData gd_txtEMFProject = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtEMFProject.widthHint = 226;
		txtEMFProject.setLayoutData(gd_txtEMFProject);
		txtEMFProject.setBounds(0, 0, 244, 21);
		toolkit.adapt(txtEMFProject, true, true);

		Button btnBrowseEMFProject = new Button(grpDomainModelDefinition,
				SWT.NONE);
		btnBrowseEMFProject.setBounds(0, 0, 50, 25);
		toolkit.adapt(btnBrowseEMFProject, true, true);
		btnBrowseEMFProject.setText("Browse");

		Link linkGenmodel = new Link(grpDomainModelDefinition, 0);
		linkGenmodel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		linkGenmodel.setText("<a>genmodel</a>");
		toolkit.adapt(linkGenmodel, true, true);

		txtGenmodel = new Text(grpDomainModelDefinition, SWT.BORDER);
		txtGenmodel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1));
		toolkit.adapt(txtGenmodel, true, true);

		Button btnBrowseGenmodel = new Button(grpDomainModelDefinition,
				SWT.NONE);
		btnBrowseGenmodel.setText("Browse");
		toolkit.adapt(btnBrowseGenmodel, true, true);

		Label lblRootContainerModel = new Label(grpDomainModelDefinition,
				SWT.NONE);
		lblRootContainerModel.setBounds(0, 0, 55, 15);
		toolkit.adapt(lblRootContainerModel, true, true);
		lblRootContainerModel.setText("Root container model element");

		txtRootContainerModelElement = new Text(grpDomainModelDefinition,
				SWT.BORDER);
		txtRootContainerModelElement.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));
		txtRootContainerModelElement.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtRootContainerModelElement, true, true);

		Button btnNewButton = new Button(grpDomainModelDefinition, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		btnNewButton.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnNewButton, true, true);
		btnNewButton.setText("Select");

		Group grpConcreteSyntaxDefinition = new Group(this, SWT.NONE);
		grpConcreteSyntaxDefinition.setText("Concrete syntax definition");
		toolkit.adapt(grpConcreteSyntaxDefinition);
		toolkit.paintBordersFor(grpConcreteSyntaxDefinition);
		grpConcreteSyntaxDefinition.setLayout(new GridLayout(1, false));

		Group grpTextualEditor = new Group(grpConcreteSyntaxDefinition,
				SWT.NONE);
		grpTextualEditor.setLayout(new GridLayout(3, false));
		GridData gd_grpTextualEditor = new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1);
		gd_grpTextualEditor.heightHint = 49;
		grpTextualEditor.setLayoutData(gd_grpTextualEditor);
		grpTextualEditor.setText("Textual editor");
		grpTextualEditor.setBounds(0, 0, 70, 82);
		toolkit.adapt(grpTextualEditor);
		toolkit.paintBordersFor(grpTextualEditor);

		Link linkXTextEditorProject = new Link(grpTextualEditor, SWT.NONE);
		linkXTextEditorProject.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkXTextEditorProject, true, true);
		linkXTextEditorProject.setText("<a>xText project</a>");

		txtXTextEditorProject = new Text(grpTextualEditor, SWT.BORDER);
		GridData gd_txtXTextEditorProject = new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1);
		gd_txtXTextEditorProject.widthHint = 279;
		txtXTextEditorProject.setLayoutData(gd_txtXTextEditorProject);
		txtXTextEditorProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtXTextEditorProject, true, true);

		Button btnNewButton_1 = new Button(grpTextualEditor, SWT.NONE);
		btnNewButton_1.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnNewButton_1, true, true);
		btnNewButton_1.setText("Browse");

		Group grpGraphicalEditor = new Group(grpConcreteSyntaxDefinition,
				SWT.NONE);
		grpGraphicalEditor.setLayout(new GridLayout(3, false));
		grpGraphicalEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpGraphicalEditor.setText("Graphical editor");
		grpGraphicalEditor.setBounds(0, 0, 70, 82);
		toolkit.adapt(grpGraphicalEditor);
		toolkit.paintBordersFor(grpGraphicalEditor);

		Link linkSiriusEditorProject = new Link(grpGraphicalEditor, 0);
		linkSiriusEditorProject
				.setText("<a>Sirius viewpoint design project</a>");
		linkSiriusEditorProject.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkSiriusEditorProject, true, true);

		txtSiriusEditorProject = new Text(grpGraphicalEditor, SWT.BORDER);
		GridData gd_txtSiriusEditorProject = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtSiriusEditorProject.widthHint = 181;
		txtSiriusEditorProject.setLayoutData(gd_txtSiriusEditorProject);
		txtSiriusEditorProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtSiriusEditorProject, true, true);

		Button btnBrowse_1 = new Button(grpGraphicalEditor, SWT.NONE);
		btnBrowse_1.setText("Browse");
		btnBrowse_1.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnBrowse_1, true, true);

		Group grpAnimationDefinition = new Group(grpConcreteSyntaxDefinition,
				SWT.NONE);
		grpAnimationDefinition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpAnimationDefinition.setText("Animation definition");
		toolkit.adapt(grpAnimationDefinition);
		toolkit.paintBordersFor(grpAnimationDefinition);
		grpAnimationDefinition.setLayout(new GridLayout(3, false));

		Label lblThisSectionDescribes_3 = new Label(grpAnimationDefinition,
				SWT.NONE);
		lblThisSectionDescribes_3.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblThisSectionDescribes_3
				.setText("This section describes the animation views for this language.");
		toolkit.adapt(lblThisSectionDescribes_3, true, true);

		Link linkSiriusAnimatorProject = new Link(grpAnimationDefinition, 0);
		linkSiriusAnimatorProject.setText("<a>Sirius viewpoint design project</a>");
		toolkit.adapt(linkSiriusAnimatorProject, true, true);

		txtSiriusAnimationProject = new Text(grpAnimationDefinition, SWT.BORDER);
		GridData gd_txtSiriusAnimationProject = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtSiriusAnimationProject.widthHint = 182;
		txtSiriusAnimationProject.setLayoutData(gd_txtSiriusAnimationProject);
		toolkit.adapt(txtSiriusAnimationProject, true, true);

		Button button_2 = new Button(grpAnimationDefinition, SWT.NONE);
		button_2.setText("Browse");
		toolkit.adapt(button_2, true, true);
		new Label(grpAnimationDefinition, SWT.NONE);
		new Label(grpAnimationDefinition, SWT.NONE);
		new Label(grpAnimationDefinition, SWT.NONE);

		Group grpBehaviorDefinition = new Group(this, SWT.NONE);
		grpBehaviorDefinition.setText("Behavior definition");
		toolkit.adapt(grpBehaviorDefinition);
		toolkit.paintBordersFor(grpBehaviorDefinition);
		grpBehaviorDefinition.setLayout(new GridLayout(1, false));

		Group grpDsaDefinition = new Group(grpBehaviorDefinition, SWT.NONE);
		grpDsaDefinition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpDsaDefinition.setText("DSA definition");
		toolkit.adapt(grpDsaDefinition);
		toolkit.paintBordersFor(grpDsaDefinition);
		grpDsaDefinition.setLayout(new GridLayout(3, false));

		Label lblNewLabel_1 = new Label(grpDsaDefinition, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 3, 1));
		lblNewLabel_1.setBounds(0, 0, 55, 15);
		toolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1
				.setText("This section describes the execution function and data about this language.");

		Link linkDSAProject = new Link(grpDsaDefinition, SWT.NONE);
		linkDSAProject.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkDSAProject, true, true);
		linkDSAProject.setText("<a>K3 project</a>");

		txtDSAProject = new Text(grpDsaDefinition, SWT.BORDER);
		GridData gd_txtDSAProject = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtDSAProject.widthHint = 215;
		txtDSAProject.setLayoutData(gd_txtDSAProject);
		txtDSAProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtDSAProject, true, true);

		Button btnBrowseDSAProject = new Button(grpDsaDefinition, SWT.NONE);
		btnBrowseDSAProject.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnBrowseDSAProject, true, true);
		btnBrowseDSAProject.setText("browse");

		Group grpMocDefinitionLibrary = new Group(grpBehaviorDefinition,
				SWT.NONE);
		grpMocDefinitionLibrary.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));
		grpMocDefinitionLibrary.setText("MoC definition library");
		toolkit.adapt(grpMocDefinitionLibrary);
		toolkit.paintBordersFor(grpMocDefinitionLibrary);
		grpMocDefinitionLibrary.setLayout(new GridLayout(3, false));

		Label lblThisSectionDescribes_2 = new Label(grpMocDefinitionLibrary,
				SWT.NONE);
		lblThisSectionDescribes_2.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblThisSectionDescribes_2
				.setText("This section describes the reusable MoC definitions used by this language.");
		lblThisSectionDescribes_2.setBounds(0, 0, 397, 15);
		toolkit.adapt(lblThisSectionDescribes_2, true, true);

		Link linkMoCCMLProject = new Link(grpMocDefinitionLibrary, 0);
		linkMoCCMLProject.setText("<a>MoCCML project</a>");
		linkMoCCMLProject.setBounds(0, 0, 60, 15);
		toolkit.adapt(linkMoCCMLProject, true, true);

		txtMoCCProject = new Text(grpMocDefinitionLibrary, SWT.BORDER);
		GridData gd_txtMoCCProject = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtMoCCProject.widthHint = 178;
		txtMoCCProject.setLayoutData(gd_txtMoCCProject);
		txtMoCCProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtMoCCProject, true, true);

		Button btnBrowseMoCCProject = new Button(grpMocDefinitionLibrary, SWT.NONE);
		btnBrowseMoCCProject.setText("browse");
		btnBrowseMoCCProject.setBounds(0, 0, 50, 25);
		toolkit.adapt(btnBrowseMoCCProject, true, true);

		Group grpDSEDefinition = new Group(grpBehaviorDefinition, SWT.NONE);
		grpDSEDefinition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpDSEDefinition.setText("DSE definition");
		toolkit.adapt(grpDSEDefinition);
		toolkit.paintBordersFor(grpDSEDefinition);
		grpDSEDefinition.setLayout(new GridLayout(3, false));

		Label lblThisSectionDescribes_1 = new Label(grpDSEDefinition, SWT.NONE);
		lblThisSectionDescribes_1.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblThisSectionDescribes_1
				.setText("This section describes the Domain Specific Event of this language.");
		lblThisSectionDescribes_1.setBounds(0, 0, 397, 15);
		toolkit.adapt(lblThisSectionDescribes_1, true, true);

		Link linkDSEProject = new Link(grpDSEDefinition, 0);
		linkDSEProject.setText("<a>ECL project</a>");
		linkDSEProject.setBounds(0, 0, 53, 15);
		toolkit.adapt(linkDSEProject, true, true);

		txtDSEProject = new Text(grpDSEDefinition, SWT.BORDER);
		GridData gd_txtDSEProject = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtDSEProject.widthHint = 212;
		txtDSEProject.setLayoutData(gd_txtDSEProject);
		txtDSEProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtDSEProject, true, true);

		Button btnBrowseDSEProject = new Button(grpDSEDefinition, SWT.NONE);
		btnBrowseDSEProject.setText("browse");
		btnBrowseDSEProject.setBounds(0, 0, 50, 25);
		toolkit.adapt(btnBrowseDSEProject, true, true);

		m_bindingContext = initDataBindings();
	}

	public void initControl(AdapterFactoryEditingDomain editingDomain) {
		if (editingDomain != null){
			this.editingDomain = editingDomain;
			editingDomain.toString();
			if(editingDomain.getResourceSet().getResources().size() > 0){
				if(editingDomain.getResourceSet().getResources().get(0).getContents().size() > 0){
					EObject eObject = editingDomain.getResourceSet().getResources().get(0).getContents().get(0);
					if(eObject instanceof GemocLanguageWorkbenchConfiguration){
						GemocLanguageWorkbenchConfiguration confModelElement = (GemocLanguageWorkbenchConfiguration)eObject;
						rootModelElement = confModelElement;
						XDSMLModelWrapperHelper.init(xdsmlWrappedObject, confModelElement.getLanguageDefinition());
					}
				}
			}
		}
		
		initControlFromWrappedObject();

		initListeners();
	}
	
	protected void initControlFromWrappedObject(){
		txtLanguageName.setText(xdsmlWrappedObject.getLanguageName());
		txtEMFProject.setText(xdsmlWrappedObject.getDomainModelProjectName());
		txtGenmodel.setText(xdsmlWrappedObject.getGenmodelLocationURI());
		txtRootContainerModelElement.setText(xdsmlWrappedObject.getRootContainerModelElement());
		txtXTextEditorProject.setText(xdsmlWrappedObject.getXTextEditorProjectName());
		txtSiriusEditorProject.setText(xdsmlWrappedObject.getSiriusEditorProjectName());
		txtSiriusAnimationProject.setText(xdsmlWrappedObject.getSiriusAnimatorProjectName());
		txtDSAProject.setText(xdsmlWrappedObject.getDSAProjectName());
		txtDSEProject.setText(xdsmlWrappedObject.getDSEProjectName());
		txtMoCCProject.setText(xdsmlWrappedObject.getMoCCProjectName());
	}
	
	protected void initListeners(){
		txtLanguageName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
			    final Text text = (Text) e.widget;
			    TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								rootModelElement.getLanguageDefinition().setName(text.getText());
							}
						});
			}
		});
		txtEMFProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
			    final Text text = (Text) e.widget;
			    TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								rootModelElement.getLanguageDefinition().getDomainModelProject().setProjectName(text.getText());
							}
						});
			}
		});
		txtXTextEditorProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
			    final Text text = (Text) e.widget;
			    TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								for(EditorProject editor : rootModelElement.getLanguageDefinition().getEditorProjects()){
							    	if(editor instanceof XTextEditorProject){
							    		editor.setProjectName(text.getText());
							    	}
							    }
							}
						});
			}
		});
		txtSiriusEditorProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
			    final Text text = (Text) e.widget;
			    TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								for(EditorProject editor : rootModelElement.getLanguageDefinition().getEditorProjects()){
							    	if(editor instanceof ODProject){
							    		editor.setProjectName(text.getText());
							    	}
							    }
							}
						});
			}
		});
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtLanguageNameObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtLanguageName);
		IObservableValue languageNameXdsmlWrappedObjectObserveValue = BeanProperties.value("languageName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtLanguageNameObserveWidget, languageNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtEMFProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtEMFProject);
		IObservableValue eMFProjectXdsmlWrappedObjectObserveValue = BeanProperties.value("domainModelProject").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtEMFProjectObserveWidget, eMFProjectXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtXTextEditorProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtXTextEditorProject);
		IObservableValue xTextEditorProjectXdsmlWrappedObjectObserveValue = BeanProperties.value("xTextEditorProject").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtXTextEditorProjectObserveWidget, xTextEditorProjectXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtSiriusEditorProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSiriusEditorProject);
		IObservableValue siriusEditorProjectXdsmlWrappedObjectObserveValue = BeanProperties.value("siriusEditorProject").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtSiriusEditorProjectObserveWidget, siriusEditorProjectXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtSiriusAnimationProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSiriusAnimationProject);
		IObservableValue siriusAnimatorProjectNameXdsmlWrappedObjectObserveValue = BeanProperties.value("siriusAnimatorProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtSiriusAnimationProjectObserveWidget, siriusAnimatorProjectNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtGenmodelObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtGenmodel);
		IObservableValue genmodelLocationURIXdsmlWrappedObjectObserveValue = BeanProperties.value("genmodelLocationURI").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtGenmodelObserveWidget, genmodelLocationURIXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtDSAProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtDSAProject);
		IObservableValue dSAProjectNameXdsmlWrappedObjectObserveValue = BeanProperties.value("DSAProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtDSAProjectObserveWidget, dSAProjectNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtMoCCProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtMoCCProject);
		IObservableValue moCCProjectNameXdsmlWrappedObjectObserveValue = BeanProperties.value("moCCProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtMoCCProjectObserveWidget, moCCProjectNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtDSEProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtDSEProject);
		IObservableValue dSEProjectNameXdsmlWrappedObjectObserveValue = BeanProperties.value("DSEProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtDSEProjectObserveWidget, dSEProjectNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtRootContainerModelElementObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtRootContainerModelElement);
		IObservableValue rootContainerModelElementXdsmlWrappedObjectObserveValue = BeanProperties.value("rootContainerModelElement").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtRootContainerModelElementObserveWidget, rootContainerModelElementXdsmlWrappedObjectObserveValue, null, null);
		//
		return bindingContext;
	}
}
