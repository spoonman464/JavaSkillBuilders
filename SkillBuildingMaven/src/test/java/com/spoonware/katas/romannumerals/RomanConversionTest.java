package com.spoonware.katas.romannumerals;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class RomanConversionTest {

	private RomanConversion systemUnderTest;
	private static LinkedHashMap<Integer, String> numbers = new LinkedHashMap<Integer, String>();
	private static final String[] allRomanNumerals = {	"","I","II","III","IV","V","VI","VII","VIII","IX","X",
			"XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
			"XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
			"XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL"
	};

	@Before
	public void setUp() {
		systemUnderTest = new RomanConversion();
		numbers.put(54, "LIV");
		numbers.put(99, "XCIX");
		numbers.put(100, "C");
		numbers.put(500, "D");
		numbers.put(559, "DLIX");
		numbers.put(900, "CM");
		numbers.put(999, "CMXCIX");
		numbers.put(1000, "M");
		numbers.put(2000, "MM");
		numbers.put(2999, "MMCMXCIX");
		numbers.put(3000, "MMM");
		numbers.put(1969, "MCMLXIX");
		numbers.put(544, "DXLIV");
	}

	@Test
	public void getRomanNumerals_withArabicOneToMany_returnAllCorrectValues() {
		for(int i = 1; i < allRomanNumerals.length; i++) {
			Assert.assertEquals(allRomanNumerals[i],systemUnderTest.getRomanNumerals(i));
		}
	}

	@Test
	public void getRomanNumerals_withArabicOtherNumbers_returnAllCorrectValues() {
		for (HashMap.Entry<Integer,String> entry : numbers.entrySet()) {
			Assert.assertEquals(entry.getValue(),systemUnderTest.getRomanNumerals(entry.getKey()));
		}
	}

	@Test
	public void getRomanNumerals_withArabic4000_returnEmptyString() {
		Assert.assertEquals("",systemUnderTest.getRomanNumerals(4000));
	}

	@Test
	public void getRomanNumerals_withArabic3001_returnEmptyString() {
		Assert.assertEquals("",systemUnderTest.getRomanNumerals(3001));
	}

	@Test
	public void getRomanNumerals_withZero_returnEmptyString() {
		Assert.assertEquals("",systemUnderTest.getRomanNumerals(0));
	}
	
	//Tests for converting Roman into Arabic numbers
	@Test
	public void getArabicNumber_withEmptyString_returnZero() {
		Assert.assertEquals(0,systemUnderTest.getArabicNumber(""));
	}
	@Test
	public void getArabicNumber_withRomanOneToMany_returnAllCorrectValues() {
		for(int i = 1; i < allRomanNumerals.length; i++) {
			Assert.assertEquals(i,systemUnderTest.getArabicNumber(allRomanNumerals[i]));
		}
	}

	@Test
	public void getArabicNumber_withRomanOtherNumbers_returnAllCorrectValues() {
		for (HashMap.Entry<Integer,String> entry : numbers.entrySet()) {
			int key = entry.getKey();
			Assert.assertEquals(key,systemUnderTest.getArabicNumber(entry.getValue()));
		}
	}









}
