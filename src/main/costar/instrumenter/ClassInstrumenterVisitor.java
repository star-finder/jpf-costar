package costar.instrumenter;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassInstrumenterVisitor extends ClassVisitor {

	private String className;
	
	private String fieldName = "$bitMap";
	
	private String fieldDesc = "[Z";
	
	private String initMethodName = "$initBitMap";
	
	private String initMethodDesc = "()V";
	
	private int count = 0;
	
	public ClassInstrumenterVisitor(ClassVisitor cv, String className) {
		super(Opcodes.ASM6, cv);
		this.className = className;
	}
	
	public int nextId() {
		return count++;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getClassName() {
		return className;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public String getFieldDesc() {
		return fieldDesc;
	}
	
	public String getInitMethodName() {
		return initMethodName;
	}
	
	public String getInitMethodDesc() {
		return initMethodDesc;
	}
	
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
		boolean isInit = name.equals("<init>") || name.equals("<clinit>");
		return new MethodInstrumenterVisitor(mv, this, isInit);
	}

	@Override
	public void visitEnd() {
		createBitMapField();
		createBitMapInitMethod();
		cv.visitEnd();
	}

	private void createBitMapField() {
		final FieldVisitor fv = cv.visitField(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, fieldName,
				fieldDesc, null, null);
		fv.visitEnd();
	}
	
	private void createBitMapInitMethod() {
		final MethodVisitor mv = cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, initMethodName,
				initMethodDesc, null, null);
		mv.visitCode();
		
		mv.visitFieldInsn(Opcodes.GETSTATIC, className, fieldName, fieldDesc);
		
		Label label = new Label();
		mv.visitJumpInsn(Opcodes.IFNONNULL, label);
		
		if (count <= 127)
			mv.visitIntInsn(Opcodes.BIPUSH, count);
		else
			mv.visitIntInsn(Opcodes.SIPUSH, count);
		
		mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BOOLEAN);
		mv.visitFieldInsn(Opcodes.PUTSTATIC, className, fieldName, fieldDesc);
				
		mv.visitLabel(label);
		mv.visitInsn(Opcodes.RETURN);
		
		mv.visitMaxs(1, 1);
		
		mv.visitEnd();
	}

}
