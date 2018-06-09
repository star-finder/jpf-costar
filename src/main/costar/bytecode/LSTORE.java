package costar.bytecode;

import java.util.Map;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;

public class LSTORE extends gov.nasa.jpf.jvm.bytecode.LSTORE {

	public LSTORE(int localVarIndex) {
		super(localVarIndex);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		Object sym_v = sf.getOperandAttr();
		
		long v = sf.peekLong();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		Expression exp = sym_v != null ? (Expression) sym_v : new LiteralExpression(v);
		
		LocalVarInfo lvi = sf.getLocalVarInfo(index);
		Map<Integer,Integer> map = analysis.getNameMap().peek();
		String name = lvi.getName() + "_" + map.get(index);
		
		Variable var = new Variable(name);
				
		formula.addComparisonTerm(Comparator.ARV, var, exp);
		System.out.println(formula);
		
		return super.execute(ti);
	}

}
