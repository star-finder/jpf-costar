package bst;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class BinarySearchTree_findMax1 extends TestJPF {

	@Test
	public void test_findMax1() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_2 = null;
		bst.BinaryNode right_3 = null;
		int element_1 = 1;
		int element_76 = 1;
		int element_77 = 1;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		//System.out.println(Utilities.repOK(obj));
		obj.findMax();
	}

	@Test
	public void test_findMax2() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_5 = new bst.BinaryNode();
		bst.BinaryNode t_1 = obj.root;
		bst.BinaryNode left_4 = null;
		bst.BinaryNode left_103 = null;
		bst.BinaryNode right_102 = null;
		int element_77 = -1;
		int element_101 = 0;
		int maxE_7 = 1;
		int element_76 = -1;
		int element_3 = -1;
		obj.root.element = element_3;
		obj.root.left = left_4;
		obj.root.right = right_5;
		right_5.element = element_101;
		right_5.left = left_103;
		right_5.right = right_102;
		//System.out.println(Utilities.repOK(obj));
		obj.findMax();
	}

	@Test
	public void test_findMax3() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = null;
		//System.out.println(Utilities.repOK(obj));
		obj.findMax();
	}

}

