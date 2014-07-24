package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.BackendSpecificationExtension;

public interface IRunConfiguration {

	public String getModelURIAsString();
	
	public int getAnimationDelay();

	public boolean isTraceActive();
	
	public int getDeadlockDetectionDepth();

	public Collection<BackendSpecificationExtension> getActivatedBackendExtensions();

}