package com.mendley.ntw.domain;

public enum Units {
	zero("0"),
	one("1"),
	two("2"),
	three("3"),
	four("4"),
	five("5"),
	six("6"),
	seven("7"),
	eight("8"),
	nine("9");
	
	private String number;
	
	Units(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public static Units from(String number) {
		for (Units unit : Units.values()) {
			if(unit.getNumber().equals(number)) {
				return unit;
			}
		}
		return null;
	}
}
