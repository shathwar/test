package com.mendley.ntw.core;

import com.mendley.ntw.domain.Teens;
import com.mendley.ntw.domain.Tens;

public class TensTranslator implements Translator {

	/**
	 * Verify if the given string numeral is between and including 10 & 19
	 * 
	 * @param number
	 *          the string numeral
	 * @return <tt>true</tt> only if the input string is between and including 10
	 *         & 19, <tt>false</tt> otherwise
	 */
	public boolean isTeen(String number) {
		int convertedNumber = Integer.parseInt(number);

		return convertedNumber >= 10 && convertedNumber < 20;
	}

	@Override
	public String doTranslate(String number) {
		// handle the special case of teens
		if (isTeen(number)) {
			return Teens.from(number).toString();
		}

		// return the tens value
		int tensDigit = Integer.parseInt(number.substring(0, 1));

		return Tens.values()[tensDigit - 1].toString();
	}

}
