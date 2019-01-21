package com.spoonware.katas.linkedlist;

public class ArrayNode {
	int[] value;
	ArrayNode child;
	
	ArrayNode(int[] value, ArrayNode child){
		//value cannot have a length greater than 2
		this.value = value;
		this.child = child;
	}
	
	@Override
    public String toString() {
        return String.valueOf(value);
    }
}
