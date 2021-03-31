package org.palladiosimulator.failuremodel.failuretype.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failuretype.HWByzantineFailure;

public class HWByzantineFailureItemProvider extends HWByzantineFailureItemProviderGen{

	public HWByzantineFailureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		String id = ((HWByzantineFailure) object).getId();
		final String label = ((HWByzantineFailure) object).getEntityName() + " [ID: " + id + "] <"
				+ this.getString("_UI_HWByzantineFailure_type") + ">";
		return label == null || label.length() == 0 ? this.getString("_UI_HWByzantineFailure_type") : label;
	}
}
