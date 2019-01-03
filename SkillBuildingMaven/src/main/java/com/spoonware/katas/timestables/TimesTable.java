package com.spoonware.katas.timestables;

public class TimesTable {
	private static final int MAX_MULTIPLIER = 12;
	private static final String BLANK_PADDING = "    ";

	public void displayTimesTable(int firstNumber) {
		String message = "";
		for(int i=1; i <= MAX_MULTIPLIER; i++) {
			message += getPaddedNumber(firstNumber * i);
			if(i % 3 == 0) message += "\n";
		}
		System.out.println(message);
	}

	public String getPaddedNumber(int number) {
		String paddedNumber = BLANK_PADDING + String.valueOf(number);
		paddedNumber = paddedNumber.substring(paddedNumber.length()-4);
		return paddedNumber;
	}

	public static void main(String[] args) {
		TimesTable timesTable = new TimesTable();
		timesTable.displayTimesTable(9);
	}
}
