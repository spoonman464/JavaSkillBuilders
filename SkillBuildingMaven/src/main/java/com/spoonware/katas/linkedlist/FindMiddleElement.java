package com.spoonware.katas.linkedlist;


public class FindMiddleElement {

	/*
	 * find the middle element of a linked list
	 * If the list has an even number of items, then the first of the two 
	 * middle items is the middle.
	 * The list will be a list of String values using animal names bat, cat, dog, emu, frog, goat, hampster, iguana, jackal
	 */

	/*
	 * Solution: use two pointers. One traverses the list until it gets a null value. The second one only moves every other time the first one moves.
	 * By the time the first pointer arrives at the end of the list, the second pointer should only be half-way through the list.
	 */

	static StringNode findMiddleNode(final StringNode head) {
		StringNode first = head;
		StringNode middle = head;
		boolean toggle = false;
		while(first != null) {
			first = first.child;
			if(first != null) {
				if(toggle==true) {
					middle = middle.child;
					toggle = false;
				}else {
					toggle = true;
				}	
			}
		}
		return middle;
	}

	public static void main(String[] args) {
		//test data - builds a linked list from an array of String values
		String[] animals1 = {"bat", "cat", "dog", "emu", "frog", "goat", "hampster", "iguana", "jackal"};
		String value1 = "";
		StringNode current1 = new StringNode(value1, null);
		for(String animal : animals1) {
			current1 = new StringNode(animal, current1);
		}
		StringNode head1 = current1;

		//test data - builds a linked list from an array of String values
		String[] animals2 = {"bat", "cat", "dog", "emu", "frog", "goat"};
		String value2 = "";
		StringNode current2 = new StringNode(value2, null);
		for(String animal : animals2) {
			current2= new StringNode(animal, current2);
		}
		StringNode head2 = current2;

		//test data - builds a linked list from an array of String values
		String[] animals3 = {"pig"};
		String value3 = "";
		StringNode current3 = new StringNode(value3, null);
		for(String animal : animals3) {
			current3 = new StringNode(animal, current3);
		}
		StringNode head3 = current3;


		//test code

		StringNode results = null; 
		results = findMiddleNode(head1);
		System.out.println(results.value);
		results = findMiddleNode(head2);
		System.out.println(results.value);
		results = findMiddleNode(head3);
		System.out.println(results.value);


	}
}
