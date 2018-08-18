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
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;

public class DSTORE extends gov.nasa.jpf.jvm.bytecode.DSTORE {

	public DSTORE(int localVarIndex) {
		super(localVarIndex);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		Object sym_v = sf.getLongOperandAttr();
		
		double v = sf.peekDouble();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		Expression exp = sym_v != null ? (Expression) sym_v : new LiteralExpression(v);
		
		LocalVarInfo lvi = sf.getLocalVarInfo(index);
		if (lvi == null)
			return super.execute(ti);
		
		Map<LocalVarInfo, String> map = analysis.getNameMap().peek();
		
		String name = lvi.getName() + "_" + Utilities.freshIndex();
		map.put(lvi, name);
		
		Variable var = new Variable(name);
				
		formula.addComparisonTerm(Comparator.APV, var, exp);
		
		return super.execute(ti);
	}

}
