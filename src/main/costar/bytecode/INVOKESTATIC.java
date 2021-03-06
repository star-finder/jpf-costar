package costar.bytecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.NullExpression;

public class INVOKESTATIC extends gov.nasa.jpf.jvm.bytecode.INVOKESTATIC {

	public INVOKESTATIC(String clsDescriptor, String methodName, String signature) {
		super(clsDescriptor, methodName, signature);
	}
	
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		Object[] syms = getArgumentAttrs(ti); // only args
		Object[] vals = getArgumentValues(ti); // only args
		
		Instruction nextIns = super.execute(ti);
		
		StackFrame sf = ti.getTopFrame();
		
		Map<LocalVarInfo,String> newMap = new HashMap<LocalVarInfo,String>();
		Stack<Map<LocalVarInfo,String>> indexMap = analysis.getNameMap();
		indexMap.push(newMap);
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		MethodInfo mi = sf.getMethodInfo();
		String[] types = mi.getArgumentTypeNames();
		
		LocalVarInfo[] lvis = mi.getLocalVars(); // only args
		
		if (lvis == null || lvis.length == 0)
			return nextIns;
				
		// no "this"
		
		int numOfArgs = sf.getMethodInfo().getNumberOfArguments();
		
		for (int i = 0; i < numOfArgs; i++) {
			Expression exp = null;
			Object sym_v = syms[i];
			
			if (sym_v != null) {
				if (sym_v instanceof gov.nasa.jpf.constraints.api.Expression<?>) {
					String name = ((gov.nasa.jpf.constraints.api.Expression<?>) sym_v).toString(0);
					exp = new Variable(name);
				} else {
					exp = (Expression) sym_v;
				}
			} else if (vals[i] != null) {
				exp = new LiteralExpression(vals[i] + "");
			} else {
				exp = NullExpression.getInstance();
			}
			
			String name = lvis[i].getName() + "_" + Utilities.freshIndex();
			newMap.put(lvis[i], name);
			
			Variable var = new Variable(name);
			
			if (INVOKEInstrHelper.isPrimitiveType(types[i]))
				formula.addComparisonTerm(Comparator.APV, var, exp);
			else
				formula.addComparisonTerm(Comparator.ARV, var, exp);
		}
		
		return nextIns;
	}

}
