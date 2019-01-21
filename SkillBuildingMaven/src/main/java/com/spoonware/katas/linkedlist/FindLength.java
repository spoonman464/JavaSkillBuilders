package com.spoonware.katas.linkedlist;

public class FindLength {
	/*
	 * Using a node-based linked list (not LinkedList class in Java), count the elements in the list.
	 * 
	 * Solution: loop through the list by setting the current pointer to the child reference of the 
	 * current pointer incrementing a counter each time. Return the counter's final value.
	 */
	
	//using com.spoonware.katas.linkedlist.Node as the node class

	static int findLength(Node head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.child;
		}
		return count;
	}


	public static void main(String[] args) {
		// NOTE: The following input values will be used for testing your solution.
		Node current = new Node(1, null);
		for (int i = 2; i < 8; i++) {
			current = new Node(i, current);
		}
		Node head = current;
		// head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
		System.out.println(LinkedListUtils.linkedListToString(head));

		int results = findLength(head);
		System.out.println("list count = " + results);

		Node current2 = new Node(4, null);
		for (int i = 3; i > 0; i--) {
			current2 = new Node(i, current2);
		}
		Node head2 = current2;
		// head2 = 1 -> 2 -> 3 -> 4 -> (null)
		System.out.println(LinkedListUtils.linkedListToString(head2)); 
		int results2 = findLength(head2);
		System.out.println("list count = " + results2);

	}

}
