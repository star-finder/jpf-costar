package rbt;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class TreeMap_get1 extends TestJPF {

	@Test
	public void test_get1() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = null;
		obj.size = 0;
		obj.modCount = 0;
		int key = 0;
		////System.out.println(Utilities.repOK(obj));
		obj.get(key);
	}

	@Test
	public void test_get2() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_5 = null;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_3 = null;
		rbt.TreeMap.Entry right_4 = null;
		obj.size = 1;
		int key_1 = 4;
		int key_301 = 4;
		boolean color_6 = true;
		int key_299 = 4;
		java.lang.Object value_2 = null;
		obj.modCount = 0;
		int key = 0;
		obj.root.key = key_1;
		obj.root.value = value_2;
		obj.root.left = left_3;
		obj.root.right = right_4;
		obj.root.parent = parent_5;
		obj.root.color = color_6;
		////System.out.println(Utilities.repOK(obj));
		obj.get(key);
	}

	@Test
	public void test_get3() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_11 = null;
		rbt.TreeMap.Entry p_3 = obj.root;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_9 = null;
		rbt.TreeMap.Entry right_10 = null;
		obj.size = 1;
		boolean color_12 = true;
		int key_1 = 1;
		int key_301 = 0;
		int key_2 = 1;
		int key = 1;
		int k_4 = 1;
		int key_7 = 0;
		int key_299 = 0;
		java.lang.Object value_8 = null;
		obj.modCount = 0;
		obj.root.key = key_7;
		obj.root.value = value_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.parent = parent_11;
		obj.root.color = color_12;
		////System.out.println(Utilities.repOK(obj));
		obj.get(key);
	}

	@Test
	public void test_get4() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_9 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_11 = null;
		rbt.TreeMap.Entry p_3 = obj.root;
		rbt.TreeMap.Entry p_5 = left_9;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry right_10 = null;
		rbt.TreeMap.Entry left_368 = null;
		rbt.TreeMap.Entry right_366 = null;
		obj.size = 2;
		boolean color_369 = false;
		int key_365 = 0;
		int key_2 = 0;
		int key = 0;
		int k_4 = 0;
		int key_7 = 1;
		int key_1 = 0;
		boolean color_12 = true;
		int key_301 = 1;
		int minE_13 = -1;
		int key_299 = 1;
		obj.modCount = 0;
		java.lang.Object value_370 = null;
		java.lang.Object value_8 = null;
		obj.root.key = key_7;
		obj.root.value = value_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.parent = parent_11;
		obj.root.color = color_12;
		left_9.key = key_365;
		left_9.value = value_370;
		left_9.left = left_368;
		left_9.right = right_366;
		left_9.parent = obj.root;
		left_9.color = color_369;
		////System.out.println(Utilities.repOK(obj));
		obj.get(key);
	}

	@Test
	public void test_get5() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_9 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_10 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_11 = null;
		rbt.TreeMap.Entry p_3 = obj.root;
		rbt.TreeMap.Entry p_5 = right_10;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_361 = null;
		rbt.TreeMap.Entry right_359 = null;
		rbt.TreeMap.Entry left_376 = null;
		rbt.TreeMap.Entry right_374 = null;
		int maxE_16 = 2;
		obj.size = 3;
		int key_2 = 1;
		int key = 1;
		int key_7 = 0;
		int k_4 = 1;
		boolean color_377 = true;
		int key_358 = -1;
		boolean color_362 = true;
		boolean color_12 = true;
		int key_1 = 1;
		int key_301 = 0;
		int minE_13 = -2;
		int key_373 = 1;
		int key_299 = 0;
		java.lang.Object value_363 = null;
		obj.modCount = 0;
		java.lang.Object value_8 = null;
		java.lang.Object value_378 = null;
		obj.root.key = key_7;
		obj.root.value = value_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.parent = parent_11;
		obj.root.color = color_12;
		left_9.key = key_358;
		left_9.value = value_363;
		left_9.left = left_361;
		left_9.right = right_359;
		left_9.parent = obj.root;
		left_9.color = color_362;
		right_10.key = key_373;
		right_10.value = value_378;
		right_10.left = left_376;
		right_10.right = right_374;
		right_10.parent = this_root_300;
		right_10.color = color_377;
		////System.out.println(Utilities.repOK(obj));
		obj.get(key);
	}

	@Test
	public void test_get6() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_11 = null;
		rbt.TreeMap.Entry p_3 = obj.root;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_9 = null;
		rbt.TreeMap.Entry right_10 = null;
		obj.size = 1;
		boolean color_12 = true;
		int key_1 = 3;
		int key_301 = 3;
		int key_2 = 3;
		int key = 3;
		int k_4 = 3;
		int key_7 = 3;
		int key_299 = 3;
		java.lang.Object value_8 = null;
		obj.modCount = 0;
		obj.root.key = key_7;
		obj.root.value = value_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.parent = parent_11;
		obj.root.color = color_12;
		////System.out.println(Utilities.repOK(obj));
		obj.get(key);
	}

}

