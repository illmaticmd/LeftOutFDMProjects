package com.fdmgroup.ood2exceptionsdemo.presentation;

import com.fdmgroup.ood2exceptionsdemo.Account;
import com.fdmgroup.ood2exceptionsdemo.AccountsManager;
import com.fdmgroup.ood2exceptionsdemo.AccountsManagerCheckedException;
import com.fdmgroup.ood2exceptionsdemo.AccountsManagerUncheckedException;

public class Client {

	public static void main(String[] args) {

		AccountsManager accountsManager = null;
		try {
			accountsManager = new AccountsManager();
			accountsManager.create("ckent", "superman");
			accountsManager.create("   bwayne", "   batman  ");
			accountsManager.create("  cbrown", "good grief");
			accountsManager.create("pparker    ", "spiderman   ");
			accountsManager.create("tstark", "ironman");
		}
		
		/*
		 * After running the application as is, then:
		 * 
		 *  	1. Comment out lines 31-33 below.
		 *  	2. In AccountsManager#create, comment out lines 18-20.
		 *  	3. In AccountsManager#create, uncomment out lines 22-28.
		 *  
		 * How does moving the catch block to AccountsManager#create affect the output? Why?
		 */
		catch (AccountsManagerUncheckedException e) {
			System.out.println(e.getClass() + ":: " + e.getMessage());
		} 
		finally {
			if (accountsManager.read().size() > 0) {
				System.out.println("\nRegistered accounts...");
				for (Account account : accountsManager.read()) {
					System.out.println(account);
				}
			} else {
				System.out.println("No accounts registered!");
			}
		}
	}
}
