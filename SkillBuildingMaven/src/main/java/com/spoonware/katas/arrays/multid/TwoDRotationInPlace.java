package com.spoonware.katas.arrays.multid;

public class TwoDRotationInPlace {

	public static int[][] rotate(int[][] a, int n) {
		boolean done = false;
		int x = 0;
		int y = 0;
		int tempValue = 0;
		int newValue = a[x][y];
		int newX = 0;
		int newY = 0;
		int counter = 0;
		for(int i=0; i < n; i++) {
			y = i;
			while(!done) {
				int[] tempArray = computeNextCoordinates(x, y, n);
				newX = tempArray[0];
				newY = tempArray[1];
				tempValue = a[newX][newY];
				a[newX][newY] = newValue;
				x = newX;
				y = newY;
				newValue = tempValue;
				System.out.println("x=" + x + " and y=" + y);
				counter++;
				if(counter > 3) done = true;
				//	    	   if((x==0) && (y==0)) {
				//	    		   done = true;
				//	    	   }
			}
		}

		return a;
	}

	private static int[] computeNextCoordinates(int x, int y, int n) {
		int[] results = new int[2];
		int newX = y;
		int newY = n - 1 - x;
		results[0]=newX;
		results[1]=newY;
		return results;
	}

	public static void main(String[] args) {
		// NOTE: The following input values will be used for testing your solution.
		int a1[][] = {{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};
		// rotate(a1, 3) should return:
		// [[7, 4, 1],
		//  [8, 5, 2],
		//  [9, 6, 3]]

		int a2[][] = {{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}};
		// rotate(a2, 4) should return:
		// [[13, 9, 5, 1],
		//  [14, 10, 6, 2],
		//  [15, 11, 7, 3],
		//  [16, 12, 8, 4]]

		//	        rotate(a1, 3);
		ArrayUtils.printTwoDArray(rotate(a1, 3));

	}

}
