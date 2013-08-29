package com.mendley.ntw.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.mendley.ntw.util.NumberUtils;

public class NumberUtilsTest {

	@Test
	public void givenAnInvalidIntegralStringTo_IsPositiveInteger_returnFalse() {
		String gibberish = "some string that is not an integer!";
		boolean validInteger = NumberUtils.isPositiveInteger(gibberish);
		assertFalse(gibberish + " is a valid integer", validInteger);
	}
	
	@Test
	public void givenAFloatingPointTo_IsPositiveInteger_returnFalse() {
		String gibberish = "1.23";
		boolean validInteger = NumberUtils.isPositiveInteger(gibberish);
		assertFalse(gibberish + " is a valid integer", validInteger);
	}
	
	@Test
	public void givenAValidIntegralStringTo_IsPositiveInteger_returnTrue() {
		String number = "99988";
		boolean validInteger = NumberUtils.isPositiveInteger(number);
		assertTrue(number + " is not a valid integer", validInteger);
	}
	
	@Test
	public void givenANegativeIntegralStringTo_IsPositiveInteger_returnFalse() {
		String number = "-99988";
		boolean validInteger = NumberUtils.isPositiveInteger(number);
		assertFalse(number + " is not a valid positive integer", validInteger);
	}
	
	@Test
	public void givenAValidIntegralStringWithLeadingZeroes_removeLeadingZeroes() {
		String input = "00088";
		String actual = "88";
		String expected = NumberUtils.removeLeadingZeroes(input);
		assertEquals("Leading zeroes were not removed", actual, expected);
	}
	
	@Test
	public void givenAValidIntegralStringWithTrailingZeroesTo_removeLeadingZeroes_retunrUnchanged() {
		String input = "88000";
		String actual = "88000";
		String expected = NumberUtils.removeLeadingZeroes(input);
		assertEquals("Trailing zeroes were not removed", actual, expected);
	}

	@Test
	public void givenZeroTo_removeLeadingZeroes_retunrUnchanged() {
		String input = "0";
		String actual = "0";
		String expected = NumberUtils.removeLeadingZeroes(input);
		assertEquals("Zero was removed", actual, expected);
	}
	
	@Test
	public void givenANumberTo_divideNumericPortions_returnPortions() {
		String input = "1234567";
		List<String> divideNumericPortions = NumberUtils.divideNumericPortions(input, 2);
		assertEquals(4, divideNumericPortions.size());
		divideNumericPortions = NumberUtils.divideNumericPortions(input, 3);
		assertEquals(3, divideNumericPortions.size());
	}
	
	@Test
	public void givenANumberTo_getUnitsDigit_returnUnitsDigit() {
		String number = "1234567";
		String lastDigit = NumberUtils.getUnitsDigit(number);
		assertEquals("7", lastDigit);
		number = "123456";
		lastDigit = NumberUtils.getUnitsDigit(number);
		assertEquals("6", lastDigit);
	}
	
}
