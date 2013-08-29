package com.mendley.ntw.core;

import java.util.List;

import com.mendley.ntw.domain.Units;
import com.mendley.ntw.util.NumberUtils;

/**
 * This is the main class to run the translation from number to words 
 * assumption 1: program not to cater for localisation of numbers (commas as seperators)
 * assumption 2: only positive numbers are allowed as input to the program and upto
 * 999999999
 */
public class NumbersToWords {

	// the size of digits to group together which is the common repetitive pattern
	// in the words
	private static final int DIGIT_GROUP_SIZE = 3;

	public static void main(String... args) {
		if (args.length < 1) {
			System.out.println("Please pass a positive integral value to translate");
			System.exit(0);
		} else if (args.length > 1) {
			System.out
					.println("Application will consider only the first parameter for the convertion and rest will be ignored.");
		}

		boolean isValidInput = NumberUtils.isPositiveInteger(args[0]);

		if (isValidInput) {
			System.out.println(translateNumberToWords(args[0]));
		} else {
			System.out
					.println("Please supply a valid integral number without commas or dots");
			System.exit(0);
		}
	}

	/**
	 * The translation workflow to translate numbers to words
	 * 
	 * @param number
	 *          the number to translate
	 * @return the translated word
	 */
	public static String translateNumberToWords(String number) {

		Long convertedNumber = Long.parseLong(number);
		// treating zero as special case as further down the line we compare values
		// with zero which may result in some weird behaviour
		if (convertedNumber == 0) {
			return Units.zero.toString();
		}

		StringBuilder sb = new StringBuilder();

		// step 1: remove any leading zeroes in the numeric string
		String inputNumber = NumberUtils.removeLeadingZeroes(number);

		// step 2: breakdown into numeric portions (groups of {@value
		// DIGIT_GROUP_SIZE} digits)
		List<String> numericPortions = NumberUtils.divideNumericPortions(
				inputNumber, DIGIT_GROUP_SIZE);

		// step 3: translate each portion of digits into words
		for (int i = 0; i < numericPortions.size(); i++) {
			String digits = numericPortions.get(i);
			// all numbers greater than {@value DIGIT_GROUP_SIZE} digits
			if (i > 0) {
				sb.insert(0, TranslatorHelper.translateMultiples(digits, i));
			} else {
				// append the final {@value DIGIT_GROUP_SIZE} digits translation
				sb.append(TranslatorHelper.translateHundreds(digits));
			}
		}

		return sb.toString().trim();
	}
}
