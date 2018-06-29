package aatree;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class AATree_findMin1 extends TestJPF {

	@Test
	public void test_findMin1() throws Exception {
		AATree obj = new AATree();
		obj.root = new aatree.AATree.AANode();
		aatree.AATree.AANode left_7 = new aatree.AATree.AANode();
		aatree.AATree.AANode right_8 = new aatree.AATree.AANode();
		aatree.AATree.AANode b_3 = obj.nullNode;
		aatree.AATree.AANode c_4 = obj.nullNode;
		aatree.AATree.AANode ptr_1 = obj.root;
		aatree.AATree.AANode this_nullNode_319 = obj.nullNode;
		aatree.AATree.AANode left_372 = obj.nullNode;
		aatree.AATree.AANode right_371 = obj.nullNode;
		aatree.AATree.AANode left_380 = this_nullNode_319;
		aatree.AATree.AANode right_379 = this_nullNode_319;
		int element_316 = 1;
		int level_9 = 2;
		int level1_11 = 1;
		int a_2 = 0;
		int element_370 = 0;
		int element_317 = 1;
		int element_378 = 2;
		int maxE_12 = 3;
		int minE_10 = -1;
		int element_6 = 1;
		int level1_318 = 1;
		int d_5 = 0;
		obj.lastNode = null;
		obj.deletedNode = null;
		obj.root.element = element_6;
		obj.root.left = left_7;
		obj.root.right = right_8;
		obj.root.level = level_9;
		left_7.element = element_370;
		left_7.left = left_372;
		left_7.right = right_371;
		left_7.level = level1_11;
		right_8.element = element_378;
		right_8.left = left_380;
		right_8.right = right_379;
		right_8.level = level1_318;
		//System.out.println(Utilities.repOK(obj));
		obj.findMin();
	}

	@Test
	public void test_findMin2() throws Exception {
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
		obj.root.element = element_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		obj.root.level = level_8;
		right_7.element = element_366;
		right_7.left = left_368;
		right_7.right = right_367;
		right_7.level = level_318;
		//System.out.println(Utilities.repOK(obj));
		obj.findMin();
	}

	@Test
	public void test_findMin3() throws Exception {
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
		obj.root.element = element_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		obj.root.level = level_8;
		//System.out.println(Utilities.repOK(obj));
		obj.findMin();
	}

	@Test
	public void test_findMin4() throws Exception {
		AATree obj = new AATree();
		obj.root = obj.nullNode;
		aatree.AATree.AANode b_2 = obj.nullNode;
		aatree.AATree.AANode c_3 = obj.nullNode;
		int d_4 = 0;
		int a_1 = 0;
		obj.lastNode = null;
		obj.deletedNode = null;
		//System.out.println(Utilities.repOK(obj));
		obj.findMin();
	}

}

