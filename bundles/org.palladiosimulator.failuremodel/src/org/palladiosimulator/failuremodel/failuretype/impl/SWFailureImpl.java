package org.palladiosimulator.failuremodel.failuretype.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.seff.SeffPackage;

public class SWFailureImpl extends SWFailureImplGen{
	@Override
	public EList<EObject> getSupportedElementType() {

		EList<EObject> supportedElementTypes = new BasicEList<EObject>();
		supportedElementTypes.add(SeffPackage.Literals.INTERNAL_ACTION);
		return supportedElementTypes;
	}
}
