package costar.instrumenter;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodNode;

public class ClassInstrumenter {
	
	private static String className;
	
	private static String fieldName = "$bitMap";
	
	private static String fieldDesc = "[Z";
	
	private static String initMethodName = "$initBitMap";
	
	private static String initMethodDesc = "()V";
	
	private static int count = 0;
	
	public void transform(ClassNode cn, String className, boolean isLast) {
		if (ClassInstrumenter.className == null)
			ClassInstrumenter.className = className;
		
		if (!isLast) {
			MethodInstrumenter mi = new MethodInstrumenter();
			for (MethodNode mn : cn.methods) {
				String name = mn.name;
				if (!name.equals("<init>") && !name.equals("<clinit>")) {
					mi.transform(mn, this);
				}
			}
		}
		
		if (isLast) {
			initClassNode(cn);
			createBitMapField(cn);
			createBitMapInitMethod(cn);
		}
	}
	
	private void initClassNode(ClassNode cn) {
		cn.version = Opcodes.V1_8;
		cn.access = Opcodes.ACC_PUBLIC;
		cn.name = className;
		cn.superName = "java/lang/Object";
	}
	
	private void createBitMapField(ClassNode cn) {
		FieldNode bitMap = new FieldNode(Opcodes.ACC_PROTECTED | Opcodes.ACC_STATIC, fieldName,
				fieldDesc, null, null);
		cn.fields.add(bitMap);
	}
	
	private void createBitMapInitMethod(ClassNode cn) {
		MethodNode initBitMap = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, initMethodName,
				initMethodDesc, null, null);
		
		InsnList il = initBitMap.instructions;
		il.add(new FieldInsnNode(Opcodes.GETSTATIC, className, fieldName, fieldDesc));
		
		LabelNode label = new LabelNode();
		il.add(new JumpInsnNode(Opcodes.IFNONNULL, label));
		
		if (count <= 127)
			il.add(new IntInsnNode(Opcodes.BIPUSH, count));
		else
			il.add(new IntInsnNode(Opcodes.SIPUSH, count));
		
		il.add(new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_BOOLEAN));
		il.add(new FieldInsnNode(Opcodes.PUTSTATIC, className, fieldName, fieldDesc));
				
		il.add(label);
		il.add(new InsnNode(Opcodes.RETURN));
		
		initBitMap.maxLocals = 1;
		initBitMap.maxStack = 1;
		
		cn.methods.add(initBitMap);
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

}
