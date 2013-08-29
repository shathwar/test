package com.mendley.ntw.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumbersToWordsTest {

	@Test
	public void givenANumber_returnUnits() {
		String zero = NumbersToWords.translateNumberToWords("0");
		String nine = NumbersToWords.translateNumberToWords("9");
		String four = NumbersToWords.translateNumberToWords("004");

		assertEquals("zero", zero);
		assertEquals("nine", nine);
		assertEquals("four", four);
	}

	@Test
	public void givenANumber_returnTens() {
		String eleven = NumbersToWords.translateNumberToWords("011");
		String ten = NumbersToWords.translateNumberToWords("10");
		String nineteen = NumbersToWords.translateNumberToWords("19");
		String eightynine = NumbersToWords.translateNumberToWords("00089");

		assertEquals("eleven", eleven);
		assertEquals("ten", ten);
		assertEquals("nineteen", nineteen);
		assertEquals("eighty nine", eightynine);
	}

	@Test
	public void givenANumber_returnHundreds() {
		String hundred = NumbersToWords.translateNumberToWords("100");
		String hundred11 = NumbersToWords.translateNumberToWords("0111");
		String hundred90 = NumbersToWords.translateNumberToWords("190");
		String hundred72 = NumbersToWords.translateNumberToWords("172");
		String fivehundred = NumbersToWords.translateNumberToWords("500");

		assertEquals("one hundred", hundred);
		assertEquals("one hundred and eleven", hundred11);
		assertEquals("one hundred and ninety", hundred90);
		assertEquals("one hundred and seventy two", hundred72);
		assertEquals("five hundred", fivehundred);
	}

	@Test
	public void givenANumber_returnThousands() {
		String oneThousand = NumbersToWords.translateNumberToWords("1000");
		String twoThousand311 = NumbersToWords.translateNumberToWords("2311");
		String eightThousand900 = NumbersToWords.translateNumberToWords("8900");
		String eightThousand906 = NumbersToWords.translateNumberToWords("8906");

		assertEquals("one thousand", oneThousand);
		assertEquals("two thousand three hundred and eleven", twoThousand311);
		assertEquals("eight thousand nine hundred", eightThousand900);
		assertEquals("eight thousand nine hundred and six", eightThousand906);
	}

	@Test
	public void givenANumber_returnTenThousands() {
		String tenThousand = NumbersToWords.translateNumberToWords("10000");
		String threeThousand100 = NumbersToWords.translateNumberToWords("30100");
		String fiftyFiveThousand1 = NumbersToWords
				.translateNumberToWords("55001");

		assertEquals("ten thousand", tenThousand);
		assertEquals("thirty thousand one hundred", threeThousand100);
		assertEquals("fifty five thousand one", fiftyFiveThousand1);
	}

	@Test
	public void givenANumber_returnMillion() {
		String example1 = NumbersToWords.translateNumberToWords("56945781");
		String example2 = NumbersToWords.translateNumberToWords("999999999");
		assertEquals(
				"fifty six million nine hundred and forty five thousand seven hundred and eighty one",
				example1);
		assertEquals(
				"nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
				example2);
	}

}
