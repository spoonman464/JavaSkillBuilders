package com.spoonware.katas.arrays;

public class Rotation {
	
	

	static boolean isRotation(int[] array1, int[] array2) {
		if(array1.length != array2.length) return false;
		boolean results = true;
		int targetPosition = -1;
		for(int i=0; i < array2.length; i++) {
			int target = array1[0];			
			if(array2[i]==target) {
				targetPosition = i;
				i = array2.length;
			}
		}
		if(targetPosition==-1) return false;
		int difference = array2.length - targetPosition;
		
		for(int i = targetPosition; i < array2.length; i++ ) {
			if(array1[i-targetPosition] != array2[i]) {
				return false;
			}
		}
		
		for(int i = difference; i < array1.length; i++ ) {
			if(array2[i-difference] != array1[i]) {
				return false;
			}
		}
		
		
		
		return results;
	}
	
	public static void main(String[] args) {
		  // NOTE: The following input values will be used for testing your solution.
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        // isRotation(array1, array2a) should return false.
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        // isRotation(array1, array2b) should return true.
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        // isRotation(array1, array2c) should return false.
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        // isRotation(array1, array2d) should return false.
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        // isRotation(array1, array2e) should return false.
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        // isRotation(array1, array2f) should return true.
//		int[] array1 = {1,2,3,4,5,6,7,8,9,10};
		int[] array2 = {4,5,6,7,8,9,10,1,2,3};
		
		int[] array3 = {1,2,3,4,5,6,7,8,9,10};
		boolean results = isRotation(array1, array2f);
		System.out.println("results=" + results);
	}
	
}
