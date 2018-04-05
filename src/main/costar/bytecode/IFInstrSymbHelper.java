package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.jvm.bytecode.BIPUSH;
import gov.nasa.jpf.jvm.bytecode.IfInstruction;
import gov.nasa.jpf.jvm.bytecode.SIPUSH;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;

public class IFInstrSymbHelper {
	
	public static int getIndex(ThreadInfo ti, Instruction instr) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		boolean[] bitMap = analysis.getBitMap();
		
		int index = -1;
		Instruction nextInstr = instr.getNext();
		
		if (nextInstr instanceof BIPUSH) {
			BIPUSH bp = (BIPUSH) nextInstr;
			index = bp.getValue();
		} else if (nextInstr instanceof SIPUSH) {
			SIPUSH sp = (SIPUSH) nextInstr;
			index = sp.getValue();
		}
		
//		if (!bitMap[index]) return index;
//		else return -1;
		
		return index;
	}
	
	public static Instruction getNextInstructionAndSetPCChoice(ThreadInfo ti, IfInstruction instr,
			Expression sym_v1, Expression sym_v2, Comparator trueComparator, Comparator falseComparator) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		StackFrame sf = ti.getModifiableTopFrame();
		
		Config config = ti.getVM().getConfig();
		boolean isInstrument = Boolean.parseBoolean(config.getProperty("costar.instrument", "false"));
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		List<Formula> constraints = new ArrayList<Formula>();
		
		int v1 = 0, v2 = 0;
		
		if (instr instanceof IFEQ || instr instanceof IFGE || instr instanceof IFGT ||
				instr instanceof IFLE || instr instanceof IFLT || instr instanceof IFNE) {
			v1 = sf.pop();
		} else {
			v2 = sf.pop();
			v1 = sf.pop();
		}
		
		boolean isTrue = trueComparator.evaluate(v1, v2);
		
		Formula f0 = formula.copy();
		Formula f1 = formula.copy();
			
		if (sym_v1 != null) {
			if (sym_v2 != null) {
				f0.addComparisonTerm(trueComparator, sym_v1, sym_v2);
				f1.addComparisonTerm(falseComparator, sym_v1, sym_v2);
			} else {
				f0.addComparisonTerm(trueComparator, sym_v1, new LiteralExpression(v2));
				f1.addComparisonTerm(falseComparator, sym_v1, new LiteralExpression(v2));
			}
		} else {
			f0.addComparisonTerm(trueComparator, new LiteralExpression(v1), sym_v2);
			f1.addComparisonTerm(falseComparator, new LiteralExpression(v1), sym_v2);
		}
		
		constraints.add(f0);
		constraints.add(f1);
		
		if (isTrue) {
			if (isInstrument) {
				int index = getIndex(ti, instr.getNext(ti));
				if (index >= 0) tree.addToStack(f1, index);
			}
			
			analysis.decision(ti, instr, 0, constraints);
			return instr.getTarget();
		} else {
			if (isInstrument) {
				int index = getIndex(ti, instr.getTarget());
				if (index >= 0) tree.addToStack(f0, index);
			}
			
			analysis.decision(ti, instr, 1, constraints);
			return instr.getNext(ti);
		}
	}

}
