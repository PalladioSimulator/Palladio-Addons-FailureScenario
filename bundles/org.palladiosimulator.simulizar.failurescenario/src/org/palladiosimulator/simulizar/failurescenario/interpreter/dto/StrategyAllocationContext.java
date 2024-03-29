package org.palladiosimulator.simulizar.failurescenario.interpreter.dto;

import org.palladiosimulator.failuremodel.failurescenario.Occurrence;
import org.palladiosimulator.simulizar.failurescenario.interpreter.provider.ReferenceResolverSwitch;
import org.palladiosimulator.simulizar.failurescenario.interpreter.provider.ScheduledResourceProviderSwitch;
import org.palladiosimulator.simulizar.runtimestate.PreInterpretationBehaviorManager;

/**
 * Data Transfer Object to allocate a strategies internal fields.
 * 
 * @author Jonas Lehmann
 *
 */
public class StrategyAllocationContext {

	private final ReferenceResolverSwitch referenceResolver;
	private final ScheduledResourceProviderSwitch resourceProvider;
	private final PreInterpretationBehaviorManager pibManager;
	private final Occurrence occurrence;

	/**
	 * Creates a new {@link StrategyAllocationContext}.
	 * 
	 * @param referenceResolver
	 * @param resourceProvider
	 * @param pibManager
	 * @param occurrence
	 */
	public StrategyAllocationContext(ReferenceResolverSwitch referenceResolver,
			ScheduledResourceProviderSwitch resourceProvider, PreInterpretationBehaviorManager pibManager,
			Occurrence occurrence) {
				this.referenceResolver = referenceResolver;
				this.resourceProvider = resourceProvider;
				this.pibManager = pibManager;
				this.occurrence = occurrence;
	}

	public ReferenceResolverSwitch getReferenceResolver() {
		return referenceResolver;
	}

	public ScheduledResourceProviderSwitch getResourceProvider() {
		return resourceProvider;
	}

	public PreInterpretationBehaviorManager getPibManager() {
		return pibManager;
	}

	public Occurrence getOccurrence() {
		return occurrence;
	}
	
}
