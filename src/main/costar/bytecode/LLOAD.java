package costar.bytecode;

import java.util.Map;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Variable;
import starlib.formula.expression.Expression;

public class LLOAD extends gov.nasa.jpf.jvm.bytecode.LLOAD {
	
	public LLOAD(int localVarIndex) {
		super(localVarIndex);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		
		LocalVarInfo lvi = sf.getLocalVarInfo(index);
		if (lvi == null)
			return super.execute(ti);
		
		Map<LocalVarInfo, String> map = analysis.getNameMap().peek();
		
		String name = map.get(lvi);
		
		Expression exp = new Variable(name);
		sf.setLongLocalAttr(index, exp);
		
		return super.execute(ti);
	}

}
