package costar.constrainsts;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.jdart.constraints.InternalConstraintsTree.BranchEffect;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;

public class CoStarConstrainstTree {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	private CoStarNode root;
	
	private CoStarNode current;
	
	public CoStarConstrainstTree() {
		this.root = new CoStarNode();
		this.current = root;
	}
	
	public CoStarNode getCurrent() {
		return current;
	}

	public boolean findNext() {
		for (int i = 0; i < current.childrend.length; i++) {
			if (current.childrend[i].isOpen) {
				current.childrend[i].isOpen = false;
				return true;
			}	
		}
		
		return false;
	}

	public void decision(ThreadInfo ti, Instruction inst, int chosenIdx, String[] constraints) {
		if (current.childrend == null) {
			current.childrend = new CoStarNode[constraints.length];
			current.childrend[0] = new CoStarNode();
			current.childrend[1] = new CoStarNode();
					
			current.childrend[0].formula = constraints[0];
			current.childrend[1].formula = constraints[1];
			
			current.childrend[chosenIdx].isOpen = false;
		}
	}

}
