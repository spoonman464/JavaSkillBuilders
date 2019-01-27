package com.spoonware.katas.strings;

public class FizzBuzz {
	
	static void printFizzBuzzList(int lower, int upper) {
		for(int i=lower; i <= upper; i++) {
			String message = "";
			if((i % 3 == 0) && (i % 5 == 0)) {
				//both conditions
				message += "FizzBuzz";
			}else if(i % 3 == 0) {
				// %3 condition
				message += "Fizz";
			}else if(i % 5 == 0) {
				//%5 condition
				message += "Buzz";
			}else {
				//just the number
				message += i;
			}
			System.out.println(message);
		}
	}

	public static void main(String[] args) {

		printFizzBuzzList(1, 100);
	}

}
