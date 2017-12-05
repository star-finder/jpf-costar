package star.bst;

import bst.BinarySearchTree;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		BinarySearchTree tree = new BinarySearchTree();
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
		case "printTree":
			tree.printTree();
			break;
		case "remove":
			tree.remove(0);
			break;
		default:
			// do nothing
		}
	}

}
