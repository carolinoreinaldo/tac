package com.tac.exceptions;

public class IdAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5824095172988332721L;
	
	public IdAlreadyExistException(String message) {
		super(message);
	}

}
