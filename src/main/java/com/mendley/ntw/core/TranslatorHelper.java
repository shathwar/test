package com.mendley.ntw.core;

import com.mendley.ntw.domain.Multiples;
import com.mendley.ntw.util.NumberUtils;

/**
 * This class is a helper class to do the translation from numbers to words
 */
public final class TranslatorHelper {

	public static final String SPACE = " ";
	public static final String AND = "and ";

	// not meant to be instantiated
	private TranslatorHelper() {
	}

	/**
	 * Translate the digit at the units place
	 * 
	 * @param number
	 *          the integer to translate
	 * @return translated word
	 */
	public static String translateUnits(int number) {
		return translateUnits(String.valueOf(number));
	}

	/**
	 * Translate the digit at the units place
	 * 
	 * @param number
	 *          the string numeral to translate
	 * @return translated word
	 */
	public static String translateUnits(String number) {
		assert number.length() == 1;
		return new UnitsTranslator().doTranslate(number);
	}
	
	/**
	 * Translate the digit at the tens place
	 * 
	 * @param number
	 *          the integer to translate
	 * @return translated word
	 */
	public static String translateTens(int number) {
		return translateTens(String.valueOf(number));
	}

	/**
	 * Translate the digit at the tens place
	 * 
	 * @param number
	 *          the string numeral to translate
	 * @return translated word
	 */
	public static String translateTens(String number) {
		int convertedNumber = Integer.parseInt(number);
		int tenthPlaceDigit = convertedNumber / 10;
		boolean hasFurtherDigits = convertedNumber % 10 != 0;
		StringBuilder sb = new StringBuilder();
		TensTranslator tensTranslator = new TensTranslator();

		// for numbers between 10 & 19 and whole 2-digit numbers end processing here
		if (tensTranslator.isTeen(number) || !hasFurtherDigits) {
			return tensTranslator.doTranslate(number);
		} else if (tenthPlaceDigit != 0) {
			sb.append(tensTranslator.doTranslate(number)).append(SPACE);
		}

		if (hasFurtherDigits) {
			// proceed to processing the last digit
			sb.append(translateUnits(NumberUtils.getUnitsDigit(number)));
		}

		return sb.toString();
	}

	/**
	 * Translate the digit at the hundredth place
	 * 
	 * @param number
	 *          the string numeral to translate
	 * @return translated word
	 */
	public static String translateHundreds(String number) {
		int convertedNumber = Integer.parseInt(number);

		int hundredthPlaceDigit = convertedNumber / 100;
		boolean hasFurtherDigits = convertedNumber % 100 != 0;
		StringBuilder sb = new StringBuilder();

		// we don't want to print zero hundred
		if (hundredthPlaceDigit != 0) {
			sb.append(translateUnits(hundredthPlaceDigit)).append(SPACE)
					.append(Multiples.hundred);

			// follow the word "hundred" with the word " and "
			if (hasFurtherDigits) {
				sb.append(SPACE).append(AND);
			}
		}

		if (hasFurtherDigits) {
			sb.append(translateTens(convertedNumber % 100));
		}

		return sb.toString();
	}
	
	/**
	 * Translate the multiples of 10
	 * 
	 * @param number
	 * 			the string numeral to be translated
	 * @param ordinal
	 * 			the ordinal that determines the correct {@link Multiples}
	 * @return
	 */
	public static String translateMultiples(String number, int ordinal) {
		StringBuilder sb = new StringBuilder();

		sb.append(translateHundreds(number)).append(SPACE)
				.append(Multiples.values()[ordinal]).append(SPACE);

		return sb.toString();
	}

}
