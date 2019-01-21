package com.spoonware.katas.arrays.multid;

public class MineSweeper {



	public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
		int[][] field = new int[numRows][numCols];

		for(int[] bomb : bombs) {
			for(int value : bomb) {
				System.out.println("value=" + value);
			}
			int fieldX = bomb[0];
			int fieldY = bomb[1];
			field[fieldX][fieldY] = -1;
			for(int i = fieldX - 1; i <= fieldX + 1; i++) {
				for(int j = fieldY - 1; j <= fieldY + 1; j++) {
					if(i >= 0 && i < numRows && j >= 0 && j < numCols && field[i][j] != -1) {
						field[i][j] += 1;	
					}

				}
			}
		}

		ArrayUtils.printTwoDArray(field);
		return field;
	}


	public static void main(String[] args) {
		// NOTE: The following input values will be used for testing your solution.
		int[][] bombs1 = {{0, 2}, {2, 0}};
		// mineSweeper(bombs1, 3, 3) should return:
		// [[0, 1, -1],
		//  [1, 2, 1],
		//  [-1, 1, 0]]

		int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
		// mineSweeper(bombs2, 3, 4) should return:
		// [[-1, -1, 2, 1],
		//  [2, 3, -1, 1],
		//  [0, 1, 1, 1]]

		int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
		// mineSweeper(bombs3, 5, 5) should return:
		// [[1, 2, 2, 1, 0],
		//  [1, -1, -1, 2, 0],
		//  [1, 3, -1, 2, 0],
		//  [0, 1, 2, 2, 1],
		//  [0, 0, 1, -1, 1]]
		int[][] bombs4 = {{0, 0}, {0, 1}};
		// mineSweeper(bombs4, 3, 4) should return:
		// [[-1,-1, 1, 0],
		//  [ 2, 2, 1, 0],
		//  [ 0, 0, 0, 0]]

		int[][] results = mineSweeper(bombs2, 3, 4);

	}



}
