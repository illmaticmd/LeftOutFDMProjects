package com.fdmgroup.ood2genericsdemos;

import java.util.ArrayList;
import java.util.List;

public class TypedCollection {

	/* An example user-defined generic method. */

	public <T> List<T> getList(T t) {

		List<T> listOfT = new ArrayList<>();
		listOfT.add(t);

		return listOfT;
	}
}
