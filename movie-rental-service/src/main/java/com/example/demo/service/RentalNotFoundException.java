package com.example.demo.service;

@SuppressWarnings("serial")
public class RentalNotFoundException extends RuntimeException {

	private String message;

	public RentalNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
