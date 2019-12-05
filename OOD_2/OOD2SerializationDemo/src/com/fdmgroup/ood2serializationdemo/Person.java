package com.fdmgroup.ood2serializationdemo;

public abstract class Person {
	
	private String firstName;
	private String lastName;
	
	String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName;
	}	
}
