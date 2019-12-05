package com.fdmgroup.unittestingdemo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.unittestingdemo.shapes.Square;

public class SquareTest {

	private Square classUnderTest;

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
		Object classUnderTest = new Square(5);
		assertTrue(classUnderTest instanceof Square);
	}

	@Test
	public void testGetSideOnSquareIntializedWithPositiveFive() {
		// arrange
		classUnderTest = new Square(5);
		int expected = 5;

		// act
		int actual = classUnderTest.getSide();

		// assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSideOnSquareInitializedWithNegativeFive() {
		// arrange
		classUnderTest = new Square(-5);
		int expected = 5;

		// act
		int actual = classUnderTest.getSide();

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPerimeterOnSideFive() {
		// arrange
		classUnderTest = new Square(5);
		int expected = 20;

		// act
		int actual = classUnderTest.getPerimeter();

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testGetAreaOnSideFive() {
		// arrange
		classUnderTest = new Square(5);
		int expected = 25;

		// act
		int actual = classUnderTest.getArea();

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDiagonalOnSideFive() {
		// arrange
		classUnderTest = new Square(5);
		double expected = 7.07;

		// act
		double actual = classUnderTest.getDiagonal();

		// assert
		assertEquals(expected, actual, 0.0010679);
	}
}
