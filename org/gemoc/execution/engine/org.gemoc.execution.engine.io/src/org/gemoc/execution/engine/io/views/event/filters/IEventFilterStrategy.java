package org.gemoc.execution.engine.io.views.event.filters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.gemoc.execution.engine.io.views.event.ModelSpecificEvent;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public interface IEventFilterStrategy {
	public Collection<ModelSpecificEvent> applyFilter();

	public void setParamFilter(List<Relation> relations, Map<String, ModelSpecificEvent> cache);
}

