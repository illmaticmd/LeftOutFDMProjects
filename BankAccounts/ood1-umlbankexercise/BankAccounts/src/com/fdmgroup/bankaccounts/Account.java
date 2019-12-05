package com.fdmgroup.bankaccounts;

import java.math.BigDecimal;

public abstract class Account {

	private BigDecimal balance;
	private int accIDNum;
	
	private Customer customer; //Has a relationship

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getAccIDNum() {
		return accIDNum;
	}

	public void setAccIDNum(int accIDNum) {
		this.accIDNum = accIDNum;
	}

	// method to make deposit
	public BigDecimal deposit(BigDecimal bd) {
		balance = balance.add(bd);
		return balance;
	}

	// method to make withdrawal
	public BigDecimal withdraw(BigDecimal bd) {
		balance = balance.subtract(bd);
		return balance;
	}

	// method to make correction to account balance
	public void correction(BigDecimal bd) {
		balance = bd;
	}

	@Override
	public String toString() {
		return "Account [Balance=" + balance + ", accIDNum=" + accIDNum + "]";
	}

}
