package com.spoonware.katas.arrays;

import java.util.ArrayList;
import java.util.List;

public class OccurringInCommon {
	
	/*
	 * Given two sorted arrays of integers, find the elements in common
	 * in time O(max(n,m)) where n = array A length and m = array B length
	 */
	

	

	
	
	public static Integer[] commonElements2(int[] array1, int[] array2) {
        Integer[] resultInArray = new Integer[0];
        List<Integer> list = new ArrayList<>();
        int aCursor = 0;
        int bCursor = 0;
        while((aCursor < array1.length) && (bCursor < array2.length)) {
        	if(array1[aCursor] == array2[bCursor]) {
        		list.add(array1[aCursor]);
        		aCursor++; 
        		bCursor++;        		
        	}else if(array1[aCursor] > array2[bCursor]) {
        		bCursor++;
        	}else {
        		aCursor++;
        	}
        }
        return list.toArray(resultInArray);
	}
	

	public static void main(String[] args) {
		
		// NOTE: The following input values are used for testing your solution.
//        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).
        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};

//        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).
//        int[] array1B = {1, 2, 9, 10, 11, 12};
//        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};

//        // common_elements(array1C, array2C) should return [] (an empty array).//
//        int[] array1C = {0, 1, 2, 3, 4, 5};
//        int[] array2C = {6, 7, 8, 9, 10, 11};

		
		int[] inputsB = {1,2,5,6,7,8,9,51}; //{1,2,5,6,7,8,9,10}
		int[] inputsA = {1,2,3,4,5,6,7,8,9,10,12,50};
		OccurringInCommon mfo = new OccurringInCommon();
		Integer[] results = OccurringInCommon.commonElements2(array1A, array2A);
		String message = "Elements in common are: ";
		boolean isFirst = true;
		for(Integer i : results) {
			message += ( isFirst ? "" : ", ") + i;
			isFirst = false;
		}
		System.out.println(message);

	}



}
