package org.palladiosimulator.failuremodel.failuretype.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failuretype.SWTransientFailure;

public class SWTransientFailureItemProvider extends SWTransientFailureItemProviderGen {

	public SWTransientFailureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		String id = ((SWTransientFailure) object).getId();
		final String label = ((SWTransientFailure) object).getEntityName() + " [ID: " + id + "] <"
				+ this.getString("_UI_SWTransientFailure_type") + ">";
		return label == null || label.length() == 0 ? this.getString("_UI_SWTransientFailure_type") : label;
	}
}
