package org.palladiosimulator.failuremodel.failuretype.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

public class HWFailureImpl extends HWFailureImplGen {
	@Override
	public EList<EClass> getSupportedElementTypes() {

		EList<EClass> supportedElementTypes = new BasicEList<EClass>();
		supportedElementTypes.add(ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER);
		return supportedElementTypes;
	}
}
