package star.aatree;

import aatree.AATree;

public class Driver {

	public static void main(String[] args) {
		if (args.length < 1)
			return;
		AATree tree = new AATree();
		switch (args[0]) {
		case "contains":
			tree.contains(0);
			break;
		case "findMax":
			tree.findMax();
			break;
		case "findMin":
			tree.findMin();
			break;
		case "insert":
			tree.insert(0);
			break;	
		case "isEmpty":
			tree.isEmpty();
			break;
		case "makeEmpty":
			tree.makeEmpty();;
			break;
		case "remove":
			tree.remove(0);
			break;
		case "wellFormed":
			tree.wellFormed();
			break;
		default:
			// do nothing
		}
	}
}
