package bst;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class BinarySearchTree_find1 extends TestJPF {

	@Test
	public void test_find1() throws Exception {
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
		obj.find(x);
	}

	@Test
	public void test_find2() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode left_6 = null;
		bst.BinaryNode right_7 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_77 = -1;
		int element_76 = -1;
		int x = 0;
		int element_5 = -1;
		obj.root.element = element_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

	@Test
	public void test_find3() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode left_8 = null;
		bst.BinaryNode right_9 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_77 = 0;
		int element_7 = 0;
		int element_76 = 0;
		int x = 0;
		obj.root.element = element_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

	@Test
	public void test_find4() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = null;
		int x = 0;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

	@Test
	public void test_find5() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_8 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_8;
		bst.BinaryNode right_9 = null;
		bst.BinaryNode left_109 = null;
		bst.BinaryNode right_108 = null;
		int x_2 = -1;
		int x_1 = -1;
		int element_7 = 0;
		int element_76 = 0;
		int element_107 = -1;
		int minE_10 = -2;
		int element_77 = 0;
		int x_4 = -1;
		int x = -1;
		obj.root.element = element_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		left_8.element = element_107;
		left_8.left = left_109;
		left_8.right = right_108;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

	@Test
	public void test_find6() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_9 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_9;
		bst.BinaryNode left_8 = null;
		bst.BinaryNode left_113 = null;
		bst.BinaryNode right_112 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_7 = -1;
		int element_76 = -1;
		int element_77 = -1;
		int element_111 = 0;
		int x_4 = 0;
		int maxE_11 = 1;
		int x = 0;
		obj.root.element = element_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		right_9.element = element_111;
		right_9.left = left_113;
		right_9.right = right_112;
		//System.out.println(Utilities.repOK(obj));
		obj.find(x);
	}

}

