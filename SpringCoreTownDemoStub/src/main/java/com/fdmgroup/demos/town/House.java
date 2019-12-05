package com.fdmgroup.demos.town;

import org.springframework.stereotype.Component;

@Component
public class House extends Building {

	private Person headOfHousehold;

	public Person getHeadOfHousehold() {
		return headOfHousehold;
	}

	public void setHeadOfHousehold(Person headOfHousehold) {
		this.headOfHousehold = headOfHousehold;
	}
	
	@Override
	public String toString() {
		return "\nType: House\n"
				+  getAddress() +"\n"+
				"Head of Household: " + headOfHousehold;
	}
	
}
