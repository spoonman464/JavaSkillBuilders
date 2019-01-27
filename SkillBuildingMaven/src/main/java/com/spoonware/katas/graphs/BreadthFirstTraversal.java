package com.spoonware.katas.graphs;

import java.util.ArrayList;

public class BreadthFirstTraversal {
	/*
	 * Traverse through a graph using a breadth-first approach.
	 * Breadth-first starts at the root node of the graph.
	 * Then it examines each child of the root.
	 * Then it examines the first child's children, then the next child's 
	 * children until it runs out of first level children, etc.
	 * 
	 * Consider both iterative and recursive solutions here.
	 */

	static void traverseIteratively(GraphNode rootNode) {
		for(GraphNode child : rootNode.children) {
			for(GraphNode grandChild : child.children) {
			}
		}

	}
	
	static boolean isPath(GraphNode rootNode, int value) {
		// Is there a path from rootNode.value to value in the graph
		boolean results = false;
		
		for(GraphNode child : rootNode.children) {
			System.out.println("child.value=" + child.value);
			if(child.value==value) return true;
			for(GraphNode grandChild : child.children) {
				System.out.println("grandChild.value=" + grandChild.value);
				if(grandChild.value==value) return true;
			}
		}
		return results;
	}

	static void traverseRecursively(GraphNode rootNode) {


	}

	static GraphNode createGraph(int[][] row1, int[][] row2, int[][] row3) {
		GraphNode root = new GraphNode(0, new ArrayList<GraphNode>());
		for(int i=0; i < row1.length; i++) {
			for(int j=0; j < row1[0].length; j++) {
				GraphNode child = new GraphNode(row1[i][j], new ArrayList<GraphNode>());
				root.children.add(child);			
			}
		}

		for(int k = 0; k < root.children.size(); k++) {
			//row2[k] is one set of children for root's children
			for(int j = 0; j < row2[k].length; j++) {
				
				GraphNode child = new GraphNode(row2[k][j], new ArrayList<GraphNode>());
//				System.out.println("Adding child value=" + child.value + " to rootChild ");
				GraphNode temp = root.children.get(k);
				temp.children.add(child);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		//create a graph for testing
		int[][] row1 = {{1,2,3}};
		int[][] row2 = {{11,12,13},
				{21,22,23},
				{31,32,33}};
		int[][] row3 = {{1111,1112,1113},
				{1214,1215,1216},
				{1317,1318,1319},
				{2411,2412,2413},
				{2524,2525,2526},
				{2637,2638,2639},
				{3711,3712,3713},
				{3824,3825,3826},
				{3937,3938,3939}};

		GraphNode base = createGraph(row1, row2, row3);
		System.out.println("base.value=" + base.value);
//		traverseIteratively(base);
		System.out.println("isPath()=" + isPath(base, 31));

	}

}
