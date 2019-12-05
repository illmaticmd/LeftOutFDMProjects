package com.fdmgroup.demos.town;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;

public class TownSimulation {

	public static void main(String[] args) {
		
		

		Address mainSt = new Address();
		mainSt.setNumber(100);
		mainSt.setStreet("Main Street");

		Person mrSmith = new Person();
		mrSmith.setName("Mohamad");
		mrSmith.setJob("Software Engineer");
		
		House house = new House();
		house.setAddress(mainSt);
		house.setHeadOfHousehold(mrSmith);
		
		
		
		Address wallSt = new Address();
		wallSt.setNumber(14);
		wallSt.setStreet("Wall Street");
		
		Person msDoe = new Person();
		msDoe.setName("Jane");
		msDoe.setJob("Building Manager");
		
		Company fdm = new Company();
		fdm.setName("FDM Group");

		Company chipotle = new Company();
		chipotle.setName("Chipotle");
		
		Company oracle = new Company();
		oracle.setName("Oracle");
		
		Set<Company> companies = new HashSet<Company>();
		companies.add(fdm);
		companies.add(chipotle);
		companies.add(oracle);
		
		OfficeBuilding offices = new OfficeBuilding();
		offices.setAddress(wallSt);
		offices.setManager(msDoe);
		offices.setCompanies(companies);
		
		
		System.out.println(house);
		System.out.println(offices);
		
	}

}
