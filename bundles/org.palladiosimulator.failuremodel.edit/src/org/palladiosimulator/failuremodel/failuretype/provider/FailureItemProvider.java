package org.palladiosimulator.failuremodel.failuretype.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failuretype.Failure;

public class FailureItemProvider extends FailureItemProviderGen {

	public FailureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		String id = ((Failure) object).getId();
		final String label = ((Failure) object).getEntityName() + " [ID: " + id + "] <"
				+ this.getString("_UI_Failure_type") + ">";
		return label == null || label.length() == 0 ? this.getString("_UI_Failure_type") : label;
	}
}
