package com.fdmgroup.ood2exceptionsdemo;

import java.util.ArrayList;
import java.util.List;

public class AccountsManager {

	private static List<Account> accounts;

	public AccountsManager() {

		super();
		accounts = new ArrayList<>();
	}

	public void create(String username, String password) {

		username = validate(username);
		password = validate(password);
		accounts.add(new Account(username, password));
		
//		try {
//			username = validate(username);
//			password = validate(password);
//			accounts.add(new Account(username, password));
//		} catch (AccountsManagerUncheckedException e) {
//			System.out.println(e.getClass() + ":: " + e.getMessage());
//		}
	}

	private String validate(String str) {
		
		if (str == null) {
			throw new AccountsManagerUncheckedException("encountered null input argument.");
		}
		
		String trimmedStr = str.trim();
		if (trimmedStr.isEmpty() || trimmedStr.contains(" ")) {
			throw new AccountsManagerUncheckedException("input argument cannot be empty or contain white space: '" + str + "'");
		}
			
		return trimmedStr;
	}

	public List<Account> read() {

		return accounts;
	}
}
