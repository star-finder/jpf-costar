package costar.bytecode;

import java.util.Map;
import java.util.Stack;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;

public class RETURN extends gov.nasa.jpf.jvm.bytecode.RETURN {
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		Stack<Map<Integer,Integer>> indexMap = analysis.getNameMap();
		if (!indexMap.isEmpty()) indexMap.pop(); // indexMap will be empty at the last return in main method
		
		return super.execute(ti);
	}

}
