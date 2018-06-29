package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_indexOf1 extends TestJPF {

	@Test
	public void test_indexOf1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_5 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_7 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_6 = next_5;
		java.lang.Object o_1 = null;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = next_5;
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
		obj.indexOf(o);
	}

	@Test
	public void test_indexOf2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_9 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_11 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_12 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_10 = next_9;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = next_9;
		obj.size = 1;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_13 = o_1;
		java.lang.Object ele_8 = null;
		obj.modCount = 0;
		obj.header.element = ele_8;
		obj.header.next = next_9;
		obj.header.previous = prev_10;
		next_9.element = ele_13;
		next_9.next = nextE_12;
		next_9.previous = prevE_11;
		//System.out.println(Utilities.repOK(obj));
		obj.indexOf(o);
	}

	@Test
	public void test_indexOf3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		obj.size = 0;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		obj.modCount = 0;
		java.lang.Object ele_335 = null;
		obj.header.element = ele_335;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.indexOf(o);
	}

	@Test
	public void test_indexOf4() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_5 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_7 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = next_5;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_5;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_6 = prev_326;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_4 = null;
		java.lang.Object ele_352 = null;
		obj.modCount = 0;
		obj.header.element = ele_4;
		obj.header.next = next_5;
		obj.header.previous = prev_6;
		next_5.element = ele_352;
		next_5.next = nextE_8;
		next_5.previous = prevE_7;
		//System.out.println(Utilities.repOK(obj));
		obj.indexOf(o);
	}

	@Test
	public void test_indexOf5() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_7 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_12 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_9 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_10 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = next_7;
		doublelinkedlist.DoubleLinkedList.Entry e_5 = next_12;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = next_7;
		doublelinkedlist.DoubleLinkedList.Entry prev_327 = next_12;
		obj.size = 2;
		doublelinkedlist.DoubleLinkedList.Entry prev_8 = prev_327;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_11 = new java.lang.Object();
		java.lang.Object ele_6 = null;
		java.lang.Object ele_372 = null;
		obj.modCount = 0;
		obj.header.element = ele_6;
		obj.header.next = next_7;
		obj.header.previous = prev_8;
		next_7.element = ele_11;
		next_7.next = next_12;
		next_7.previous = prevE_9;
		next_12.element = ele_372;
		next_12.next = nextE_10;
		next_12.previous = next_326;
		//System.out.println(Utilities.repOK(obj));
		obj.indexOf(o);
	}

	@Test
	public void test_indexOf6() throws Exception {
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
		obj.indexOf(o);
	}

	@Test
	public void test_indexOf7() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_7 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_12 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_9 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_10 = obj.header;
		java.lang.Object o_1 = null;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = next_7;
		doublelinkedlist.DoubleLinkedList.Entry e_5 = next_12;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = next_7;
		doublelinkedlist.DoubleLinkedList.Entry prev_327 = next_12;
		obj.size = 2;
		java.lang.Object o = o_1;
		doublelinkedlist.DoubleLinkedList.Entry prev_8 = prev_327;
		java.lang.Object ele_11 = new java.lang.Object();
		java.lang.Object ele_6 = null;
		java.lang.Object ele_373 = null;
		obj.modCount = 0;
		obj.header.element = ele_6;
		obj.header.next = next_7;
		obj.header.previous = prev_8;
		next_7.element = ele_11;
		next_7.next = next_12;
		next_7.previous = prevE_9;
		next_12.element = ele_373;
		next_12.next = nextE_10;
		next_12.previous = next_326;
		//System.out.println(Utilities.repOK(obj));
		obj.indexOf(o);
	}

	@Test
	public void test_indexOf8() throws Exception {
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
		obj.indexOf(o);
	}

}

