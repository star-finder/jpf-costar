package star.tll;

import tll.Node;
import tll.Tll;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		Tll tll = new Tll();
		tll.root = new Node();
		switch (args[0]) {
		case "positiveLeafCount":
			tll.positiveLeafCount();
			break;
		default:
			// do nothing
		}
	}

}
