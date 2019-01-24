package com.spoonware.katas.linkedlist;

public class Palindrome {
	/*
	 * Implement a function to determine if a singly linked list is a palindrome.
	 * Solution: make a new linked list that is the reverse of the first list then
	 * traverse the lists comparing each value. If any value does not match, 
	 * return false.
	 * A more efficient solution would use the runner / halfSpeedRunner to find the middle of the list.
	 * Then put the first half on a stack and then pop the stack until empty comparing
	 * the rest of the list.
	 */

	static boolean isPalindrome(final Node headNode) {
		boolean results = true;
		Node reverseHeadNode = new Node(headNode.value, null);
		Node reverseRunner = reverseHeadNode;
		Node runner = headNode.child;
		while(runner != null) {
			reverseRunner = new Node(runner.value, reverseRunner);
			runner = runner.child;
		}

		//traverse both lists looking for exact matches in each value
		runner = headNode;
		reverseHeadNode = reverseRunner;


		while(runner != null) {
			if(runner.value != reverseRunner.value) results = false;
			
//			if(runner.value == reverseRunner.value) {
//			}else {
//				results = false;
//			}
			runner = runner.child;

			reverseRunner = reverseRunner.child;

		}



		return results;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values1 = {1,2,3,4,5,4,3,2,1};

		Node current1 = new Node(values1[0], null);
		for(int i=1; i < values1.length; i++) {
			current1 = new Node(values1[i], current1);
		}
		Node head1 = current1;
		System.out.println("results=" + isPalindrome(head1));
		
		int[] values2 = {10,2,3,4,5,4,3,2,1};

		Node current2 = new Node(values2[0], null);
		for(int i=1; i < values2.length; i++) {
			current2 = new Node(values2[i], current2);
		}
		Node head2 = current2;
		System.out.println("results=" + isPalindrome(head2));
		
		int[] values3 = {3,3,3,3};

		Node current3 = new Node(values3[0], null);
		for(int i=1; i < values3.length; i++) {
			current3 = new Node(values3[i], current3);
		}
		Node head3 = current3;
		System.out.println("results=" + isPalindrome(head3));

	}

}
