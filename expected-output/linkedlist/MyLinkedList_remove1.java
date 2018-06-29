package linkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class MyLinkedList_remove1 extends TestJPF {

	@Test
	public void test_remove1() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = null;
		java.lang.Object x = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove2() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_9 = new java.lang.Object();
		linkedlist.MyListNode itr_3 = obj._header;
		java.lang.Object x_2 = element_9;
		linkedlist.MyListNode next_10 = null;
		java.lang.Object x_1 = x_2;
		java.lang.Object x = x_1;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		next._element = element_9;
		next._next = next_10;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove3() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_8 = new java.lang.Object();
		linkedlist.MyListNode next_9 = new linkedlist.MyListNode();
		java.lang.Object element_45 = new java.lang.Object();
		linkedlist.MyListNode itr_3 = obj._header;
		linkedlist.MyListNode itr_4 = next;
		linkedlist.MyListNode next_44 = null;
		java.lang.Object x_1 = new java.lang.Object();
		java.lang.Object x = x_1;
		java.lang.Object x_2 = x_1;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		next._element = element_8;
		next._next = next_9;
		next_9._element = element_45;
		next_9._next = next_44;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove4() throws Exception {
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
		obj.remove(x);
	}

}

