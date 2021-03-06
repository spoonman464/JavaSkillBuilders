package com.spoonware.katas.linkedlist;

class StringNode {
	String value;
    StringNode child;

    StringNode(String value, StringNode child) {
        this.value = value;
        this.child = child;
    }

    // The string representation of this node.
    // Will be used for testing.
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
