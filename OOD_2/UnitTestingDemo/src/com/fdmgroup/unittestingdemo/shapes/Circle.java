package com.fdmgroup.unittestingdemo.shapes;

public class Circle {
	
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = Math.abs(radius);
	}
	
	public double getRadius() {
		
		return radius;
	}
}
