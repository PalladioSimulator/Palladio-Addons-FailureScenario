package org.palladiosimulator.failuremodel.failuretype.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failuretype.SWByzantineFailure;

public class SWByzantineFailureItemProvider extends SWByzantineFailureItemProviderGen {

	public SWByzantineFailureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		String id = ((SWByzantineFailure) object).getId();
		final String label = ((SWByzantineFailure) object).getEntityName() + " [ID: " + id + "] <"
				+ this.getString("_UI_SWByzantineFailure_type") + ">";
		return label == null || label.length() == 0 ? this.getString("_UI_SWByzantineFailure_type") : label;
	}
}
