package com.spoonware.katas.arrays.multid;

public class ZeroMatrix {
	/*
	 * Write an algorithm such that if an element in an MxN matrix
	 * is zero, its entire row and column are set to zero.
	 * Assume all values are positive integers.
	 * Solution: traverse the entire array looking for values that are zero. If found, set all values in the current row to -1 except leave the zero as a zero.
	 * Then set all values in the current column to -1 except leave the zero a zero.
	 * Once all zeros have been found, there should be rows and columns of -1.
	 * Finally, traverse the entire array changing all -1 values to zero. 
	 * 
	 * If negative numbers are allowed, then a different solution is needed. 
	 * 
	 * 
	 */

	private static void tagRow(final int[][] matrix, int rowId) {
		int maxColumns = matrix[0].length;
		for(int j=0; j < maxColumns; j++) {
			matrix[rowId][j] = (matrix[rowId][j]==0) ? 0 : -1;
		}
	}

	private static void tagColumn(final int[][] matrix, int colId) {
		int maxRows = matrix.length;
		for(int i=0; i < maxRows; i++) {
			matrix[i][colId] = (matrix[i][colId]==0) ? 0 : -1 ;
		}
	}

	private static void convertMatrix(final int[][] matrix) {
		//turn all -1 to zero
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				if(matrix[i][j]==-1) matrix[i][j] = 0; 
			}
		}
	}

	static int[][] zeroOutMatrix(final int[][] matrix){
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				if(matrix[i][j]==0) {
					tagRow(matrix, i);
					tagColumn(matrix, j);
				}
			}
		}
		convertMatrix(matrix);
		return matrix.clone();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a10 = {{0,1,1},{2,2,2},{3,3,3},{4,4,4},{5,5,5}};
		int[][] a11 = {{1,0,1},{2,2,2},{3,3,3},{4,4,4},{5,5,5}};
		int[][] a12 = {{1,1,0},{2,2,2},{3,3,3},{4,4,4},{5,5,5}};
		int[][] a13 = {{0,1,1},{2,0,2},{3,3,3},{4,4,4},{5,5,5}};
		int[][] a21 = {{1,1,1,0},{2,2,2,2},{3,3,3,3},{4,4,4,4},{5,5,5,5},{6,6,6,6}};
		int[][] a22 = {{1,1,1,1},{2,2,0,2},{3,3,3,3},{4,4,4,4},{5,5,5,5},{6,6,6,6}};
		int[][] a23 = {{1,1,1,1},{2,2,2,2},{3,0,3,3},{4,4,4,4},{5,5,5,5},{6,6,6,6}};
		int[][] a24 = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4},{5,5,5,5},{6,0,6,0}};
		int[][] a3 = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5},{6,6,6,6,6},{7,7,7,7,7},{8,8,8,8,8}};


		ArrayUtils.printTwoDArray(zeroOutMatrix(a10));
		System.out.println("");
		ArrayUtils.printTwoDArray(zeroOutMatrix(a11));
		System.out.println("");
		ArrayUtils.printTwoDArray(zeroOutMatrix(a12));
		System.out.println("");
		ArrayUtils.printTwoDArray(zeroOutMatrix(a13));
		System.out.println("");
		ArrayUtils.printTwoDArray(zeroOutMatrix(a21));
		System.out.println("");
		ArrayUtils.printTwoDArray(zeroOutMatrix(a22));
		System.out.println("");
		ArrayUtils.printTwoDArray(zeroOutMatrix(a23));
		System.out.println("");
		ArrayUtils.printTwoDArray(zeroOutMatrix(a24));
		System.out.println("");

	}

}
