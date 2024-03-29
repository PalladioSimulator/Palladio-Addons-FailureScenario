package org.palladiosimulator.simulizar.failurescenario.interpreter.strategies;

import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.BehavioralDecider;
import org.palladiosimulator.simulizar.failurescenario.interpreter.dto.StrategyAllocationContext;

public interface FailureBehaviorChangingStrategy {

	/**
	 * Executes the strategy. Before, you should test if this call is possible by
	 * calling isValid().
	 */
	public void execute();

	/**
	 * Checks if the strategys context has been allocated.
	 * 
	 * @return true if context is allocated.
	 */
	public boolean isValid();

	/**
	 * Sets a Decider to the Behavior.
	 * 
	 * @param decider
	 */
	public void setDecider(BehavioralDecider decider);

	/**
	 * Allocate the strategies context.
	 * 
	 * @return Returns false if it was impossible to allocate the strategy.
	 */
	public boolean allocateContext(StrategyAllocationContext allocationContext);

	public FailureBehaviorChangingStrategy getRevertedStrategy();
}
