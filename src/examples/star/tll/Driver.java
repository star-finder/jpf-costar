package star.tll;

import tll.Node;
import tll.Tll;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		
		Tll tll = new Tll();
		tll.root = new Node();
		tll.root.val = 0;
		tll.root.parent = null;
		tll.root.left = null;
		tll.root.right = null;
		tll.root.next = new Node();
		tll.positiveLeafCount();
		
		switch (args[0]) {
		case "positiveLeafCount":
			tll.positiveLeafCount();
			break;
		default:
			// do nothing
		}
	}

}
