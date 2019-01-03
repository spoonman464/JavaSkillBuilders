package com.spoonware.katas.primenumbers;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PrimeNumbersTest {
	private PrimeNumbers systemUnderTest;
	
	@Before
	public void setUp() {
		systemUnderTest = new PrimeNumbers();
	}
	
	@Test
	public void test() {
		Assertions.assertThat(true);
	}
	
	@Test
	public void getPrimes_withFour_return123() {
		Assertions.assertThat(systemUnderTest.getPrimes(4)).containsExactly(1,2,3);
	}
	
	@Test
	public void getPrimes_withNine_return12357() {
		Assertions.assertThat(systemUnderTest.getPrimes(9)).containsExactly(1,2,3,5,7);
	}
	
	@Test
	public void getPrimes_withOneHundred_returnPrimesFromOneToOneHundred() {
		Assertions.assertThat(systemUnderTest.getPrimes(100))
		.containsExactly(1,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97)
		;
	}

	

	
	
}
