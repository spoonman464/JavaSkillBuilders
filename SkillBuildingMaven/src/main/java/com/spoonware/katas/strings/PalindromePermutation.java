package com.spoonware.katas.strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	/*
	 * 1.4 Given a string, write a function to check if it is a permutation of a palindrome. In other words,
	 * are there any palindromes in the string. Assume case insensitivity.
	 * Solution: remove blanks from string, count characters in remaining string. Populate Map<Character, Integer> so that
	 * the count of each character is the Integer and the char wrapper is the key. 
	 * If the string is even length and all counts are even, then it's a palindrome.
	 * If the string is odd length and all counts are even except 1, then it's a palindrome.
	 */

	private static String removeSpaces(String str) {
		String[] strArray = str.split(" ");
		StringBuilder results = new StringBuilder();
		for(String s : strArray) {
			results.append(s);
		}
		return results.toString();
	}

	private static boolean isEvenLength(String s) {
		String str = new String(removeSpaces(s));
		if((str.length() % 2) == 0) {
			return true;
		}else {
			return false;	
		}

	}

	private static int computeOddCounter(Map<Character, Integer> map) {
		int oddCounter = 0;
		//loop through Map to see if all counts are even
		for(Character key : map.keySet()) {
			Integer x = map.get(key);
			//			System.out.println("key=" + key + "; value=" + x);
			if((x.intValue() %2) != 0 ) {
				oddCounter++;
			}
		}
		return oddCounter;
	}
	
	static HashMap<Character, Integer> populateMap(final Map<Character, Integer> map, char[] chars) {
		for(char c : chars) {
			if(c != ' ') {
				Character key = new Character(c);
				if(map.containsKey(key)) {
					Integer x = map.get(key);
					int y = x.intValue() + 1;
					map.put(key, new Integer(y));
				}else {
					map.put(key, 1);
				}
			}
		}
		
		return new HashMap<Character, Integer>(map);
	}

	static boolean isPalindromePermutation(String s) {
		boolean results = true;
		char[] chars = s.toLowerCase().toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		map = populateMap(map, chars);
		if(isEvenLength(s)) {
			if(computeOddCounter(map) > 0) {
				results = false;
			}
		}else {
			if(computeOddCounter(map)  > 1) {
				results = false;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		String s1 = "cat taco";
		System.out.println(isPalindromePermutation(s1));

		String s2 = "car race";
		System.out.println(isPalindromePermutation(s2));

		String s3 = "a man a plan a canal panama";
		System.out.println(isPalindromePermutation(s3));
		
		String s4 = "a panama man a a canal plan";
		System.out.println(isPalindromePermutation(s4));
		
		String s5 = "xyz";
		System.out.println(isPalindromePermutation(s5));

	}

}
