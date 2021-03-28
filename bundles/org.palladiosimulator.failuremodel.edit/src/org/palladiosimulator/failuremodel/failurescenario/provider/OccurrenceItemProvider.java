package org.palladiosimulator.failuremodel.failurescenario.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.failuremodel.failurescenario.Occurrence;
import org.palladiosimulator.failuremodel.failuretype.Failure;
import org.palladiosimulator.pcm.core.PCMRandomVariable;

public class OccurrenceItemProvider extends OccurrenceItemProviderGen {

	public OccurrenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		Failure failure = ((Occurrence) object).getFailure();
		PCMRandomVariable pointInTime = ((Occurrence) object).getPointInTime();

		final String label = ((failure != null) ? "of " + failure.getEntityName() : "")
				+ ((pointInTime != null) ? " at " + pointInTime.getSpecification() : "");
		return label == null || label.length() == 0 ? this.getString("_UI_Occurrence_type")
				: this.getString("_UI_Occurrence_type") + " " + label;
	}
}
