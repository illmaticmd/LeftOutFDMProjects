package com.fdmgroup.ood2serializationdemo;

public class Client {

	public static void main(String[] args) {

		User clarkKent = new User("Clark", "Kent", "ckent", "superman");
		System.out.println("clarkKent    : " + clarkKent);
		
		PersistUser persistUser = new PersistUser();
		persistUser.serializeUser(clarkKent);
		
		User retrievedUser = persistUser.deSerializeUser();
		System.out.println("retrievedUser: " + retrievedUser);
		
		System.out.print("'clarkKent and 'retrievedUser' ");
		if (clarkKent == retrievedUser) {
			System.out.println("are referencing the same objects in memory.");
		} else {
			System.out.println("are not referencing the same object in memory.");
		}
	}
}