package com.example.demo.exceptions;

public class ElementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	private String errorMessage;

	

	public ElementNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage=errorMessage;
	}



	@Override
	public String getMessage() {
		return this.errorMessage;
	}
	
	
}
