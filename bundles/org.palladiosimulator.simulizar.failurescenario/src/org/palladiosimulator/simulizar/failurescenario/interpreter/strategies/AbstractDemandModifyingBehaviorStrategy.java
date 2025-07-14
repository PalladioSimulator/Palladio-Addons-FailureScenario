package org.palladiosimulator.simulizar.failurescenario.interpreter.strategies;

import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.BehavioralDecider;
import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.IBehavioralDecisionDecorated;
import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.demandmodifying.DecisionDecoratedDemandModifyingBehavior;
import org.palladiosimulator.simulizar.failurescenario.interpreter.dto.StrategyAllocationContext;

import de.uka.ipd.sdq.simucomframework.core.resources.DemandModifyingBehavior;
import de.uka.ipd.sdq.simucomframework.core.resources.IResourceDemandModifiable;

public abstract class AbstractDemandModifyingBehaviorStrategy implements FailureBehaviorChangingStrategy {

	protected IResourceDemandModifiable modifiableResource;
	protected DemandModifyingBehavior behavior;

	public AbstractDemandModifyingBehaviorStrategy(IResourceDemandModifiable modifiableResource,
			DemandModifyingBehavior behavior) {
		this.modifiableResource = modifiableResource;
		this.behavior = behavior;
	}

	@Override
	public abstract void execute();

	@Override
	public abstract FailureBehaviorChangingStrategy getRevertedStrategy();

	@Override
	public void setDecider(BehavioralDecider decider) {
		if (this.behavior instanceof IBehavioralDecisionDecorated) {
			((IBehavioralDecisionDecorated) this.behavior).setDecider(decider);
		} else {
			this.behavior = new DecisionDecoratedDemandModifyingBehavior(this.behavior, decider);
		}
	}

	@Override
	public boolean isValid() {
		return this.modifiableResource != null && this.behavior != null;
	}

	@Override
	public boolean allocateContext(StrategyAllocationContext allocationContext) {
		this.modifiableResource = allocationContext.getResourceProvider()
				.doSwitch(allocationContext.getOccurrence().getOrigin());
		return (this.modifiableResource != null);
	}
}
