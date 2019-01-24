package com.spoonware.katas.arrays.multid;

public class TwoDRotation {

	/*
	 * Take a square array and rotate it 90 degrees
	 * Try it once with making a new array.
	 * Try it again with replacing the one array in place.
	 */
	
    public static int[][] rotate(int[][] a) {
    	
        int[][] rotated = new int[a.length][a.length];
        for(int i=0; i < rotated.length; i++) {
        	for(int j=0; j < rotated.length; j++) {
        		rotated[i][a.length - 1 - j] = a[j][i];
        	}
        }
        return rotated;
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
        
//        rotate(a1, 3);
        int a3[][] = {{1, 2, 3, 4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9, 10, 11, 12},
                {9, 10, 11, 12, 13, 14, 15, 16},
                {13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28},
                {25, 26, 27, 28, 29, 210, 211, 212},
                {29, 210, 211, 212, 213, 214, 215, 216},
                {213, 214, 215, 216, 217, 218, 219, 220}};
        
        ArrayUtils.printTwoDArray(rotate(a2));
        
    }
    
    
}
