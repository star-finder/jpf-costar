import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;

public class Input_travel1 extends TestJPF {

	@Test
	public void test_travel1() throws Exception {
		Input obj = new Input();
		features.sll.Node root = new features.sll.Node();
		features.sll.Node next_2 = null;
		int elem_1 = 0;
		root.elem = elem_1;
		root.next = next_2;
		obj.travel(root);
	}

	@Test
	public void test_travel2() throws Exception {
		Input obj = new Input();
		features.sll.Node root = new features.sll.Node();
		features.sll.Node next_2 = new features.sll.Node();
		features.sll.Node next1_4 = null;
		int elem1_3 = 0;
		int elem_1 = 0;
		root.elem = elem_1;
		root.next = next_2;
		next_2.elem = elem1_3;
		next_2.next = next1_4;
		obj.travel(root);
	}

}

