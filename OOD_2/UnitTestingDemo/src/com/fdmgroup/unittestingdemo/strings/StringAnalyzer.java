package com.fdmgroup.unittestingdemo.strings;

public class StringAnalyzer {
	
	private void validate(String str) {

		if (str == null || str.trim().isEmpty()) {
			throw new IllegalArgumentException("encountered null input argument.");
		}
	}

	/*
	 * iterative version...
	 */
	public boolean isPalindrome(String input) {

		validate(input);

		int inputLength = input.length();
		int indexBoundary = inputLength / 2;

		for (int i = 0; i < indexBoundary; i++) {
			if (input.charAt(i) != input.charAt(inputLength - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * re-factored to a recursive version....
	 */
//	public boolean isPalindrome(String input) {
//
//		validate(input);
//
//		return doEndsMatch(input, 0, input.length() - 1);
//	}
//
//	private boolean doEndsMatch(String input, int startIndex, int endIndex) {
//
//		if (startIndex > endIndex) {
//			
//			return true;
//		}
//
//		if (input.charAt(startIndex) != input.charAt(endIndex)) {
//			
//			return false;
//		} else {
//			
//			return doEndsMatch(input, ++startIndex, --endIndex);
//		}
//	}
}
