package costar.constrainsts;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;

public class CoStarConstrainstTree {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	private CoStarNode root;
	
	private CoStarNode current;
	
	public CoStarConstrainstTree() {
		this.root = new CoStarNode(null, null, null, null, true);
		this.current = root;
	}
	
	public CoStarNode getCurrent() {
		return current;
	}

	public boolean findNext() {
		while (current != null) {
			if (current.childrend == null) {
				current = current.parent;
				continue;
			}
			
			for (int i = 0; i < current.childrend.length; i++) {
				if (!current.childrend[i].hasVisited) {
					logger.info(current.childrend[i].formula);
					current.childrend[i].hasVisited = true; // should call solver here
					return true;
				}	
			}
			
			current = current.parent;
		}
		
		return false;
	}

	public void decision(ThreadInfo ti, Instruction inst, int chosenIdx, String[] constraints) {
		if (current.childrend == null) {
			int length = constraints.length;
			current.childrend = new CoStarNode[length];
			
			for (int i = 0; i < length; i++) {
				current.childrend[i] = new CoStarNode(current, null, constraints[i], inst, false);
			}
			
			current.childrend[chosenIdx].hasVisited = true;
			current = current.childrend[chosenIdx];
		}
	}
	
	public void reset() {
		current = root;
	}

}
