package bst;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class BinarySearchTree_insert1 extends TestJPF {

	@Test
	public void test_insert1() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_2 = null;
		bst.BinaryNode right_3 = null;
		int element_1 = 1;
		int element_76 = 1;
		int element_77 = 1;
		int x = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert2() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode left_5 = null;
		bst.BinaryNode right_6 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_77 = -1;
		int element_4 = -1;
		int element_76 = -1;
		int x = 0;
		obj.root.element = element_4;
		obj.root.left = left_5;
		obj.root.right = right_6;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert3() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = null;
		int x = 0;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert4() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_15 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_15;
		bst.BinaryNode right_16 = null;
		bst.BinaryNode left_109 = null;
		bst.BinaryNode right_108 = null;
		int x_2 = -1;
		int x_1 = -1;
		int element_76 = 0;
		int element_107 = -1;
		int minE_17 = -2;
		int element_77 = 0;
		int element_14 = 0;
		int x_4 = -1;
		int x = -1;
		obj.root.element = element_14;
		obj.root.left = left_15;
		obj.root.right = right_16;
		left_15.element = element_107;
		left_15.left = left_109;
		left_15.right = right_108;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert5() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_16 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_16;
		bst.BinaryNode left_15 = null;
		bst.BinaryNode left_113 = null;
		bst.BinaryNode right_112 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_76 = -1;
		int element_77 = -1;
		int element_111 = 0;
		int element_14 = -1;
		int x_4 = 0;
		int maxE_18 = 1;
		int x = 0;
		obj.root.element = element_14;
		obj.root.left = left_15;
		obj.root.right = right_16;
		right_16.element = element_111;
		right_16.left = left_113;
		right_16.right = right_112;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert6() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode left_7 = null;
		bst.BinaryNode right_8 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_77 = 0;
		int element_76 = 0;
		int x = 0;
		int element_6 = 0;
		obj.root.element = element_6;
		obj.root.left = left_7;
		obj.root.right = right_8;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

}

