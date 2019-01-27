package com.spoonware.katas.graphs;

import java.util.ArrayList;

/*
 * Like a regular Node except it has an array of children instead of just one child
 */
public class GraphNode {
	public int value;
//    public GraphNode[] children;
    public ArrayList<GraphNode> children;

    public GraphNode(int value, ArrayList<GraphNode> children) {
        this.value = value;
        this.children = children;
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
