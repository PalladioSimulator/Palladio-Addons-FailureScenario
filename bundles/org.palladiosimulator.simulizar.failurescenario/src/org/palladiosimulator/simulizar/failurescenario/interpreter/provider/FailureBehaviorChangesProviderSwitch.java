package org.palladiosimulator.simulizar.failurescenario.interpreter.provider;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.failuremodel.failuretype.Byzantine;
import org.palladiosimulator.failuremodel.failuretype.Content;
import org.palladiosimulator.failuremodel.failuretype.Crash;
import org.palladiosimulator.failuremodel.failuretype.Failure;
import org.palladiosimulator.failuremodel.failuretype.SWTimingFailure;
import org.palladiosimulator.failuremodel.failuretype.Timing;
import org.palladiosimulator.failuremodel.failuretype.Transient;
import org.palladiosimulator.failuremodel.failuretype.util.FailuretypeSwitch;
import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.BehavioralDecider;
import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.ProbabilisticDecider;
import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.preinterpretation.CorruptContentBehavior;
import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.preinterpretation.CrashBehavior;
import org.palladiosimulator.simulizar.failurescenario.interpreter.behavior.preinterpretation.DelayBehavior;
import org.palladiosimulator.simulizar.failurescenario.interpreter.dto.FailureBehaviorChange;
import org.palladiosimulator.simulizar.failurescenario.interpreter.strategies.impl.AddDemandModifyingBehaviorStrategy;
import org.palladiosimulator.simulizar.failurescenario.interpreter.strategies.impl.AddPreInterpretationBehaviorStrategy;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.resources.DemandModifyingBehavior;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * A Provider for FailureBehaviorChange DataTransferObjects, which contain a
 * strategy for behavior changes.
 * 
 * @author Jonas Lehmann
 *
 */
public class FailureBehaviorChangesProviderSwitch extends FailuretypeSwitch<List<FailureBehaviorChange>> {

	private final IRandomGenerator randomNumberGenerator;

	public FailureBehaviorChangesProviderSwitch(IRandomGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	// Crash Failures
	// ------------------------------------------------------------------------------------------

	@Override
	public List<FailureBehaviorChange> caseCrash(Crash object) {
		FailureBehaviorChange dto = null;
		if (object instanceof Failure) {
			dto = new FailureBehaviorChange(
					new AddPreInterpretationBehaviorStrategy(new CrashBehavior((Failure) object)), 0.0);
		}
		return Arrays.asList(new FailureBehaviorChange[] { dto });
	}

	// Timing Failures
	// ------------------------------------------------------------------------------------------

	@Override
	public List<FailureBehaviorChange> caseTiming(Timing object) {
		DemandModifyingBehavior dmb = new DemandModifyingBehavior(object.getScalingFactor().getSpecification(),
				object.getDelay().getSpecification());
		return Arrays.asList(new FailureBehaviorChange[] {
				new FailureBehaviorChange(new AddDemandModifyingBehaviorStrategy(dmb), 0.0) });
	}

	@Override
	public List<FailureBehaviorChange> caseSWTimingFailure(SWTimingFailure object) {
		DelayBehavior delayPib = new DelayBehavior(object.getDelay().getSpecification());
		return Arrays.asList(new FailureBehaviorChange[] {
				new FailureBehaviorChange(new AddPreInterpretationBehaviorStrategy(delayPib), 0.0) });
	}

	// Content Failures
	// ------------------------------------------------------------------------------------------

	@Override
	public List<FailureBehaviorChange> caseContent(Content object) {
		FailureBehaviorChange dto = new FailureBehaviorChange(new AddPreInterpretationBehaviorStrategy(
				new CorruptContentBehavior(object.getDegreeOfCorruption().getSpecification())), 0.0);
		return Arrays.asList(new FailureBehaviorChange[] { dto });
	}

	// Transient Failures
	// ------------------------------------------------------------------------------------------

	@Override
	public <Failuretype extends Failure> List<FailureBehaviorChange> caseTransient(Transient<Failuretype> object) {

		FailureBehaviorChange addingBehavior = this.doSwitch(object.getDecoratedFailure()).get(0);
		Double relativePointInTimeOfRemoving = NumberConverter
				.toDouble(StackContext.evaluateStatic(object.getDuration().getSpecification()));
		FailureBehaviorChange removingBehavior = new FailureBehaviorChange(
				addingBehavior.getStrategy().getRevertedStrategy(), relativePointInTimeOfRemoving);

		return Arrays.asList(new FailureBehaviorChange[] { addingBehavior, removingBehavior });
	}

	// Byzantine Failures
	// ------------------------------------------------------------------------------------------

	@Override
	public <Failuretype extends Failure> List<FailureBehaviorChange> caseByzantine(Byzantine<Failuretype> object) {

		String probabilitySpec = object.getProbabilityOfOccurrence().getSpecification();
		BehavioralDecider decider = new ProbabilisticDecider(randomNumberGenerator, probabilitySpec);

		FailureBehaviorChange behavior = this.doSwitch(object.getDecoratedFailure()).get(0);
		behavior.getStrategy().setDecider(decider);
		return Arrays.asList(new FailureBehaviorChange[] { behavior });
	}

	/**
	 * Returns the failure behavior changes (Represented as DataTransferObjects with
	 * a changingStrategy and a relativePointInTime)
	 */
	@Override
	public List<FailureBehaviorChange> doSwitch(EObject object) {
		return super.doSwitch(object);
	}
}
