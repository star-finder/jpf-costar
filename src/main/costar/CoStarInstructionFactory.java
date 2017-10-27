package costar;

import costar.bytecode.ALOAD;
import costar.bytecode.DLOAD;
import costar.bytecode.FLOAD;
import costar.bytecode.GETFIELD;
import costar.bytecode.GETSTATIC;
import costar.bytecode.IFLE;
import costar.bytecode.ILOAD;
import costar.bytecode.LLOAD;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.jvm.bytecode.InstructionFactory;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import star.bytecode.D2F;
import star.bytecode.D2I;
import star.bytecode.D2L;
import star.bytecode.DADD;
import star.bytecode.DDIV;
import star.bytecode.DMUL;
import star.bytecode.DNEG;
import star.bytecode.DREM;
import star.bytecode.DSUB;
import star.bytecode.F2D;
import star.bytecode.F2I;
import star.bytecode.F2L;
import star.bytecode.FADD;
import star.bytecode.FDIV;
import star.bytecode.FMUL;
import star.bytecode.FNEG;
import star.bytecode.FREM;
import star.bytecode.FSUB;
import star.bytecode.I2B;
import star.bytecode.I2C;
import star.bytecode.I2D;
import star.bytecode.I2F;
import star.bytecode.I2L;
import star.bytecode.I2S;
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
import star.bytecode.L2D;
import star.bytecode.L2F;
import star.bytecode.L2I;
import star.bytecode.LADD;
import star.bytecode.LAND;
import star.bytecode.LDIV;
import star.bytecode.LMUL;
import star.bytecode.LNEG;
import star.bytecode.LOR;
import star.bytecode.LREM;
import star.bytecode.LSHL;
import star.bytecode.LSHR;
import star.bytecode.LSUB;
import star.bytecode.LUSHR;
import star.bytecode.LXOR;

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
	public Instruction lload(int localVarIndex) {
		return new LLOAD(localVarIndex);
	}

	@Override
	public Instruction ladd() {
		return new LADD();
	}

	@Override
	public Instruction land() {
		return new LAND();
	}

	@Override
	public Instruction ldiv() {
		return new LDIV();
	}

	@Override
	public Instruction lmul() {
		return new LMUL();
	}

	@Override
	public Instruction lneg() {
		return new LNEG();
	}

	@Override
	public Instruction lor() {
		return new LOR();
	}

	@Override
	public Instruction lrem() {
		return new LREM();
	}

	@Override
	public Instruction lshl() {
		return new LSHL();
	}

	@Override
	public Instruction lshr() {
		return new LSHR();
	}

	@Override
	public Instruction lsub() {
		return new LSUB();
	}

	@Override
	public Instruction lushr() {
		return new LUSHR();
	}

	@Override
	public Instruction lxor() {
		return new LXOR();
	}
	
	@Override
	public Instruction fload(int localVarIndex) {
		return new FLOAD(localVarIndex);
	}

	@Override
	public Instruction fadd() {
		return new FADD();
	}

	@Override
	public Instruction fdiv() {
		return new FDIV();
	}

	@Override
	public Instruction fmul() {
		return new FMUL();
	}

	@Override
	public Instruction fneg() {
		return new FNEG();
	}

	@Override
	public Instruction frem() {
		return new FREM();
	}

	@Override
	public Instruction fsub() {
		return new FSUB();
	}
	
	@Override
	public Instruction dload(int localVarIndex) {
		return new DLOAD(localVarIndex);
	}

	@Override
	public Instruction dadd() {
		return new DADD();
	}

	@Override
	public Instruction ddiv() {
		return new DDIV();
	}

	@Override
	public Instruction dmul() {
		return new DMUL();
	}

	@Override
	public Instruction dneg() {
		return new DNEG();
	}

	@Override
	public Instruction drem() {
		return new DREM();
	}

	@Override
	public Instruction dsub() {
		return new DSUB();
	}

	@Override
	public Instruction i2b() {
		return new I2B();
	}

	@Override
	public Instruction i2c() {
		return new I2C();
	}

	@Override
	public Instruction i2d() {
		return new I2D();
	}

	@Override
	public Instruction i2f() {
		return new I2F();
	}

	@Override
	public Instruction i2l() {
		return new I2L();
	}

	@Override
	public Instruction i2s() {
		return new I2S();
	}

	@Override
	public Instruction l2d() {
		return new L2D();
	}

	@Override
	public Instruction l2f() {
		return new L2F();
	}

	@Override
	public Instruction l2i() {
		return new L2I();
	}

	@Override
	public Instruction f2d() {
		return new F2D();
	}

	@Override
	public Instruction f2i() {
		return new F2I();
	}

	@Override
	public Instruction f2l() {
		return new F2L();
	}

	@Override
	public Instruction d2f() {
		return new D2F();
	}

	@Override
	public Instruction d2i() {
		return new D2I();
	}

	@Override
	public Instruction d2l() {
		return new D2L();
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
