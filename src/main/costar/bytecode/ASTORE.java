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

public class ASTORE extends gov.nasa.jpf.jvm.bytecode.ASTORE {

	public ASTORE(int index) {
		super(index);
	}

	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);

		if (analysis == null)
			return super.execute(ti);

		StackFrame sf = ti.getModifiableTopFrame();
		Expression exp = (Expression) sf.getOperandAttr();

		Instruction nextIns = super.execute(ti);

		LocalVarInfo lvi = sf.getLocalVarInfo(index);
		String name = lvi.getName();

		Variable var = new Variable(name);
		Variable newVar = Utilities.freshVar(var);

		Map<String, String> nameMap = analysis.getNameMap();
		nameMap.put(name, newVar.getName());

		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();

		Formula formula = current.formula;
		formula.addComparisonTerm(Comparator.EQ, newVar, exp);

		return nextIns;
	}

}
