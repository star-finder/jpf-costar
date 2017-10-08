package costar.constrainsts;

import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;

public class CoStarConstrainstTree {
	
	CoStarNode root;
	
	CoStarNode current;
	
	public CoStarConstrainstTree() {
		this.root = new CoStarNode();
		this.current = root;
	}
	
	public CoStarNode getCurrent() {
		return current;
	}

	public boolean findNext() {
		return true;
	}

	public void decision(ThreadInfo ti, Instruction inst, int chosenIdx) {
		
	}

}
