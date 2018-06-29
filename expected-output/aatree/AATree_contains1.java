package aatree;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class AATree_contains1 extends TestJPF {

	@Test
	public void test_contains1() throws Exception {
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
		obj.contains(x);
	}

	@Test
	public void test_contains2() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode right_10 = new aatree.AATree.AANode();
		aatree.AATree.AANode b_5 = obj.nullNode;
		aatree.AATree.AANode c_6 = obj.nullNode;
		aatree.AATree.AANode current_2 = obj.root;
		aatree.AATree.AANode this_nullNode_319 = obj.nullNode;
		aatree.AATree.AANode left_9 = obj.nullNode;
		aatree.AATree.AANode left_378 = this_nullNode_319;
		aatree.AATree.AANode right_377 = this_nullNode_319;
		int element_8 = 0;
		int x_1 = 0;
		int element_316 = 0;
		int element_376 = 1;
		int level_11 = 1;
		int level_318 = 1;
		int element_317 = 0;
		int a_4 = 0;
		int maxE_14 = 2;
		int x = 0;
		int a_16 = 0;
		int d_7 = 0;
		obj.lastNode = null;
		obj.deletedNode = null;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.level = level_11;
		right_10.element = element_376;
		right_10.left = left_378;
		right_10.right = right_377;
		right_10.level = level_318;
		//System.out.println(Utilities.repOK(obj));
		obj.contains(x);
	}

	@Test
	public void test_contains3() throws Exception {
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
		obj.contains(x);
	}

	@Test
	public void test_contains4() throws Exception {
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
		obj.contains(x);
	}

}

