package star.rbt;

import rbt.TreeMap;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		TreeMap tree = new TreeMap();
		switch (args[0]) {
		case "containsKey":
			tree.containsKey(0);
			break;
		case "containsValue":
			tree.containsValue(null);
			break;
		case "firstKey":
			tree.firstKey();
			break;
		case "get":
			tree.get(0);
			break;	
		case "lastKey":
			tree.lastKey();
			break;
		case "put":
			tree.put(0, null);
			break;
		case "remove":
			tree.remove(0);
			break;
		default:
			// do nothing
		}
	}

}
