package costar;

import costar.bytecode.ALOAD;
import costar.bytecode.GETFIELD;
import costar.bytecode.GETSTATIC;
import costar.bytecode.IFLE;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.jvm.bytecode.InstructionFactory;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;

public class CoStarInstructionFactory extends InstructionFactory {

	private JPFLogger logger = JPF.getLogger("costar");

	@Override
	public Instruction ifle(int targetPc) {
		return new IFLE(targetPc);
	}

	@Override
	public Instruction aload(int localVarIndex) {
		return new ALOAD(localVarIndex);
	}

	@Override
	public Instruction getfield(String fieldName, String clsName, String fieldDescriptor) {
		return new GETFIELD(fieldName, clsName, fieldDescriptor);
	}

	@Override
	public Instruction getstatic(String fieldName, String clsName, String fieldDescriptor) {
		return new GETSTATIC(fieldName, clsName, fieldDescriptor);
	}

}
