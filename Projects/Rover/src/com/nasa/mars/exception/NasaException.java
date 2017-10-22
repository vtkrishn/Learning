package com.nasa.mars.exception;

public class NasaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * NasaException Constructor
	 */
	public NasaException() {
		super();
	}
	
	/**
	 * NasaException Constructor accepting a message
	 * @param message
	 */
	public NasaException(final String message) {
		
		System.out.println(message);
			
	}
}
