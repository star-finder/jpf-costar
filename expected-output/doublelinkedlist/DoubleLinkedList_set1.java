package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_set1 extends TestJPF {

	@Test
	public void test_set1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_11 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_363 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_13 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_14 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_4 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_6 = next_11;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_363;
		int index_3 = 1;
		obj.size = 2;
		int index = 1;
		int index_1 = 1;
		int i_7 = 1;
		int i_5 = 0;
		doublelinkedlist.DoubleLinkedList.Entry prev_12 = prev_326;
		java.lang.Object ele_365 = null;
		java.lang.Object ele_364 = null;
		obj.modCount = 0;
		java.lang.Object ele_10 = null;
		java.lang.Object element = null;
		obj.header.element = ele_10;
		obj.header.next = next_11;
		obj.header.previous = prev_12;
		next_11.element = ele_364;
		next_11.next = next_363;
		next_11.previous = prevE_13;
		next_363.element = ele_365;
		next_363.next = nextE_14;
		next_363.previous = next_11;
		//System.out.println(Utilities.repOK(obj));
		obj.set(index,element);
	}

	@Test
	public void test_set2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		obj.size = 0;
		int index_3 = -1;
		int index_1 = -1;
		int index = -1;
		obj.modCount = 0;
		java.lang.Object element = null;
		java.lang.Object ele_335 = null;
		obj.header.element = ele_335;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.set(index,element);
	}

	@Test
	public void test_set3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = obj.header;
		obj.size = 0;
		java.lang.Object ele_1 = null;
		int index = 0;
		obj.modCount = 0;
		java.lang.Object element = null;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		//System.out.println(Utilities.repOK(obj));
		obj.set(index,element);
	}

	@Test
	public void test_set4() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_4 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_5 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_2;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = prev_326;
		int index = 0;
		java.lang.Object ele_1 = null;
		java.lang.Object ele_341 = null;
		obj.modCount = 0;
		java.lang.Object element = null;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		next_2.element = ele_341;
		next_2.next = nextE_5;
		next_2.previous = prevE_4;
		//System.out.println(Utilities.repOK(obj));
		obj.set(index,element);
	}

}

