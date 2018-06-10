package costar.bytecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.jvm.bytecode.JVMInstructionVisitor;
import gov.nasa.jpf.jvm.bytecode.VirtualInvocation;
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

public class INVOKEVIRTUAL extends VirtualInvocation {
	
	public INVOKEVIRTUAL() {
	}

	public INVOKEVIRTUAL(String clsDescriptor, String methodName, String signature) {
		super(clsDescriptor, methodName, signature);
	}
	
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		Object[] syms = getArgumentAttrs(ti);
		Object[] vals = getArgumentValues(ti);
		
		Instruction nextIns = super.execute(ti);
		
		StackFrame sf = ti.getTopFrame();
		
		Map<Integer,Integer> newMap = new HashMap<Integer,Integer>();
		for (int i = 1; i < sf.getLocalVariableCount(); i++) {
			newMap.put(i, Utilities.freshIndex());
		}
		
		Stack<Map<Integer,Integer>> indexMap = analysis.getNameMap();
		indexMap.push(newMap);
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		MethodInfo mi = sf.getMethodInfo();
		
		LocalVarInfo[] lvis = mi.getLocalVars();
		
		// index 0 is "this"
		for (int i = 1; i < sf.getMethodInfo().getArgumentsSize(); i++) {
			Expression exp = null;
			Object sym_v = syms[i];
			
			if (sym_v != null) {
				if (sym_v instanceof gov.nasa.jpf.constraints.api.Expression<?>) {
					String name = ((gov.nasa.jpf.constraints.api.Expression<?>) sym_v).toString(0);
					exp = new Variable(name);
				} else {
					exp = (Expression) sym_v;
				}
			} else {
				exp = new LiteralExpression(vals[i] + "");
			}
			
			Variable var = new Variable(lvis[i].getName() + "_" + newMap.get(i));
			formula.addComparisonTerm(Comparator.EQ, var, exp);
		}
		
		return nextIns;
	}

	@Override
	public int getByteCode() {
		return 0xB6;
	}

	@Override
	public String toString() {
		// methodInfo not set outside real call context (requires target object)
		return "invokevirtual " + cname + '.' + mname;
	}

	@Override
	public void accept(JVMInstructionVisitor insVisitor) {
		insVisitor.visit(this);
	}
	
}
