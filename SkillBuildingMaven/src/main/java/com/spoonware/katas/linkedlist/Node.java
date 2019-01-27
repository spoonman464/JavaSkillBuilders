package com.spoonware.katas.linkedlist;

public class Node {
	int value;
	Node child;

	Node(int value, Node child) {
		this.value = value;
		this.child = child;
	}
	//    Node(Node n){
	//    	this.value = n.value;
	//    	this.child = n.child;
	//    }

	// The string representation of this node.
	// Will be used for testing.
	@Override
	public
	String toString() {
		return String.valueOf(value);
	}
}
