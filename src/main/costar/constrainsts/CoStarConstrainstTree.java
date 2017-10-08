package costar.constrainsts;

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
		return false;
	}

}
