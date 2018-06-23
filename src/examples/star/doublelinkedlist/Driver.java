package star.doublelinkedlist;

import doublelinkedlist.DoubleLinkedList;
import doublelinkedlist.Main;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		DoubleLinkedList list = new DoubleLinkedList();
		switch (args[0]) {
		case "addFirst":
			list.addFirst(null);
			break;
		case "addI":
			list.addI(0,null);
			break;
		case "addLast":
			list.addLast(null);
			break;
		case "add":
			list.add(null);
			break;	
		case "clear":
			list.clear();
			break;
		case "clone":
			list.clone();
			break;
		case "contains":
			list.contains(null);
			break;
		case "getFirst":
			list.getFirst();
			break;
		case "getLast":
			list.getLast();
			break;
		case "get":
			list.get(0);
			break;
		case "indexOf":
			list.indexOf(null);
			break;
		case "inList":
			list.inList(null);
			break;
		case "lastIndexOf":
			list.lastIndexOf(null);
			break;
		case "removeFirst":
			list.removeFirst();
			break;
		case "removeI":
			list.removeI(0);
			break;
		case "removeLast":
			list.removeLast();
			break;
		case "remove":
			list.remove(null);
			break;
		case "set":
			list.set(0,null);
			break;
		case "size":
			list.size();
			break;
		case "toArray":
			list.toArray();
			break;
		case "sample":
			Main main = new Main();
			Object o = new Object();
			main.sample(list, o);
		default:
			// do nothing
		}
	}

}
