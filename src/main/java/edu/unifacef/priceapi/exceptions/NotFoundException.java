package edu.unifacef.priceapi.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5972204969471406318L;
	
	public NotFoundException (final String message) {
		super(message);
	}

}
