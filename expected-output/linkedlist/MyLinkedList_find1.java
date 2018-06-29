package linkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class MyLinkedList_find1 extends TestJPF {

	@Test
	public void test_find1() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = null;
		java.lang.Object x = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

	@Test
	public void test_find2() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_7 = new java.lang.Object();
		linkedlist.MyListNode itr_2 = next;
		java.lang.Object x_1 = element_7;
		linkedlist.MyListNode next_8 = null;
		java.lang.Object x = x_1;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		next._element = element_7;
		next._next = next_8;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

	@Test
	public void test_find3() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_1 = new java.lang.Object();
		linkedlist.MyListNode next_2 = null;
		java.lang.Object x = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		next._element = element_1;
		next._next = next_2;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

	@Test
	public void test_find4() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_6 = new java.lang.Object();
		linkedlist.MyListNode next_7 = new linkedlist.MyListNode();
		java.lang.Object element_43 = new java.lang.Object();
		linkedlist.MyListNode itr_2 = next;
		linkedlist.MyListNode itr_3 = next_7;
		linkedlist.MyListNode next_42 = null;
		java.lang.Object x_1 = new java.lang.Object();
		java.lang.Object x = x_1;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		next._element = element_6;
		next._next = next_7;
		next_7._element = element_43;
		next_7._next = next_42;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

}

