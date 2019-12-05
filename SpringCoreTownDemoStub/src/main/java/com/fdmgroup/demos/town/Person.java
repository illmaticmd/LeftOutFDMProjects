package com.fdmgroup.demos.town;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name;
	private String job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return job + " " + name;
	}

}
