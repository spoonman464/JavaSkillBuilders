package com.spoonware.katas.linkedlist;

public class FindNthElementFromEnd {
	/*
	 * Given a node-based linked list, find the element n items from the tail of the list
	 * 
	 * Solution: Use two pointers: One to traverse the entire list. The second to wait at the head of the
	 * list until the first pointer has traversed n elements of the list then traverse the list as normal.
	 * Once the first pointer is null, the second pointer will be pointing to the nth item from the tail
	 */
	
	static Node findNthNode(Node head, int offset) {
		Node current = head;
		Node target = head;
		for(int i = 0; i < offset; i++) {
			if(current == null) {
				return null;
			}else {
				current = current.child;
			}
		}
		
		while(current != null) {
			current = current.child;
			target = target.child;
		}
		return target;
	}
	
	public static void main(String[] args) {
		//test data - builds a linked list from an array of int values
		int[] values1 = {1,2,3,5,7,11,13,17,19,23};
//		int value1 = 1;
		Node current1 = new Node(values1[0], null);
		for(int i=1; i < values1.length; i++) {
			current1 = new Node(values1[i], current1);
		}
		Node head1 = current1;
		
		Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current;
        
        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;

		


		//test code

		Node results = null; 
//		results = findNthNode(head1,4);
//		System.out.println((results==null) ? "null" : results.value );
		results = findNthNode(null,1);
		System.out.println((results==null) ? "null" : results.value);

		// nthFromLast(head, 1) should return 1.
        // nthFromLast(head, 5) should return 5.
        // nthFromLast(head2, 2) should return 3.
        // nthFromLast(head2, 4) should return 1.
        // nthFromLast(head2, 5) should return null.
        // nthFromLast(null, 1) should return null.

	}

}
