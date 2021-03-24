package org.palladiosimulator.failuremodel.failurescenario.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failurescenario.FailureScenario;

public class FailureScenarioItemProvider extends FailureScenarioItemProviderGen {

	public FailureScenarioItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		Boolean executionEnabled = ((FailureScenario) object).getExecutionEnabled();
		final String label = ((FailureScenario) object).getEntityName()
				+ ((executionEnabled == null || executionEnabled) ? "" : " (OFF)");
		return label == null || label.length() == 0 ? this.getString("_UI_FailureScenario_type")
				: this.getString("_UI_FailureScenario_type") + " " + label;
	}
}
