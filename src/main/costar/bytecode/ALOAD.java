package costar.bytecode;

import java.util.Map;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.expression.Expression;

public class ALOAD extends gov.nasa.jpf.jvm.bytecode.ALOAD {
	
	public ALOAD(int index) {
		super(index);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		
		LocalVarInfo lvi = sf.getLocalVarInfo(index);
		Map<LocalVarInfo, String> map = analysis.getNameMap().peek();
		
		String name = "";
		if (map.containsKey(lvi)) {
			name = map.get(lvi);
		} else {
			if (lvi.getName().equals("this"))
				name = lvi.getName();
			else
				name = lvi.getName() + "_" + Utilities.freshIndex();
			map.put(lvi, name);
		}
		
		Expression exp = new Variable(name);
		sf.setLocalAttr(index, exp);
		
		return super.execute(ti);
	}

}
