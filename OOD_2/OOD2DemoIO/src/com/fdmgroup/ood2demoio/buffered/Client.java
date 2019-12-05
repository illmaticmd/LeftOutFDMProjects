package com.fdmgroup.ood2demoio.buffered;

public class Client {

	public static void main(String[] args) {
		
		ReadFromWriteTo readFromWriteTo;
		readFromWriteTo = new ReadFromWriteTo("data/example.txt", "output.txt");		
		readFromWriteTo.getPut();
	}
}
