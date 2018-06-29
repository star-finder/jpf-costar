package avl;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class AvlTree_minElement1 extends TestJPF {

	@Test
	public void test_minElement1() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_5 = new avl.AvlNode();
		avl.AvlNode right_6 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_5;
		avl.AvlNode t_7 = null;
		avl.AvlNode t_9 = null;
		avl.AvlNode t_11 = right_6;
		avl.AvlNode left_13 = null;
		avl.AvlNode right_14 = null;
		avl.AvlNode left_309 = null;
		avl.AvlNode right_308 = null;
		int heightL_9 = 0;
		int heightR_11 = 0;
		int element_307 = 2;
		int element_12 = 0;
		int minE_1 = -1;
		int minE_4 = -1;
		int element_4 = 1;
		int element_226 = 1;
		int minE_2 = -1;
		int minE_6 = -1;
		int height_7 = 1;
		int element_223 = 1;
		int minE_10 = -1;
		int element_224 = 0;
		int minE_8 = -1;
		int element_225 = 0;
		int minE = -1;
		int maxE_10 = 3;
		obj.root.element = element_4;
		obj.root.left = left_5;
		obj.root.right = right_6;
		obj.root.height = height_7;
		left_5.element = element_12;
		left_5.left = left_13;
		left_5.right = right_14;
		left_5.height = heightL_9;
		right_6.element = element_307;
		right_6.left = left_309;
		right_6.right = right_308;
		right_6.height = heightR_11;
		//System.out.println(Utilities.repOK(obj));
		obj.minElement(minE);
	}

	@Test
	public void test_minElement2() throws Exception {
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
		int minE = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		left_2.element = element_249;
		left_2.left = left_251;
		left_2.right = right_250;
		left_2.height = heightL_6;
		//System.out.println(Utilities.repOK(obj));
		obj.minElement(minE);
	}

	@Test
	public void test_minElement3() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = null;
		int minE = 0;
		//System.out.println(Utilities.repOK(obj));
		obj.minElement(minE);
	}

	@Test
	public void test_minElement4() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_17 = new avl.AvlNode();
		avl.AvlNode right_18 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_17;
		avl.AvlNode left_25 = null;
		avl.AvlNode right_26 = null;
		avl.AvlNode left_288 = null;
		avl.AvlNode right_287 = null;
		int maxE_22 = 2;
		int heightL_21 = 0;
		int heightR_23 = 0;
		int element_286 = 1;
		int minE_1 = 0;
		int minE_4 = 0;
		int element_226 = 0;
		int minE_2 = 0;
		int element_24 = -1;
		int minE_20 = -2;
		int element_223 = 0;
		int element_224 = -1;
		int element_225 = -1;
		int element_16 = 0;
		int minE = 0;
		int height_19 = 1;
		obj.root.element = element_16;
		obj.root.left = left_17;
		obj.root.right = right_18;
		obj.root.height = height_19;
		left_17.element = element_24;
		left_17.left = left_25;
		left_17.right = right_26;
		left_17.height = heightL_21;
		right_18.element = element_286;
		right_18.left = left_288;
		right_18.right = right_287;
		right_18.height = heightR_23;
		//System.out.println(Utilities.repOK(obj));
		obj.minElement(minE);
	}

	@Test
	public void test_minElement5() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_2 = null;
		avl.AvlNode right_3 = null;
		int height_4 = 0;
		int element_1 = 3;
		int element_223 = 3;
		int element_224 = 3;
		int minE = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		//System.out.println(Utilities.repOK(obj));
		obj.minElement(minE);
	}

	@Test
	public void test_minElement6() throws Exception {
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
		int minE = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		right_3.element = element_263;
		right_3.left = left_265;
		right_3.right = right_264;
		right_3.height = heightR_8;
		//System.out.println(Utilities.repOK(obj));
		obj.minElement(minE);
	}

	@Test
	public void test_minElement7() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_8 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = null;
		avl.AvlNode t_7 = right_8;
		avl.AvlNode left_7 = null;
		avl.AvlNode left_289 = null;
		avl.AvlNode right_288 = null;
		int maxE_12 = 2;
		int element_223 = 0;
		int element_6 = 0;
		int minE_1 = 0;
		int minE_4 = 0;
		int height_9 = 1;
		int minE = 0;
		int element_224 = 0;
		int heightR_13 = 0;
		int element_287 = 1;
		int minE_2 = 0;
		int minE_6 = 0;
		obj.root.element = element_6;
		obj.root.left = left_7;
		obj.root.right = right_8;
		obj.root.height = height_9;
		right_8.element = element_287;
		right_8.left = left_289;
		right_8.right = right_288;
		right_8.height = heightR_13;
		//System.out.println(Utilities.repOK(obj));
		obj.minElement(minE);
	}

}

