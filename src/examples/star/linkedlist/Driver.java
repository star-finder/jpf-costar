package star.linkedlist;

import java.io.IOException;

import linkedlist.MyLinkedList;
import linkedlist.MyLinkedListItr;
import linkedlist.MyListNode;

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
		case "insert":
			Object x = new Object();
			MyListNode node = new MyListNode();
			MyLinkedListItr itr = new MyLinkedListItr(node);
			list.insert(x, itr);
			break;
		case "isEmpty":
			list.isEmpty();
			break;
		case "printList":
			try {
				MyLinkedList theList = new MyLinkedList();
				list.printList(theList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
