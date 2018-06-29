package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_getLast1 extends TestJPF {

	@Test
	public void test_getLast1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prev_3 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevE_5 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry nextE_4 = obj.header;
		doublelinkedlist.DoubleLinkedList.Entry next_326 = prev_3;
		obj.size = 1;
		doublelinkedlist.DoubleLinkedList.Entry next_2 = next_326;
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
		obj.getLast();
	}

	@Test
	public void test_getLast2() throws Exception {
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
		obj.getLast();
	}

}

