package com.fdmgroup.ood2exceptionsdemo;

public class AccountsManagerUncheckedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountsManagerUncheckedException() {
		
	}

	public AccountsManagerUncheckedException(String message) {
		super(message);
		
	}

	public AccountsManagerUncheckedException(Throwable cause) {
		super(cause);
		
	}

	public AccountsManagerUncheckedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountsManagerUncheckedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
}
