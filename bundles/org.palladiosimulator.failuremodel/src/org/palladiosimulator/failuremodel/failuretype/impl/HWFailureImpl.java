package org.palladiosimulator.failuremodel.failuretype.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

public class HWFailureImpl extends HWFailureImplGen {
	@Override
	public EList<EObject> getSupportedElementType() {

		EList<EObject> supportedElementTypes = new BasicEList<EObject>();
		//supportedElementTypes.add(ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER);
		//supportedElementTypes.add(ResourcetypePackage.Literals.PROCESSING_RESOURCE_TYPE);
		supportedElementTypes.add(ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION);
		return supportedElementTypes;
	}
}
