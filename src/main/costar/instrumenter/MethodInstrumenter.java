package costar.instrumenter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class MethodInstrumenter {

	private Set<LabelNode> labels;
	
	private ClassInstrumenter ci;

	public void transform(MethodNode mn, ClassInstrumenter ci) {
		this.ci = ci;
		
		collectLabels(mn);
		addInstruction(mn);
	}

	private void collectLabels(MethodNode mn) {
		labels = new HashSet<LabelNode>();
		InsnList il = mn.instructions;

		Iterator<AbstractInsnNode> it = il.iterator();
		while (it.hasNext()) {
			AbstractInsnNode in = it.next();
			if (in instanceof JumpInsnNode) {
				JumpInsnNode jn = (JumpInsnNode) in;
				int opcode = jn.getOpcode();
				if (opcode != Opcodes.GOTO) {
					labels.add(jn.label);
				}
			}
		}
	}
	
	private void addInstruction(MethodNode mn) {
		InsnList il = mn.instructions;
		il.insert(new MethodInsnNode(Opcodes.INVOKESTATIC, ci.getClassName(), ci.getInitMethodName(), ci.getInitMethodDesc(), false));
		
		Iterator<AbstractInsnNode> it = il.iterator();
		while (it.hasNext()) {
			AbstractInsnNode in = it.next();
			if (in instanceof JumpInsnNode) {
				JumpInsnNode jn = (JumpInsnNode) in;
				int opcode = jn.getOpcode();
				if (opcode != Opcodes.GOTO) {
					int id = ci.nextId();
					insertProbe(il, in, id);
				}
			} else if (in instanceof LabelNode) {
				if (labels.contains(in)) {
					int id = ci.nextId();
					insertProbe(il, in, id);
				}
			}
		}
	}
	
	private void insertProbe(InsnList il, AbstractInsnNode in, int id) {
		InsnList newIl = new InsnList();
		
		newIl.add(new FieldInsnNode(Opcodes.GETSTATIC, ci.getClassName(), ci.getFieldName(), ci.getFieldDesc()));
		if (id <= 127)
			newIl.add(new IntInsnNode(Opcodes.BIPUSH, id));
		else
			newIl.add(new IntInsnNode(Opcodes.SIPUSH, id));
		newIl.add(new InsnNode(Opcodes.ICONST_1));
		newIl.add(new InsnNode(Opcodes.BASTORE));
		
		il.insert(in, newIl);
	}

}
