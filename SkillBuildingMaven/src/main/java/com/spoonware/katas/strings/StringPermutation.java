package com.spoonware.katas.strings;

import java.util.Arrays;

public class StringPermutation {
/*
 * 1.2 Problem: Given two strings, write a method to decide if one is permutation of the other.
 * Solution: sort both strings and then compare them for equality.
 * Assumptions: consider whether or not the comparison should be case-sensitive.
 * 
 */
	static String sortString(String s) {
		char[] content = s.toLowerCase().toCharArray(); //makes the comparison case-insensitive.
		Arrays.sort(content);
		return new String(content);
	}
	
	static boolean isPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		String content1 = sortString(s1);
		String content2 = sortString(s2);
		if(content1.equals(content2)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		String s1 = "BEAST";
		String s2 = "BATEs";
		if(isPermutation(s1, s2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
}
