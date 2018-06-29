package bst;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class BinarySearchTree_printTree1 extends TestJPF {

	@Test
	public void test_printTree1() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_7 = new bst.BinaryNode();
		bst.BinaryNode t_1 = obj.root;
		bst.BinaryNode t_2 = left_7;
		bst.BinaryNode right_8 = null;
		bst.BinaryNode left_107 = null;
		bst.BinaryNode right_106 = null;
		int element_77 = 1;
		int minE_9 = -1;
		int element_76 = 1;
		int element_105 = 0;
		int element_6 = 1;
		obj.root.element = element_6;
		obj.root.left = left_7;
		obj.root.right = right_8;
		left_7.element = element_105;
		left_7.left = left_107;
		left_7.right = right_106;
		//System.out.println(Utilities.repOK(obj));
		obj.printTree();
	}

	@Test
	public void test_printTree2() throws Exception {
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
		obj.printTree();
	}

	@Test
	public void test_printTree3() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = null;
		//System.out.println(Utilities.repOK(obj));
		obj.printTree();
	}

	@Test
	public void test_printTree4() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_6 = new bst.BinaryNode();
		bst.BinaryNode t_1 = obj.root;
		bst.BinaryNode t_2 = null;
		bst.BinaryNode t_3 = right_6;
		bst.BinaryNode left_5 = null;
		bst.BinaryNode left_113 = null;
		bst.BinaryNode right_112 = null;
		int element_77 = -1;
		int element_111 = 0;
		int element_4 = -1;
		int element_76 = -1;
		int maxE_8 = 1;
		obj.root.element = element_4;
		obj.root.left = left_5;
		obj.root.right = right_6;
		right_6.element = element_111;
		right_6.left = left_113;
		right_6.right = right_112;
		//System.out.println(Utilities.repOK(obj));
		obj.printTree();
	}

}

