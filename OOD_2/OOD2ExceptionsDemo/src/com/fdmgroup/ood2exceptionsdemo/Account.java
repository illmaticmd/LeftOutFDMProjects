package com.fdmgroup.ood2exceptionsdemo;

public class Account {
	
	private String username;
	private String password;

	Account(String username, String password) {
		
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + "]";
	}
}
