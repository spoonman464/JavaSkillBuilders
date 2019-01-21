package com.spoonware.katas.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentlyOccurring {

	public static Integer mostFreqent(int[] givenArray) {
		Integer maxItem = null;
		if(givenArray.length != 0) {
			Map<Integer,Integer> occurrances = new HashMap<>();
			int frontRunner = 0;
			int highestKnownCount = 0;
			for(Integer value : givenArray) {
				if(occurrances.get(value) == null) {
					occurrances.put(value, 1);
				}else {
					int currentCount = occurrances.get(value) + 1;
					occurrances.put(value, currentCount);
					if(currentCount > highestKnownCount) {
						highestKnownCount = currentCount;
						frontRunner = value;
					}
				}
			}
			maxItem = frontRunner;
		}
		return maxItem;
	}




	public static void main(String[] args) {
		MostFrequentlyOccurring oic = new MostFrequentlyOccurring();

		// NOTE: The following input values are used for testing your solution.

		// mostFrequent(array1) should return 1.
		int[] array1 = {1, 3, 1, 3, 2, 1};
		// mostFrequent(array2) should return 3.
		int[] array2 = {3, 3, 1, 3, 2, 1};
		// mostFrequent(array3) should return null.
		int[] array3 = {};
		// mostFrequent(array4) should return 0.
		int[] array4 = {0};
		// mostFrequent(array5) should return -1.
		int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};
		// mostFrequent(array6) should return 4.
		int[] array6 = {1,3,1,3,2,1,4,6,7,4,3,4,6,8,7,9,8,7,6,7,8,9,8,4,2,3,1,4,5,6,2,4,4,6,7,8};
		List<int[]> inputArrays = new ArrayList<>();
		inputArrays.add(array1);
		inputArrays.add(array2);
		inputArrays.add(array3);
		inputArrays.add(array4);
		inputArrays.add(array5);
		inputArrays.add(array6);
		for(int[] inputs : inputArrays) {
			Integer results = MostFrequentlyOccurring.mostFreqent(inputs);
			System.out.println("results=" + results);	
		}
		
	}

}
