package com.spoonware.katas.recursion;

public class Fibonacci {

	private static int counter = 0;
	
	static int fib(int n) { 
		counter++;
		System.out.println("counter=" + counter);
    if (n <= 1) 
       return n; 
    return fib(n-1) + fib(n-2); 
    } 
	
	static int fib2(int n) {
		 int a = 0, b = 1, c = 0; 
		 System.out.println(b);
	        if (n == 0) 
	            return a; 
	        for (int i = 1; i < n; i++) 
	        { 
	            c = a + b; 
	            System.out.println(c);
	            a = b; 
	            b = c; 
	        } 
	        return b; 
	}
       
    public static void main (String args[]) 
    { 
    int n = 30; 
//    System.out.println(fib2(n)); 
    fib2(n);
    }
}
