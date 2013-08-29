package com.mendley.ntw.domain;

public enum Teens {
	ten("10"),
	eleven("11"),
	twelve("12"),
	thirteen("13"),
	fourteen("14"),
	fifteen("15"),
	sixteen("16"),
	seventeen("17"),
	eighteen("18"),
	nineteen("19");
	
	private String number;
	
	Teens(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public static Teens from(String number) {
		for (Teens tens : Teens.values()) {
			if(tens.getNumber().equals(number)) {
				return tens;
			}
		}
		return null;
	}
}
