package org.palladiosimulator.failuremodel.failuretype.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failuretype.HWTransientFailure;

public class HWTransientFailureItemProvider extends HWTransientFailureItemProviderGen{

	public HWTransientFailureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		String id = ((HWTransientFailure) object).getId();
		final String label = ((HWTransientFailure) object).getEntityName() + " [ID: " + id + "] <"
				+ this.getString("_UI_HWTransientFailure_type") + ">";
		return label == null || label.length() == 0 ? this.getString("_UI_HWTransientFailure_type") : label;
	}
}
