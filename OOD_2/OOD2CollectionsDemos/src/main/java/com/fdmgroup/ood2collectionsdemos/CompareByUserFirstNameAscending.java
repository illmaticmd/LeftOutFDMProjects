package com.fdmgroup.ood2collectionsdemos;

import java.util.Comparator;

public class CompareByUserFirstNameAscending implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}
