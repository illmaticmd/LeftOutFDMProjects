package com.fdmgroup.demos.town;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private int number;
	private String street;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	

	@Override
	public String toString() {
		return "Address: "+number + " " + street+ " NY, NY";
	}
}
