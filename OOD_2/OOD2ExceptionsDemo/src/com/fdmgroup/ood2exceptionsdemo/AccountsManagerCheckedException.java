package com.fdmgroup.ood2exceptionsdemo;

public class AccountsManagerCheckedException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountsManagerCheckedException() {
		
	}

	public AccountsManagerCheckedException(String message) {
		super(message);
		
	}

	public AccountsManagerCheckedException(Throwable cause) {
		super(cause);
		
	}

	public AccountsManagerCheckedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountsManagerCheckedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
}
