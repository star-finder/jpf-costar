package costar.constrainsts;

import gov.nasa.jpf.vm.Instruction;

public class CoStarNode {
	
	public CoStarNode parent;
	
	public CoStarNode[] childrend;
	
	public String formula;
	
	public Instruction inst;
	
	public boolean hasVisited;
	
	public CoStarNode(CoStarNode parent, CoStarNode[] children,
			String formula, Instruction inst, boolean hasVisited) {
		this.parent = parent;
		this.childrend = children;
		this.formula = formula;
		this.inst = inst;
		this.hasVisited = hasVisited;
	}
	
}
