package com.fdmgroup.unittestingdemo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.unittestingdemo.strings.StringAnalyzer;

public class StringAnalyzerTest {
	
	private StringAnalyzer classUnderTest;

	@BeforeClass
	public static void setUpBeforeClass() {
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsPalindromeReturnsTrueOnStringLengthOne() {
		//arrange
		String input = "a";
		boolean expected = true;
		classUnderTest = new StringAnalyzer();
		
		//act
		boolean actual = classUnderTest.isPalindrome(input);
		
		//assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsPalindromeReturnsTrueOnStringLengthTwoEndsMatched() {
		//arrange
		String input = "aa";
		classUnderTest = new StringAnalyzer();
		
		//act
		boolean actual = classUnderTest.isPalindrome(input);
		
		//assert
		assertTrue(actual);
	}
	
	@Test
	public void testIsPalindromeReturnsFalseOnStringLengthTwoEndsNotMatched() {
		//arrange
		String input = "ab";
		classUnderTest = new StringAnalyzer();
		
		//act & assert
		assertFalse(classUnderTest.isPalindrome(input));
	}
	
	@Test
	public void testIsPalindromeReturnsTrueOnStringLengthThreeSameCharacters() {
		//arrange
		String input = "aaa";
		classUnderTest = new StringAnalyzer();
		
		//act & assert
		assertTrue(classUnderTest.isPalindrome(input));
	}

	@Test
	public void testIsPalindromeReturnsTrueOnStringLengthThreeEndsMatched() {
		//arrange
		String input = "aba";
		classUnderTest = new StringAnalyzer();
		
		//act & assert
		assertTrue(classUnderTest.isPalindrome(input));
	}
	
	@Test
	public void testIsPalindromeReturnsFalseOnStringLengthThreeEndsNotMatched() {
		//arrange
		String input = "abc";
		classUnderTest = new StringAnalyzer();
		
		//act & assert
		assertFalse(classUnderTest.isPalindrome(input));
	}
	
	@Test
	public void testIsPalindromeReturnsTrueOnStringLengthFourSameCharacters() {
		//arrange
		String input = "aaaa";
		classUnderTest = new StringAnalyzer();
		
		//act & assert
		assertTrue(classUnderTest.isPalindrome(input));
	}
	
	@Test
	public void testIsPalindromeReturnsTrueOnStringLengthFourInnersAndEndsMatched() {
		//arrange
		String input = "abba";
		classUnderTest = new StringAnalyzer();
		
		//act & assert
		assertTrue(classUnderTest.isPalindrome(input));
	}
	
	@Test
	public void testIsPalindromeReturnsFalseOnStringLengthFourInnersNotMatched() {
		//arrange
		String input = "abca";
		classUnderTest = new StringAnalyzer();
		
		//act & assert
		assertFalse(classUnderTest.isPalindrome(input));
	}
	
	@Test
	public void testIsPalindromeReturnsTrueOnInput_step_on_no_pets() {
		//arrange
		String input = "step on no pets";
		classUnderTest = new StringAnalyzer();
		
		//act & assert
		assertTrue(classUnderTest.isPalindrome(input));
	}
	
	@Test(expected=IllegalArgumentException.class) //assert
	public void testIsPalindromeThrowsOnNullInput() {
		//arrange
		String input = null;
		classUnderTest = new StringAnalyzer();
		
		//act
		classUnderTest.isPalindrome(input);
	}
	
	@Test(expected=IllegalArgumentException.class) //assert
	public void testIsPalindromeThrowsOnEmptyStringInput() {
		//arrange
		String input = "";
		classUnderTest = new StringAnalyzer();
		
		//act
		classUnderTest.isPalindrome(input);
	}
	
	@Test(expected=IllegalArgumentException.class) //assert
	public void testIsPalindromeThrowsOnAllSpacesStringInput() {
		//arrange
		String input = "   ";
		classUnderTest = new StringAnalyzer();
		
		//act
		classUnderTest.isPalindrome(input);
	}
}
