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
import starlib.formula.expression.BinaryExpression;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.Operator;

public class IINC extends gov.nasa.jpf.jvm.bytecode.IINC {

	public IINC(int localVarIndex, int increment) {
		super(localVarIndex, increment);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		Object sym_v = sf.getOperandAttr();
		
		int v = sf.peek();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		LocalVarInfo lvi = sf.getLocalVarInfo(index);
		Map<Integer,Integer> map = analysis.getNameMap().peek();
		String name = lvi.getName() + "_" + map.get(index);
		
		Expression exp = new BinaryExpression(Operator.PLUS, new Variable(name), new LiteralExpression(increment));
		formula.addComparisonTerm(Comparator.APV, new Variable(name), exp);
				
		return super.execute(ti);
	}

}
