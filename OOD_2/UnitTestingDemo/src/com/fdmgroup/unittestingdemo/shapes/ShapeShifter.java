package com.fdmgroup.unittestingdemo.shapes;

public class ShapeShifter {
	
	public static final int CIRCUMSCRIBED_SIZE_LIMIT = 50;
	
	public Circle squareToCircle(Square square) {
		
		if (square.getSide() > CIRCUMSCRIBED_SIZE_LIMIT) {
			
			/*
			 * Create inscribed-sized circle...
			 */
			return new Circle((double)square.getSide() / 2); 
		
		} else {
			
			/*
			 * Create circumscribed-sized circle...
			 */
			return new Circle(square.getDiagonal() / 2);
		}
	}
}
