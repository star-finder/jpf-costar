package linkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class MyLinkedList_insert1 extends TestJPF {

	@Test
	public void test_insert1() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyLinkedListItr p = new linkedlist.MyLinkedListItr();
		linkedlist.MyListNode next = null;
		linkedlist.MyListNode current_1 = null;
		java.lang.Object x = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		p._current = current_1;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x,p);
	}

	@Test
	public void test_insert2() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = null;
		linkedlist.MyLinkedListItr p = null;
		java.lang.Object x = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x,p);
	}

	@Test
	public void test_insert3() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyLinkedListItr p = new linkedlist.MyLinkedListItr();
		linkedlist.MyListNode current_1 = new linkedlist.MyListNode();
		java.lang.Object element_2 = new java.lang.Object();
		linkedlist.MyListNode next = null;
		linkedlist.MyListNode next_3 = null;
		java.lang.Object x = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		p._current = current_1;
		current_1._element = element_2;
		current_1._next = next_3;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x,p);
	}

}

