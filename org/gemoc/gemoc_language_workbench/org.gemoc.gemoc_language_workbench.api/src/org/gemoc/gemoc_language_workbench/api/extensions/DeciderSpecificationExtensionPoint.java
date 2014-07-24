package org.gemoc.gemoc_language_workbench.api.extensions;

import java.util.Collection;

public class DeciderSpecificationExtensionPoint extends ExtensionPoint<DeciderSpecificationExtension>
{

	public static final String GEMOC_DECIDER_EXTENSION_POINT = "org.gemoc.gemoc_language_workbench.deciders";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_NAME = "Name";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_CLASS = "Class";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_Description = "Description";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_ICONPATH = "Icon";


	protected DeciderSpecificationExtensionPoint() 
	{
		super(DeciderSpecificationExtension.class);
	}

	
	private static DeciderSpecificationExtensionPoint _singleton;
	
	private static DeciderSpecificationExtensionPoint getExtensionPoint()
	{
		if (_singleton == null)
		{
			_singleton = new DeciderSpecificationExtensionPoint();
		}
		return _singleton;
	}
		
	static public Collection<DeciderSpecificationExtension> getSpecifications() 
	{
		return getExtensionPoint().internal_getSpecifications();
	}


	@Override
	protected String getExtensionPointName()
	{
		return GEMOC_DECIDER_EXTENSION_POINT;
	}
	
}