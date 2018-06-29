package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_addI1 extends TestJPF {

	@Test
	public void test_addI1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		obj.size = 0;
		int index_3 = -1;
		int index_1 = -1;
		int index = -1;
		java.lang.Object element_2 = new java.lang.Object();
		java.lang.Object element = element_2;
		java.lang.Object ele_341 = null;
		obj.modCount = 0;
		obj.header.element = ele_341;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.addI(index,element);
	}

	@Test
	public void test_addI2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_19 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_365 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_21 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_22 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_4 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_6 = next_19;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_365;
		int index_3 = 1;
		obj.size = 2;
		int index = 1;
		int index_1 = 1;
		int i_7 = 1;
		int i_5 = 0;
		doublelinkedlist.DoubleLinkedList.Entry prev_20 = prev_326;
		java.lang.Object element_2 = new java.lang.Object();
		java.lang.Object element = element_2;
		java.lang.Object ele_367 = null;
		java.lang.Object ele_366 = null;
		java.lang.Object ele_18 = null;
		obj.modCount = 0;
		obj.header.element = ele_18;
		obj.header.next = next_19;
		obj.header.previous = prev_20;
		next_19.element = ele_366;
		next_19.next = next_365;
		next_19.previous = prevE_21;
		next_365.element = ele_367;
		next_365.next = nextE_22;
		next_365.previous = next_19;
		//System.out.println(Utilities.repOK(obj));
		obj.addI(index,element);
	}

	@Test
	public void test_addI3() throws Exception {
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
		obj.addI(index,element);
	}

	@Test
	public void test_addI4() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		obj.size = 0;
		int index_3 = 1;
		int index_1 = 1;
		int index = 1;
		java.lang.Object element_2 = new java.lang.Object();
		java.lang.Object element = element_2;
		obj.modCount = 0;
		java.lang.Object ele_338 = null;
		obj.header.element = ele_338;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.addI(index,element);
	}

	@Test
	public void test_addI5() throws Exception {
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
		obj.addI(index,element);
	}

}

