package rbt;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class TreeMap_containsValue1 extends TestJPF {

	@Test
	public void test_containsValue1() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = null;
		obj.size = 0;
		obj.modCount = 0;
		java.lang.Object value = null;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue2() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_7 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_8 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry left_6 = null;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_384 = null;
		rbt.TreeMap.Entry right_382 = null;
		obj.size = 2;
		boolean color_385 = false;
		boolean color_9 = true;
		int key_381 = 0;
		int key_301 = -1;
		int key_4 = -1;
		int maxE_13 = 1;
		int key_299 = -1;
		java.lang.Object value_1 = new java.lang.Object();
		java.lang.Object value = value_1;
		java.lang.Object value_3 = value_1;
		java.lang.Object value_5 = new java.lang.Object();
		java.lang.Object value_386 = null;
		obj.modCount = 0;
		obj.root.key = key_4;
		obj.root.value = value_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		obj.root.parent = parent_8;
		obj.root.color = color_9;
		right_7.key = key_381;
		right_7.value = value_386;
		right_7.left = left_384;
		right_7.right = right_382;
		right_7.parent = this_root_300;
		right_7.color = color_385;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue3() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_7 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_9 = null;
		rbt.TreeMap.Entry parent_21 = obj.root;
		java.lang.Object value_1 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry n_3 = left_7;
		rbt.TreeMap.Entry left_19 = null;
		rbt.TreeMap.Entry right_20 = null;
		rbt.TreeMap.Entry right_8 = null;
		rbt.TreeMap.Entry left_300 = left_7;
		rbt.TreeMap.Entry left_302 = left_7;
		int key_5 = 1;
		obj.size = 2;
		boolean color_10 = true;
		int minE_11 = -1;
		int key_304 = 1;
		int key_17 = 0;
		boolean color_22 = false;
		int key_301 = 0;
		int key_303 = 0;
		int key_299 = 1;
		java.lang.Object value = value_1;
		java.lang.Object value_6 = new java.lang.Object();
		java.lang.Object value_18 = new java.lang.Object();
		obj.modCount = 0;
		obj.root.key = key_5;
		obj.root.value = value_6;
		obj.root.left = left_7;
		obj.root.right = right_8;
		obj.root.parent = parent_9;
		obj.root.color = color_10;
		left_7.key = key_17;
		left_7.value = value_18;
		left_7.left = left_19;
		left_7.right = right_20;
		left_7.parent = parent_21;
		left_7.color = color_22;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue4() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_7 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_8 = null;
		rbt.TreeMap.Entry parent_20 = obj.root;
		java.lang.Object value_1 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry left_6 = null;
		rbt.TreeMap.Entry n_3 = right_7;
		rbt.TreeMap.Entry right_300 = right_7;
		rbt.TreeMap.Entry right_303 = right_7;
		rbt.TreeMap.Entry left_18 = null;
		rbt.TreeMap.Entry right_19 = null;
		obj.size = 2;
		int key_16 = 0;
		int key_304 = 0;
		boolean color_21 = false;
		boolean color_9 = true;
		int key_301 = -1;
		int key_4 = -1;
		int key_302 = 0;
		int maxE_13 = 1;
		int key_299 = -1;
		java.lang.Object value = value_1;
		java.lang.Object value_5 = new java.lang.Object();
		java.lang.Object value_17 = new java.lang.Object();
		obj.modCount = 0;
		obj.root.key = key_4;
		obj.root.value = value_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		obj.root.parent = parent_8;
		obj.root.color = color_9;
		right_7.key = key_16;
		right_7.value = value_17;
		right_7.left = left_18;
		right_7.right = right_19;
		right_7.parent = parent_20;
		right_7.color = color_21;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue5() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_6 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_7 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_8 = null;
		rbt.TreeMap.Entry parent_20 = obj.root;
		java.lang.Object value_1 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry n_3 = left_6;
		rbt.TreeMap.Entry left_300 = left_6;
		rbt.TreeMap.Entry left_302 = left_6;
		rbt.TreeMap.Entry left_18 = null;
		rbt.TreeMap.Entry right_19 = null;
		rbt.TreeMap.Entry left_401 = null;
		rbt.TreeMap.Entry right_399 = null;
		int key_299 = -1;
		obj.size = 3;
		int key_16 = -2;
		int key_304 = -1;
		boolean color_21 = true;
		int key_398 = 0;
		boolean color_9 = true;
		boolean color_402 = true;
		int key_301 = -2;
		int key_303 = -2;
		int minE_10 = -3;
		int key_4 = -1;
		int maxE_13 = 1;
		java.lang.Object value = value_1;
		java.lang.Object value_5 = new java.lang.Object();
		java.lang.Object value_17 = new java.lang.Object();
		java.lang.Object value_403 = null;
		obj.modCount = 0;
		obj.root.key = key_4;
		obj.root.value = value_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		obj.root.parent = parent_8;
		obj.root.color = color_9;
		left_6.key = key_16;
		left_6.value = value_17;
		left_6.left = left_18;
		left_6.right = right_19;
		left_6.parent = parent_20;
		left_6.color = color_21;
		right_7.key = key_398;
		right_7.value = value_403;
		right_7.left = left_401;
		right_7.right = right_399;
		right_7.parent = obj.root;
		right_7.color = color_402;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue6() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_318 = null;
		rbt.TreeMap.Entry left_316 = null;
		rbt.TreeMap.Entry right_313 = null;
		boolean color_317 = true;
		obj.size = 1;
		java.lang.Object value_1 = new java.lang.Object();
		java.lang.Object value = value_1;
		java.lang.Object value_319 = null;
		obj.modCount = 0;
		int key_312 = 0;
		obj.root.key = key_312;
		obj.root.value = value_319;
		obj.root.left = left_316;
		obj.root.right = right_313;
		obj.root.parent = parent_318;
		obj.root.color = color_317;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue7() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_9 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_10 = null;
		rbt.TreeMap.Entry parent_22 = obj.root;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry left_8 = null;
		rbt.TreeMap.Entry n_4 = right_9;
		rbt.TreeMap.Entry right_300 = right_9;
		rbt.TreeMap.Entry right_303 = right_9;
		rbt.TreeMap.Entry left_20 = null;
		rbt.TreeMap.Entry right_21 = null;
		obj.size = 2;
		int key_18 = 0;
		int key_304 = 0;
		boolean color_23 = false;
		int key_301 = -1;
		int key_6 = -1;
		int key_302 = 0;
		boolean color_11 = true;
		int maxE_15 = 1;
		int key_299 = -1;
		java.lang.Object value_1 = new java.lang.Object();
		java.lang.Object value = value_1;
		java.lang.Object value_3 = value_1;
		java.lang.Object value_7 = new java.lang.Object();
		java.lang.Object value_5 = value_3;
		java.lang.Object value_19 = value_5;
		obj.modCount = 0;
		obj.root.key = key_6;
		obj.root.value = value_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		obj.root.parent = parent_10;
		obj.root.color = color_11;
		right_9.key = key_18;
		right_9.value = value_19;
		right_9.left = left_20;
		right_9.right = right_21;
		right_9.parent = parent_22;
		right_9.color = color_23;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue8() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_6 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_7 = null;
		java.lang.Object value_1 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry left_5 = null;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_383 = null;
		rbt.TreeMap.Entry right_381 = null;
		int key_299 = -1;
		obj.size = 2;
		int key_301 = -1;
		int maxE_12 = 1;
		int key_380 = 0;
		boolean color_8 = true;
		int key_3 = -1;
		boolean color_384 = false;
		java.lang.Object value = value_1;
		java.lang.Object value_4 = new java.lang.Object();
		java.lang.Object value_385 = null;
		obj.modCount = 0;
		obj.root.key = key_3;
		obj.root.value = value_4;
		obj.root.left = left_5;
		obj.root.right = right_6;
		obj.root.parent = parent_7;
		obj.root.color = color_8;
		right_6.key = key_380;
		right_6.value = value_385;
		right_6.left = left_383;
		right_6.right = right_381;
		right_6.parent = this_root_300;
		right_6.color = color_384;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue9() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_8 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_9 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_10 = null;
		rbt.TreeMap.Entry parent_22 = obj.root;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry n_4 = left_8;
		rbt.TreeMap.Entry left_20 = null;
		rbt.TreeMap.Entry right_21 = null;
		rbt.TreeMap.Entry left_300 = left_8;
		rbt.TreeMap.Entry left_302 = left_8;
		rbt.TreeMap.Entry left_412 = null;
		rbt.TreeMap.Entry right_410 = null;
		boolean color_413 = true;
		obj.size = 3;
		int key_18 = -1;
		int key_304 = 0;
		boolean color_23 = true;
		int minE_12 = -2;
		int key_301 = -1;
		int key_303 = -1;
		int key_6 = 0;
		boolean color_11 = true;
		int key_409 = 1;
		int maxE_15 = 2;
		int key_299 = 0;
		java.lang.Object value_1 = new java.lang.Object();
		java.lang.Object value = value_1;
		java.lang.Object value_3 = value_1;
		java.lang.Object value_7 = new java.lang.Object();
		java.lang.Object value_5 = value_3;
		java.lang.Object value_19 = new java.lang.Object();
		obj.modCount = 0;
		java.lang.Object value_414 = null;
		obj.root.key = key_6;
		obj.root.value = value_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		obj.root.parent = parent_10;
		obj.root.color = color_11;
		left_8.key = key_18;
		left_8.value = value_19;
		left_8.left = left_20;
		left_8.right = right_21;
		left_8.parent = parent_22;
		left_8.color = color_23;
		right_9.key = key_409;
		right_9.value = value_414;
		right_9.left = left_412;
		right_9.right = right_410;
		right_9.parent = obj.root;
		right_9.color = color_413;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue10() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_10 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry right_11 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_12 = null;
		rbt.TreeMap.Entry parent_24 = obj.root;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry n_4 = left_10;
		rbt.TreeMap.Entry left_300 = left_10;
		rbt.TreeMap.Entry left_302 = left_10;
		rbt.TreeMap.Entry left_22 = null;
		rbt.TreeMap.Entry right_23 = null;
		rbt.TreeMap.Entry left_407 = null;
		rbt.TreeMap.Entry right_405 = null;
		obj.size = 3;
		int maxE_17 = 2;
		int key_20 = -1;
		int key_304 = 0;
		int key_8 = 0;
		boolean color_13 = true;
		int minE_14 = -2;
		boolean color_408 = true;
		int key_301 = -1;
		int key_303 = -1;
		boolean color_25 = true;
		int key_404 = 1;
		int key_299 = 0;
		java.lang.Object value_1 = new java.lang.Object();
		java.lang.Object value = value_1;
		java.lang.Object value_3 = value_1;
		java.lang.Object value_9 = new java.lang.Object();
		java.lang.Object value_5 = value_3;
		java.lang.Object value_21 = value_5;
		java.lang.Object value_409 = null;
		obj.modCount = 0;
		obj.root.key = key_8;
		obj.root.value = value_9;
		obj.root.left = left_10;
		obj.root.right = right_11;
		obj.root.parent = parent_12;
		obj.root.color = color_13;
		left_10.key = key_20;
		left_10.value = value_21;
		left_10.left = left_22;
		left_10.right = right_23;
		left_10.parent = parent_24;
		left_10.color = color_25;
		right_11.key = key_404;
		right_11.value = value_409;
		right_11.left = left_407;
		right_11.right = right_405;
		right_11.parent = obj.root;
		right_11.color = color_408;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue11() throws Exception {
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
		java.lang.Object value = null;
		obj.root.key = key_1;
		obj.root.value = value_2;
		obj.root.left = left_3;
		obj.root.right = right_4;
		obj.root.parent = parent_5;
		obj.root.color = color_6;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue12() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_6 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_8 = null;
		java.lang.Object value_1 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry right_7 = null;
		rbt.TreeMap.Entry left_365 = null;
		rbt.TreeMap.Entry right_363 = null;
		boolean color_9 = true;
		int key_299 = 1;
		obj.size = 2;
		int key_301 = 1;
		int key_362 = 0;
		int key_4 = 1;
		int minE_10 = -1;
		boolean color_366 = false;
		java.lang.Object value = value_1;
		java.lang.Object value_5 = new java.lang.Object();
		java.lang.Object value_367 = null;
		obj.modCount = 0;
		obj.root.key = key_4;
		obj.root.value = value_5;
		obj.root.left = left_6;
		obj.root.right = right_7;
		obj.root.parent = parent_8;
		obj.root.color = color_9;
		left_6.key = key_362;
		left_6.value = value_367;
		left_6.left = left_365;
		left_6.right = right_363;
		left_6.parent = obj.root;
		left_6.color = color_366;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue13() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry left_8 = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_10 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry right_9 = null;
		rbt.TreeMap.Entry left_366 = null;
		rbt.TreeMap.Entry right_364 = null;
		obj.size = 2;
		int key_363 = 0;
		int minE_12 = -1;
		int key_301 = 1;
		int key_6 = 1;
		boolean color_11 = true;
		boolean color_367 = false;
		int key_299 = 1;
		java.lang.Object value_1 = new java.lang.Object();
		java.lang.Object value = value_1;
		java.lang.Object value_3 = value_1;
		java.lang.Object value_7 = new java.lang.Object();
		java.lang.Object value_368 = null;
		obj.modCount = 0;
		obj.root.key = key_6;
		obj.root.value = value_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		obj.root.parent = parent_10;
		obj.root.color = color_11;
		left_8.key = key_363;
		left_8.value = value_368;
		left_8.left = left_366;
		left_8.right = right_364;
		left_8.parent = obj.root;
		left_8.color = color_367;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue14() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_10 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_8 = null;
		rbt.TreeMap.Entry right_9 = null;
		int key_299 = 4;
		obj.size = 1;
		int key_301 = 4;
		int key_6 = 4;
		boolean color_11 = true;
		java.lang.Object value_1 = new java.lang.Object();
		java.lang.Object value = value_1;
		java.lang.Object value_3 = value_1;
		java.lang.Object value_7 = value_3;
		obj.modCount = 0;
		obj.root.key = key_6;
		obj.root.value = value_7;
		obj.root.left = left_8;
		obj.root.right = right_9;
		obj.root.parent = parent_10;
		obj.root.color = color_11;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

	@Test
	public void test_containsValue15() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new rbt.TreeMap.Entry();
		rbt.TreeMap.Entry parent_7 = null;
		java.lang.Object value_1 = null;
		rbt.TreeMap.Entry n_2 = obj.root;
		rbt.TreeMap.Entry this_root_300 = obj.root;
		rbt.TreeMap.Entry left_5 = null;
		rbt.TreeMap.Entry right_6 = null;
		obj.size = 1;
		int key_301 = 4;
		boolean color_8 = true;
		int key_3 = 4;
		int key_299 = 4;
		java.lang.Object value = value_1;
		java.lang.Object value_4 = new java.lang.Object();
		obj.modCount = 0;
		obj.root.key = key_3;
		obj.root.value = value_4;
		obj.root.left = left_5;
		obj.root.right = right_6;
		obj.root.parent = parent_7;
		obj.root.color = color_8;
		//System.out.println(Utilities.repOK(obj));
		obj.containsValue(value);
	}

}

