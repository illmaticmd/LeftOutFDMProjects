package com.fdmgroup.bankaccounts;

import java.math.BigDecimal;
import java.util.Map.Entry;

public class Company extends Customer {

	private Current current;
	private Savings savings;

	public void add(BigDecimal bd) {

		for (Entry<Integer, Account> acc : getAccounts().entrySet()) {

			Account account = acc.getValue();
			BigDecimal balance = account.getBalance();
			BigDecimal sum = balance.add(bd);
			account.setBalance(sum);
		}
	}
}
