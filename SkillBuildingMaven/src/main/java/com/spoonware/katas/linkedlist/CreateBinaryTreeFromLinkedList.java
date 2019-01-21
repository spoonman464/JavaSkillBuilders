package com.spoonware.katas.linkedlist;

import java.util.PriorityQueue;
import java.util.Queue;

import javax.crypto.spec.RC2ParameterSpec;

public class CreateBinaryTreeFromLinkedList {

	/*
	 * Problem: starting with a node-based linked list, create a binary tree 
	 * where the top of the tree is the head of the list and children are applied to each level,
	 * left to right evenly until the original list is exhausted
	 */
	
	static Node createList(int limit) {
		Node current = new Node(0, null);
		for(int i=limit; i > 0; i--) {
			current = new Node(i * limit, current);
		}
		Node head = current;
		return head;
	}
	
	static TreeNode addChildrenOld(final Node headNode) {
		if(headNode == null) return null;
		PriorityQueue<Node> q = new PriorityQueue<>();
		System.out.println("running addChildren with headNode.value=" + headNode.value);
		TreeNode treeNode = new TreeNode(headNode.value, null, null);
		Node pointer = headNode.child;
		treeNode.left = new TreeNode(pointer.value, null, null);
		q.add(pointer);		
		pointer = pointer.child;
		treeNode.right = new TreeNode(pointer.value, null, null);
		q.add(pointer);
		return treeNode;
	}
	
	static TreeNode addChildren2(final Node headNode) {
		if(headNode == null) return null;
		Node cursor = headNode;
		PriorityQueue<Node> q = new PriorityQueue<>();
		System.out.println("running addChildren with headNode.value=" + headNode.value);
		TreeNode treeNode = new TreeNode(headNode.value, null, null);
		q.add(headNode);
		Node current = q.poll();
		while(cursor != null) {
			
			cursor = cursor.child;
			
				Node pointer = current;
				treeNode.left = new TreeNode(pointer.value, null, null);
//				q.add(pointer);		
				pointer = pointer.child;
				treeNode.right = new TreeNode(pointer.value, null, null);
//				q.add(pointer);
				current = q.poll();
		}
		
		
		return treeNode;
	}
	
	static TreeNode addChildren(final Node headNode) {
		if(headNode == null) return null;
		Node cursor = headNode;
		PriorityQueue<TreeNode> q = new PriorityQueue<>();
		TreeNode treeNode = new TreeNode(headNode.value, null, null);
		q.add(treeNode);
		cursor = headNode.child;
		while(cursor != null) {
			TreeNode leftChild = null;
			TreeNode rightChild = null;
			TreeNode parent = q.poll();
			if(parent != null) {
				leftChild = new TreeNode(cursor.value, null, null);
				q.add(leftChild);
				parent.left = leftChild;
				cursor = cursor.child;
//				if(cursor != null) {
//					rightChild = new TreeNode(cursor.value, null, null);
//					q.add(rightChild);
//					parent.right = rightChild;
//				}
			}
			cursor = cursor.child;
		}
		
		return treeNode;
	}
	
	
	
	public static void main(String[] args) {
		
		Node head = createList(10);
		TreeNode x = addChildren(head);
//		System.out.println(x.value + " - " + x.left.value + " - " + x.right.value);
		
//		System.out.println("head.value=" + head.value);
		
		
		
		
	}
}
