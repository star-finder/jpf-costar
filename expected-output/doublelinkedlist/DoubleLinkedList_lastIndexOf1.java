package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_lastIndexOf1 extends TestJPF {

	@Test
	public void test_lastIndexOf1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_8 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_12 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_10 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_9 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = prev_8;
		doublelinkedlist.DoubleLinkedList.Entry e_5 = prev_12;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = prev_8;
		doublelinkedlist.DoubleLinkedList.Entry next_327 = prev_12;
		obj.size = 2;
		int index_2 = 2;
		doublelinkedlist.DoubleLinkedList.Entry next_7 = next_327;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_11 = new java.lang.Object();
		java.lang.Object ele_6 = null;
		java.lang.Object ele_373 = null;
		obj.modCount = 0;
		obj.header.element = ele_6;
		obj.header.next = next_7;
		obj.header.previous = prev_8;
		prev_8.element = ele_11;
		prev_8.next = nextE_9;
		prev_8.previous = prev_12;
		prev_12.element = ele_373;
		prev_12.next = prev_326;
		prev_12.previous = prevE_10;
		//System.out.println(Utilities.repOK(obj));
		obj.lastIndexOf(o);
	}

	@Test
	public void test_lastIndexOf2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_10 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_12 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_11 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry next_9 = prev_10;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = prev_10;
		obj.size = 1;
		int index_2 = 1;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_13 = o_1;
		java.lang.Object ele_8 = null;
		obj.modCount = 0;
		obj.header.element = ele_8;
		obj.header.next = next_9;
		obj.header.previous = prev_10;
		prev_10.element = ele_13;
		prev_10.next = nextE_11;
		prev_10.previous = prevE_12;
		//System.out.println(Utilities.repOK(obj));
		obj.lastIndexOf(o);
	}

	@Test
	public void test_lastIndexOf3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_5 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_4 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = prev_3;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry next_2 = next_326;
		java.lang.Object o = null;
		java.lang.Object ele_1 = null;
		java.lang.Object ele_341 = null;
		obj.modCount = 0;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		prev_3.element = ele_341;
		prev_3.next = nextE_4;
		prev_3.previous = prevE_5;
		//System.out.println(Utilities.repOK(obj));
		obj.lastIndexOf(o);
	}

	@Test
	public void test_lastIndexOf4() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_8 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_12 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_10 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_9 = obj.header;
		java.lang.Object o_1 = null;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = prev_8;
		doublelinkedlist.DoubleLinkedList.Entry e_5 = prev_12;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = prev_8;
		doublelinkedlist.DoubleLinkedList.Entry next_327 = prev_12;
		obj.size = 2;
		int index_2 = 2;
		java.lang.Object o = o_1;
		doublelinkedlist.DoubleLinkedList.Entry next_7 = next_327;
		java.lang.Object ele_11 = new java.lang.Object();
		java.lang.Object ele_6 = null;
		java.lang.Object ele_374 = null;
		obj.modCount = 0;
		obj.header.element = ele_6;
		obj.header.next = next_7;
		obj.header.previous = prev_8;
		prev_8.element = ele_11;
		prev_8.next = nextE_9;
		prev_8.previous = prev_12;
		prev_12.element = ele_374;
		prev_12.next = prev_326;
		prev_12.previous = prevE_10;
		//System.out.println(Utilities.repOK(obj));
		obj.lastIndexOf(o);
	}

	@Test
	public void test_lastIndexOf5() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		obj.size = 0;
		int index_2 = 0;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		obj.modCount = 0;
		java.lang.Object ele_335 = null;
		obj.header.element = ele_335;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.lastIndexOf(o);
	}

	@Test
	public void test_lastIndexOf6() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_6 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_7 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = prev_6;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = prev_6;
		obj.size = 1;
		int index_2 = 1;
		doublelinkedlist.DoubleLinkedList.Entry next_5 = next_326;
		java.lang.Object o_1 = new java.lang.Object();
		java.lang.Object o = o_1;
		java.lang.Object ele_4 = null;
		java.lang.Object ele_352 = null;
		obj.modCount = 0;
		obj.header.element = ele_4;
		obj.header.next = next_5;
		obj.header.previous = prev_6;
		prev_6.element = ele_352;
		prev_6.next = nextE_7;
		prev_6.previous = prevE_8;
		//System.out.println(Utilities.repOK(obj));
		obj.lastIndexOf(o);
	}

	@Test
	public void test_lastIndexOf7() throws Exception {
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
		obj.lastIndexOf(o);
	}

	@Test
	public void test_lastIndexOf8() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_7 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_9 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry next_6 = prev_7;
		java.lang.Object o_1 = null;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = prev_7;
		obj.size = 1;
		int index_2 = 1;
		java.lang.Object o = o_1;
		java.lang.Object ele_10 = new java.lang.Object();
		java.lang.Object ele_5 = null;
		obj.modCount = 0;
		obj.header.element = ele_5;
		obj.header.next = next_6;
		obj.header.previous = prev_7;
		prev_7.element = ele_10;
		prev_7.next = nextE_8;
		prev_7.previous = prevE_9;
		//System.out.println(Utilities.repOK(obj));
		obj.lastIndexOf(o);
	}

}

