package rbt;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class TreeMap_firstKey1 extends TestJPF {

	@Test
	public void test_firstKey1() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = null;
		obj.size = 0;
		obj.modCount = 0;
		//System.out.println(Utilities.repOK(obj));
		obj.firstKey();
	}

	@Test
	public void test_firstKey2() throws Exception {
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
		obj.firstKey();
	}

	@Test
	public void test_firstKey3() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_5 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_7 = null;
		rbt.TreeMap.Entry p_1 = obj.root;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry right_6 = null;
		rbt.TreeMap.Entry left_357 = null;
		rbt.TreeMap.Entry right_355 = null;
		int minE_9 = -1;
		obj.size = 2;
		int key_354 = 0;
		int key_301 = 1;
		boolean color_8 = true;
		int key_3 = 1;
		boolean color_358 = false;
		int key_299 = 1;
		java.lang.Object value_4 = null;
		java.lang.Object value_359 = null;
		obj.modCount = 0;
		obj.root.key = key_3;
		obj.root.value = value_4;
		obj.root.left = left_5;
		obj.root.right = right_6;
		obj.root.parent = parent_7;
		obj.root.color = color_8;
		left_5.key = key_354;
		left_5.value = value_359;
		left_5.left = left_357;
		left_5.right = right_355;
		left_5.parent = obj.root;
		left_5.color = color_358;
		//System.out.println(Utilities.repOK(obj));
		obj.firstKey();
	}

}

