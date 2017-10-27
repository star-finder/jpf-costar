package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.jvm.bytecode.IfInstruction;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;

public class IFInstrSymbHelper {
	
	public static Instruction getNextInstructionAndSetPCChoice(ThreadInfo ti, IfInstruction instr,
			Expression sym_v1, Expression sym_v2, Comparator trueComparator, Comparator falseComparator) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		StackFrame sf = ti.getModifiableTopFrame();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>()); // true formulas
		constraints.add(new ArrayList<Formula>()); // false formulas
		
		int v1 = 0, v2 = 0;
		
		if (instr instanceof IFEQ || instr instanceof IFGE || instr instanceof IFGT ||
				instr instanceof IFLE || instr instanceof IFLT || instr instanceof IFNE) {
			v1 = sf.pop();
		} else {
			v2 = sf.pop();
			v1 = sf.pop();
		}
		
		boolean isTrue = trueComparator.evaluate(v1, v2);
		
		for (Formula formula : formulas) {
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
			
			constraints.get(0).add(f0);
			constraints.get(1).add(f1);
		}
		
		if (isTrue) {
			analysis.decision(ti, instr, 0, constraints);
			return instr.getTarget();
		} else {
			analysis.decision(ti, instr, 1, constraints);
			return instr.getNext(ti);
		}
	}

}
