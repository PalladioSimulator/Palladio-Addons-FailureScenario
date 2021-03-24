package org.palladiosimulator.failuremodel.failurescenario.provider;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.failuremodel.failurescenario.FailurescenarioPackage;
import org.palladiosimulator.failuremodel.failurescenario.Occurrence;

public class OccurrenceItemProvider extends OccurrenceItemProviderGen {

	public OccurrenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {
		final String label = "of " + ((Occurrence) object).getFailure().getEntityName() + " at "
				+ ((Occurrence) object).getPointInTime().getSpecification();
		return label == null || label.length() == 0 ? this.getString("_UI_Occurrence_type")
				: this.getString("_UI_Occurrence_type") + " " + label;
	}
	
	/**
	 * This returns the property descriptors for the adapted class.
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addFailurePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Failure feature.
	 */
	protected void addFailurePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Occurrence_failure_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Occurrence_failure_feature", "_UI_Occurrence_type"),
				 FailurescenarioPackage.Literals.OCCURRENCE__FAILURE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

}
