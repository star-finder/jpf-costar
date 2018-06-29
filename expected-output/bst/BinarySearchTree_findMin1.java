package bst;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class BinarySearchTree_findMin1 extends TestJPF {

	@Test
	public void test_findMin1() throws Exception {
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
		obj.findMin();
	}

	@Test
	public void test_findMin2() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = null;
		//System.out.println(Utilities.repOK(obj));
		obj.findMin();
	}

	@Test
	public void test_findMin3() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_4 = new bst.BinaryNode();
		bst.BinaryNode t_1 = obj.root;
		bst.BinaryNode right_5 = null;
		bst.BinaryNode left_100 = null;
		bst.BinaryNode right_99 = null;
		int element_77 = 1;
		int element_98 = 0;
		int element_76 = 1;
		int minE_6 = -1;
		int element_3 = 1;
		obj.root.element = element_3;
		obj.root.left = left_4;
		obj.root.right = right_5;
		left_4.element = element_98;
		left_4.left = left_100;
		left_4.right = right_99;
		//System.out.println(Utilities.repOK(obj));
		obj.findMin();
	}

}

