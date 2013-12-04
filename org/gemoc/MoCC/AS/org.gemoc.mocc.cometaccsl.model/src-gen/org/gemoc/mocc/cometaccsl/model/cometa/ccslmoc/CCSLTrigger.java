/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CCSL Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger#getTrueTriggers <em>True Triggers</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger#getFalseTriggers <em>False Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage#getCCSLTrigger()
 * @model
 * @generated
 */
public interface CCSLTrigger extends Trigger {
	/**
	 * Returns the value of the '<em><b>True Triggers</b></em>' reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Triggers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Triggers</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage#getCCSLTrigger_TrueTriggers()
	 * @model
	 * @generated
	 */
	EList<BindableEntity> getTrueTriggers();

	/**
	 * Returns the value of the '<em><b>False Triggers</b></em>' reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Triggers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Triggers</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage#getCCSLTrigger_FalseTriggers()
	 * @model
	 * @generated
	 */
	EList<BindableEntity> getFalseTriggers();

} // CCSLTrigger
