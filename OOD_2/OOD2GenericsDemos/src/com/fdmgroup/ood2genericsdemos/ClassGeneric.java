package com.fdmgroup.ood2genericsdemos;

/*An example user-defined generic class.*/

public class ClassGeneric<T> {
	
	private T t;

	public ClassGeneric(T t) {
		super();
		this.t = t;
	}

	T getT() {
		return t;
	}

	void setT(T t) {
		this.t = t;
	}
}
