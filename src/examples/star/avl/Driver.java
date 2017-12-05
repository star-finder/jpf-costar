package star.avl;

import avl.AvlTree;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		AvlTree tree = new AvlTree();
		switch (args[0]) {
		case "findMax":
			tree.findMax();
			break;
		case "findMin":
			tree.findMin();
			break;
		case "find":
			tree.find(0);
			break;
		case "insert":
			tree.insert(0);
			break;	
		case "isEmpty":
			tree.isEmpty();
			break;
		case "makeEmpty":
			tree.makeEmpty();
			break;
		case "maxElement":
			tree.maxElement(0);
			break;
		case "minElement":
			tree.minElement(0);
			break;
		case "printTree":
			tree.printTree();
			break;
		default:
			// do nothing
		}
	}
}
