package com.spoonware.katas.linkedlist;

import java.util.HashSet;

public class LoopDetection {
	/*
	 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop
	 * 
	 * Solution: traverse the loop putting each node into a HashSet<Node>. Before putting each Node in the HashSet, query .contains() method to see
	 * if the element is already in the HashSet.  If it is, then you know you have a loop and you know which Node is the start of the loop.
	 * 
	 * Alternate solution: not using a HashSet or any other storage. 
	 * Use the two-runner with toggle approach to traverse the list. At each movement of the fast runner, check to see if it is == with the 
	 * slow runner. If they are ever equal, there is a loop because the fast runner will catch up to the slow runner.
	 * 
	 */

	static boolean isLoopAlternate(final Node headNode) {
		boolean results = false;
		Node runner = headNode;
		Node slowRunner = headNode;
		boolean toggle = false;
		while((runner != null) && (!results)) {
			if(toggle) {
				slowRunner = slowRunner.child;
				toggle = false;
			}else {
				toggle = true;
			}
			runner = runner.child;
			if(runner == slowRunner) results = true;
		}
		return results;


	}

	static boolean isLoop(final Node headNode) {
		HashSet<Node> hs = new HashSet<>();
		Node runner = headNode;
		boolean results = false;
		while((runner != null) && (!results)) {
			//			System.out.println("runner.value=" + runner.value);
			if(hs.contains(runner)) {
				results = true;
			}else{
				hs.add(runner);
			}
			runner = runner.child;
		}
		return results;
	}

	private static Node makeListLoopMiddle(final Node headNode) {
		Node runner = headNode;
		Node slowRunner = headNode;
		boolean toggle = false;
		boolean loopComplete = false;
		while((runner != null) && (!loopComplete)) {
			if(toggle) {
				slowRunner = slowRunner.child;
				toggle = false;
			}else {
				toggle = true;
			}
			if(runner.child == null) {
				runner.child = slowRunner;
				loopComplete = true;

			}else {
				runner = runner.child;
			}
		}
		return headNode;
	}

	private static Node makeListLoopHead(final Node headNode) {

		return headNode;
	}

	private static Node makeListLoopTail(final Node headNode) {

		return headNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values1 = {5,4,3,2,1};
		Node current1 = new Node(values1[0], null);
		for(int i=1; i < values1.length; i++) {
			current1 = new Node(values1[i], current1);
		}
		Node head1 = current1;		
		System.out.println("isLoopAlternate with head1=" + isLoopAlternate(head1));
		//		System.out.println(LinkedListUtils.linkedListToString(head1));
		Node loopedHead = makeListLoopMiddle(head1);
		System.out.println("isLoopAlternate with head1=" + isLoopAlternate(head1));
		System.out.println("isLoopAlternate with loopedHead=" + isLoopAlternate(loopedHead));
	}
}
