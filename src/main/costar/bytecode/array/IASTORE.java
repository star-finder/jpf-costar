package costar.bytecode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.expression.BinaryExpression;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.Operator;

public class IASTORE extends gov.nasa.jpf.jvm.bytecode.IASTORE {
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		if (analysis == null)
			return super.execute(ti);
		
		Map<Variable, Variable> arrayMap = analysis.getArrayMap();

		StackFrame sf = ti.getModifiableTopFrame();
		arrayRef = sf.peek(2); // ..., arrayRef, idx, value
		index = sf.peek(1);
		int value = sf.peek(0);
		
		if (arrayRef == MJIEnv.NULL) {
			return ti.createAndThrowException("java.lang.NullPointerException");
		}

		ElementInfo arrayInfo = ti.getElementInfo(arrayRef);
		
		Variable arrayAttr = (Variable) peekArrayAttr(ti);
		Expression indexAttr = (Expression) peekIndexAttr(ti);
		Expression valueAttr = (Expression) sf.getOperandAttr();
		
		if (arrayAttr == null) {
			// In this case, the array isn't symbolic
			if (indexAttr == null) {
				// In this case, the index isn't symbolic either
				return super.execute(ti);
			}
		} else if (indexAttr == null) {
			indexAttr = new LiteralExpression(index);
		}
		
		if (valueAttr == null) {
			valueAttr = new LiteralExpression(value);
		}
		
		if (arrayMap.containsKey(arrayAttr))
			arrayAttr = arrayMap.get(arrayAttr);
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();

		List<Formula> formulas = current.formulas;

		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>());
		constraints.add(new ArrayList<Formula>());
		constraints.add(new ArrayList<Formula>());
	
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
					
					Variable freshVar1 = Utilities.freshVar(arrayAttr); // freshVar = index expression
					Variable freshVar2 = Utilities.freshVar(arrayAttr); // new array name
					
					Variable selection = new Variable(arrayAttr + "[" + freshVar1 + "]");
					BinaryExpression exp = new BinaryExpression(Operator.SELECT, selection, valueAttr);
					
					f.addComparisonTerm(Comparator.EQ, freshVar1, indexAttr);
					f.addComparisonTerm(Comparator.EQ, freshVar2, exp); 
					
					arrayMap.put(arrayAttr, freshVar2);
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
