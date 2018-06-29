package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_remove1 extends TestJPF {

	@Test
	public void test_remove1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_4 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_6 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_7 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_2 = next_4;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_4;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_5 = prev_326;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_3 = null;
		java.lang.Object ele_350 = null;
		obj.modCount = 0;
		obj.header.element = ele_3;
		obj.header.next = next_4;
		obj.header.previous = prev_5;
		next_4.element = ele_350;
		next_4.next = nextE_7;
		next_4.previous = prevE_6;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(o);
	}

	@Test
	public void test_remove2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_5 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_10 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_7 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_2 = next_5;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = next_10;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = next_5;
		doublelinkedlist.DoubleLinkedList.Entry prev_327 = next_10;
		obj.size = 2;
		doublelinkedlist.DoubleLinkedList.Entry prev_6 = prev_327;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_9 = new java.lang.Object();
		java.lang.Object ele_366 = null;
		java.lang.Object ele_4 = null;
		obj.modCount = 0;
		obj.header.element = ele_4;
		obj.header.next = next_5;
		obj.header.previous = prev_6;
		next_5.element = ele_9;
		next_5.next = next_10;
		next_5.previous = prevE_7;
		next_10.element = ele_366;
		next_10.next = nextE_8;
		next_10.previous = next_326;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(o);
	}

	@Test
	public void test_remove3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_5 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_10 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_7 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_8 = obj.header;
		java.lang.Object o_1 = null;
		doublelinkedlist.DoubleLinkedList.Entry e_2 = next_5;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = next_10;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = next_5;
		doublelinkedlist.DoubleLinkedList.Entry prev_327 = next_10;
		obj.size = 2;
		java.lang.Object o = o_1;
		doublelinkedlist.DoubleLinkedList.Entry prev_6 = prev_327;
		java.lang.Object ele_9 = new java.lang.Object();
		java.lang.Object ele_367 = null;
		java.lang.Object ele_4 = null;
		obj.modCount = 0;
		obj.header.element = ele_4;
		obj.header.next = next_5;
		obj.header.previous = prev_6;
		next_5.element = ele_9;
		next_5.next = next_10;
		next_5.previous = prevE_7;
		next_10.element = ele_367;
		next_10.next = nextE_8;
		next_10.previous = next_326;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(o);
	}

	@Test
	public void test_remove4() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		obj.size = 0;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		obj.modCount = 0;
		java.lang.Object ele_333 = null;
		obj.header.element = ele_333;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(o);
	}

	@Test
	public void test_remove5() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_5 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_7 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_6 = next_5;
		java.lang.Object o_1 = null;
		doublelinkedlist.DoubleLinkedList.Entry e_2 = next_5;
		obj.size = 1;
		java.lang.Object o = o_1;
		java.lang.Object ele_9 = new java.lang.Object();
		java.lang.Object ele_4 = null;
		obj.modCount = 0;
		obj.header.element = ele_4;
		obj.header.next = next_5;
		obj.header.previous = prev_6;
		next_5.element = ele_9;
		next_5.next = nextE_8;
		next_5.previous = prevE_7;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(o);
	}

	@Test
	public void test_remove6() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_6 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_9 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_7 = next_6;
		doublelinkedlist.DoubleLinkedList.Entry e_2 = next_6;
		obj.size = 1;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_10 = o_1;
		java.lang.Object ele_5 = null;
		obj.modCount = 0;
		obj.header.element = ele_5;
		obj.header.next = next_6;
		obj.header.previous = prev_7;
		next_6.element = ele_10;
		next_6.next = nextE_9;
		next_6.previous = prevE_8;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(o);
	}

	@Test
	public void test_remove7() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = obj.header;
		obj.size = 0;
		java.lang.Object ele_1 = null;
		obj.modCount = 0;
		java.lang.Object o = null;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(o);
	}

	@Test
	public void test_remove8() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_4 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_5 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_2;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = prev_326;
		java.lang.Object o = null;
		java.lang.Object ele_1 = null;
		java.lang.Object ele_341 = null;
		obj.modCount = 0;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		next_2.element = ele_341;
		next_2.next = nextE_5;
		next_2.previous = prevE_4;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(o);
	}

}

