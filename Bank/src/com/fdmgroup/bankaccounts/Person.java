package com.fdmgroup.bankaccounts;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

public class Person extends Customer {

//	private BigDecimal balance;
	private Account hm;
	private Account savings;

	
//	public BigDecimal getBalance() {
//		return balance;
//	}
//
//	public void setBalance(BigDecimal balance) {
//		this.balance = balance;
//	}
	
	
	public void reset() {
		for (Entry<Integer,Account> acc : getAccounts().entrySet()){
			
			acc.getValue().setBalance(BigDecimal.ZERO);
		}

	}

}
