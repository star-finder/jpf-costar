package stack;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class StackLi_contains1 extends TestJPF {

	@Test
	public void test_contains1() throws Exception {
		StackLi obj = new StackLi();
		obj.topOfStack = null;
		java.lang.Object e = null;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(e);
	}

	@Test
	public void test_contains2() throws Exception {
		StackLi obj = new StackLi();
		obj.topOfStack = new stack.ListNode();
		stack.ListNode temp_2 = obj.topOfStack;
		stack.ListNode next_4 = null;
		java.lang.Object e_1 = new java.lang.Object();
		java.lang.Object e = e_1;
		java.lang.Object element_3 = new java.lang.Object();
		obj.topOfStack.element = element_3;
		obj.topOfStack.next = next_4;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(e);
	}

	@Test
	public void test_contains3() throws Exception {
		StackLi obj = new StackLi();
		obj.topOfStack = new stack.ListNode();
		stack.ListNode next_2 = null;
		java.lang.Object e = null;
		java.lang.Object element_1 = null;
		obj.topOfStack.element = element_1;
		obj.topOfStack.next = next_2;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(e);
	}

	@Test
	public void test_contains4() throws Exception {
		StackLi obj = new StackLi();
		obj.topOfStack = new stack.ListNode();
		stack.ListNode next_5 = new stack.ListNode();
		stack.ListNode temp_2 = obj.topOfStack;
		stack.ListNode temp_3 = next_5;
		stack.ListNode next_39 = null;
		java.lang.Object e_1 = new java.lang.Object();
		java.lang.Object e = e_1;
		java.lang.Object element_4 = new java.lang.Object();
		java.lang.Object element_40 = null;
		obj.topOfStack.element = element_4;
		obj.topOfStack.next = next_5;
		next_5.element = element_40;
		next_5.next = next_39;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(e);
	}

}

