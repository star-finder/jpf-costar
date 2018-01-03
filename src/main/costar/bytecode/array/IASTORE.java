package costar.bytecode.array;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;

public class IASTORE extends gov.nasa.jpf.jvm.bytecode.IASTORE {
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);

		StackFrame sf = ti.getModifiableTopFrame();
		arrayRef = sf.peek(2); // ..., arrayRef, idx
		
		if (arrayRef == MJIEnv.NULL) {
			return ti.createAndThrowException("java.lang.NullPointerException");
		}

		ElementInfo arrayInfo = ti.getElementInfo(arrayRef);
		
		Variable arrayAttr = (Variable) peekArrayAttr(ti);
		Expression indexAttr = (Expression) peekIndexAttr(ti);
		
		if (arrayAttr == null) {
			// In this case, the array isn't symbolic
			if (indexAttr == null) {
				// In this case, the index isn't symbolic either
				return super.execute(ti);
			}
		} else if (indexAttr == null) {
			indexAttr = new LiteralExpression(index);
		}
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();

		List<Formula> formulas = current.formulas;

		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>());
		constraints.add(new ArrayList<Formula>());
		constraints.add(new ArrayList<Formula>());
	
		index = sf.peek(1);
		
		for (int i = 0; i < 3; i++) {
			for (Formula formula : formulas) {
				Formula f = formula.copy();
								
				if (i == 0) {
					f.addComparisonTerm(Comparator.LT, indexAttr, new LiteralExpression(0));
				} else if (i == 1) {
					f.addComparisonTerm(Comparator.GE, indexAttr, new LiteralExpression(arrayAttr.getName() + "_len"));
				} else {
					f.addComparisonTerm(Comparator.GE, indexAttr, new LiteralExpression(0));
					f.addComparisonTerm(Comparator.LT, indexAttr, new LiteralExpression(arrayAttr.getName() + "_len"));
				}
				
				constraints.get(i).add(f);
			}
		}
		
		if (index < 0) {
			analysis.decision(ti, this, 0, constraints);
			ti.getVM().getSystemState().setIgnored(true);
		} else if (index >= arrayInfo.arrayLength()) {
			analysis.decision(ti, this, 1, constraints);
			ti.getVM().getSystemState().setIgnored(true);
		} else {
			analysis.decision(ti, this, 2, constraints);
			return super.execute(ti);
		}
		
		return getNext(ti);
	}

}
