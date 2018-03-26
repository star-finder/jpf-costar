package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;

public class IF_ACMPNE extends gov.nasa.jpf.jvm.bytecode.IF_ACMPNE {
	
	public IF_ACMPNE(int targetPc) {
		super(targetPc);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		Object sym_v1 = sf.getOperandAttr(1);
		Object sym_v2 = sf.getOperandAttr(0);
		
		if (sym_v1 == null && sym_v2 == null) {
			return super.execute(ti);
		} else {
			int v2 = sf.pop();
			int v1 = sf.pop();
			
			CoStarConstrainstTree tree = analysis.getConstrainstTree();
			CoStarNode current = tree.getCurrent();
			
			Formula formula = current.formula;
			
			List<Formula> constraints = new ArrayList<Formula>();
			
			Formula f0 = formula.copy();
			Formula f1 = formula.copy();
				
			Expression exp1 = CMPInstrSymbHelper.makeExpression(sym_v1, v1);
			Expression exp2 = CMPInstrSymbHelper.makeExpression(sym_v2, v2);
				
			f0.addComparisonTerm(Comparator.EQ, exp1, exp2);
			f1.addComparisonTerm(Comparator.NE, exp1, exp2);
				
			constraints.add(f0);
			constraints.add(f1);
			
			if (v1 != v2) {
				if (!IFInstrSymbHelper.isExecuted(ti, getNext(ti))) {
					tree.addToStack(f0);
				}
				
				analysis.decision(ti, this, 1, constraints);
				return getTarget();
			} else {
				if (!IFInstrSymbHelper.isExecuted(ti, getTarget())) {
					tree.addToStack(f1);
				}
				
				analysis.decision(ti, this, 0, constraints);
				return getNext(ti);
			}
		}
		
	}

}
