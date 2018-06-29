package linkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class MyLinkedList_first1 extends TestJPF {

	@Test
	public void test_first1() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		//System.out.println(Utilities.repOK(obj));
		obj.first();
	}

	@Test
	public void test_first2() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_1 = new java.lang.Object();
		linkedlist.MyListNode next_2 = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		next._element = element_1;
		next._next = next_2;
		//System.out.println(Utilities.repOK(obj));
		obj.first();
	}

}

