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
import starlib.formula.expression.VariableExpression;

public class IFNULL extends gov.nasa.jpf.jvm.bytecode.IFNULL {
	
	public IFNULL(int targetPc) {
		super(targetPc);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		Object sym_v = sf.getOperandAttr();
		
		if(sym_v == null) {
			return super.execute(ti);
		} else if (sym_v.toString().contains("newNode_")) {
			return super.execute(ti);
		} else {
			int objRef = sf.pop();
			
			CoStarConstrainstTree tree = analysis.getConstrainstTree();
			CoStarNode current = tree.getCurrent();
			
			List<Formula> formulas = current.formulas;
			
			List<List<Formula>> constraints = new ArrayList<List<Formula>>();
			constraints.add(new ArrayList<Formula>()); // null formulas
			constraints.add(new ArrayList<Formula>()); // not null formulas
			
			for (Formula formula : formulas) {
				Formula f0 = formula.copy();
				Formula f1 = formula.copy();
				
				f0.addComparisonTerm(Comparator.EQ, new VariableExpression(sym_v.toString()), null);
				f1.addComparisonTerm(Comparator.NE, new VariableExpression(sym_v.toString()), null);
				
				constraints.get(0).add(f0);
				constraints.get(1).add(f1);
			}
			
			if (objRef == 0) {
				analysis.decision(ti, this, 0, constraints);
				return getTarget();
			} else {
				analysis.decision(ti, this, 1, constraints);
				return getNext(ti);
			}
		}
	}

}
