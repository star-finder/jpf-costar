package linkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class MyLinkedList_addLast1 extends TestJPF {

	@Test
	public void test_addLast1() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = null;
		java.lang.Object x = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		//System.out.println(Utilities.repOK(obj));
		obj.addLast(x);
	}

	@Test
	public void test_addLast2() throws Exception {
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
		obj.addLast(x);
	}

	@Test
	public void test_addLast3() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_14 = new java.lang.Object();
		linkedlist.MyListNode next_15 = new linkedlist.MyListNode();
		java.lang.Object element_41 = new java.lang.Object();
		linkedlist.MyListNode itr_2 = obj._header;
		linkedlist.MyListNode itr_3 = next;
		linkedlist.MyListNode next_40 = null;
		java.lang.Object x_1 = new java.lang.Object();
		java.lang.Object x = x_1;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		next._element = element_14;
		next._next = next_15;
		next_15._element = element_41;
		next_15._next = next_40;
		//System.out.println(Utilities.repOK(obj));
		obj.addLast(x);
	}

}

