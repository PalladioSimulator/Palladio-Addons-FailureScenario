package org.palladiosimulator.failuremodel.failuretype.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failuretype.LinkTransientFailure;

public class LinkTransientFailureItemProvider extends LinkTransientFailureItemProviderGen {

	public LinkTransientFailureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		String id = ((LinkTransientFailure) object).getId();
		final String label = ((LinkTransientFailure) object).getEntityName() + " [ID: " + id + "] <"
				+ this.getString("_UI_LinkTransientFailure_type") + ">";
		return label == null || label.length() == 0 ? this.getString("_UI_LinkTransientFailure_type") : label;
	}
}
