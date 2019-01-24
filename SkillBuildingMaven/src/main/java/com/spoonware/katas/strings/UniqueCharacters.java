package com.spoonware.katas.strings;

public class UniqueCharacters {
	
	/*
	 * 1.1 Implement an algorithm to determine if a string has all uniequ characters. 
	 * What if you cannot use additional data structures?
	 * Solution: make an array of booleans 128 items long. Get the charAt() value of each character
	 * and check to see if the array element is already true. If do, return false as a duplicate 
	 * character has been found. Otherwise, set the corresponding array element value to true.
	 * Alternate solution: sort the array then traverse it looking for the same letter twice in a row.
	 */

	
	public static void main(String[] args) {
		if(isUniqueCharacters("snoopy")) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}

	private static boolean isUniqueCharacters(String str) {
		if(str.length() > 128) return false;
		boolean[] char_set = new boolean[128];
		for(int i=0; i<str.length(); i++) {
			int value = str.charAt(i);
			System.out.println("value=" + value);
			if(char_set[value]) {
				return false;
			}
			char_set[value] = true;
		}
		return true;
	}
}
