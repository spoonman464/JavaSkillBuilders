package com.spoonware.katas.arrays.multid;

public class ArrayUtils {
	static void printTwoDArray(int[][] inputs, int rows, int cols) {
		String message = "[";
		for(int i=0; i < rows; i++) {
			message += "[";
			for(int j=0; j < cols; j++) {
				message += inputs[i][j];
				message += (j==cols-1) ? "" : ", " ;
			}
			message += "]" + ((i==rows-1) ? "" : ",");
			message += (i==rows-1) ? "" : "\n" ;
		}
		message += "]";
		System.out.println(message);
	}
	
	static void printTwoDArray(int[][] inputs) {
		int rows = inputs.length;
		int cols = (inputs.length > 0) ? inputs[0].length : 0;

		
		String message = "[";
		for(int i=0; i < rows; i++) {
			message += "[";
			for(int j=0; j < cols; j++) {
				message += inputs[i][j];
				message += (j==cols-1) ? "" : ", " ;
			}
			message += "]" + ((i==rows-1) ? "" : ",");
			message += (i==rows-1) ? "" : "\n" ;
		}
		message += "]";
		System.out.println(message);
	}
}
