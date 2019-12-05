package com.fdmgroup.bankaccounts;

public abstract class Customer {

	String Name;
	String Address;
	int TaxIDNum;
	int custIDNum;
	
	@Override
	public String toString() {
		return "Customer [Name=" + Name + ", Address=" + Address + ", TaxIDNum=" + TaxIDNum + ", custIDNum=" + custIDNum
				+ "]";
	}

}
