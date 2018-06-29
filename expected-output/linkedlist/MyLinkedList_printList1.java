package linkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class MyLinkedList_printList1 extends TestJPF {

	@Test
	public void test_printList1() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyLinkedList theList = new linkedlist.MyLinkedList();
		linkedlist.MyListNode header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_1 = new java.lang.Object();
		linkedlist.MyListNode nextH = null;
		linkedlist.MyListNode next_2 = null;
		java.lang.Object element_25 = new java.lang.Object();
		java.lang.Object element = element_25;
		int size = 0;
		obj._maxsize = 0;
		obj._header._element = element;
		obj._header._next = nextH;
		theList._header = header;
		theList._maxsize = size;
		header._element = element_25;
		header._next = next;
		next._element = element_1;
		next._next = next_2;
		//System.out.println(Utilities.repOK(obj));
		obj.printList(theList);
	}

	@Test
	public void test_printList2() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyLinkedList theList = new linkedlist.MyLinkedList();
		linkedlist.MyListNode header = new linkedlist.MyListNode();
		linkedlist.MyListNode nextH = null;
		linkedlist.MyListNode next = null;
		java.lang.Object element_25 = new java.lang.Object();
		java.lang.Object element = element_25;
		int size = 0;
		obj._maxsize = 0;
		obj._header._element = element;
		obj._header._next = nextH;
		theList._header = header;
		theList._maxsize = size;
		header._element = element_25;
		header._next = next;
		//System.out.println(Utilities.repOK(obj));
		obj.printList(theList);
	}

}

