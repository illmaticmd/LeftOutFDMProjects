package com.fdmgroup.ood2jsonjacksondemo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int currentID;
	
	@JsonProperty("user_id")
	private int id;
	
	@JsonProperty("access_credentials")
	private Credentials credentials;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String username, String password) {
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setCredentials(new Credentials(username, password));
	}

	private int getNextId() {
		
		return ++currentID;
	}

	public int getId() {
		if (id == 0) {
			id = getNextId();
		}
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	@Override
	@JsonProperty("first_name")
	public String getFirstName() {
		return super.getFirstName();
	}
	
	@Override
	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		super.setFirstName(firstName);
	}
	
	@Override
	@JsonProperty("last_name")
	public String getLastName() {
		return super.getLastName();
	}
	
	@Override
	@JsonProperty("last_name")
	public void setLastName(String firstName) {
		super.setLastName(firstName);
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", " + credentials + ", " + super.toString() +"]";
	}	
}
