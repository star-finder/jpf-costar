package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_size1 extends TestJPF {

	@Test
	public void test_size1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = obj.header;
		obj.size = 0;
		java.lang.Object ele_1 = null;
		obj.modCount = 0;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		//System.out.println(Utilities.repOK(obj));
		obj.size();
	}

	@Test
	public void test_size2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next_2 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_4 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_5 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry prev_326 = next_2;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = prev_326;
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
		obj.size();
	}

}

