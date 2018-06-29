package rbt;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class TreeMap_lastKey1 extends TestJPF {

	@Test
	public void test_lastKey1() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = null;
		obj.size = 0;
		obj.modCount = 0;
		//System.out.println(Utilities.repOK(obj));
		obj.lastKey();
	}

	@Test
	public void test_lastKey2() throws Exception {
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
		obj.root.key = key_1;
		obj.root.value = value_2;
		obj.root.left = left_3;
		obj.root.right = right_4;
		obj.root.parent = parent_5;
		obj.root.color = color_6;
		//System.out.println(Utilities.repOK(obj));
		obj.lastKey();
	}

	@Test
	public void test_lastKey3() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_5 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_6 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_7 = null;
		rbt.TreeMap.Entry p_1 = obj.root;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_350 = null;
		rbt.TreeMap.Entry right_348 = null;
		rbt.TreeMap.Entry left_365 = null;
		rbt.TreeMap.Entry right_363 = null;
		obj.size = 3;
		boolean color_351 = true;
		int key_347 = -2;
		int minE_9 = -3;
		int key_362 = 0;
		int key_301 = -1;
		int maxE_12 = 1;
		boolean color_8 = true;
		int key_3 = -1;
		boolean color_366 = true;
		int key_299 = -1;
		java.lang.Object value_367 = null;
		obj.modCount = 0;
		java.lang.Object value_352 = null;
		java.lang.Object value_4 = null;
		obj.root.key = key_3;
		obj.root.value = value_4;
		obj.root.left = left_5;
		obj.root.right = right_6;
		obj.root.parent = parent_7;
		obj.root.color = color_8;
		left_5.key = key_347;
		left_5.value = value_352;
		left_5.left = left_350;
		left_5.right = right_348;
		left_5.parent = obj.root;
		left_5.color = color_351;
		right_6.key = key_362;
		right_6.value = value_367;
		right_6.left = left_365;
		right_6.right = right_363;
		right_6.parent = this_root_300;
		right_6.color = color_366;
		//System.out.println(Utilities.repOK(obj));
		obj.lastKey();
	}

}

