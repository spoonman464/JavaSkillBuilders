package com.spoonware.katas.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {
	
	/*
	 * 2.1 Write code to remove duplicates from an unsorted singly linked list using Node objects 
	 */
	
	static Node removeNode(final Node parentNode) {
		//parentNode's child is to be removed
		Node temp = parentNode;
//		System.out.println("running removeNode with parentNode.value=" + parentNode.value);
		Node deletionNode = temp.child;
//		System.out.println("running removeNode with deletionNode.value=" + deletionNode.value);
		Node nextNode = deletionNode.child;
		temp.child = nextNode;
//		deletionNode.child = null;
		return temp;
	}
	
	static void dedupeList(final Node head) {
		HashSet<Integer> hs = new HashSet<>();
		Node runner = head;
		Node parent = runner;
		while(runner != null) {
//			System.out.print(runner.value + " - ");
			boolean success = hs.add(Integer.valueOf(runner.value));
//			System.out.println("success=" + success);
			//if !success, invoke method to remove current runner
			if(success) {
				parent = runner;
				runner = runner.child;
			}else {
				
				//the same value could not be added to the Set so it should be removed from the list
				parent = removeNode(parent);
				runner = parent.child;
			}
			
			
		}
//		return head;
	}

	public static void main(String[] args) {
		//test data - builds a linked list from an array of int values
		int[] values1 = {2,5,4,6,8,5,8,4,9,10};
		
		Node current1 = new Node(values1[0], null);
		for(int i=1; i < values1.length; i++) {
			current1 = new Node(values1[i], current1);
		}
		Node head1 = current1;
		
		dedupeList(head1);
		
		System.out.println(LinkedListUtils.linkedListToString(head1));
		
		
		int[] values2 = {2,5,5,5,5,5,5,5,5,10};
		Node current2 = new Node(values2[0], null);
		for(int i=1; i < values2.length; i++) {
			current2 = new Node(values2[i], current2);
		}
		Node head2 = current2;
//		
		dedupeList(head2);
		
		System.out.println(LinkedListUtils.linkedListToString(head2));
		
	}

}
