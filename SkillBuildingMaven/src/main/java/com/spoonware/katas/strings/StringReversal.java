package com.spoonware.katas.strings;

public class StringReversal {

	/*
	 * reverse a given string and return the reversed string
	 */
	
	static String reverseString(String str) {
		char[] results = new char[str.toCharArray().length];
		for(int i=0; i < str.toCharArray().length; i++) {
			results[i] = str.toCharArray()[str.toCharArray().length - 1 - i];
		}
		 
		return String.valueOf(results);
	}
	
	public static void main(String[] args) {
		String str = "  something!!$%^&  ";
		System.out.println("|" + reverseString(str) + "|" );
		
	}
}
