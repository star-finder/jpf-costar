package costar;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.perturb.OperandPerturbator;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ChoiceGenerator;
import gov.nasa.jpf.vm.StackFrame;

public class CoStarPerturbator implements OperandPerturbator {
	
	private JPFLogger logger = JPF.getLogger("costar");

	@Override
	public Class<? extends ChoiceGenerator<?>> getChoiceGeneratorType() {
		return null;
	}

	@Override
	public ChoiceGenerator<?> createChoiceGenerator(String id, StackFrame frame, Object refObject) {
		logger.info("here here here");
		return new CoStarChoiceGenerator();
	}

	@Override
	public boolean perturb(ChoiceGenerator<?> cg, StackFrame frame) {
		logger.info("CoStar Perturbator");
		return false;
	}

}
