package org.palladiosimulator.failuremodel.failuretype.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.seff.SeffPackage;

public class SWFailureImpl extends SWFailureImplGen{
	@Override
	public EList<EClass> getSupportedElementTypes() {

		EList<EClass> supportedElementTypes = new BasicEList<EClass>();
		supportedElementTypes.add(SeffPackage.Literals.INTERNAL_ACTION);
		return supportedElementTypes;
	}
}
