package costar.constrainsts;

import gov.nasa.jpf.vm.Instruction;

public class CoStarNode {
	
	public String formula;
	
	public Instruction inst;
	
	public CoStarNode parent;
	
	public CoStarNode[] childrend;
	
	public boolean isOpen;
	
	public CoStarNode() {
		isOpen = true;
	}
	
}
