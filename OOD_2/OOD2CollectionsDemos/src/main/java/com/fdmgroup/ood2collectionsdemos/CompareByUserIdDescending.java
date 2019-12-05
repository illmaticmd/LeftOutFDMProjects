package com.fdmgroup.ood2collectionsdemos;

import java.util.Comparator;

public class CompareByUserIdDescending implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		return o2.getId() - o1.getId();
	}

}
