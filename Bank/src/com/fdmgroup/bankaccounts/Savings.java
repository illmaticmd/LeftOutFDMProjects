package com.fdmgroup.bankaccounts;

import java.math.BigDecimal;

public class Savings extends Account {

	private BigDecimal interest = new BigDecimal(0);
	
    @Override
    public BigDecimal withdraw(BigDecimal withdrawalAmount) {
           BigDecimal currentBalance = this.getBalance();
           BigDecimal balanceAfterWithdrawal = currentBalance.subtract(withdrawalAmount);
           boolean wouldNotOverdraw = currentBalance.compareTo(withdrawalAmount) >= 0;
           
           //Only withdraw if there withdrawal wouldn't set the balance below zero
           if (wouldNotOverdraw) {
                  this.setBalance(balanceAfterWithdrawal);
           }
		return balanceAfterWithdrawal;
    }

}
