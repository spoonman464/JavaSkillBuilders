package com.spoonware.katas.linkedlist;

import java.util.HashMap;

public class CreateBinaryTreeFromLinkedListOfArrays {
	
	/*
	 * Create a binary tree using a int[n][2] array where the inner arrays are all 2-element arrays
	 */
	
	static TreeNode createTree(HashMap<Integer, int[][]> mapping, int headValue) {
		for(Integer key : mapping.keySet()) {
			int[][] values = mapping.get(key);
			System.out.println("key=" + key);
			for(int[] value : values) {
				System.out.println(value[0] + " - " + value[1]);
			}
			
		}
		return null;
	}
	
	static ArrayNode createLinkedListOfArrays(int[][] pairs, int headValue) {
		//build a linked list of TreeNode objects. Traverse the pairs array in reverse
		// so that that top of the tree is at the head of the list
		ArrayNode current = new ArrayNode(new int[0], null);
		for(int i=pairs.length-1; i >= 0 ; i--) {
			current = new ArrayNode(pairs[i], current);
//			System.out.println(pairs[i][0] + " - " + pairs[i][1]);
		}
		int[] temp = {0};
		ArrayNode headNode = new ArrayNode(temp, current);
		return headNode;
	}
	
	static ArrayNode createTreeFromLinkedListOfArrays(ArrayNode arrayHead) {
		//traverse the list
		// first item is the head and the remaining items become the family
		// each child gets one and only one child.
		// each child is 2-element array functioning as a pair
		ArrayNode pointer = arrayHead;
		// create a TreeNode for each integer in each array. the children come from the subsequent list elements
		TreeNode treeHead = new TreeNode(arrayHead.value[0], null, null);
		pointer = arrayHead.child;
		boolean done = false;
		while(pointer != null) {
			TreeNode left = new TreeNode(pointer.value[0], null, null);
			TreeNode right = new TreeNode(pointer.value[1], null, null);
			treeHead.left = left;
			treeHead.right = right;
			System.out.println("pointer is still true");
			pointer = pointer.child;
			done = true;
		}
		return null;
	}
	
	public static void main(String[] args) {
		//turn the following array of tuples into a binary tree
		// the first pair should be under the head
		// the next pair is the left pair and the final pair is the right pair
		int[][] pairs1 = {{1, 2},{14, 15},{27, 29}};
		
		int[][] pairs2 = {{1, 2},{14, 15},{27, 29},{147, 149},{157, 159},{277, 279},{297, 299}};
		int headValue2 = 0;
		
		HashMap<Integer, int[][]> mapping1 = new HashMap<Integer, int[][]>();
		int[][] childrenA = {{1, 2}};
		int[][] childrenB = {{14, 15},{27, 29}};
		mapping1.put(0, childrenA);
		mapping1.put(1, childrenB);
	
		HashMap<Integer, int[][]> mapping2 = new HashMap<Integer, int[][]>();
		int[][] childrenA1 = {{1, 2}};
		int[][] childrenB1 = {{14, 15},{27, 29}};
		int[][] childrenC1 = {{147, 149},{157, 159},{277, 279},{297, 299}};
		
		mapping2.put(0, childrenA1);
		mapping2.put(1, childrenB1);
		mapping2.put(2, childrenC1);
	
		// test code
		
//		TreeNode head1 = createTree(mapping2, 0);
		
		ArrayNode headNode = createLinkedListOfArrays(pairs2, headValue2);
//		System.out.println(headNode.value[0] + " - " + headNode.value[1]);
//		for(int i=0; i < headNode.child.value.length; i++)
//			System.out.println("value=" + headNode.child.value[i]);
		
		createTreeFromLinkedListOfArrays(headNode);
	}

}
