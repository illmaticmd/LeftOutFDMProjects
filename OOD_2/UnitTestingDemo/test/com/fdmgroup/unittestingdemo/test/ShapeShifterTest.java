package com.fdmgroup.unittestingdemo.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static com.fdmgroup.unittestingdemo.shapes.ShapeShifter.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.unittestingdemo.shapes.Circle;
import com.fdmgroup.unittestingdemo.shapes.ShapeShifter;
import com.fdmgroup.unittestingdemo.shapes.Square;

public class ShapeShifterTest {
	
	private ShapeShifter classUnderTest;

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
	public void testSquareToCircleReturnsCircumscribedSizedCircleOnSquareForSideAtCircumscribedSizeLimit() {
		//arrange
		classUnderTest = new ShapeShifter();
		Square square = new Square(CIRCUMSCRIBED_SIZE_LIMIT);
		Double expectedRadius = (CIRCUMSCRIBED_SIZE_LIMIT * Math.sqrt(2)) / 2;
		
		//act
		Circle circle = classUnderTest.squareToCircle(square);
		
		//assert
		assertEquals(expectedRadius, circle.getRadius(), 0.00001);
	}
	
	@Test
	public void testSquareToCircleReturnsInscribedSizedCircleOnSquareForSideGreaterThanCircumscribedSizeLimit() {
		//arrange
		classUnderTest = new ShapeShifter();
		Square square = new Square(CIRCUMSCRIBED_SIZE_LIMIT + 1);
		Double expectedRadius = (CIRCUMSCRIBED_SIZE_LIMIT + 1) / 2.0;
		
		//act
		Circle circle = classUnderTest.squareToCircle(square);
		
		//assert
		assertEquals(expectedRadius, circle.getRadius(), 0.00001);
	}
	
	@Test
	public void testSquareToCircleCallsGetDiagonalOnSquareForSideAtCircumscribedSizeLimit() {
		//arrange
		classUnderTest = new ShapeShifter();
		Square mockSquare = mock(Square.class);
		when(mockSquare.getSide()).thenReturn(CIRCUMSCRIBED_SIZE_LIMIT);
		
		//act
		classUnderTest.squareToCircle(mockSquare);
		
		//assert
		verify(mockSquare, times(1)).getDiagonal();
	}
	
	@Test
	public void testSquareToCircleCallsGetSideTwiceOnSquareForSideGreaterThanCircumscribedSizeLimit() {
		//arrange
		classUnderTest = new ShapeShifter();
		Square mockSquare = mock(Square.class);
		when(mockSquare.getSide()).thenReturn(CIRCUMSCRIBED_SIZE_LIMIT + 1);
		
		//act
		classUnderTest.squareToCircle(mockSquare);
		
		//assert
		verify(mockSquare, times(2)).getSide();
	}
}
