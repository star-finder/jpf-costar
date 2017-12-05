package star.linkedlist;

import linkedlist.MyLinkedList;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		MyLinkedList list = new MyLinkedList();
		switch (args[0]) {
		case "addLast":
			list.addLast(null);
			break;
		case "clear":
			list.clear();
			break;
		case "findPrevious":
			list.findPrevious(null);
			break;
		case "find":
			list.find(null);
			break;	
		case "first":
			list.first();
			break;
		case "isEmpty":
			list.isEmpty();
			break;
		case "remove":
			list.remove(null);
			break;
		case "size":
			list.size();
			break;
		default:
			// do nothing
		}
	}

}
