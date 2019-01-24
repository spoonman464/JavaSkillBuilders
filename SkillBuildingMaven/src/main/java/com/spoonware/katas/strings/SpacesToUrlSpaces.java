package com.spoonware.katas.strings;

public class SpacesToUrlSpaces {
	/*
	 * 1.3 Write a method to replace all spaces with '%20' like the way spaces are replaced in URLs.
	 * Solution: Split on spaces, loop the new array, build up a String from the array values followed by the 
	 * separator "%20" ignoring array elements that are empty strings like "". Finally, remove the trailing separator. 
	 * 
	 */

	static String makeSpaces(String s) {
		String separator = "%20";
		String[] sa = s.split(" ");
//		System.out.println(sa.length);
		String output = "";
		for(String x : sa) {
			output += x;
			output += ("".equals(x)) ? "" : separator ;
		}
		
		return output.substring(0, output.length() - separator.length());
	}
	
	static String makeSpacesStringBuilder(String s) {
		String separator = "%20";
		String[] sa = s.split(" ");
		StringBuilder output = new StringBuilder();
		for(String x : sa) {
			output.append(x);
			output.append(("".equals(x)) ? "" : separator);
		}
		return output.substring(0, output.length() - separator.length());
	}
	
	public static void main(String[] args) {
		String input1 = "Mr John Smith   ";
		String message1 = makeSpaces(input1);
		System.out.println(message1);
		
		String input2 = "Mr John   Smith  ";
		String message2 = makeSpaces(input2);
		System.out.println(message2);
		
		String input3 = "Mr John   Smith  ";
		String message3 = makeSpacesStringBuilder(input3);
		System.out.println(message3);
	}

}
