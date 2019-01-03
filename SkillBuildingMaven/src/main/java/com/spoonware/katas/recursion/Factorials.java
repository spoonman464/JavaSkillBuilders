package com.spoonware.katas.recursion;

public class Factorials {

	private static long factorial(int n){
		if (n == 1) {
			return 1;
		}else{
			return n * factorial(n-1);
		}
	}
	
	public static void main(String args[]) {
//		Factorials f = new Factorials();
//		long x = f.factorial(n)
		long x = Factorials.factorial(6);
		System.out.println(x);
	}
}
