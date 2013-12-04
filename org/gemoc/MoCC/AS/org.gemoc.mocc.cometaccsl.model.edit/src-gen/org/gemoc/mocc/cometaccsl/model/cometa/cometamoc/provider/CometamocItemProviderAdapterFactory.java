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
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.util.CometamocAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CometamocItemProviderAdapterFactory extends CometamocAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometamocItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueueItemProvider queueItemProvider;

	/**
	 * This creates an adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createQueueAdapter() {
		if (queueItemProvider == null) {
			queueItemProvider = new QueueItemProvider(this);
		}

		return queueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CometaMoCLibraryItemProvider cometaMoCLibraryItemProvider;

	/**
	 * This creates an adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCometaMoCLibraryAdapter() {
		if (cometaMoCLibraryItemProvider == null) {
			cometaMoCLibraryItemProvider = new CometaMoCLibraryItemProvider(this);
		}

		return cometaMoCLibraryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoCDomainItemProvider moCDomainItemProvider;

	/**
	 * This creates an adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMoCDomainAdapter() {
		if (moCDomainItemProvider == null) {
			moCDomainItemProvider = new MoCDomainItemProvider(this);
		}

		return moCDomainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueBehaviorItemProvider opaqueBehaviorItemProvider;

	/**
	 * This creates an adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOpaqueBehaviorAdapter() {
		if (opaqueBehaviorItemProvider == null) {
			opaqueBehaviorItemProvider = new OpaqueBehaviorItemProvider(this);
		}

		return opaqueBehaviorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoCEventItemProvider moCEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMoCEventAdapter() {
		if (moCEventItemProvider == null) {
			moCEventItemProvider = new MoCEventItemProvider(this);
		}

		return moCEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueueInstanceItemProvider queueInstanceItemProvider;

	/**
	 * This creates an adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createQueueInstanceAdapter() {
		if (queueInstanceItemProvider == null) {
			queueInstanceItemProvider = new QueueInstanceItemProvider(this);
		}

		return queueInstanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.FiniteStateMachineBehavior} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FiniteStateMachineBehaviorItemProvider finiteStateMachineBehaviorItemProvider;

	/**
	 * This creates an adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.FiniteStateMachineBehavior}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFiniteStateMachineBehaviorAdapter() {
		if (finiteStateMachineBehaviorItemProvider == null) {
			finiteStateMachineBehaviorItemProvider = new FiniteStateMachineBehaviorItemProvider(this);
		}

		return finiteStateMachineBehaviorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CometaTriggerItemProvider cometaTriggerItemProvider;

	/**
	 * This creates an adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCometaTriggerAdapter() {
		if (cometaTriggerItemProvider == null) {
			cometaTriggerItemProvider = new CometaTriggerItemProvider(this);
		}

		return cometaTriggerItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (queueItemProvider != null) queueItemProvider.dispose();
		if (cometaMoCLibraryItemProvider != null) cometaMoCLibraryItemProvider.dispose();
		if (moCDomainItemProvider != null) moCDomainItemProvider.dispose();
		if (opaqueBehaviorItemProvider != null) opaqueBehaviorItemProvider.dispose();
		if (moCEventItemProvider != null) moCEventItemProvider.dispose();
		if (queueInstanceItemProvider != null) queueInstanceItemProvider.dispose();
		if (finiteStateMachineBehaviorItemProvider != null) finiteStateMachineBehaviorItemProvider.dispose();
		if (cometaTriggerItemProvider != null) cometaTriggerItemProvider.dispose();
	}

}
