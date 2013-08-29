package com.mendley.ntw.util;

import java.util.ArrayList;
import java.util.List;

public final class NumberUtils {

	// Not intended to be instantiated
	private NumberUtils() {
	}

	/**
	 * Verify if the string passed is a valid positive integer
	 * 
	 * @param str
	 *            the input integral string
	 * @return <tt>true</tt> only if the input string is a positive integer, <tt>false</tt>
	 *         otherwise
	 */
	public static boolean isPositiveInteger(String str) {
		Long longValue = null;
		try {
			longValue = Long.parseLong(str);
		} catch (NumberFormatException nfe) {
			// no need to do anything with the exception
			return false;
		}
		return longValue >= 0;
	}

	/**
	 * Removes leading zeroes from a numeric string and leaves one Zero for
	 * number Zero. eg: 0001 translates to 1 and 0 translates to 0
	 * Does not validate input string number.
	 * 
	 * @param str
	 *            input numeric string
	 * @return numeric string with no leading zeroes
	 */
	public static String removeLeadingZeroes(String str) {
		return str.replaceFirst("^0+(?!$)", "");
	}

	/**
	 * Divides a numeric string into buckets of 3 digits, begining with the
	 * righ-most digits. Does not validate input string number
	 * 
	 * @param number
	 *            the string numeral
	 * @param portionSize
	 *            the number of digits to group
	 * @return {@link java.util.List<String>} values with the right-most digit
	 *         group as the first element
	 */
	public static List<String> divideNumericPortions(String number,
			int portionSize) {
		List<String> portions = new ArrayList<String>();

		// divide into portion size beginning from right-most
		for (int i = number.length(); i > 0; i -= portionSize) {
			portions.add(number.substring(Math.max(0, i - portionSize), i));
		}

		return portions;
	}
	
	/**
	 * Return the right-most digit in the numeric string. 
	 * Does not validate input string number.
	 * 
	 * @param number
	 *            the string numeral
	 */
	public static String getUnitsDigit(String number) {
		return number.substring(number.length() - 1);
	}
}
