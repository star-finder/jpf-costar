package costar.constrainsts;

import gov.nasa.jpf.vm.Instruction;
import starlib.formula.Formula;

public class CoStarNode {
	
	public CoStarNode parent;
	
	public CoStarNode[] childrend;
	
	public Formula formula;
	
	public Instruction inst;
	
	public boolean hasVisited;
	
	public CoStarNode(CoStarNode parent, CoStarNode[] children,
			Formula formula, Instruction inst, boolean hasVisited) {
		this.parent = parent;
		this.childrend = children;
		this.formula = formula;
		this.inst = inst;
		this.hasVisited = hasVisited;
	}
	
}
