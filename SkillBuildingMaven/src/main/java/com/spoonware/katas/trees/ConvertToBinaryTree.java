package com.spoonware.katas.trees;

public class ConvertToBinaryTree {
	/*
	 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to creat a binary search tree
	 * with minimal height.
	 * 
	 */
	static void preOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println("pOT=" + root.value);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	static TreeNode convertArrayToBST(int[] values) {
		int middle = computeMiddleValue(values);
		TreeNode root = new TreeNode(middle, null, null);
		TreeNode leftRunner = root;
		TreeNode rightRunner = root;
		boolean isDone = false;
		int counter = 1;
		
		while(leftRunner != null) {
			leftRunner.left = computeLeftSideOfTree(values, leftRunner.value);
			leftRunner = leftRunner.left;
		}
		
		while(rightRunner != null) {
			rightRunner.right = computeRightSideOfTree(values, rightRunner.value);
			rightRunner = rightRunner.right;
		}
//		isDone = true;
//		while(!isDone) {
////			leftRunner.left = computeLeftSideOfTree(values, leftRunner.value);
//			counter++;
//			rightRunner.right = computeRightSideOfTree(values, rightRunner.value);
//			counter++;
////			leftRunner = leftRunner.left;
//			rightRunner = rightRunner.right;
//			isDone = (counter > 20) ? true : false ;
//		}
//		rightRunner.right = computeRightSideOfTree_new(values, rightRunner);
		
		

		//build up the rest of the tree
		return root;
	}

	private static int[] computeLowerArray(int[] values, int maxValue) {
		//return all of the array to the left of maxValue
		int targetIndex = 0;
		for(int i=0; i < values.length; i++) {
			if(values[i] == maxValue) {
				targetIndex = i;
			}
		}
		//using targetIndex make new array size targetIndex + 1
		int[] results = new int[targetIndex + 1];
		for(int j= 0; j < results.length; j++) {
			results[j] = values[j];
		}
		//print it out
		for(int result : results) {
			System.out.println("result computeLowerArray=" + result);
		}
		if(results.length <= 1) {
			return null;
		}else {
			return results;
		}
	}

	private static int[] computeUpperArray(int[] values, int minValue) {
		//return all of the array to the left of maxValue
		int targetIndex = 0;
		for(int i=0; i < values.length; i++) {
			if(values[i] == minValue) {
				targetIndex = i;
			}
		}
		//using targetIndex make new array size values.length - targetIndex
		int[] results = new int[values.length - targetIndex];
		for(int j= 0; j < results.length; j++) {
			results[j] = values[targetIndex + j];
		}
		//print it out
		for(int result : results) {
			System.out.println("result computeUpperArray=" + result);
		}
		if(results.length <= 1) {
			return null;
		}else {
			return results;
		}
	}

	private static int computeMiddleValue(int[] values) {
		if(values.length < 1) return -1;
		int middlePosition = (values.length / 2) + (values.length % 2);
		return values[values.length - middlePosition];
	}

	private static TreeNode computeLeftSideOfTree(final int[] values, final int maxValue) {
		int[] tempArray = computeLowerArray(values, maxValue);
		if(tempArray == null) {
			System.out.println("computeLowerArray returned null array");
			return null;
		}
		int value = 0;
		if(tempArray.length <= 2) {
			value = tempArray[0];
		}else {
			value = computeMiddleValue(tempArray);
		}
		
		System.out.println("compute left side value=" + value);
		TreeNode root = new TreeNode(value, null, null);
		return root;
	}

	private static TreeNode computeRightSideOfTree(final int[] values, final int minValue) {
		int[] tempArray = computeUpperArray(values, minValue);
		if(tempArray == null) {
			System.out.println("computeUpperArray returned null array");
			return null;
		}
//		if(tempArray.length==0) {
//			System.out.println("computeUpperArray returned empty array");
//			return null;
//		}
		//if array length <= 1 then return null
		TreeNode root = new TreeNode(computeMiddleValue(tempArray), null, null);
		return root;
	}
	
	private static TreeNode computeRightSideOfTree_new(final int[] values, final TreeNode parentNode) {
		System.out.println("running cRSOT recursive");
		int minValue = parentNode.value;
		int[] tempArray = computeUpperArray(values, minValue);
		if(tempArray.length==0) {
			System.out.println("computeUpperArray returned empty array");
			return null;
		}
		//if array length <= 1 then return null
		TreeNode root = new TreeNode(computeMiddleValue(tempArray), null, null);
//		return computeRightSideOfTree(tempArray, root);
		return root;
		
	}



	public static void main(String[] args) {
//		int[] values = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
				int[] values = {2,3,5,7,11,13,17,19,23,29,31};
//						int[] values = {2,3,5,7,11,13};
		//		int[] values = {2};
		//		int middle = computeMiddleValue(values);
		//		System.out.println("middle=" + middle);

		TreeNode head = convertArrayToBST(values);

		preOrderTraversal(head);
		//		System.out.println("head.value=" + head.value);
		//		System.out.println("head.left.value=" + head.left.value);
		//		System.out.println("head.right.value=" + head.right.value);
		//
		//		System.out.println("head.left.left.value=" + head.left.left.value);
		//		System.out.println("head.right.right.value=" + head.right.right.value);
		//
		//		System.out.println("head.left.left.value=" + head.left.left.left.value);
		//		System.out.println("head.right.right.value=" + head.right.right.right.value);

	}

}
