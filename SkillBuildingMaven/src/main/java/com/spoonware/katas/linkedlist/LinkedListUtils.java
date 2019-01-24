package com.spoonware.katas.linkedlist;

class LinkedListUtils {
	static String linkedListToString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(String.valueOf(current.value));
            sb.append(" -> ");
            current = current.child;
        }
        sb.append("(null)");
        return sb.toString();
    }

	/**
	 * Use this method when printing a linked list that is known to have a loop in it
	 * @param head
	 * @param bounds - limits the number of times the infinite loop can loop thus making it finite within this bounds
	 * @return - a String containing the String presentation of the list.
	 */
	static String linkedListToStringBounded(Node head, int bounds) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        while ((current != null) && (counter < bounds)) {
            sb.append(String.valueOf(current.value));
            sb.append(" -> ");
            current = current.child;
            counter++;
        }
        sb.append("(null)");
        return sb.toString();
    }
	
	static String linkedListToString(StringNode head) {
		StringNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(String.valueOf(current.value));
            sb.append(" -> ");
            current = current.child;
        }
        sb.append("(null)");
        return sb.toString();
    }
}
