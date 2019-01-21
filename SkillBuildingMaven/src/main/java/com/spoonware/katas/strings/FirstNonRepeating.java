package com.spoonware.katas.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
	
	/*
	 * given a string with 0 or more characters that appear more than once 
	 * determine which character, if any, is not repeated. If there is more than
	 * one, any one will do.
	 */
	
	
	
	private static Character repeatedChar(String s) {
		Map<Character, Integer> buckets = new HashMap<>();
		
		char[] chars = s.toCharArray();
		
		Character results = null;
		for(char c : chars) {
			if(buckets.containsKey(c)) {
				Integer value = buckets.get(c) + 1;
				buckets.put(c, value);
			}else {
				buckets.put(c, 1);
			}
		}
		for(char c : chars) {
			if(buckets.get(c)==1) {
				results = c;
				break;
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		String input = "ababcb";
		System.out.println("c=" + FirstNonRepeating.repeatedChar(input));
		
	}


}
