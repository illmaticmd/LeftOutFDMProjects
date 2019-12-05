package com.fdmgroup.bankaccounts;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Demo {

	private Map<Integer, Customer> customers;
//	private Map<Integer, Account> accounts;
	private int IDtrack = 1000;
	private int custTracker;
	private int accTracker;
	private int custIDtracker = 2000000;

	public Demo() {
		customers = new HashMap<>();
//		accounts = new HashMap<>();
	}

	public Current addCurrAcc(BigDecimal uh, int firstcheck, int nextCheque) {
		Current currAcc = new Current();
		currAcc.setBalance(uh);
		currAcc.setAccIDNum(IDtrack);
		currAcc.firstcheck = firstcheck;
		currAcc.chequeNum = nextCheque;
		IDtrack += 5;
		accTracker++;
		return currAcc;
	}

	public Savings addSavAcc(BigDecimal uh) {
		Savings savAcc = new Savings();
		savAcc.setBalance(uh);
		savAcc.setAccIDNum(IDtrack);
		IDtrack += 5;
		accTracker++;
		return savAcc;
	}

	public Company addCompany(String str, String str1, int custax) {
		Company company = new Company();
		company.setName(str);
		company.setAddress(str1);
		company.setTaxIDNum(custax);
		company.setCustIDNum(custIDtracker);
		custIDtracker += 7;
		custTracker++;
		return company;
	}

	public Person addPerson(String str, String str1, int custax) {
		Person person = new Person();
		person.setName(str);
		person.setAddress(str1);
		person.setTaxIDNum(custax);
		person.setCustIDNum(custIDtracker);
		custIDtracker += 7;
		custTracker++;
		return person;
	}

	public static void main(String[] args) {

		// Account acc = new Account(); - nope, can't instantiate abstract class.

		Demo dem = new Demo();
		BigDecimal initialDeposit = new BigDecimal(0);

		Person customer1 = dem.addPerson("Ade", "104 Lane Dr", 28738);
		dem.customers.put(customer1.getCustIDNum(), customer1);
		BigDecimal startingNum1 = new BigDecimal(100);
		Customer customer2 = dem.addPerson("Jane", "104 Lane Dr", 43436);
		dem.customers.put(customer2.getCustIDNum(), customer2);
		BigDecimal startingNum2 = new BigDecimal(30);
		Company company1 = dem.addCompany("This Company", "3948 Lego Ln", 76858);
		dem.customers.put(company1.getCustIDNum(), company1);
		BigDecimal startingNum3 = new BigDecimal(30124);
		
		

		Savings forcustomer1 = dem.addSavAcc(startingNum1);
		customer1.getAccounts().put(forcustomer1.getAccIDNum(), forcustomer1);
		Current forcustomer2 = dem.addCurrAcc(startingNum2, 5615652, 8744155); //saving first check num and next cheque num
		customer2.getAccounts().put(forcustomer2.getAccIDNum(), forcustomer2);
		Current forcompany1 = dem.addCurrAcc(startingNum3, 52929526, 615651922);
		company1.getAccounts().put(forcompany1.getAccIDNum(), forcompany1);

		BigDecimal withdrawl = new BigDecimal(110); //testing no overdraft of savings
		forcustomer1.withdraw(withdrawl);
		
		BigDecimal deposit = new BigDecimal(40); //test deposit method
		forcustomer2.deposit(deposit);
		

		customer1.reset();
		
		System.out.println(company1);
		
		company1.add(deposit);
		
		
		//company1.add(bd);
		
		//forcustomer2.overdraw(); // test overdraft fee method
		
		//BigDecimal correctbalance = new BigDecimal(1000); // test correction method
		//forcustomer2.correction(correctbalance);

		
		
		System.out.println(dem.customers);

		// BigDecimal accBalance = new BigDecimal(0);
		// currAcc.setBalance(accBalance); // okay it works. i guess. so thats good.
		// System.out.println(currAcc.getBalance());
		//
		// accountSetUp(accBalance, 1000);
	}

}