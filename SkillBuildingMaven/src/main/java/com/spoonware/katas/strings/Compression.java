package com.spoonware.katas.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class Compression {

	/*
	 * Implement a method to perform basid string compression using the counts of repeated characters. For example, the string "aabcccccaaa" would become
	 * "a2b1c5a3". If the compressed string will not become smaller than the original string, the method should return the original string. 
	 * Assume case insensitivity
	 * Solution: Convert the string into a lower case char array. Loop through the array putting each character on the stack if the stack is empty or if the 
	 * top of the stack is the same character
	 */

	static int computeStackDepth(Deque<Character> stack) {
		int count = 0;
		while(!stack.isEmpty()) {
			count++;
			stack.pop();
		}
		//		System.out.println("count=" + count);
		return count;
	}

	static String compressString(String s) {
		//		Stack stack = new Stack();
		Deque<Character> stack = new ArrayDeque<>();
		StringBuilder strBuilder = new StringBuilder();
		char[] chars = s.toLowerCase().toCharArray();
		int popCount = 0;
		for(char c : chars) {
			//			System.out.println("for loop with c=" + c);

			if(stack.isEmpty()) {
				//				System.out.println("stack is empty");
				strBuilder.append(c);
				stack.push(Character.valueOf(c));
			} else {
				if(Character.valueOf(c).equals(stack.peek())) {
					//					System.out.println("char equals peek");
					//					System.out.println("pushing stack with " + c);
					stack.push(Character.valueOf(c));
				}else {
					//					System.out.println("char NOT equals peek");
					//pop stack until empty and record the count
					popCount = computeStackDepth(stack);
					strBuilder.append(popCount);
					strBuilder.append(c);
					stack.push(Character.valueOf(c));
				}
			}
		}
		popCount = computeStackDepth(stack);
		strBuilder.append(popCount);
		return (strBuilder.length() >= s.length()) ? s : strBuilder.toString();

	}



	public static void main(String[] args) {
		String s1 = compressString("snoopy");
		System.out.println(s1);

		String s2 = compressString("aabcccccaaa");
		System.out.println(s2);

		String s3 = compressString("xyz");
		System.out.println(s3);
		
		String s4 = compressString("x         y   z   c");
		System.out.println(s4);




	}

}
