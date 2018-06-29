package avl;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class AvlTree_printTree1 extends TestJPF {

	@Test
	public void test_printTree1() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_2 = new avl.AvlNode();
		avl.AvlNode right_3 = null;
		avl.AvlNode left_251 = null;
		avl.AvlNode right_250 = null;
		int height_4 = 1;
		int heightL_6 = 0;
		int element_249 = 0;
		int minE_5 = -1;
		int element_1 = 1;
		int element_223 = 1;
		int element_224 = 1;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		left_2.element = element_249;
		left_2.left = left_251;
		left_2.right = right_250;
		left_2.height = heightL_6;
		//System.out.println(Utilities.repOK(obj));
		obj.printTree();
	}

	@Test
	public void test_printTree2() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = null;
		//System.out.println(Utilities.repOK(obj));
		obj.printTree();
	}

	@Test
	public void test_printTree3() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_2 = null;
		avl.AvlNode right_3 = null;
		int height_4 = 0;
		int element_1 = 3;
		int element_223 = 3;
		int element_224 = 3;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		//System.out.println(Utilities.repOK(obj));
		obj.printTree();
	}

	@Test
	public void test_printTree4() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_3 = new avl.AvlNode();
		avl.AvlNode left_2 = null;
		avl.AvlNode left_265 = null;
		avl.AvlNode right_264 = null;
		int height_4 = 1;
		int maxE_7 = 1;
		int element_1 = -1;
		int heightR_8 = 0;
		int element_263 = 0;
		int element_223 = -1;
		int element_224 = -1;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		right_3.element = element_263;
		right_3.left = left_265;
		right_3.right = right_264;
		right_3.height = heightR_8;
		//System.out.println(Utilities.repOK(obj));
		obj.printTree();
	}

}

