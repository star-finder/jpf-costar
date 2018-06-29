package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_contains1 extends TestJPF {

	@Test
	public void test_contains1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_10 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_12 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_13 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_11 = next_10;
		doublelinkedlist.DoubleLinkedList.Entry e_4 = next_10;
		obj.size = 1;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object o_2 = o_1;
		java.lang.Object ele_14 = o_2;
		obj.modCount = 0;
		java.lang.Object ele_9 = null;
		obj.header.element = ele_9;
		obj.header.next = next_10;
		obj.header.previous = prev_11;
		next_10.element = ele_14;
		next_10.next = nextE_13;
		next_10.previous = prevE_12;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(o);
	}

	@Test
	public void test_contains2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_6 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_9 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_7 = next_6;
		java.lang.Object o_2 = null;
		doublelinkedlist.DoubleLinkedList.Entry e_4 = next_6;
		obj.size = 1;
		java.lang.Object o_1 = o_2;
		java.lang.Object o = o_1;
		java.lang.Object ele_10 = new java.lang.Object();
		java.lang.Object ele_5 = null;
		obj.modCount = 0;
		obj.header.element = ele_5;
		obj.header.next = next_6;
		obj.header.previous = prev_7;
		next_6.element = ele_10;
		next_6.next = nextE_9;
		next_6.previous = prevE_8;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(o);
	}

	@Test
	public void test_contains3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_6 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_9 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_4 = next_6;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_6;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_7 = prev_326;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object o_2 = o_1;
		java.lang.Object ele_354 = null;
		java.lang.Object ele_5 = null;
		obj.modCount = 0;
		obj.header.element = ele_5;
		obj.header.next = next_6;
		obj.header.previous = prev_7;
		next_6.element = ele_354;
		next_6.next = nextE_9;
		next_6.previous = prevE_8;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(o);
	}

	@Test
	public void test_contains4() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_8 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_13 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_10 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_11 = obj.header;
		java.lang.Object o_2 = null;
		doublelinkedlist.DoubleLinkedList.Entry e_4 = next_8;
		doublelinkedlist.DoubleLinkedList.Entry e_6 = next_13;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = next_8;
		doublelinkedlist.DoubleLinkedList.Entry prev_327 = next_13;
		obj.size = 2;
		java.lang.Object o_1 = o_2;
		doublelinkedlist.DoubleLinkedList.Entry prev_9 = prev_327;
		java.lang.Object o = o_1;
		java.lang.Object ele_12 = new java.lang.Object();
		java.lang.Object ele_375 = null;
		java.lang.Object ele_7 = null;
		obj.modCount = 0;
		obj.header.element = ele_7;
		obj.header.next = next_8;
		obj.header.previous = prev_9;
		next_8.element = ele_12;
		next_8.next = next_13;
		next_8.previous = prevE_10;
		next_13.element = ele_375;
		next_13.next = nextE_11;
		next_13.previous = next_326;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(o);
	}

	@Test
	public void test_contains5() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_8 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_13 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_10 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_11 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_4 = next_8;
		doublelinkedlist.DoubleLinkedList.Entry e_6 = next_13;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = next_8;
		doublelinkedlist.DoubleLinkedList.Entry prev_327 = next_13;
		obj.size = 2;
		doublelinkedlist.DoubleLinkedList.Entry prev_9 = prev_327;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object o_2 = o_1;
		java.lang.Object ele_12 = new java.lang.Object();
		java.lang.Object ele_374 = null;
		java.lang.Object ele_7 = null;
		obj.modCount = 0;
		obj.header.element = ele_7;
		obj.header.next = next_8;
		obj.header.previous = prev_9;
		next_8.element = ele_12;
		next_8.next = next_13;
		next_8.previous = prevE_10;
		next_13.element = ele_374;
		next_13.next = nextE_11;
		next_13.previous = next_326;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(o);
	}

	@Test
	public void test_contains6() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		obj.size = 0;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object o_2 = o_1;
		obj.modCount = 0;
		java.lang.Object ele_337 = null;
		obj.header.element = ele_337;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(o);
	}

	@Test
	public void test_contains7() throws Exception {
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
		obj.contains(o);
	}

	@Test
	public void test_contains8() throws Exception {
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
		obj.contains(o);
	}

}

