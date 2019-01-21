package com.spoonware.katas.recursion;

public class StringRecursiveReversal {
	String reverse = "";

	public String reverseString(String str){

		if(str.length() == 1){
			return str;
		} else {
			reverse += str.charAt(str.length()-1)
					+reverseString(str.substring(0,str.length()-1));
			System.out.println(reverse);
			
			return reverse;
		}
	}

	public static void main(String a[]){
		StringRecursiveReversal srr = new StringRecursiveReversal();
		System.out.println("Result: "+srr.reverseString("Java2novice"));
	}
}