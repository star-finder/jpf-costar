package costar.constrainsts;

import java.util.List;

import gov.nasa.jpf.vm.Instruction;
import starlib.formula.Formula;

public class CoStarNode {
	
	public CoStarNode parent;
	
	public CoStarNode[] childrend;
	
	public int heigth;
	
	public List<Formula> formulas;
	
	public Instruction inst;
	
	public boolean hasVisited;
	
	public CoStarNode(CoStarNode parent, CoStarNode[] children, int height,
			List<Formula> formulas, Instruction inst, boolean hasVisited) {
		this.parent = parent;
		this.childrend = children;
		this.heigth = height;
		this.formulas = formulas;
		this.inst = inst;
		this.hasVisited = hasVisited;
	}
	
}
