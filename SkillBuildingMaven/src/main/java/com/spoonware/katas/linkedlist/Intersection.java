package com.spoonware.katas.linkedlist;

public class Intersection {
	/*
	 * Given two singly linked lists, determine if the two lists intersect.
	 * Return the intersecting node. Note that the intersection is defined based on reference,
	 * not value. That is, if the kth node of the first linked list is the exact same node
	 * (by reference) as the jth node of the second linked list, then they are intersecting.
	 * 
	 * Assume that once the lists intersect, they do not diverge down range.
	 * For example, these lists intersect at 7 and then stay together. 
	 *  3 -> 1 -> 5 -> 9 -> 7 -> 2 -> 1 -> null
	 *                      ^ 
	 *            4 -> 6 -> |
	 *            
	 * Tricky part - creating two lists that intersect. Create the tail (part in common) first, then create list1 where the first child is the tail part,
	 * then create list2 the same way. In the end, list1 and list2 will have the same tailing list thus there will be an intersection.
	 *            
	 * Solution: Find the lengths of both lists, trim the front of the longer list
	 * until the lists are the same length. Then traverse the lists in parallel looking
	 * for list1.child == list2.child. The child is the intersection.
	 * 
	 * Shortcut, first check to see if the last node of each list is the same. If not, there
	 * is not intersection.
	 * 
	 * Solution: find the tail elements of each list and see if the are == . if not, lists do not intersect
	 * if yes, then
	 * 		find the length of each list in order to shorten the longer list by removing leading elements until 
	 * 			the lists are the same length
	 * 		Once the lists are the same length, traverse them in parallel looking for runner1.child == runner2.child.
	 * 		If the runner children are == then the child is the intersecting Node. 
	 * 
	 * Improvement: consider an inner class that holds a list length and a tail node like the following so that tails and sizes are only computed once per list:
	 * class Result{ 
		public Node tail;
		public int size;
		public Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}
	 */
	
	

	private static int computeListLength(final Node headNode) {
		Node runner = headNode;
		int counter = 0;
		while(runner != null) {
			counter++;
			runner = runner.child;
		}
		return counter;
	}

	private static boolean areTailsEqual(final Node listHead1, final Node listHead2) {
		boolean results = false;
		if(findTail(listHead1) == findTail(listHead2)) {
//			System.out.println("yes");
			results = true;
		}
		return results;

	}

	private static Node findTail(final Node headNode) {
		Node runner = headNode;
		Node parent = runner;
		while(runner != null) {
			if(runner != null) {
				parent = runner;
			}
			runner = runner.child;
		}
		return parent;
	}
	
	private static Node shortenList(Node headNode, int k) {
		System.out.println("running shortenList with k=" + k);
		Node runner = headNode;
		for(int i=0; i < k; i++) {
			runner = headNode.child;					
		}
		
		return runner;
	}

	static Node computeIntersection(final Node listHead1, final Node listHead2) {
		//check if tail elements are equal
		if(!areTailsEqual(listHead1, listHead2)) return null;

		//shorten the longer list
		int length1 = computeListLength(listHead1);
		int length2 = computeListLength(listHead2);
		int difference = length1 - length2;
//		System.out.println("difference=" + difference);
		Node runner1 = null;
		Node runner2 = null;
		if(difference > 0) {
			//list1 is longer - make list1 shorter by difference
//			System.out.println("difference is positive - shorten list1");
			runner1 = shortenList(listHead1, Math.abs(difference));
			runner2 = listHead2;
		}else if(difference < 0) {
			//list2 is longer - make list2 shorter by difference
//			System.out.println("difference is negative - shorten list2");
			runner1 = listHead1;
			runner2 = shortenList(listHead2, Math.abs(difference));
		}else {
			//both lists are the same length
//			System.out.println("lists are same length");
			runner1 = listHead1;
			runner2 = listHead2;
		}
		//at this point both lists should be the same length
		
		Node results = null;
		boolean intersectionFound = false;
		while((runner1 != null) && (!intersectionFound)) {
			if(runner1.child==runner2.child) {
				intersectionFound = true;
//				System.out.println("found with runner1.value=" + runner1.value);
				results = runner1.child;
			}
			runner1 = runner1.child;
			runner2 = runner2.child;
		}


		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values1 = {8,9,3,2}; 	//list1 part 1
		int[] values2 = {5,10,6,4};		//list2 part1 
		int[] values3 = {1,2,7};	//tail end of both lists

		Node current3 = new Node(values3[0], null);
		for(int i=1; i < values3.length; i++) {
			current3 = new Node(values3[i], current3);
		}
		Node head3 = current3;

		Node current1 = new Node(values1[0], head3);
		for(int i=1; i < values1.length; i++) {
			current1 = new Node(values1[i], current1);
		}
		Node head1 = current1;

		Node current2 = new Node(values2[0], head3);
		for(int i=1; i < values2.length; i++) {
			current2 = new Node(values2[i], current2);
		}
		Node head2 = current2;

//		System.out.println("length=" + computeListLength(head1));
//		System.out.println("length=" + computeListLength(head2));
//				System.out.println(LinkedListUtils.linkedListToString(head1));
//				System.out.println(LinkedListUtils.linkedListToString(head2));
		//		System.out.println(LinkedListUtils.linkedListToString(head3));

		Node results = computeIntersection(head1, head2);
		System.out.println("results.value=" + results.value);

	}

}
