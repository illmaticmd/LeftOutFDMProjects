package com.fdmgroup.ood2genericsdemos;

import java.util.ArrayList;
import java.util.List;

public class Client {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		/*
		 * In the following example, variable 'object' is declared as a raw type
		 * of List and an instance of a raw type of ArrayList is assigned to it.
		 * This is how things were done before Generics were introduced in Java.
		 */
		List objects = new ArrayList();
		int result = 0;
		objects.add(new Integer(21));
		objects.add(new Integer(5));
		objects.add(new Integer(13));
		objects.add(new Integer(2));

		result = parseAndAddInts(objects);
		System.out.println("result = " + result);

		objects = new ArrayList();
		objects.add("21");
		objects.add("5");
		objects.add("Thirteen");
		objects.add("2");

		/*
		 * Here, notice the exception that is thrown at runtime, when an element
		 * that is not type Integer is encountered...
		 */
		// result = parseAndAddInts(objects);
		// System.out.println("result = " + result);

		/*
		 * With Generics, the type argument Integer ensures that the ArrayList
		 * referenced by variable 'integers' can only hold elements that is type
		 * Integer.
		 */
		List<Integer> integers = new ArrayList<>();
		integers.add(new Integer(12));

		/* Below, int literal 33 is autoboxed to an Integer instance. */
		integers.add(33);

		/*
		 * Now, observe the compile-time error that occurs when trying to add an
		 * element that is not type Integer...
		 */
		// integers.add("21");

		/*
		 * Example of obtaining an instance of a user-defined generic class. Try
		 * declaring instances with a different type argument other than type
		 * String.
		 */
		ClassGeneric<String> stringClassGeneric = new ClassGeneric("hello");
		// System.out.println(stringClassGeneric.getT());

		TypedCollection typedCollection = new TypedCollection();
		List<Vehicle> vehicles = typedCollection.getList(new Car());

		/*
		 * Check typedCollection#getList(). Now, try declaring 'vehicles' as
		 * List<Car>. What is the inferred type of T?
		 */
		vehicles.add(new Vehicle());

		/*
		 * Try performing the following three add() operations when variable
		 * 'otherVehicles' is declared in the following ways. Which works and
		 * why?
		 */
		List<Vehicle> otherVehicles = new ArrayList<>();
		// List<? extends Vehicle> otherVehicles = new ArrayList<Vehicle>();
		// List<? super Vehicle> otherVehicles = new ArrayList<Vehicle>();

		otherVehicles.add(new Vehicle());
		otherVehicles.add(new Car());
		otherVehicles.add(new SUV());

		/*
		 * Please see comment to manageList() below.
		 */
		manageList(new ArrayList<Object>());
		manageList(new ArrayList<Vehicle>());
		manageList(new ArrayList<Car>());
	}

	/*
	 * Examples of the use of wildcards in Generics. Try declaring the following
	 * parameter type in manageList() as follows.
	 * 
	 * List<Object>
	 * 
	 * List<? extends Vehicle>
	 * 
	 * List<? super Vehicle>
	 * 
	 * On which invocations of manageList() are compile-time errors observed?
	 */
	public static void manageList(List<?> vehicles) {

		vehicles.size();

		/*
		 * Under which parameter type declaration can the add() operation be
		 * called?
		 */
		// vehicles.add(new Truck());
	}

	@SuppressWarnings("rawtypes")
	private static int parseAndAddInts(List objects) {
		int result = 0;
		for (Object obj : objects) {
			if (obj instanceof Integer) {
				Integer integerObj = (Integer) obj;
				result += integerObj;
			} else {
				throw new IllegalArgumentException("Encountered element not of type Integer.");
			}
		}
		return result;
	}
}
