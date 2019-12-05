package com.fdmgroup.demolog4j2andjavadocs.data;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.demolog4j2andjavadocs.model.Account;

/*
 * ***************************************************************
 * To generate Javadocs in Eclipse:
 *	
 * 1. Select target Eclipse project
 * 
 * 2. On main menu bar, select: Project -> Generate Javadoc...
 * 
 * ***************************************************************
 */

/**
 * Class AccountInMemoryDao encapsulates basic CRUD operations that can be
 * performed on an input list of Account elements.
 * 
 * @author karl.huff
 */
public class AccountInMemoryDao implements Crudable<Account, String> {

	private static final Logger LOG;
	private static final String LOADED;
	private static final String CONSTRUCTOR;
	private static final String CREATE;
	private static final String READ;
	private static final String UPDATE;
	private static final String DELETE;
	private static final String VALIDATE;
	private static final String RETURNED;
	private static final String NULL_ARG;
	private static final String THROWN;
	
	static {
		LOG = LogManager.getLogger();
		LOADED = "#<clinit>:: class loaded.";
		CONSTRUCTOR = "#<init>:: instantiation: accounts=";
		CREATE = "#create:: account=";
		READ = "#read:: username=";
		UPDATE = "#update:: account=";
		DELETE = "#delete:: username=";
		VALIDATE = "   #validate:: obj=";
		RETURNED = "   Returned= ";
		THROWN = ":: Exception thrown...";
		NULL_ARG = "Null argument input.";
		LOG.trace(LOADED);
	}

	private List<Account> accounts;

	/**
	 * Initializes this AccountInMemoryDao with an input list of type Account
	 * elements.
	 * 
	 * @param accounts
	 *            is the input list.
	 * @throws IllegalArgumentException
	 *             if accounts is null.
	 */
	public AccountInMemoryDao(List<Account> accounts) {

		super();
		LOG.trace(CONSTRUCTOR + accounts);
		validate(accounts);
		this.accounts = accounts;
	}

	/**
	 * Adds the input Account instance to the in-memory list of accounts.
	 * 
	 * @param account
	 *            is an Account instance to be added.
	 * @return true if the account is added, false otherwise.
	 * @throws IllegalArgumentException
	 *             if account is null.
	 */
	public boolean create(Account account) {

		LOG.trace(CREATE + account);
		validate(account);
		
		boolean added = this.accounts.add(account);
		
		LOG.trace(RETURNED + added);
		return added;
	}

	/**
	 * Retrieves an Optional containing the Account instance of the input username from the in-memory
	 * list of Accounts.
	 * 
	 * @param username
	 *            is the username of the Account instance to be retrieved.
	 * @return an Optional containing the target instance as its value, or empty otherwise.
	 * @throws IllegalArgumentException
	 *             if username is null.
	 */
	public Optional<Account> read(String username) {

		LOG.trace(READ + username);
		validate(username);

		Optional<Account> optionalReadAccount = Optional.empty();
		for (Account account : accounts) {
			if (username.equals(account.getUsername())) {
				optionalReadAccount = Optional.of(account);
			}
		}

		LOG.trace(RETURNED + optionalReadAccount);
		return optionalReadAccount;
	}

	/**
	 * Updates a stored Account with the state of the input Account instance.
	 * The input and stored accounts are matched by the username.
	 * 
	 * @param account
	 *            is the state of the current version of the target Account
	 *            instance.
	 * @return true if the update occurs, false otherwise.
	 * @throws IllegalArgumentException
	 *             if account is null.
	 */
	public boolean update(Account account) {

		LOG.trace(UPDATE + account);
		validate(account);

		boolean updated = false;
		Optional<Account> optionalAccount = read(account.getUsername());

		if (optionalAccount.isPresent()) {
			Account readAccount = optionalAccount.get();
			readAccount.setPassword(account.getPassword());
			updated = true;
		}

		LOG.trace(RETURNED + updated);
		return updated;
	}

	/**
	 * Removes the Account instance of the input username from the in-memory
	 * list of accounts.
	 * 
	 * @param username
	 *            is the username of the Account instance to be deleted.
	 * @return true if the delete occurs, false otherwise.
	 * @throws IllegalArgumentException
	 *             if username is null.
	 */
	public boolean delete(String username) {

		LOG.trace(DELETE + username);
		validate(username);

		boolean deleted = false;
		Optional<Account> optionalAccount = read(username);
		if (optionalAccount.isPresent()) {
			Account readAccount = optionalAccount.get();
			deleted = accounts.remove(readAccount);
		}

		LOG.trace(RETURNED + deleted);
		return deleted;
	}

	/**
	 * Tests whether the input Object reference is null.
	 * 
	 * @param obj
	 *            is the reference to the target object.
	 * @throws IllegalArgumentException
	 *             if obj is null.
	 */
	private void validate(Object obj) {

		LOG.trace(VALIDATE + obj);

		if (obj == null) {
			RuntimeException e = new IllegalArgumentException(NULL_ARG);
			LOG.error(THROWN, e);
			throw e;
		}
	}
}
