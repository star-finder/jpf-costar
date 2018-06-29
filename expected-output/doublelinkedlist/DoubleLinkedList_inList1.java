package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_inList1 extends TestJPF {

	@Test
	public void test_inList1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_5 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_7 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_8 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry tmp_2 = next_5;
		doublelinkedlist.DoubleLinkedList.Entry e_1 = tmp_2;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_5;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry e = e_1;
		doublelinkedlist.DoubleLinkedList.Entry prev_6 = prev_326;
		java.lang.Object ele_4 = null;
		java.lang.Object ele_351 = null;
		obj.modCount = 0;
		obj.header.element = ele_4;
		obj.header.next = next_5;
		obj.header.previous = prev_6;
		next_5.element = ele_351;
		next_5.next = nextE_8;
		next_5.previous = prevE_7;
		//System.out.println(Utilities.repOK(obj));
		obj.inList(e);
	}

	@Test
	public void test_inList2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry e_1 = obj.header;
		obj.size = 0;
		doublelinkedlist.DoubleLinkedList.Entry e = e_1;
		obj.modCount = 0;
		java.lang.Object ele_332 = null;
		obj.header.element = ele_332;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.inList(e);
	}

	@Test
	public void test_inList3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = obj.header;
		obj.size = 0;
		java.lang.Object ele_1 = null;
		doublelinkedlist.DoubleLinkedList.Entry e = null;
		obj.modCount = 0;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		//System.out.println(Utilities.repOK(obj));
		obj.inList(e);
	}

	@Test
	public void test_inList4() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_4 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_5 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_2;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = prev_326;
		doublelinkedlist.DoubleLinkedList.Entry e = null;
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
		obj.inList(e);
	}

}

