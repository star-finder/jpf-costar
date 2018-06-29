package aatree;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class AATree_insert1 extends TestJPF {

	@Test
	public void test_insert1() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode b_31 = obj.nullNode;
		aatree.AATree.AANode c_32 = obj.nullNode;
		aatree.AATree.AANode t_3 = obj.root;
		aatree.AATree.AANode t_5 = obj.nullNode;
		aatree.AATree.AANode this_nullNode_319 = obj.nullNode;
		aatree.AATree.AANode left_35 = obj.nullNode;
		aatree.AATree.AANode right_36 = this_nullNode_319;
		int x_2 = 1;
		int x_1 = 1;
		int element_316 = 0;
		int element_317 = 0;
		int element_34 = 0;
		int a_30 = 0;
		int d_33 = 0;
		int level_37 = 1;
		int x = 1;
		int x_4 = 1;
		obj.lastNode = null;
		obj.deletedNode = null;
		obj.root.element = element_34;
		obj.root.left = left_35;
		obj.root.right = right_36;
		obj.root.level = level_37;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert2() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode right_27 = new aatree.AATree.AANode();
		aatree.AATree.AANode newNode_6 = new aatree.AATree.AANode();
		aatree.AATree.AANode b_22 = obj.nullNode;
		aatree.AATree.AANode c_23 = obj.nullNode;
		aatree.AATree.AANode t_3 = obj.root;
		aatree.AATree.AANode t_5 = obj.nullNode;
		aatree.AATree.AANode lt_12 = obj.nullNode;
		aatree.AATree.AANode rt_13 = obj.nullNode;
		aatree.AATree.AANode left_51 = lt_12;
		aatree.AATree.AANode right_52 = rt_13;
		aatree.AATree.AANode left_54 = newNode_6;
		aatree.AATree.AANode t_14 = t_3;
		aatree.AATree.AANode k2_15 = t_14;
		aatree.AATree.AANode k1_16 = left_54;
		aatree.AATree.AANode left_55 = right_52;
		aatree.AATree.AANode right_56 = k2_15;
		aatree.AATree.AANode t_17 = k1_16;
		aatree.AATree.AANode t_18 = t_17;
		aatree.AATree.AANode t_19 = t_18;
		aatree.AATree.AANode this_nullNode_320 = obj.nullNode;
		aatree.AATree.AANode this_nullNode_323 = obj.nullNode;
		aatree.AATree.AANode left_26 = obj.nullNode;
		aatree.AATree.AANode left_40 = this_nullNode_320;
		aatree.AATree.AANode right_41 = this_nullNode_323;
		int theElement_11 = -1;
		int element_319 = 1;
		int x_1 = -1;
		int element_50 = -1;
		int level_53 = 1;
		int level_317 = 1;
		int maxE_31 = 2;
		int x_4 = -1;
		int x_2 = -1;
		int element_39 = 1;
		int d_24 = 0;
		int element_321 = 1;
		int a_21 = 0;
		int element_318 = 0;
		int level_28 = 1;
		int element_25 = 0;
		int x = -1;
		int element_316 = 0;
		obj.lastNode = null;
		aatree.AATree.AANode left_8 = null;
		int element_7 = 0;
		obj.deletedNode = null;
		int level_10 = 0;
		aatree.AATree.AANode right_9 = null;
		obj.root.element = element_25;
		obj.root.left = left_26;
		obj.root.right = right_27;
		obj.root.level = level_28;
		right_27.element = element_39;
		right_27.left = left_40;
		right_27.right = right_41;
		right_27.level = level_317;
		newNode_6.element = element_7;
		newNode_6.left = left_8;
		newNode_6.right = right_9;
		newNode_6.level = level_10;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert3() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode right_33 = new aatree.AATree.AANode();
		aatree.AATree.AANode left_32 = new aatree.AATree.AANode();
		aatree.AATree.AANode right_44 = new aatree.AATree.AANode();
		aatree.AATree.AANode b_28 = obj.nullNode;
		aatree.AATree.AANode c_29 = obj.nullNode;
		aatree.AATree.AANode t_3 = obj.root;
		aatree.AATree.AANode t_5 = right_33;
		aatree.AATree.AANode t_7 = right_44;
		aatree.AATree.AANode this_nullNode_320 = obj.nullNode;
		aatree.AATree.AANode this_nullNode_323 = obj.nullNode;
		aatree.AATree.AANode left_43 = this_nullNode_320;
		aatree.AATree.AANode left_414 = obj.nullNode;
		aatree.AATree.AANode right_413 = obj.nullNode;
		aatree.AATree.AANode left_426 = this_nullNode_323;
		aatree.AATree.AANode right_425 = this_nullNode_323;
		int element_316 = -1;
		int element_319 = 0;
		int x_1 = 1;
		int level1_317 = 1;
		int element_31 = -1;
		int element_42 = 0;
		int level1_36 = 1;
		int maxE_37 = 2;
		int element_412 = -2;
		int level1_322 = 1;
		int x_4 = 1;
		int x_2 = 1;
		int minE_35 = -3;
		int a_27 = 0;
		int d_30 = 0;
		int level_34 = 2;
		int element_321 = 0;
		int element_318 = -1;
		int element_424 = 1;
		int x_6 = 1;
		int x = 1;
		obj.lastNode = null;
		obj.deletedNode = null;
		obj.root.element = element_31;
		obj.root.left = left_32;
		obj.root.right = right_33;
		obj.root.level = level_34;
		right_33.element = element_42;
		right_33.left = left_43;
		right_33.right = right_44;
		right_33.level = level1_317;
		left_32.element = element_412;
		left_32.left = left_414;
		left_32.right = right_413;
		left_32.level = level1_36;
		right_44.element = element_424;
		right_44.left = left_426;
		right_44.right = right_425;
		right_44.level = level1_322;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert4() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode right_7 = new aatree.AATree.AANode();
		aatree.AATree.AANode b_2 = obj.nullNode;
		aatree.AATree.AANode c_3 = obj.nullNode;
		aatree.AATree.AANode this_nullNode_319 = obj.nullNode;
		aatree.AATree.AANode left_6 = obj.nullNode;
		aatree.AATree.AANode left_368 = this_nullNode_319;
		aatree.AATree.AANode right_367 = this_nullNode_319;
		int level_8 = 1;
		int d_4 = 0;
		int level_318 = 1;
		int element_317 = -1;
		int a_1 = 0;
		int element_5 = -1;
		int maxE_11 = 1;
		int element_316 = -1;
		int element_366 = 0;
		obj.lastNode = null;
		obj.deletedNode = null;
		int x = 0;
		obj.root.element = element_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		obj.root.level = level_8;
		right_7.element = element_366;
		right_7.left = left_368;
		right_7.right = right_367;
		right_7.level = level_318;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert5() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode right_24 = new aatree.AATree.AANode();
		aatree.AATree.AANode b_19 = obj.nullNode;
		aatree.AATree.AANode c_20 = obj.nullNode;
		aatree.AATree.AANode t_3 = obj.root;
		aatree.AATree.AANode this_nullNode_319 = obj.nullNode;
		aatree.AATree.AANode left_23 = obj.nullNode;
		aatree.AATree.AANode left_378 = this_nullNode_319;
		aatree.AATree.AANode right_377 = this_nullNode_319;
		int x_2 = 0;
		int element_376 = 1;
		int x_1 = 0;
		int level_318 = 1;
		int element_317 = 0;
		int maxE_28 = 2;
		int d_21 = 0;
		int a_18 = 0;
		int level_25 = 1;
		int x = 0;
		int element_22 = 0;
		int element_316 = 0;
		obj.lastNode = null;
		obj.deletedNode = null;
		obj.root.element = element_22;
		obj.root.left = left_23;
		obj.root.right = right_24;
		obj.root.level = level_25;
		right_24.element = element_376;
		right_24.left = left_378;
		right_24.right = right_377;
		right_24.level = level_318;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert6() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode b_2 = obj.nullNode;
		aatree.AATree.AANode c_3 = obj.nullNode;
		aatree.AATree.AANode this_nullNode_319 = obj.nullNode;
		aatree.AATree.AANode left_6 = obj.nullNode;
		aatree.AATree.AANode right_7 = this_nullNode_319;
		int level_8 = 1;
		int d_4 = 0;
		int element_317 = 4;
		int element_5 = 4;
		int a_1 = 0;
		int element_316 = 4;
		obj.lastNode = null;
		obj.deletedNode = null;
		int x = 0;
		obj.root.element = element_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		obj.root.level = level_8;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert7() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode right_22 = new aatree.AATree.AANode();
		aatree.AATree.AANode b_17 = obj.nullNode;
		aatree.AATree.AANode c_18 = obj.nullNode;
		aatree.AATree.AANode t_3 = obj.root;
		aatree.AATree.AANode t_5 = right_22;
		aatree.AATree.AANode this_nullNode_320 = obj.nullNode;
		aatree.AATree.AANode this_nullNode_323 = obj.nullNode;
		aatree.AATree.AANode left_21 = obj.nullNode;
		aatree.AATree.AANode left_28 = this_nullNode_320;
		aatree.AATree.AANode right_29 = this_nullNode_323;
		int x_1 = -1;
		int level_317 = 1;
		int x_4 = -1;
		int a_16 = 0;
		int x_2 = -1;
		int d_19 = 0;
		int element_27 = 0;
		int maxE_26 = 1;
		int element_20 = -2;
		int level_23 = 1;
		int element_321 = 0;
		int element_318 = -2;
		int element_319 = 0;
		int x = -1;
		int element_316 = -2;
		obj.lastNode = null;
		obj.deletedNode = null;
		obj.root.element = element_20;
		obj.root.left = left_21;
		obj.root.right = right_22;
		obj.root.level = level_23;
		right_22.element = element_27;
		right_22.left = left_28;
		right_22.right = right_29;
		right_22.level = level_317;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert8() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode right_30 = new aatree.AATree.AANode();
		aatree.AATree.AANode b_25 = obj.nullNode;
		aatree.AATree.AANode c_26 = obj.nullNode;
		aatree.AATree.AANode t_3 = obj.root;
		aatree.AATree.AANode t_5 = right_30;
		aatree.AATree.AANode this_nullNode_320 = obj.nullNode;
		aatree.AATree.AANode this_nullNode_323 = obj.nullNode;
		aatree.AATree.AANode left_29 = obj.nullNode;
		aatree.AATree.AANode left_36 = this_nullNode_320;
		aatree.AATree.AANode right_37 = this_nullNode_323;
		int level_31 = 1;
		int x_1 = 1;
		int element_35 = 0;
		int a_24 = 0;
		int element_28 = -1;
		int level_317 = 1;
		int maxE_34 = 1;
		int x_4 = 1;
		int x_2 = 1;
		int element_321 = 0;
		int element_318 = -1;
		int d_27 = 0;
		int element_316 = -1;
		int element_319 = 0;
		int x = 1;
		obj.lastNode = null;
		obj.deletedNode = null;
		obj.root.element = element_28;
		obj.root.left = left_29;
		obj.root.right = right_30;
		obj.root.level = level_31;
		right_30.element = element_35;
		right_30.left = left_36;
		right_30.right = right_37;
		right_30.level = level_317;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert9() throws Exception {
		AATree obj = new AATree();
		obj.root = obj.nullNode;
		aatree.AATree.AANode b_2 = obj.nullNode;
		aatree.AATree.AANode c_3 = obj.nullNode;
		int d_4 = 0;
		int a_1 = 0;
		obj.lastNode = null;
		int x = 0;
		obj.deletedNode = null;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

}

