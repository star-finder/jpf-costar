package costar.instrumenter;

import java.util.HashSet;
import java.util.Set;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodInstrumenterVisitor extends MethodVisitor {

	private ClassInstrumenterVisitor cv;

	private boolean isInit;
	
	private Set<Label> labels = new HashSet<Label>();

	public MethodInstrumenterVisitor(MethodVisitor mv, ClassInstrumenterVisitor cv, boolean isInit) {
		super(Opcodes.ASM6, mv);
		this.cv = cv;
		this.isInit = isInit;
	}

	@Override
	public void visitCode() {
		mv.visitCode();
		if (!isInit) {
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, cv.getClassName(), cv.getInitMethodName(), cv.getInitMethodDesc(), false);
		}
	}
	
	@Override
	public void visitJumpInsn(int opcode, Label label) {
		mv.visitJumpInsn(opcode, label);
		if (!isInit && opcode != Opcodes.GOTO) {
			labels.add(label);
			int id = cv.nextId();
			insertProbe(id);
		}
	}

	@Override
	public void visitLabel(Label label) {
		mv.visitLabel(label);
		if (!isInit && labels.contains(label)) {
			int id = cv.nextId();
			insertProbe(id);
		}
	}

//	@Override
//	public void visitMaxs(int maxStack, int maxLocals) {
//		mv.visitMaxs(maxStack + 1, maxLocals);
//	}

	private void insertProbe(int id) {
		mv.visitFieldInsn(Opcodes.GETSTATIC, cv.getClassName(), cv.getFieldName(), cv.getFieldDesc());
		if (id <= 127)
			mv.visitIntInsn(Opcodes.BIPUSH, id);
		else
			mv.visitIntInsn(Opcodes.SIPUSH, id);
		mv.visitInsn(Opcodes.ICONST_1);
		mv.visitInsn(Opcodes.BASTORE);
	}

}
