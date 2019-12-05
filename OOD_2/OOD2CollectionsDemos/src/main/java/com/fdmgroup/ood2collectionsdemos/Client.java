package com.fdmgroup.ood2collectionsdemos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Client {

	public static void main(String[] args) {
		
		User johnSmith = new User("John", "Smith", "jsmith", "johnsmith@smithy.com");
		User jackieSmith = new User("Jackie", "Smith", "jsmith", "jackiesmith@smithy.com");
		User jeremySmith = new User("Jeremy", "Smith", "jsmith", "jeremysmith@smithy.com");
				
		Set<User> usersSet = new HashSet<>();
		
		usersSet.add(johnSmith);
		usersSet.add(jackieSmith);
		usersSet.add(jeremySmith);
		
//		Refer to the overridden implementations of User#hashcode() and User#equals().
//		Why are the current contents of userSets as such?
		System.out.println("usersSet contains:");
		System.out.println(usersSet);
		
		Map<Integer, User> usersMappedById = new HashMap<>();
		
		usersMappedById.put(johnSmith.getId(), johnSmith);
		usersMappedById.put(jackieSmith.getId(), jackieSmith);
		usersMappedById.put(jeremySmith.getId(), jeremySmith);

		System.out.println("usersMappedById contains:");
		System.out.println(usersMappedById);
		
		Map<String, User> usersMappedByUsername = new HashMap<>();
		
		usersMappedByUsername.put(johnSmith.getUsername(), johnSmith);
		usersMappedByUsername.put(jackieSmith.getUsername(), jackieSmith);
		User userReturnedFromMap = usersMappedByUsername.put(jeremySmith.getUsername(), jeremySmith);

//		Why are the the contents of usersMappedById different than the contents of usersMappedByUsername ?
		System.out.println("usersMappedByUsername contains:");
		System.out.println(usersMappedByUsername);		
		System.out.println("userReturnedFromMap= " + userReturnedFromMap);
		
		User georgeWashington = new User("George", "Washington", "gwashington", "gwashington@uspresident.com");
		User johnAdams = new User("John", "Adams", "jadams", "jadams@uspresident.com");
		
		List<User> usersList = new ArrayList<>();
		
		usersList.add(georgeWashington);
		usersList.add(jeremySmith);
		usersList.add(johnSmith);
		usersList.add(johnAdams);
		usersList.add(jackieSmith);
		
		System.out.println("usersList unsorted:");
		for (User user : usersList) {
			System.out.println(user);
		}
		
		Collections.sort(usersList);
		
		System.out.println("usersList sorted by implementation of User#compareTo():");
		for (User user : usersList) {
			System.out.println(user);
		}
		
		Comparator<User> compareByUserIdDescending = new CompareByUserIdDescending();
		Collections.sort(usersList, compareByUserIdDescending);
		
		System.out.println("usersList sorted by implementation of comparator CompareByUserIdDescending:");
		for (User user : usersList) {
			System.out.println(user);
		}
		
		Comparator<User> compareByUserLastNameAscending = new CompareByUserLastNameAscending();
		Collections.sort(usersList, compareByUserLastNameAscending);
		
		System.out.println("usersList sorted by implementation of comparator CompareByUserLastNameAscending:");
		for (User user : usersList) {
			System.out.println(user.getLastName() + ", " + user.getFirstName());
		}
		
		Comparator<User> compareByUserFirstNameAscending = new CompareByUserFirstNameAscending();
		Collections.sort(usersList, compareByUserLastNameAscending.thenComparing(compareByUserFirstNameAscending));
		
		System.out.println("Now, further sorted by comparator CompareByUserFirstNameAscending:");
		for (User user : usersList) {
			System.out.println(user.getLastName() + ", " + user.getFirstName());
		}	
	}
}
