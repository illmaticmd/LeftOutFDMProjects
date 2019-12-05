package com.fdmgroup.demolog4j2andjavadocs.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.demolog4j2andjavadocs.data.AccountInMemoryDao;
import com.fdmgroup.demolog4j2andjavadocs.data.Crudable;
import com.fdmgroup.demolog4j2andjavadocs.model.Account;

public class AccountInMemoryDaoTest {
	
	private Crudable<Account, String> classUnderTest;

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
	public void testInstantiationClassUnderTest() {
		List<Account> inputAccountList = new ArrayList<>();
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		assertTrue(classUnderTest instanceof AccountInMemoryDao);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInstantiationClassUnderTestThrowsOnNullInputList() {
		classUnderTest = new AccountInMemoryDao(null);
		assertTrue(classUnderTest instanceof AccountInMemoryDao);
	}
	
	@Test
	public void testCreateAddsAccount() {
		
		List<Account> inputAccountList = new ArrayList<>();
		int expectedResultListSize = inputAccountList.size() + 1;
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		Account mockAccount = mock(Account.class);
		
		boolean created = classUnderTest.create(mockAccount);
		
		if (created) {
			assertEquals(expectedResultListSize, inputAccountList.size());
		} else {
			fail();
		}	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateThrowsOnNullAccountArgument() {
		List<Account> inputAccountList = new ArrayList<>();
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		classUnderTest.create(null);
	}
	
	@Test
	public void testReadReturnsAccountOnMatchedUsername() {
		List<Account> inputAccountList = new ArrayList<>();
		String mockUsername = "mockUsername";
		Account mockAccount = mock(Account.class);
		when(mockAccount.getUsername()).thenReturn(mockUsername);
		inputAccountList.add(mockAccount);
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		Optional<Account> optionalAccount = classUnderTest.read(mockUsername);
		
		if (optionalAccount.isPresent()) {
			Account readAccount = optionalAccount.get();
			assertEquals(mockAccount, readAccount);
		} else {
			fail("An account is not contained in the returned optional!");
		}	
	}
	
	@Test
	public void testReadReturnsEmptyOptionalOnUnMatchedUsername() {
		List<Account> inputAccountList = new ArrayList<>();
		String mockUsername = "mockUsername";
		String notMockUsername = "notMockUsername";
		Account mockAccount = mock(Account.class);
		when(mockAccount.getUsername()).thenReturn(mockUsername);
		inputAccountList.add(mockAccount);
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		Optional<Account> optionalAccount = classUnderTest.read(notMockUsername);
		
		assertFalse(optionalAccount.isPresent());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testReadThrowsOnNullUsernameInput() {
		List<Account> inputAccountList = new ArrayList<>();
		Account mockAccount = mock(Account.class);
		inputAccountList.add(mockAccount);
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		classUnderTest.read(null);
	}
	
	@Test
	public void testUpdateCallsGetPasswordOnInputAccountWhenFoundAccount() {
		String sameUsername = "matchedUsername";
		List<Account> inputAccountList = new ArrayList<>();
		Account mockAccountElement = mock(Account.class);
		when(mockAccountElement.getUsername()).thenReturn(sameUsername);
		inputAccountList.add(mockAccountElement);
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		Account mockAccountArgument = mock(Account.class);
		when(mockAccountArgument.getUsername()).thenReturn(sameUsername);
		
		boolean updated = classUnderTest.update(mockAccountArgument);
		
		if(updated) {
			verify(mockAccountArgument, times(1)).getPassword();
		} else {
			fail();
		}
	}
	
	@Test
	public void testUpdateDoesNotCallGetPasswordOnInputAccountWhenAccountNotFound() {
		String mockUsername = "mockUsername";
		Account mockAccountElement = mock(Account.class);
		when(mockAccountElement.getUsername()).thenReturn(mockUsername);
		List<Account> inputAccountList = new ArrayList<>();
		inputAccountList.add(mockAccountElement);
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		String notMockUsername = "notMockUsername";
		Account mockAccountArgument = mock(Account.class);
		when(mockAccountArgument.getUsername()).thenReturn(notMockUsername);
		
		boolean updated = classUnderTest.update(mockAccountArgument);
		
		if(!updated) {
			verify(mockAccountArgument, times(0)).getPassword();
		} else {
			fail();
		}
	}
	
	@Test
	public void testUpdateCallsSetPasswordOnFoundAccount() {
		String mockElementUsername = "mockUsername";
		Account mockAccountElement = mock(Account.class);
		when(mockAccountElement.getUsername()).thenReturn(mockElementUsername);
		
		List<Account> inputAccountList = new ArrayList<>();
		inputAccountList.add(mockAccountElement);
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		Account mockAccountArgument = mock(Account.class);
		when(mockAccountArgument.getUsername()).thenReturn(mockElementUsername);
		String mockArgumentPassword = "mockPassword";
		when(mockAccountArgument.getPassword()).thenReturn(mockArgumentPassword);
		
		boolean updated = classUnderTest.update(mockAccountArgument);
		
		if(updated) {
			verify(mockAccountElement, times(1)).setPassword(anyString());
		} else {
			fail();
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUpdateThrowsOnNullAccountArgument() {
		List<Account> inputAccountList = new ArrayList<>();
		Account mockAccount = mock(Account.class);
		inputAccountList.add(mockAccount);
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		classUnderTest.update(null);
	}
	
	
	@Test
	public void testDeleteOnMatchedUsername() {
		
		String mockUsername = "mockUsername";
		Account mockAccountElement = mock(Account.class);
		when(mockAccountElement.getUsername()).thenReturn(mockUsername);
		
		List<Account> inputAccountList = new ArrayList<>();
		inputAccountList.add(mockAccountElement);
		int expectedResultListSize = inputAccountList.size() - 1;
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		boolean deleted = classUnderTest.delete(mockUsername);
		
		if(deleted) {
			assertEquals(expectedResultListSize, inputAccountList.size());
		} else {
			fail();
		}
	}
	
	@Test
	public void testDeleteOnUnMatchedUsername() {
		
		String mockUsername = "mockUsername";
		Account mockAccountElement = mock(Account.class);
		when(mockAccountElement.getUsername()).thenReturn(mockUsername);
		
		List<Account> inputAccountList = new ArrayList<>();
		inputAccountList.add(mockAccountElement);
		int expectedResultListSize = inputAccountList.size();
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		String notMockUsername = "notMockUsername";
		
		boolean deleted = classUnderTest.delete(notMockUsername);
		
		if(!deleted) {
			assertEquals(expectedResultListSize, inputAccountList.size());
		} else {
			fail();
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDeleteThrowsOnNullUsernameArgument() {
		List<Account> inputAccountList = new ArrayList<>();
		Account mockAccount = mock(Account.class);
		inputAccountList.add(mockAccount);
		classUnderTest = new AccountInMemoryDao(inputAccountList);
		
		classUnderTest.delete(null);
	}
}
