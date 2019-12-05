package com.fdmgroup.demos.town;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class OfficeBuilding extends Building {

	private Set<Company> companies;
	private Person manager;

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "\n\n" + "Type: Office Building\n" + getAddress() + "\n" + "Managed by: " + manager + "\n"
				+ "Companies: " + companies;
	}

}
