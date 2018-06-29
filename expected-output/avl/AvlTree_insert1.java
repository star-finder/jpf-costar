package avl;

import org.junit.Test;

import common.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class AvlTree_insert1 extends TestJPF {

	@Test
	public void test_insert1() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_2 = new avl.AvlNode();
		avl.AvlNode right_3 = null;
		avl.AvlNode left_251 = null;
		avl.AvlNode right_250 = null;
		int height_4 = 1;
		int heightL_6 = 0;
		int element_249 = 0;
		int minE_5 = -1;
		int element_1 = 1;
		int element_223 = 1;
		int element_224 = 1;
		int x = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		left_2.element = element_249;
		left_2.left = left_251;
		left_2.right = right_250;
		left_2.height = heightL_6;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert2() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_34 = new avl.AvlNode();
		avl.AvlNode newNode_8 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_34;
		avl.AvlNode t_7 = null;
		avl.AvlNode t_16 = newNode_8;
		avl.AvlNode left_80 = t_16;
		avl.AvlNode t_21 = left_80;
		avl.AvlNode t_22 = null;
		avl.AvlNode t_23 = left_80;
		avl.AvlNode t_24 = null;
		avl.AvlNode left_82 = t_5;
		avl.AvlNode t_27 = left_82;
		avl.AvlNode t_28 = null;
		avl.AvlNode right_35 = null;
		avl.AvlNode left_71 = null;
		avl.AvlNode right_72 = null;
		int x_1 = -1;
		int element_70 = 0;
		int heightL_38 = 0;
		int x_4 = -1;
		int x_2 = -1;
		int height_36 = 1;
		int element_225 = 0;
		int x_6 = -1;
		int element_33 = 1;
		int theElement_13 = -1;
		int element_226 = 1;
		int element_223 = 1;
		int element_224 = 0;
		int element_75 = -1;
		int minE_37 = -1;
		int x = -1;
		avl.AvlNode right_11 = null;
		avl.AvlNode left_10 = null;
		int element_9 = 0;
		int height_12 = 0;
		obj.root.element = element_33;
		obj.root.left = left_34;
		obj.root.right = right_35;
		obj.root.height = height_36;
		left_34.element = element_70;
		left_34.left = left_71;
		left_34.right = right_72;
		left_34.height = heightL_38;
		newNode_8.element = element_9;
		newNode_8.left = left_10;
		newNode_8.right = right_11;
		newNode_8.height = height_12;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert3() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_35 = new avl.AvlNode();
		avl.AvlNode newNode_8 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = right_35;
		avl.AvlNode t_7 = null;
		avl.AvlNode t_16 = newNode_8;
		avl.AvlNode left_109 = t_16;
		avl.AvlNode t_21 = left_109;
		avl.AvlNode t_22 = null;
		avl.AvlNode t_23 = left_109;
		avl.AvlNode t_24 = null;
		avl.AvlNode right_111 = t_5;
		avl.AvlNode t_27 = right_111;
		avl.AvlNode t_28 = null;
		avl.AvlNode left_34 = null;
		avl.AvlNode left_100 = null;
		avl.AvlNode right_101 = null;
		int x_1 = -1;
		int heightR_40 = 0;
		int element_99 = 0;
		int x_4 = -1;
		int x_2 = -1;
		int height_36 = 1;
		int element_104 = -1;
		int maxE_39 = 1;
		int element_225 = 0;
		int x_6 = -1;
		int element_33 = -2;
		int theElement_13 = -1;
		int element_226 = 0;
		int element_223 = -2;
		int element_224 = -2;
		int x = -1;
		avl.AvlNode right_11 = null;
		avl.AvlNode left_10 = null;
		int element_9 = 0;
		int height_12 = 0;
		obj.root.element = element_33;
		obj.root.left = left_34;
		obj.root.right = right_35;
		obj.root.height = height_36;
		right_35.element = element_99;
		right_35.left = left_100;
		right_35.right = right_101;
		right_35.height = heightR_40;
		newNode_8.element = element_9;
		newNode_8.left = left_10;
		newNode_8.right = right_11;
		newNode_8.height = height_12;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert4() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_54 = new avl.AvlNode();
		avl.AvlNode right_55 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_54;
		avl.AvlNode left_62 = null;
		avl.AvlNode right_63 = null;
		avl.AvlNode left_288 = null;
		avl.AvlNode right_287 = null;
		int x_1 = -2;
		int minE_57 = -2;
		int height_56 = 1;
		int element_286 = 1;
		int element_53 = 0;
		int element_61 = -1;
		int x_4 = -2;
		int element_226 = 0;
		int x_2 = -2;
		int maxE_59 = 2;
		int element_223 = 0;
		int element_224 = -1;
		int element_225 = -1;
		int heightL_58 = 0;
		int heightR_60 = 0;
		int x = -2;
		obj.root.element = element_53;
		obj.root.left = left_54;
		obj.root.right = right_55;
		obj.root.height = height_56;
		left_54.element = element_61;
		left_54.left = left_62;
		left_54.right = right_63;
		left_54.height = heightL_58;
		right_55.element = element_286;
		right_55.left = left_288;
		right_55.right = right_287;
		right_55.height = heightR_60;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert5() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = null;
		int x = 0;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert6() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_18 = new avl.AvlNode();
		avl.AvlNode left_17 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = right_18;
		avl.AvlNode left_25 = null;
		avl.AvlNode right_26 = null;
		avl.AvlNode left_290 = null;
		avl.AvlNode right_289 = null;
		int x_1 = 1;
		int maxE_22 = 1;
		int heightL_21 = 0;
		int heightR_23 = 0;
		int x_4 = 1;
		int element_226 = 0;
		int element_24 = 0;
		int x_2 = 1;
		int minE_20 = -3;
		int element_223 = -1;
		int element_224 = -1;
		int element_225 = 0;
		int element_16 = -1;
		int element_288 = -2;
		int x = 1;
		int height_19 = 1;
		obj.root.element = element_16;
		obj.root.left = left_17;
		obj.root.right = right_18;
		obj.root.height = height_19;
		right_18.element = element_24;
		right_18.left = left_25;
		right_18.right = right_26;
		right_18.height = heightR_23;
		left_17.element = element_288;
		left_17.left = left_290;
		left_17.right = right_289;
		left_17.height = heightL_21;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert7() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_9 = new avl.AvlNode();
		avl.AvlNode right_10 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_9;
		avl.AvlNode t_6 = null;
		avl.AvlNode t_7 = null;
		avl.AvlNode left_22 = t_5;
		avl.AvlNode t_10 = left_22;
		avl.AvlNode t_11 = right_10;
		avl.AvlNode left_17 = null;
		avl.AvlNode right_18 = null;
		avl.AvlNode left_322 = null;
		avl.AvlNode right_321 = null;
		int x_1 = -1;
		int heightR_15 = 0;
		int x_4 = -1;
		int element_226 = 0;
		int element_8 = 0;
		int x_2 = -1;
		int element_320 = 1;
		int height_11 = 1;
		int minE_12 = -2;
		int element_223 = 0;
		int element_224 = -1;
		int heightL_13 = 0;
		int element_16 = -1;
		int element_225 = -1;
		int maxE_14 = 2;
		int x = -1;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.height = height_11;
		left_9.element = element_16;
		left_9.left = left_17;
		left_9.right = right_18;
		left_9.height = heightL_13;
		right_10.element = element_320;
		right_10.left = left_322;
		right_10.right = right_321;
		right_10.height = heightR_15;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert8() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_2 = null;
		avl.AvlNode right_3 = null;
		int height_4 = 0;
		int element_1 = 3;
		int element_223 = 3;
		int element_224 = 3;
		int x = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert9() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode newNode_6 = new avl.AvlNode();
		avl.AvlNode left_26 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = null;
		avl.AvlNode t_14 = newNode_6;
		avl.AvlNode right_44 = t_14;
		avl.AvlNode t_19 = right_44;
		avl.AvlNode t_20 = left_26;
		avl.AvlNode right_27 = null;
		avl.AvlNode left_325 = null;
		avl.AvlNode right_324 = null;
		int theElement_11 = 2;
		int x_1 = 2;
		int height_28 = 1;
		int minE_29 = -1;
		int x_4 = 2;
		int heightL_30 = 0;
		int x_2 = 2;
		int element_323 = 0;
		int element_39 = 2;
		int element_223 = 1;
		int element_224 = 1;
		int element_25 = 1;
		int x = 2;
		avl.AvlNode left_8 = null;
		avl.AvlNode right_9 = null;
		int element_7 = 0;
		int height_10 = 0;
		obj.root.element = element_25;
		obj.root.left = left_26;
		obj.root.right = right_27;
		obj.root.height = height_28;
		newNode_6.element = element_7;
		newNode_6.left = left_8;
		newNode_6.right = right_9;
		newNode_6.height = height_10;
		left_26.element = element_323;
		left_26.left = left_325;
		left_26.right = right_324;
		left_26.height = heightL_30;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert10() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode newNode_6 = new avl.AvlNode();
		avl.AvlNode right_45 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = null;
		avl.AvlNode t_14 = newNode_6;
		avl.AvlNode left_68 = t_14;
		avl.AvlNode t_19 = left_68;
		avl.AvlNode t_20 = right_45;
		avl.AvlNode left_44 = null;
		avl.AvlNode left_338 = null;
		avl.AvlNode right_337 = null;
		int theElement_11 = -2;
		int x_1 = -2;
		int heightR_50 = 0;
		int element_336 = 0;
		int element_43 = -1;
		int element_63 = -2;
		int height_46 = 1;
		int x_4 = -2;
		int x_2 = -2;
		int element_223 = -1;
		int element_224 = -1;
		int maxE_49 = 1;
		int x = -2;
		avl.AvlNode left_8 = null;
		avl.AvlNode right_9 = null;
		int element_7 = 0;
		int height_10 = 0;
		obj.root.element = element_43;
		obj.root.left = left_44;
		obj.root.right = right_45;
		obj.root.height = height_46;
		newNode_6.element = element_7;
		newNode_6.left = left_8;
		newNode_6.right = right_9;
		newNode_6.height = height_10;
		right_45.element = element_336;
		right_45.left = left_338;
		right_45.right = right_337;
		right_45.height = heightR_50;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert11() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_10 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_4 = null;
		avl.AvlNode t_5 = right_10;
		avl.AvlNode left_9 = null;
		avl.AvlNode left_286 = null;
		avl.AvlNode right_285 = null;
		int x_2 = 0;
		int x_1 = 0;
		int height_11 = 1;
		int element_284 = 1;
		int heightR_15 = 0;
		int element_223 = 0;
		int element_224 = 0;
		int maxE_14 = 2;
		int x = 0;
		int element_8 = 0;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.height = height_11;
		right_10.element = element_284;
		right_10.left = left_286;
		right_10.right = right_285;
		right_10.height = heightR_15;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert12() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_9 = new avl.AvlNode();
		avl.AvlNode right_10 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_4 = left_9;
		avl.AvlNode left_267 = null;
		avl.AvlNode right_266 = null;
		avl.AvlNode left_281 = null;
		avl.AvlNode right_280 = null;
		int x_2 = 0;
		int x_1 = 0;
		int height_11 = 1;
		int minE_12 = -2;
		int element_265 = -1;
		int heightR_15 = 0;
		int element_223 = 0;
		int element_224 = 0;
		int heightL_13 = 0;
		int element_279 = 1;
		int maxE_14 = 2;
		int x = 0;
		int element_8 = 0;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.height = height_11;
		left_9.element = element_265;
		left_9.left = left_267;
		left_9.right = right_266;
		left_9.height = heightL_13;
		right_10.element = element_279;
		right_10.left = left_281;
		right_10.right = right_280;
		right_10.height = heightR_15;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert13() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode left_26 = null;
		avl.AvlNode right_27 = null;
		int x_2 = 0;
		int x_1 = 0;
		int height_28 = 0;
		int element_25 = 0;
		int x = 0;
		int element_223 = 0;
		int element_224 = 0;
		obj.root.element = element_25;
		obj.root.left = left_26;
		obj.root.right = right_27;
		obj.root.height = height_28;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert14() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_9 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_4 = left_9;
		avl.AvlNode t_5 = null;
		avl.AvlNode right_10 = null;
		avl.AvlNode left_272 = null;
		avl.AvlNode right_271 = null;
		int x_2 = 0;
		int element_270 = -1;
		int x_1 = 0;
		int height_11 = 1;
		int minE_12 = -2;
		int element_223 = 0;
		int element_224 = 0;
		int heightL_13 = 0;
		int x = 0;
		int element_8 = 0;
		obj.root.element = element_8;
		obj.root.left = left_9;
		obj.root.right = right_10;
		obj.root.height = height_11;
		left_9.element = element_270;
		left_9.left = left_272;
		left_9.right = right_271;
		left_9.height = heightL_13;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert15() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_17 = new avl.AvlNode();
		avl.AvlNode right_18 = new avl.AvlNode();
		avl.AvlNode right_31 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_17;
		avl.AvlNode t_6 = null;
		avl.AvlNode t_7 = right_31;
		avl.AvlNode left_30 = null;
		avl.AvlNode left_305 = null;
		avl.AvlNode right_304 = null;
		avl.AvlNode left_333 = null;
		avl.AvlNode right_332 = null;
		int x_1 = 0;
		int maxE_22 = 4;
		int heightL_21 = 1;
		int heightR_23 = 0;
		int x_4 = 0;
		int element_226 = 2;
		int heightR_33 = 0;
		int x_2 = 0;
		int element_303 = 3;
		int minE_20 = -1;
		int element_223 = 2;
		int element_224 = 0;
		int element_225 = 0;
		int element_16 = 2;
		int element_29 = 0;
		int element_331 = 1;
		int x = 0;
		int height_19 = 2;
		obj.root.element = element_16;
		obj.root.left = left_17;
		obj.root.right = right_18;
		obj.root.height = height_19;
		left_17.element = element_29;
		left_17.left = left_30;
		left_17.right = right_31;
		left_17.height = heightL_21;
		right_18.element = element_303;
		right_18.left = left_305;
		right_18.right = right_304;
		right_18.height = heightR_23;
		right_31.element = element_331;
		right_31.left = left_333;
		right_31.right = right_332;
		right_31.height = heightR_33;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert16() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_34 = new avl.AvlNode();
		avl.AvlNode newNode_8 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_34;
		avl.AvlNode t_7 = null;
		avl.AvlNode t_16 = newNode_8;
		avl.AvlNode right_80 = t_16;
		avl.AvlNode t_21 = right_80;
		avl.AvlNode t_22 = null;
		avl.AvlNode t_23 = null;
		avl.AvlNode t_24 = right_80;
		avl.AvlNode left_82 = t_5;
		avl.AvlNode t_27 = left_82;
		avl.AvlNode t_28 = null;
		avl.AvlNode right_35 = null;
		avl.AvlNode left_71 = null;
		avl.AvlNode right_72 = null;
		int x_1 = 1;
		int element_70 = 0;
		int heightL_38 = 0;
		int x_4 = 1;
		int x_2 = 1;
		int height_36 = 1;
		int element_225 = 0;
		int x_6 = 1;
		int element_33 = 2;
		int theElement_13 = 1;
		int element_226 = 2;
		int element_223 = 2;
		int element_224 = 0;
		int element_75 = 1;
		int minE_37 = -1;
		int x = 1;
		avl.AvlNode right_11 = null;
		avl.AvlNode left_10 = null;
		int element_9 = 0;
		int height_12 = 0;
		obj.root.element = element_33;
		obj.root.left = left_34;
		obj.root.right = right_35;
		obj.root.height = height_36;
		left_34.element = element_70;
		left_34.left = left_71;
		left_34.right = right_72;
		left_34.height = heightL_38;
		newNode_8.element = element_9;
		newNode_8.left = left_10;
		newNode_8.right = right_11;
		newNode_8.height = height_12;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert17() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_18 = new avl.AvlNode();
		avl.AvlNode left_17 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = right_18;
		avl.AvlNode t_6 = null;
		avl.AvlNode t_7 = null;
		avl.AvlNode right_30 = t_5;
		avl.AvlNode t_10 = right_30;
		avl.AvlNode t_11 = left_17;
		avl.AvlNode left_25 = null;
		avl.AvlNode right_26 = null;
		avl.AvlNode left_323 = null;
		avl.AvlNode right_322 = null;
		int x_1 = 0;
		int maxE_22 = 1;
		int heightL_21 = 0;
		int heightR_23 = 0;
		int x_4 = 0;
		int element_226 = 0;
		int element_24 = 0;
		int x_2 = 0;
		int minE_20 = -3;
		int element_223 = -1;
		int element_224 = -1;
		int element_225 = 0;
		int element_321 = -2;
		int element_16 = -1;
		int x = 0;
		int height_19 = 1;
		obj.root.element = element_16;
		obj.root.left = left_17;
		obj.root.right = right_18;
		obj.root.height = height_19;
		right_18.element = element_24;
		right_18.left = left_25;
		right_18.right = right_26;
		right_18.height = heightR_23;
		left_17.element = element_321;
		left_17.left = left_323;
		left_17.right = right_322;
		left_17.height = heightL_21;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert18() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_45 = new avl.AvlNode();
		avl.AvlNode left_44 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = right_45;
		avl.AvlNode left_52 = null;
		avl.AvlNode right_53 = null;
		avl.AvlNode left_289 = null;
		avl.AvlNode right_288 = null;
		int x_1 = -1;
		int heightR_50 = 0;
		int heightL_48 = 0;
		int element_43 = -2;
		int height_46 = 1;
		int x_4 = -1;
		int element_226 = 0;
		int element_287 = -3;
		int x_2 = -1;
		int element_51 = 0;
		int minE_47 = -4;
		int element_223 = -2;
		int element_224 = -2;
		int element_225 = 0;
		int maxE_49 = 1;
		int x = -1;
		obj.root.element = element_43;
		obj.root.left = left_44;
		obj.root.right = right_45;
		obj.root.height = height_46;
		right_45.element = element_51;
		right_45.left = left_52;
		right_45.right = right_53;
		right_45.height = heightR_50;
		left_44.element = element_287;
		left_44.left = left_289;
		left_44.right = right_288;
		left_44.height = heightL_48;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert19() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode left_17 = new avl.AvlNode();
		avl.AvlNode right_18 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = left_17;
		avl.AvlNode left_25 = null;
		avl.AvlNode right_26 = null;
		avl.AvlNode left_289 = null;
		avl.AvlNode right_288 = null;
		int x_1 = -1;
		int maxE_22 = 2;
		int heightL_21 = 0;
		int heightR_23 = 0;
		int x_4 = -1;
		int element_226 = 0;
		int element_287 = 1;
		int element_24 = -2;
		int x_2 = -1;
		int minE_20 = -3;
		int element_223 = 0;
		int element_224 = -2;
		int element_225 = -2;
		int element_16 = 0;
		int x = -1;
		int height_19 = 1;
		obj.root.element = element_16;
		obj.root.left = left_17;
		obj.root.right = right_18;
		obj.root.height = height_19;
		left_17.element = element_24;
		left_17.left = left_25;
		left_17.right = right_26;
		left_17.height = heightL_21;
		right_18.element = element_287;
		right_18.left = left_289;
		right_18.right = right_288;
		right_18.height = heightR_23;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert20() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_18 = new avl.AvlNode();
		avl.AvlNode left_17 = new avl.AvlNode();
		avl.AvlNode right_36 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = right_18;
		avl.AvlNode t_6 = null;
		avl.AvlNode t_7 = right_36;
		avl.AvlNode left_35 = null;
		avl.AvlNode left_306 = null;
		avl.AvlNode right_305 = null;
		avl.AvlNode left_334 = null;
		avl.AvlNode right_333 = null;
		int element_332 = 1;
		int x_1 = 0;
		int maxE_22 = 2;
		int heightL_21 = 0;
		int heightR_23 = 1;
		int heightR_38 = 0;
		int x_4 = 0;
		int element_226 = 0;
		int x_2 = 0;
		int minE_20 = -3;
		int element_304 = -2;
		int element_34 = 0;
		int element_223 = -1;
		int element_224 = -1;
		int element_225 = 0;
		int element_16 = -1;
		int x = 0;
		int height_19 = 2;
		obj.root.element = element_16;
		obj.root.left = left_17;
		obj.root.right = right_18;
		obj.root.height = height_19;
		right_18.element = element_34;
		right_18.left = left_35;
		right_18.right = right_36;
		right_18.height = heightR_23;
		left_17.element = element_304;
		left_17.left = left_306;
		left_17.right = right_305;
		left_17.height = heightL_21;
		right_36.element = element_332;
		right_36.left = left_334;
		right_36.right = right_333;
		right_36.height = heightR_38;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert21() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_3 = new avl.AvlNode();
		avl.AvlNode left_2 = null;
		avl.AvlNode left_265 = null;
		avl.AvlNode right_264 = null;
		int height_4 = 1;
		int maxE_7 = 1;
		int element_1 = -1;
		int heightR_8 = 0;
		int element_263 = 0;
		int element_223 = -1;
		int element_224 = -1;
		int x = 0;
		obj.root.element = element_1;
		obj.root.left = left_2;
		obj.root.right = right_3;
		obj.root.height = height_4;
		right_3.element = element_263;
		right_3.left = left_265;
		right_3.right = right_264;
		right_3.height = heightR_8;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert22() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode right_35 = new avl.AvlNode();
		avl.AvlNode newNode_8 = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = right_35;
		avl.AvlNode t_7 = null;
		avl.AvlNode t_16 = newNode_8;
		avl.AvlNode right_109 = t_16;
		avl.AvlNode t_21 = right_109;
		avl.AvlNode t_22 = null;
		avl.AvlNode t_23 = null;
		avl.AvlNode t_24 = right_109;
		avl.AvlNode right_111 = t_5;
		avl.AvlNode t_27 = right_111;
		avl.AvlNode t_28 = null;
		avl.AvlNode left_34 = null;
		avl.AvlNode left_100 = null;
		avl.AvlNode right_101 = null;
		int x_1 = 1;
		int heightR_40 = 0;
		int element_99 = 0;
		int x_4 = 1;
		int x_2 = 1;
		int height_36 = 1;
		int maxE_39 = 1;
		int element_104 = 1;
		int element_225 = 0;
		int x_6 = 1;
		int element_33 = -1;
		int theElement_13 = 1;
		int element_226 = 0;
		int element_223 = -1;
		int element_224 = -1;
		int x = 1;
		avl.AvlNode right_11 = null;
		avl.AvlNode left_10 = null;
		int element_9 = 0;
		int height_12 = 0;
		obj.root.element = element_33;
		obj.root.left = left_34;
		obj.root.right = right_35;
		obj.root.height = height_36;
		right_35.element = element_99;
		right_35.left = left_100;
		right_35.right = right_101;
		right_35.height = heightR_40;
		newNode_8.element = element_9;
		newNode_8.left = left_10;
		newNode_8.right = right_11;
		newNode_8.height = height_12;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

	@Test
	public void test_insert23() throws Exception {
		AvlTree obj = new AvlTree();
		obj.root = new avl.AvlNode();
		avl.AvlNode t_3 = obj.root;
		avl.AvlNode t_5 = null;
		avl.AvlNode left_54 = null;
		avl.AvlNode right_55 = null;
		int x_2 = 1;
		int x_1 = 1;
		int element_223 = 0;
		int height_56 = 0;
		int element_224 = 0;
		int element_53 = 0;
		int x_4 = 1;
		int x = 1;
		obj.root.element = element_53;
		obj.root.left = left_54;
		obj.root.right = right_55;
		obj.root.height = height_56;
		//System.out.println(Utilities.repOK(obj));
		obj.insert(x);
	}

}

