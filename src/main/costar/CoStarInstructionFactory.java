package costar;

import costar.bytecode.ALOAD;
import costar.bytecode.GETFIELD;
import costar.bytecode.GETSTATIC;
import costar.bytecode.IFLE;
import costar.bytecode.ILOAD;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.jvm.bytecode.InstructionFactory;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import star.bytecode.IADD;
import star.bytecode.IAND;
import star.bytecode.IDIV;
import star.bytecode.IINC;
import star.bytecode.IMUL;
import star.bytecode.INEG;
import star.bytecode.IOR;
import star.bytecode.IREM;
import star.bytecode.ISHL;
import star.bytecode.ISHR;
import star.bytecode.ISUB;
import star.bytecode.IUSHR;
import star.bytecode.IXOR;

public class CoStarInstructionFactory extends InstructionFactory {

	private JPFLogger logger = JPF.getLogger("costar");
	
	@Override
	public Instruction aload(int localVarIndex) {
		return new ALOAD(localVarIndex);
	}
	
//	@Override
//	public Instruction ifeq(int targetPc) {
//		return new IFEQ(targetPc);
//	}
//
//	@Override
//	public Instruction ifne(int targetPc) {
//		return new IFNE(targetPc);
//	}
//
//	@Override
//	public Instruction ifgt(int targetPc) {
//		return new IFGT(targetPc);
//	}
//
//	@Override
//	public Instruction ifge(int targetPc) {
//		return new IFGE(targetPc);
//	}
//
//	@Override
//	public Instruction iflt(int targetPc) {
//		return new IFLT(targetPc);
//	}

	@Override
	public Instruction ifle(int targetPc) {
		return new IFLE(targetPc);
	}
	
	@Override
	public Instruction iload(int localVarIndex) {
		return new ILOAD(localVarIndex);
	}
	
	@Override
	public Instruction iadd() {
		return new IADD();
	}
	
	@Override
	public Instruction iand() {
		return new IAND();
	}

	@Override
	public Instruction idiv() {
		return new IDIV();
	}

	@Override
	public Instruction iinc(int localVarIndex, int incConstant) {
		return new IINC(localVarIndex, incConstant);
	}

	@Override
	public Instruction imul() {
		return new IMUL();
	}

	@Override
	public Instruction ineg() {
		return new INEG();
	}

	@Override
	public Instruction ior() {
		return new IOR();
	}

	@Override
	public Instruction irem() {
		return new IREM();
	}

	@Override
	public Instruction ishl() {
		return new ISHL();
	}

	@Override
	public Instruction ishr() {
		return new ISHR();
	}

	@Override
	public Instruction isub() {
		return new ISUB();
	}

	@Override
	public Instruction iushr() {
		return new IUSHR();
	}

	@Override
	public Instruction ixor() {
		return new IXOR();
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
