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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure;

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getBehaviorMap <em>Behavior Map</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getMocDomain <em>Moc Domain</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface StructureElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Behavior Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Map</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Map</em>' reference.
	 * @see #setBehaviorMap(Behavior)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureElement_BehaviorMap()
	 * @model
	 * @generated
	 */
	Behavior getBehaviorMap();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getBehaviorMap <em>Behavior Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Map</em>' reference.
	 * @see #getBehaviorMap()
	 * @generated
	 */
	void setBehaviorMap(Behavior value);

	/**
	 * Returns the value of the '<em><b>Moc Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moc Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc Domain</em>' reference.
	 * @see #setMocDomain(MoCDomain)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureElement_MocDomain()
	 * @model derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='(MoCDomain)((StructureElement)self.eContainer()).behaviorMap().eContainer()'"
	 * @generated
	 */
	MoCDomain getMocDomain();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getMocDomain <em>Moc Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moc Domain</em>' reference.
	 * @see #getMocDomain()
	 * @generated
	 */
	void setMocDomain(MoCDomain value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureElement_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

} // StructureElement
