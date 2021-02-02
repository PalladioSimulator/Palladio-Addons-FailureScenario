package org.palladiosimulator.failuremodel.failuretype.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

public class LinkFailureImpl extends LinkFailureImplGen{
	@Override
	public EList<EClass> getSupportedElementTypes() {
		
		EList<EClass> supportedElementTypes = new BasicEList<EClass>();
		supportedElementTypes.add(ResourceenvironmentPackage.Literals.LINKING_RESOURCE);
		return supportedElementTypes;
	}
}
