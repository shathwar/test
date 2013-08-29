package com.mendley.ntw.core;

import com.mendley.ntw.domain.Units;

public class UnitsTranslator implements Translator {

	@Override
	public String doTranslate(String number) {
		return Units.from(number).toString();
	}

}
