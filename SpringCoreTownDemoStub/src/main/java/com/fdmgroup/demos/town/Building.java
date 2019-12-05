package com.fdmgroup.demos.town;

import org.springframework.stereotype.Component;

@Component
public abstract class Building {

	private Address address;

	public Building() {
		// TODO Auto-generated constructor stub
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
