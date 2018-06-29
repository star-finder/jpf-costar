package avl;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class AvlTree_maxElement1 extends TestJPF {

	@Test
	public void test_maxElement1() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_9 = new avl.AvlNode();
		avl.AvlNode right_10 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_9;
		avl.AvlNode left_270 = null;
		avl.AvlNode right_269 = null;
		avl.AvlNode left_284 = null;
		avl.AvlNode right_283 = null;
		int height_11 = 1;
		int minE_12 = -2;
		int maxE_1 = 0;
		int heightR_15 = 0;
		int element_223 = 0;
		int element_224 = 0;
		int heightL_13 = 0;
		int element_268 = -1;
		int element_282 = 1;
		int maxE_14 = 2;
		int maxE = 0;
		int maxE_4 = 0;
		int maxE_2 = 0;
		int element_8 = 0;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.height = height_11;
		left_9.element = element_268;
		left_9.left = left_270;
		left_9.right = right_269;
		left_9.height = heightL_13;
		right_10.element = element_282;
		right_10.left = left_284;
		right_10.right = right_283;
		right_10.height = heightR_15;
		//System.out.println(Utilities.repOK(obj));
		obj.maxElement(maxE);
	}

	@Test
	public void test_maxElement2() throws Exception {
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
		int maxE = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		left_2.element = element_249;
		left_2.left = left_251;
		left_2.right = right_250;
		left_2.height = heightL_6;
		//System.out.println(Utilities.repOK(obj));
		obj.maxElement(maxE);
	}

	@Test
	public void test_maxElement3() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = null;
		int maxE = 0;
		//System.out.println(Utilities.repOK(obj));
		obj.maxElement(maxE);
	}

	@Test
	public void test_maxElement4() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_2 = null;
		avl.AvlNode right_3 = null;
		int height_4 = 0;
		int element_1 = 3;
		int element_223 = 3;
		int element_224 = 3;
		int maxE = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		//System.out.println(Utilities.repOK(obj));
		obj.maxElement(maxE);
	}

	@Test
	public void test_maxElement5() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = null;
		avl.AvlNode t_7 = null;
		avl.AvlNode left_13 = null;
		avl.AvlNode right_14 = null;
		int maxE_1 = 0;
		int height_15 = 0;
		int element_12 = 0;
		int element_223 = 0;
		int element_224 = 0;
		int maxE = 0;
		int maxE_4 = 0;
		int maxE_2 = 0;
		int maxE_6 = 0;
		obj.root.element = element_12;
		obj.root.left = left_13;
		obj.root.right = right_14;
		obj.root.height = height_15;
		//System.out.println(Utilities.repOK(obj));
		obj.maxElement(maxE);
	}

	@Test
	public void test_maxElement6() throws Exception {
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
		int maxE = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		right_3.element = element_263;
		right_3.left = left_265;
		right_3.right = right_264;
		right_3.height = heightR_8;
		//System.out.println(Utilities.repOK(obj));
		obj.maxElement(maxE);
	}

}

