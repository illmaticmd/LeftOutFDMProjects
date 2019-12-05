package com.fdmgroup.unittestingdemo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.unittestingdemo.shapes.Circle;
import com.fdmgroup.unittestingdemo.shapes.Square;

public class CircleTest {
	
	private Circle classUnderTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstanceClassUnderTest() {
		Object classUnderTest = new Circle(5);
		assertTrue(classUnderTest instanceof Circle);
	}

	@Test
	public void testGetRadiusOnCircleInitializedWithPositiveFive() {
		// arrange
		classUnderTest = new Circle(5);
		double expected = 5;

		// act
		double actual = classUnderTest.getRadius();

		// assert
		assertEquals(expected, actual, 0.00001);
	}
	
	@Test
	public void testGetRadiusOnCircleInitializedWithNegativeFive() {
		// arrange
		classUnderTest = new Circle(-5);
		double expected = 5;

		// act
		double actual = classUnderTest.getRadius();

		// assert
		assertEquals(expected, actual, 0.00001);
	}
}
