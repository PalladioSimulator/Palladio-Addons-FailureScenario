package org.palladiosimulator.failuremodel.failuretype.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

public class LinkFailureImpl extends LinkFailureImplGen{
	@Override
	public EList<EObject> getSupportedElementType() {
		
		EList<EObject> supportedElementTypes = new BasicEList<EObject>();
		supportedElementTypes.add(ResourceenvironmentPackage.Literals.LINKING_RESOURCE);
		supportedElementTypes.add(ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION);
		return supportedElementTypes;
	}
}
