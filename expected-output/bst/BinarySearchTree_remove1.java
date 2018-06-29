package bst;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class BinarySearchTree_remove1 extends TestJPF {

	@Test
	public void test_remove1() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode left_10 = null;
		bst.BinaryNode right_11 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_77 = 0;
		int element_76 = 0;
		int x = 0;
		int element_9 = 0;
		obj.root.element = element_9;
		obj.root.left = left_10;
		obj.root.right = right_11;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove2() throws Exception {
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
		obj.remove(x);
	}

	@Test
	public void test_remove3() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_7 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_7;
		bst.BinaryNode right_8 = null;
		bst.BinaryNode left_109 = null;
		bst.BinaryNode right_108 = null;
		int x_2 = -1;
		int minE_9 = -2;
		int x_1 = -1;
		int element_76 = 0;
		int element_107 = -1;
		int element_6 = 0;
		int element_77 = 0;
		int x_4 = -1;
		int x = -1;
		obj.root.element = element_6;
		obj.root.left = left_7;
		obj.root.right = right_8;
		left_7.element = element_107;
		left_7.left = left_109;
		left_7.right = right_108;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove4() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_9 = new bst.BinaryNode();
		bst.BinaryNode left_14 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_9;
		bst.BinaryNode t_7 = left_14;
		bst.BinaryNode right_10 = null;
		bst.BinaryNode right_15 = null;
		bst.BinaryNode left_133 = null;
		bst.BinaryNode right_132 = null;
		int x_2 = -1;
		int x_1 = -1;
		int element_79 = 1;
		int element_131 = -1;
		int element_76 = 1;
		int element_78 = 0;
		int minE_11 = -2;
		int element_13 = 0;
		int element_77 = 0;
		int x_4 = -1;
		int x_6 = -1;
		int element_8 = 1;
		int x = -1;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		left_9.element = element_13;
		left_9.left = left_14;
		left_9.right = right_15;
		left_14.element = element_131;
		left_14.left = left_133;
		left_14.right = right_132;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove5() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_8 = new bst.BinaryNode();
		bst.BinaryNode left_13 = new bst.BinaryNode();
		bst.BinaryNode right_14 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_8;
		bst.BinaryNode right_9 = null;
		bst.BinaryNode left_133 = null;
		bst.BinaryNode right_132 = null;
		bst.BinaryNode left_136 = null;
		bst.BinaryNode right_135 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_79 = 2;
		int element_131 = -1;
		int element_7 = 2;
		int element_76 = 2;
		int element_78 = 0;
		int element_12 = 0;
		int minE_10 = -2;
		int element_77 = 0;
		int element_134 = 1;
		int x_4 = 0;
		int x = 0;
		obj.root.element = element_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		left_8.element = element_12;
		left_8.left = left_13;
		left_8.right = right_14;
		left_13.element = element_131;
		left_13.left = left_133;
		left_13.right = right_132;
		right_14.element = element_134;
		right_14.left = left_136;
		right_14.right = right_135;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove6() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_6 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode right_7 = null;
		bst.BinaryNode left_106 = null;
		bst.BinaryNode right_105 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_76 = 0;
		int element_5 = 0;
		int minE_8 = -2;
		int element_77 = 0;
		int element_104 = -1;
		int x = 0;
		obj.root.element = element_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		left_6.element = element_104;
		left_6.left = left_106;
		left_6.right = right_105;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove7() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_10 = new bst.BinaryNode();
		bst.BinaryNode left_14 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_10;
		bst.BinaryNode t_7 = left_14;
		bst.BinaryNode left_9 = null;
		bst.BinaryNode right_15 = null;
		bst.BinaryNode left_134 = null;
		bst.BinaryNode right_133 = null;
		int x_2 = -1;
		int x_1 = -1;
		int element_79 = 0;
		int element_76 = -2;
		int element_78 = 0;
		int element_132 = -1;
		int maxE_12 = 1;
		int element_13 = 0;
		int element_77 = -2;
		int x_4 = -1;
		int x_6 = -1;
		int element_8 = -2;
		int x = -1;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		right_10.element = element_13;
		right_10.left = left_14;
		right_10.right = right_15;
		left_14.element = element_132;
		left_14.left = left_134;
		left_14.right = right_133;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove8() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = null;
		int x = 0;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove9() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_9 = new bst.BinaryNode();
		bst.BinaryNode right_15 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_9;
		bst.BinaryNode t_7 = right_15;
		bst.BinaryNode right_10 = null;
		bst.BinaryNode left_14 = null;
		bst.BinaryNode left_137 = null;
		bst.BinaryNode right_136 = null;
		int x_2 = 1;
		int x_1 = 1;
		int element_79 = 2;
		int element_76 = 2;
		int element_78 = 0;
		int minE_11 = -1;
		int element_13 = 0;
		int element_77 = 0;
		int element_135 = 1;
		int x_4 = 1;
		int x_6 = 1;
		int element_8 = 2;
		int x = 1;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		left_9.element = element_13;
		left_9.left = left_14;
		left_9.right = right_15;
		right_15.element = element_135;
		right_15.left = left_137;
		right_15.right = right_136;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove10() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_10 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_10;
		bst.BinaryNode right_11 = null;
		bst.BinaryNode left_15 = null;
		bst.BinaryNode right_16 = null;
		int x_2 = -1;
		int x_1 = -1;
		int element_79 = 1;
		int minE_12 = -1;
		int element_76 = 1;
		int element_78 = 0;
		int element_77 = 0;
		int element_14 = 0;
		int x_4 = -1;
		int element_9 = 1;
		int x = -1;
		obj.root.element = element_9;
		obj.root.left = left_10;
		obj.root.right = right_11;
		left_10.element = element_14;
		left_10.left = left_15;
		left_10.right = right_16;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove11() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_6 = new bst.BinaryNode();
		bst.BinaryNode right_7 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode left_109 = null;
		bst.BinaryNode right_108 = null;
		bst.BinaryNode left_112 = null;
		bst.BinaryNode right_111 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_76 = 0;
		int element_107 = -1;
		int element_5 = 0;
		int minE_8 = -2;
		int element_77 = 0;
		int element_110 = 1;
		int x = 0;
		int maxE_9 = 2;
		obj.root.element = element_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		left_6.element = element_107;
		left_6.left = left_109;
		left_6.right = right_108;
		right_7.element = element_110;
		right_7.left = left_112;
		right_7.right = right_111;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove12() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode left_12 = null;
		bst.BinaryNode right_13 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_77 = -1;
		int element_76 = -1;
		int x = 0;
		int element_11 = -1;
		obj.root.element = element_11;
		obj.root.left = left_12;
		obj.root.right = right_13;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove13() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_9 = new bst.BinaryNode();
		bst.BinaryNode left_13 = new bst.BinaryNode();
		bst.BinaryNode right_14 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_9;
		bst.BinaryNode left_8 = null;
		bst.BinaryNode left_134 = null;
		bst.BinaryNode right_133 = null;
		bst.BinaryNode left_137 = null;
		bst.BinaryNode right_136 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_79 = 0;
		int element_7 = -2;
		int element_76 = -2;
		int element_78 = 0;
		int element_132 = -1;
		int element_12 = 0;
		int element_77 = -2;
		int element_135 = 1;
		int maxE_11 = 2;
		int x_4 = 0;
		int x = 0;
		obj.root.element = element_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		right_9.element = element_12;
		right_9.left = left_13;
		right_9.right = right_14;
		left_13.element = element_132;
		left_13.left = left_134;
		left_13.right = right_133;
		right_14.element = element_135;
		right_14.left = left_137;
		right_14.right = right_136;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove14() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_11 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_11;
		bst.BinaryNode left_10 = null;
		bst.BinaryNode left_15 = null;
		bst.BinaryNode right_16 = null;
		int x_2 = -1;
		int x_1 = -1;
		int element_79 = 0;
		int element_76 = -2;
		int element_78 = 0;
		int element_77 = -2;
		int maxE_13 = 1;
		int element_14 = 0;
		int x_4 = -1;
		int element_9 = -2;
		int x = -1;
		obj.root.element = element_9;
		obj.root.left = left_10;
		obj.root.right = right_11;
		right_11.element = element_14;
		right_11.left = left_15;
		right_11.right = right_16;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove15() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_12 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_12;
		bst.BinaryNode left_11 = null;
		bst.BinaryNode left_16 = null;
		bst.BinaryNode right_17 = null;
		int x_2 = 1;
		int x_1 = 1;
		int element_79 = 0;
		int element_15 = 0;
		int element_76 = -1;
		int element_78 = 0;
		int element_10 = -1;
		int element_77 = -1;
		int maxE_14 = 1;
		int x_4 = 1;
		int x = 1;
		obj.root.element = element_10;
		obj.root.left = left_11;
		obj.root.right = right_12;
		right_12.element = element_15;
		right_12.left = left_16;
		right_12.right = right_17;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove16() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_11 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_11;
		bst.BinaryNode right_12 = null;
		bst.BinaryNode left_16 = null;
		bst.BinaryNode right_17 = null;
		int x_2 = 1;
		int x_1 = 1;
		int element_79 = 2;
		int element_15 = 0;
		int element_76 = 2;
		int element_78 = 0;
		int element_10 = 2;
		int minE_13 = -1;
		int element_77 = 0;
		int x_4 = 1;
		int x = 1;
		obj.root.element = element_10;
		obj.root.left = left_11;
		obj.root.right = right_12;
		left_11.element = element_15;
		left_11.left = left_16;
		left_11.right = right_17;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove17() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_10 = new bst.BinaryNode();
		bst.BinaryNode left_9 = new bst.BinaryNode();
		bst.BinaryNode left_14 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_4 = right_10;
		bst.BinaryNode right_15 = null;
		bst.BinaryNode left_130 = null;
		bst.BinaryNode right_129 = null;
		bst.BinaryNode left_133 = null;
		bst.BinaryNode right_132 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_79 = 2;
		int element_131 = 1;
		int element_76 = 0;
		int element_78 = 2;
		int maxE_12 = 3;
		int minE_11 = -2;
		int element_13 = 2;
		int element_77 = 0;
		int element_128 = -1;
		int element_8 = 0;
		int x = 0;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		right_10.element = element_13;
		right_10.left = left_14;
		right_10.right = right_15;
		left_9.element = element_128;
		left_9.left = left_130;
		left_9.right = right_129;
		left_14.element = element_131;
		left_14.left = left_133;
		left_14.right = right_132;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove18() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_9 = new bst.BinaryNode();
		bst.BinaryNode left_13 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_9;
		bst.BinaryNode left_8 = null;
		bst.BinaryNode right_14 = null;
		bst.BinaryNode left_131 = null;
		bst.BinaryNode right_130 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_79 = 0;
		int element_7 = -2;
		int element_76 = -2;
		int element_78 = 0;
		int element_12 = 0;
		int element_77 = -2;
		int maxE_11 = 1;
		int x_4 = 0;
		int x = 0;
		int element_129 = -1;
		obj.root.element = element_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		right_9.element = element_12;
		right_9.left = left_13;
		right_9.right = right_14;
		left_13.element = element_129;
		left_13.left = left_131;
		left_13.right = right_130;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove19() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_8 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_8;
		bst.BinaryNode left_7 = null;
		bst.BinaryNode left_113 = null;
		bst.BinaryNode right_112 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_76 = -1;
		int element_6 = -1;
		int element_77 = -1;
		int element_111 = 0;
		int x_4 = 0;
		int maxE_10 = 1;
		int x = 0;
		obj.root.element = element_6;
		obj.root.left = left_7;
		obj.root.right = right_8;
		right_8.element = element_111;
		right_8.left = left_113;
		right_8.right = right_112;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove20() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode right_10 = new bst.BinaryNode();
		bst.BinaryNode right_15 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = right_10;
		bst.BinaryNode t_7 = right_15;
		bst.BinaryNode left_9 = null;
		bst.BinaryNode left_14 = null;
		bst.BinaryNode left_138 = null;
		bst.BinaryNode right_137 = null;
		int x_2 = 1;
		int x_1 = 1;
		int element_79 = 0;
		int element_136 = 1;
		int element_76 = -1;
		int element_78 = 0;
		int maxE_12 = 2;
		int element_13 = 0;
		int element_77 = -1;
		int x_4 = 1;
		int x_6 = 1;
		int element_8 = -1;
		int x = 1;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		right_10.element = element_13;
		right_10.left = left_14;
		right_10.right = right_15;
		right_15.element = element_136;
		right_15.left = left_138;
		right_15.right = right_137;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

	@Test
	public void test_remove21() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new bst.BinaryNode();
		bst.BinaryNode left_8 = new bst.BinaryNode();
		bst.BinaryNode left_13 = new bst.BinaryNode();
		bst.BinaryNode t_3 = obj.root;
		bst.BinaryNode t_5 = left_8;
		bst.BinaryNode right_9 = null;
		bst.BinaryNode right_14 = null;
		bst.BinaryNode left_130 = null;
		bst.BinaryNode right_129 = null;
		int x_2 = 0;
		int x_1 = 0;
		int element_79 = 1;
		int element_7 = 1;
		int element_76 = 1;
		int element_78 = 0;
		int element_12 = 0;
		int minE_10 = -2;
		int element_77 = 0;
		int element_128 = -1;
		int x_4 = 0;
		int x = 0;
		obj.root.element = element_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		left_8.element = element_12;
		left_8.left = left_13;
		left_8.right = right_14;
		left_13.element = element_128;
		left_13.left = left_130;
		left_13.right = right_129;
		//System.out.println(Utilities.repOK(obj));
		obj.remove(x);
	}

}

