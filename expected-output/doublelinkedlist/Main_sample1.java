package doublelinkedlist;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class Main_sample1 extends TestJPF {

	@Test
	public void test_sample1() throws Exception {
		Main obj = new Main();
		java.lang.Object o = new java.lang.Object();
		doublelinkedlist.DoubleLinkedList dll = new doublelinkedlist.DoubleLinkedList();
		doublelinkedlist.DoubleLinkedList.Entry header_2 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry header_326 = header_2;
		doublelinkedlist.DoubleLinkedList.Entry header_327 = header_2;
		int size_3 = 0;
		java.lang.Object ele_4 = null;
		int modCount_1 = 0;
		dll.modCount = modCount_1;
		dll.header = header_2;
		dll.size = size_3;
		header_2.element = ele_4;
		header_2.next = header_326;
		header_2.previous = header_327;
		//System.out.println(Utilities.repOK(dll));
		obj.sample(dll,o);
	}

	@Test
	public void test_sample2() throws Exception {
		Main obj = new Main();
		java.lang.Object o = new java.lang.Object();
		doublelinkedlist.DoubleLinkedList dll = new doublelinkedlist.DoubleLinkedList();
		doublelinkedlist.DoubleLinkedList.Entry header_20 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry first_24 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry last_25 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry newNode_7 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry nextF_27 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next1_410 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevF_28 = header_20;
		doublelinkedlist.DoubleLinkedList.Entry nextL_30 = header_20;
		doublelinkedlist.DoubleLinkedList dll_1 = dll;
		java.lang.Object o_2 = o;
		java.lang.Object o_4 = o_2;
		java.lang.Object o_5 = o_4;
		doublelinkedlist.DoubleLinkedList.Entry e_6 = header_20;
		java.lang.Object element_11 = o_5;
		doublelinkedlist.DoubleLinkedList.Entry next_12 = e_6;
		doublelinkedlist.DoubleLinkedList.Entry previous_13 = last_25;
		java.lang.Object element_47 = element_11;
		doublelinkedlist.DoubleLinkedList.Entry next_48 = next_12;
		doublelinkedlist.DoubleLinkedList.Entry previous_49 = previous_13;
		doublelinkedlist.DoubleLinkedList.Entry newEntry_14 = newNode_7;
		doublelinkedlist.DoubleLinkedList.Entry nextL_50 = newEntry_14;
		doublelinkedlist.DoubleLinkedList.Entry last_51 = newEntry_14;
		doublelinkedlist.DoubleLinkedList.Entry first_326 = first_24;
		doublelinkedlist.DoubleLinkedList.Entry last_327 = last_25;
		doublelinkedlist.DoubleLinkedList.Entry next1_413 = last_327;
		doublelinkedlist.DoubleLinkedList.Entry prevL_328 = next1_410;
		int size_21 = 4;
		int modCount_19 = 0;
		doublelinkedlist.DoubleLinkedList.Entry prevL_31 = prevL_328;
		doublelinkedlist.DoubleLinkedList.Entry next_9 = null;
		java.lang.Object item_414 = null;
		java.lang.Object ele2_29 = null;
		java.lang.Object item_411 = null;
		java.lang.Object element_8 = null;
		java.lang.Object eleH_23 = null;
		doublelinkedlist.DoubleLinkedList.Entry previous_10 = null;
		java.lang.Object ele1_26 = null;
		dll.modCount = modCount_19;
		dll.header = header_20;
		dll.size = size_21;
		header_20.element = eleH_23;
		header_20.next = first_24;
		header_20.previous = last_25;
		first_24.element = ele1_26;
		first_24.next = nextF_27;
		first_24.previous = prevF_28;
		last_25.element = ele2_29;
		last_25.next = nextL_30;
		last_25.previous = prevL_31;
		newNode_7.element = element_8;
		newNode_7.next = next_9;
		newNode_7.previous = previous_10;
		nextF_27.element = item_411;
		nextF_27.next = next1_410;
		nextF_27.previous = first_326;
		next1_410.element = item_414;
		next1_410.next = next1_413;
		next1_410.previous = nextF_27;
		//System.out.println(Utilities.repOK(dll));
		obj.sample(dll,o);
	}

	@Test
	public void test_sample3() throws Exception {
		Main obj = new Main();
		java.lang.Object o = new java.lang.Object();
		doublelinkedlist.DoubleLinkedList dll = new doublelinkedlist.DoubleLinkedList();
		doublelinkedlist.DoubleLinkedList.Entry header_33 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry first_37 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry last_38 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry nextF_40 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next1_76 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry next1_98 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry newNode_7 = new doublelinkedlist.DoubleLinkedList.Entry();
		doublelinkedlist.DoubleLinkedList.Entry prevF_41 = header_33;
		doublelinkedlist.DoubleLinkedList.Entry nextL_43 = header_33;
		doublelinkedlist.DoubleLinkedList.Entry prev1_77 = first_37;
		doublelinkedlist.DoubleLinkedList.Entry prev1_99 = nextF_40;
		doublelinkedlist.DoubleLinkedList.Entry prev1_117 = next1_76;
		doublelinkedlist.DoubleLinkedList.Entry next1_116 = last_38;
		doublelinkedlist.DoubleLinkedList.Entry prevL_44 = next1_98;
		doublelinkedlist.DoubleLinkedList dll_1 = dll;
		java.lang.Object o_2 = o;
		java.lang.Object o_4 = o_2;
		java.lang.Object o_5 = o_4;
		doublelinkedlist.DoubleLinkedList.Entry e_6 = header_33;
		java.lang.Object element_11 = o_5;
		doublelinkedlist.DoubleLinkedList.Entry next_12 = e_6;
		doublelinkedlist.DoubleLinkedList.Entry previous_13 = last_38;
		java.lang.Object element_141 = element_11;
		doublelinkedlist.DoubleLinkedList.Entry next_142 = next_12;
		doublelinkedlist.DoubleLinkedList.Entry previous_143 = previous_13;
		doublelinkedlist.DoubleLinkedList.Entry newEntry_14 = newNode_7;
		doublelinkedlist.DoubleLinkedList.Entry nextL_144 = newEntry_14;
		doublelinkedlist.DoubleLinkedList.Entry last_145 = newEntry_14;
		doublelinkedlist.DoubleLinkedList.Entry e_17 = header_33;
		doublelinkedlist.DoubleLinkedList.Entry e_19 = first_37;
		doublelinkedlist.DoubleLinkedList.Entry e_21 = nextF_40;
		doublelinkedlist.DoubleLinkedList.Entry e_23 = next1_76;
		doublelinkedlist.DoubleLinkedList.Entry e_25 = next1_98;
		doublelinkedlist.DoubleLinkedList.Entry e_27 = next1_116;
		doublelinkedlist.DoubleLinkedList.Entry e_29 = e_27;
		doublelinkedlist.DoubleLinkedList.Entry e_30 = e_29;
		doublelinkedlist.DoubleLinkedList.Entry next1_148 = nextL_144;
		doublelinkedlist.DoubleLinkedList.Entry previous_149 = prevL_44;
		int size_34 = 5;
		int modCount_32 = -1;
		java.lang.Object o2_31 = new java.lang.Object();
		java.lang.Object ele2_42 = o2_31;
		java.lang.Object eleH_36 = null;
		doublelinkedlist.DoubleLinkedList.Entry next_9 = null;
		java.lang.Object ele1_39 = null;
		java.lang.Object element_8 = null;
		java.lang.Object item_75 = null;
		java.lang.Object item_115 = null;
		java.lang.Object item_97 = null;
		doublelinkedlist.DoubleLinkedList.Entry previous_10 = null;
		dll.modCount = modCount_32;
		dll.header = header_33;
		dll.size = size_34;
		header_33.element = eleH_36;
		header_33.next = first_37;
		header_33.previous = last_38;
		first_37.element = ele1_39;
		first_37.next = nextF_40;
		first_37.previous = prevF_41;
		last_38.element = ele2_42;
		last_38.next = nextL_43;
		last_38.previous = prevL_44;
		nextF_40.element = item_75;
		nextF_40.next = next1_76;
		nextF_40.previous = prev1_77;
		next1_76.element = item_97;
		next1_76.next = next1_98;
		next1_76.previous = prev1_99;
		next1_98.element = item_115;
		next1_98.next = next1_116;
		next1_98.previous = prev1_117;
		newNode_7.element = element_8;
		newNode_7.next = next_9;
		newNode_7.previous = previous_10;
		//System.out.println(Utilities.repOK(dll));
		obj.sample(dll,o);
	}

}

