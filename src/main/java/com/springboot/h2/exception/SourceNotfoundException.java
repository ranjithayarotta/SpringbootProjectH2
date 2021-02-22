package com.springboot.h2.exception;

public class SourceNotfoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SourceNotfoundException(String errorMessage) {
		super(errorMessage);
	}
}
