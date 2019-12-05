package com.fdmgroup.demolog4j2andjavadocs.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class Account defines an account data type. Instances of this class hold
 * username and password state.
 * 
 * @author karl.huff
 */
public class Account {
	
	private static final Logger LOG;
	private static final String LOADED;
	private static final String CONSTRUCTOR;
	private static final String GET_USERNAME;
	private static final String SET_USERNAME;
	private static final String GET_PASSWORD;
	private static final String SET_PASSWORD;
	private static final String RETURNED;
	
	static {
		LOG = LogManager.getLogger();
		LOADED = "#<clinit>:: class loaded.";
		CONSTRUCTOR = "#<init>:: instantiation.";
		GET_USERNAME = "#getUsername:: invoked." ;
		SET_USERNAME = "#setUsername:: username=" ;
		GET_PASSWORD = "#getPassword:: invoked." ;
		SET_PASSWORD = "#setPassword:: password=" ;;
		RETURNED = "   Returned= ";
		LOG.trace(LOADED);
	}

	private String username;
	private String password;

	public Account() {
		super();
		LOG.trace(CONSTRUCTOR);
	}

	/**
	 * Retrieves the username of this account.
	 * 
	 * @return this account's username.
	 */
	public String getUsername() {
		LOG.trace(GET_USERNAME);
		LOG.trace(RETURNED + username);
		
		return username;
	}

	/**
	 * Sets the username of this account.
	 * 
	 * @param username is set to this account.
	 */
	public void setUsername(String username) {
		LOG.trace(SET_USERNAME + username);
		this.username = username;
	}

	/**
	 * Retrieves the password of this account.
	 * 
	 * @return this account's password.
	 */
	public String getPassword() {
		LOG.trace(GET_PASSWORD);
		LOG.trace(RETURNED + password);
		
		return password;
	}

	/**
	 * Sets the password of this account.
	 * 
	 * @param password is set to this account.
	 */
	public void setPassword(String password) {
		LOG.trace(SET_PASSWORD + password);
		this.password = password;
	}
}
