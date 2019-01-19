package random.sll;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;

public class Input_withFloor1 extends TestJPF {

	@Test
	public void test_withFloor1() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = null;
		int elem_1 = -15;
		root.elem = elem_1;
		root.next = next_2;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor2() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = new random.sll.Node();
		random.sll.Node next_4 = new random.sll.Node();
		random.sll.Node next_6 = new random.sll.Node();
		random.sll.Node next_8 = new random.sll.Node();
		random.sll.Node next_10 = new random.sll.Node();
		random.sll.Node next_12 = null;
		int elem_9 = 5;
		int elem_11 = -22;
		int elem_3 = -3;
		int elem_1 = 14;
		int elem_7 = -8;
		int elem_5 = -19;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem_3;
		next_2.next = next_4;
		next_4.elem = elem_5;
		next_4.next = next_6;
		next_6.elem = elem_7;
		next_6.next = next_8;
		next_8.elem = elem_9;
		next_8.next = next_10;
		next_10.elem = elem_11;
		next_10.next = next_12;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor3() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = new random.sll.Node();
		random.sll.Node next_4 = new random.sll.Node();
		random.sll.Node next_6 = new random.sll.Node();
		random.sll.Node next_8 = new random.sll.Node();
		random.sll.Node next_10 = new random.sll.Node();
		random.sll.Node next_12 = new random.sll.Node();
		random.sll.Node next_14 = null;
		int elem_13 = 16;
		int elem_9 = -13;
		int elem_11 = -5;
		int elem_3 = 20;
		int elem_1 = 1;
		int elem_7 = -5;
		int elem_5 = -13;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem_3;
		next_2.next = next_4;
		next_4.elem = elem_5;
		next_4.next = next_6;
		next_6.elem = elem_7;
		next_6.next = next_8;
		next_8.elem = elem_9;
		next_8.next = next_10;
		next_10.elem = elem_11;
		next_10.next = next_12;
		next_12.elem = elem_13;
		next_12.next = next_14;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor4() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = new random.sll.Node();
		random.sll.Node next_4 = null;
		int elem_3 = -31;
		int elem_1 = -4;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem_3;
		next_2.next = next_4;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor5() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = new random.sll.Node();
		random.sll.Node next_4 = new random.sll.Node();
		random.sll.Node next_6 = new random.sll.Node();
		random.sll.Node next_8 = null;
		int elem_3 = -30;
		int elem_1 = 8;
		int elem_7 = 25;
		int elem_5 = -10;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem_3;
		next_2.next = next_4;
		next_4.elem = elem_5;
		next_4.next = next_6;
		next_6.elem = elem_7;
		next_6.next = next_8;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor6() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = new random.sll.Node();
		random.sll.Node next_4 = new random.sll.Node();
		random.sll.Node next_6 = null;
		int elem_3 = 25;
		int elem_1 = 3;
		int elem_5 = -12;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem_3;
		next_2.next = next_4;
		next_4.elem = elem_5;
		next_4.next = next_6;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor7() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = new random.sll.Node();
		random.sll.Node next_4 = new random.sll.Node();
		random.sll.Node next_6 = new random.sll.Node();
		random.sll.Node next_8 = new random.sll.Node();
		random.sll.Node next_10 = new random.sll.Node();
		random.sll.Node next_12 = new random.sll.Node();
		random.sll.Node next_14 = new random.sll.Node();
		random.sll.Node next_16 = null;
		int elem_13 = -24;
		int elem_9 = -21;
		int elem_11 = 4;
		int elem_15 = -28;
		int elem_3 = -9;
		int elem_1 = 25;
		int elem_7 = -7;
		int elem_5 = -12;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem_3;
		next_2.next = next_4;
		next_4.elem = elem_5;
		next_4.next = next_6;
		next_6.elem = elem_7;
		next_6.next = next_8;
		next_8.elem = elem_9;
		next_8.next = next_10;
		next_10.elem = elem_11;
		next_10.next = next_12;
		next_12.elem = elem_13;
		next_12.next = next_14;
		next_14.elem = elem_15;
		next_14.next = next_16;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor8() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = new random.sll.Node();
		random.sll.Node next_4 = new random.sll.Node();
		random.sll.Node next_6 = new random.sll.Node();
		random.sll.Node next_8 = new random.sll.Node();
		random.sll.Node next_10 = new random.sll.Node();
		random.sll.Node next_12 = new random.sll.Node();
		random.sll.Node next_14 = new random.sll.Node();
		random.sll.Node next_16 = new random.sll.Node();
		random.sll.Node next_18 = null;
		int elem_13 = 16;
		int elem_9 = 24;
		int elem_11 = 9;
		int elem_17 = 1;
		int elem_15 = -15;
		int elem_3 = -32;
		int elem_1 = 31;
		int elem_7 = -28;
		int elem_5 = 29;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem_3;
		next_2.next = next_4;
		next_4.elem = elem_5;
		next_4.next = next_6;
		next_6.elem = elem_7;
		next_6.next = next_8;
		next_8.elem = elem_9;
		next_8.next = next_10;
		next_10.elem = elem_11;
		next_10.next = next_12;
		next_12.elem = elem_13;
		next_12.next = next_14;
		next_14.elem = elem_15;
		next_14.next = next_16;
		next_16.elem = elem_17;
		next_16.next = next_18;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor9() throws Exception {
		Input obj = new Input();
		random.sll.Node root = null;
		obj.withFloor(root);
	}

	@Test
	public void test_withFloor10() throws Exception {
		Input obj = new Input();
		random.sll.Node root = new random.sll.Node();
		random.sll.Node next_2 = new random.sll.Node();
		random.sll.Node next_4 = new random.sll.Node();
		random.sll.Node next_6 = new random.sll.Node();
		random.sll.Node next_8 = new random.sll.Node();
		random.sll.Node next_10 = null;
		int elem_9 = -9;
		int elem_3 = 30;
		int elem_1 = 10;
		int elem_7 = -23;
		int elem_5 = 14;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem_3;
		next_2.next = next_4;
		next_4.elem = elem_5;
		next_4.next = next_6;
		next_6.elem = elem_7;
		next_6.next = next_8;
		next_8.elem = elem_9;
		next_8.next = next_10;
		obj.withFloor(root);
	}

}

