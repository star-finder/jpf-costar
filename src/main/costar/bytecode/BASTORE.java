package costar.bytecode;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;

public class BASTORE extends gov.nasa.jpf.jvm.bytecode.BASTORE {
	
	@Override
	  public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
	    int index = peekIndex(ti);

	    arrayOperandAttr = peekArrayAttr(ti);
	    
	    if (arrayOperandAttr != null && arrayOperandAttr.toString().contains("bitMap")) {
	    	analysis.setBitMap(index);
	    }
	    
	    return super.execute(ti);
	}

}
