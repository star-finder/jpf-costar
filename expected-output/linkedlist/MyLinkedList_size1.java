package linkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class MyLinkedList_size1 extends TestJPF {

	@Test
	public void test_size1() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		//System.out.println(Utilities.repOK(obj));
		obj.size();
	}

	@Test
	public void test_size2() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		obj._header = new linkedlist.MyListNode();
		linkedlist.MyListNode next = new linkedlist.MyListNode();
		java.lang.Object element_5 = new java.lang.Object();
		linkedlist.MyListNode next_6 = new linkedlist.MyListNode();
		java.lang.Object element_45 = new java.lang.Object();
		linkedlist.MyListNode itr_1 = obj._header;
		linkedlist.MyListNode itr_4 = next;
		linkedlist.MyListNode next_44 = null;
		obj._maxsize = 0;
		java.lang.Object element = null;
		obj._header._element = element;
		obj._header._next = next;
		next._element = element_5;
		next._next = next_6;
		next_6._element = element_45;
		next_6._next = next_44;
		//System.out.println(Utilities.repOK(obj));
		obj.size();
	}

	@Test
	public void test_size3() throws Exception {
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
		obj.size();
	}

}

