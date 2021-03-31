package org.palladiosimulator.failuremodel.failuretype.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failuretype.LinkByzantineFailure;

public class LinkByzantineFailureItemProvider extends LinkByzantineFailureItemProviderGen {

	public LinkByzantineFailureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		String id = ((LinkByzantineFailure) object).getId();
		final String label = ((LinkByzantineFailure) object).getEntityName() + " [ID: " + id + "] <"
				+ this.getString("_UI_LinkByzantineFailure_type") + ">";
		return label == null || label.length() == 0 ? this.getString("_UI_LinkByzantineFailure_type") : label;
	}
}
