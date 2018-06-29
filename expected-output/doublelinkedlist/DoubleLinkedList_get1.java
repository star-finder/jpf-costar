package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_get1 extends TestJPF {

	@Test
	public void test_get1() throws Exception {
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
		obj.get(index);
	}

	@Test
	public void test_get2() throws Exception {
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
		obj.get(index);
	}

	@Test
	public void test_get3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_8 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_361 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_10 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_11 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_3 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry e_5 = next_8;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_361;
		int i_6 = 1;
		obj.size = 2;
		int index = 1;
		int index_1 = 1;
		int i_4 = 0;
		int index_2 = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_9 = prev_326;
		java.lang.Object ele_363 = null;
		java.lang.Object ele_362 = null;
		java.lang.Object ele_7 = null;
		obj.modCount = 0;
		obj.header.element = ele_7;
		obj.header.next = next_8;
		obj.header.previous = prev_9;
		next_8.element = ele_362;
		next_8.next = next_361;
		next_8.previous = prevE_10;
		next_361.element = ele_363;
		next_361.next = nextE_11;
		next_361.previous = next_8;
		//System.out.println(Utilities.repOK(obj));
		obj.get(index);
	}

	@Test
	public void test_get4() throws Exception {
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
		obj.get(index);
	}

}

