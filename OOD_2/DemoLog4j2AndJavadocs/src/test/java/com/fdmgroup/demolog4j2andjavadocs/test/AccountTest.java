package com.fdmgroup.demolog4j2andjavadocs.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.demolog4j2andjavadocs.model.Account;

public class AccountTest {
	
	private Account classUnderTest;

	@BeforeClass
	public static void setUpBeforeClass() {
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testInstanceClassUnderTest() {
		Object classUnderTest = new Account();
		assertTrue(classUnderTest instanceof Account);
	}
	
	@Test 
	public void testSetGetUsername() {
		String expected = "test_username";
		classUnderTest = new Account();
		
		classUnderTest.setUsername(expected);	
		String actual = classUnderTest.getUsername();
		
		assertTrue(expected.equals(actual));
	}
	
	@Test 
	public void testSetGetPassword() {
		String expected = "test_password";
		classUnderTest = new Account();
		
		classUnderTest.setPassword(expected);	
		String actual = classUnderTest.getPassword();
		
		assertTrue(expected.equals(actual));
	}

}
