package com.example.prices.exceptions;

public class PricesException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public PricesException(String message) {
		super(message);
	}
	
	public PricesException() {
	}
}
