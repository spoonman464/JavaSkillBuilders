package com.spoonware.katas.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	public List<Integer> getPrimes(int maxValue) {
		List<Integer> primes = new ArrayList<>();
		for(int cursor = 1; cursor <= maxValue; cursor++) {
			if(cursor==1) {
				primes.add(cursor);
			}else if(cursor==2) {
				primes.add(cursor);
			}else{
				boolean isPrime = true;
				for(int j = 1; j < primes.size(); j++) {
					if(cursor % primes.get(j) == 0) {
						isPrime = false;
						j = primes.size(); //cause loop to end on next for loop check
					}
				}
				if(isPrime) primes.add(cursor);
			}
		}
		return primes;
	}
}
