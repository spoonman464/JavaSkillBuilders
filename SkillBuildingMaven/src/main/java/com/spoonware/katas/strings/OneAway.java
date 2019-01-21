package com.spoonware.katas.strings;

public class OneAway {

	static Boolean isOneAway(String s1, String s2) {
		boolean results = false;
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		if(s1.equals(s2)) {
			results = true;
		}else if(chars1.length==chars2.length) {
			int mismatches = 0;
			for(int i = 0; i < chars1.length; i++ ) {
				if(chars1[i]!=chars2[i]) {
					mismatches++;
				}
			}
			if(mismatches <= 1) results = true;
		}else if(Math.abs(s1.length() - s2.length())==1) {
			if(s1.length() > s2.length()) {
				chars1 = s1.toCharArray();
				chars2 = s2.toCharArray();
			}else {
				chars1 = s2.toCharArray();
				chars2 = s1.toCharArray();
			}
			int mismatches = 0;
			int cursor1 = 0;
			int cursor2 = 0;
			while((cursor1 < chars1.length) && (cursor2 < chars2.length)) {
				if(chars1[cursor1] != chars2[cursor2]) {
					mismatches++;
					cursor1++;
				}else {
					cursor1++;
					cursor2++;
				}				 
			}
			if(mismatches <= 1) results = true;
		}else {
			results = false;
		}
	
		return results;
	} 
	


	public static void main(String[] args) {
		boolean results;
		String s1 = "snoopy";
		String s2 = "snoopy";
		results = isOneAway(s1, s2);
		System.out.println("isOneAway is " + results);
		s1 = "abcde";
		s2 = "abfde";
		results = isOneAway(s1, s2);
		System.out.println("isOneAway is " + results);
		s1 = "abcde";
		s2 = "abfdz";
		results = isOneAway(s1, s2);
		System.out.println("isOneAway is " + results);
		s1 = "abcde";
		s2 = "abde";
		results = isOneAway(s1, s2);
		System.out.println("isOneAway is " + results);
		s1 = "abde";
		s2 = "abcde";
		results = isOneAway(s1, s2);
		System.out.println("isOneAway is " + results);
	}


}
