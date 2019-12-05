package com.fdmgroup.bankaccounts;

import java.util.HashMap;
import java.util.Map;

public abstract class Customer {

	private String name;
	private String address;
	private int taxIDNum;
	private int custIDNum;

	private Map<Integer, Account> accounts = new HashMap<>();

	public Map<Integer, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTaxIDNum() {
		return taxIDNum;
	}

	public void setTaxIDNum(int taxIDNum) {
		this.taxIDNum = taxIDNum;
	}

	public int getCustIDNum() {
		return custIDNum;
	}

	public void setCustIDNum(int custIDNum) {
		this.custIDNum = custIDNum;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", taxIDNum=" + taxIDNum + ", custIDNum=" + custIDNum
				+ ", accounts=" + accounts + "]";
	}


}
