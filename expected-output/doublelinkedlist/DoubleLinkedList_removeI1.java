package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_removeI1 extends TestJPF {

	@Test
	public void test_removeI1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_10 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_361 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_12 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_13 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_5 = next_10;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_361;
		int i_6 = 1;
		obj.size = 2;
		int index_1 = 1;
		int index = 1;
		int i_4 = 0;
		int index_2 = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_11 = prev_326;
		java.lang.Object ele_363 = null;
		java.lang.Object ele_362 = null;
		obj.modCount = 0;
		java.lang.Object ele_9 = null;
		obj.header.element = ele_9;
		obj.header.next = next_10;
		obj.header.previous = prev_11;
		next_10.element = ele_362;
		next_10.next = next_361;
		next_10.previous = prevE_12;
		next_361.element = ele_363;
		next_361.next = nextE_13;
		next_361.previous = next_10;
		//System.out.println(Utilities.repOK(obj));
		obj.removeI(index);
	}

	@Test
	public void test_removeI2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		obj.size = 0;
		int index_1 = -1;
		int index = -1;
		int index_2 = -1;
		obj.modCount = 0;
		java.lang.Object ele_333 = null;
		obj.header.element = ele_333;
		obj.header.next = obj.header;
		obj.header.previous = obj.header;
		//System.out.println(Utilities.repOK(obj));
		obj.removeI(index);
	}

	@Test
	public void test_removeI3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = obj.header;
		obj.size = 0;
		java.lang.Object ele_1 = null;
		int index = 0;
		obj.modCount = 0;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		//System.out.println(Utilities.repOK(obj));
		obj.removeI(index);
	}

	@Test
	public void test_removeI4() throws Exception {
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
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		next_2.element = ele_341;
		next_2.next = nextE_5;
		next_2.previous = prevE_4;
		//System.out.println(Utilities.repOK(obj));
		obj.removeI(index);
	}

}

