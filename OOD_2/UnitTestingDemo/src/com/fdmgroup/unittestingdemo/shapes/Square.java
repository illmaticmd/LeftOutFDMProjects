package com.fdmgroup.unittestingdemo.shapes;

public class Square {

	private int side;

	public Square(int side) {
		
		this.side = Math.abs(side);
	}

	public int getSide() {

		return side;
	}

	public int getPerimeter() {

		return 4 * side;
	}

	public int getArea() {

		return side * side;
	}

	public double getDiagonal() {

		return side * Math.sqrt(2.0);
	}
}
