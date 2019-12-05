package com.fdmgroup.bankaccounts;

import java.math.BigDecimal;

public class Person extends Customer {

//	private BigDecimal balance;
	private Account current;
	private Account savings;

//	public BigDecimal getBalance() {
//		return balance;
//	}
//
//	public void setBalance(BigDecimal balance) {
//		this.balance = balance;
//	}
	
	public void reset(BigDecimal reset) {

		reset = new BigDecimal(0);	
//		current.setBalance(reset);
//		savings.setBalance(reset);
		System.out.println(reset);
	}

}
