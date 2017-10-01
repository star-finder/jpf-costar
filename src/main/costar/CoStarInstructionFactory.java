package costar;

import costar.bytecode.ALOAD;
import costar.bytecode.GETFIELD;
import costar.bytecode.GETSTATIC;
import gov.nasa.jpf.jdart.ConcolicInstructionFactory;
import gov.nasa.jpf.vm.Instruction;

public class CoStarInstructionFactory extends ConcolicInstructionFactory {
	
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
