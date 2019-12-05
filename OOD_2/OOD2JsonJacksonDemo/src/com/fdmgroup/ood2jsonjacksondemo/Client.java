package com.fdmgroup.ood2jsonjacksondemo;

import static com.fdmgroup.ood2jsonjacksondemo.UserJsonPersistenceManager.*;

import java.io.File;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		File file = new File(JSON_PATH);
		if (file.exists()) {
			file.delete();
		}

		User clarkKent = new User("Clark", "Kent", "ckent", "superman");
		System.out.println("clarkKent    : " + clarkKent);
		
		UserJsonPersistenceManager userJsonPersistenceManager = new UserJsonPersistenceManager();
		userJsonPersistenceManager.serialize(clarkKent);
		
		User retrievedUser = userJsonPersistenceManager.deserialize();
		System.out.println("retrievedUser: " + retrievedUser);
		
		System.out.print("'clarkKent' and 'retrievedUser' ");
		if (clarkKent == retrievedUser) {
			System.out.println("are referencing the same objects in memory.");
		} else {
			System.out.println("are not referencing the same object in memory.");
		}
		System.out.println();
		
		User bruceWayne = new User("Bruce", "Wayne", "bwayne", "batman");
		User peterParker = new User("Peter", "Parker", "pparker", "spiderman");	
		userJsonPersistenceManager.write(bruceWayne, peterParker);
	
		System.out.println("Deserialized users...");
		List<User> retrievedUsers = userJsonPersistenceManager.read();
		for (User user : retrievedUsers) {
			System.out.println(user);
		}
	}
}
