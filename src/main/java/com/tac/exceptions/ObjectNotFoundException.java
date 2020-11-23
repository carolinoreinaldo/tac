package com.tac.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8683064368700607942L;
	
	public ObjectNotFoundException(String message) {
		super(message);
	}

}
