package com.fdmgroup.demos.town;

import org.springframework.stereotype.Component;

@Component
public class Company {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
