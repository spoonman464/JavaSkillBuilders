package com.spoonware.katas.romannumerals;

public class RomanConversion {

	private static final String[] 	onesRoman 		= {"","I","II","III","IV","V","VI","VII","VIII","IX"};
	private static final String[] 	tensRoman 		= {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	private static final String[] 	hundredsRoman 	= {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
	private static final String[] 	thousandsRoman 	= {"","M","MM","MMM"};
	private static final String 	PADDING_ZEROS 	= "0000"; //always pad with 4 zeros to ensure code always works with a 4-digit number like "0001" or "0945"
	private static final int		THOUSANDS_PLACE	= 0;
	private static final int		HUNDREDS_PLACE	= 1;
	private static final int		TENS_PLACE		= 2;
	private static final int		ONES_PLACE		= 3;

	public String getRomanNumerals(int i) {
		if(i > 3000) {
			return "";
		}else {
			return getThousands(i) + getHundreds(i) + getTens(i) + getOnes(i);
		}
	}

	public int getArabicNumber(String romanNumber) {
		if("".equals(romanNumber)) {
			return 0;
		}else {
			return processRomanNumber(romanNumber);
		}
	}

	private int processRomanNumber(String number) {
		int runningTotal = 0;
		char[] chars = number.toCharArray();
		for(int i=0; i < chars.length; i++) {
			String currentRoman = String.valueOf(chars[i]);
			String nextRoman = (i+1 < chars.length) ? String.valueOf(chars[i+1]) : "";
			int currentArabic = getArabicValueForRomanNumeral(currentRoman);
			int nextArabic = getArabicValueForRomanNumeral(nextRoman);
			
			if(currentArabic < nextArabic) {
				runningTotal -= currentArabic;
			}else {
				runningTotal += currentArabic;
			}
		}
		return runningTotal;
	}

	private int getArabicValueForRomanNumeral(String romanNumeral) {
		int results = 0;
		switch (romanNumeral) {
		case "M" : results += 1000;
		break;
		case "D" : results += 500;
		break;
		case "C" : results += 100;
		break;
		case "L" : results += 50;
		break;
		case "X" : results += 10;
		break;
		case "V" : results += 5;
		break;
		case "I" : results += 1;
		break;
		case "" : results += 0;
		break;
		}
		return results;
	}
	


	private String getThousands(int number) { 
		int index = getRomanNumeralIndex(number, THOUSANDS_PLACE);
		return thousandsRoman[index];
	}

	private String getHundreds(int number) { 
		int index = getRomanNumeralIndex(number, HUNDREDS_PLACE);
		return hundredsRoman[index];
	}

	private String getTens(int number) {
		int index = getRomanNumeralIndex(number, TENS_PLACE);
		return tensRoman[index];
	}

	private String getOnes(int number) {
		int index = getRomanNumeralIndex(number, ONES_PLACE);
		return onesRoman[index];
	}

	private int getRomanNumeralIndex(int number, int placeNumber) {
		String paddedNumber = PADDING_ZEROS + String.valueOf(number);
		paddedNumber = paddedNumber.substring(paddedNumber.length() - PADDING_ZEROS.length());
		char c = paddedNumber.charAt(placeNumber); 
		int index = Integer.parseInt(String.valueOf(c));
		return index;
	}
}
