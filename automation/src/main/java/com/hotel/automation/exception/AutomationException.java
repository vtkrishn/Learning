package com.hotel.automation.exception;

@SuppressWarnings("serial")
public class AutomationException extends Exception {
	public AutomationException(String message) {
		super(message);
	}
	
	public AutomationException(String userMessage, Exception exception) {
		super(userMessage, exception);
	}
}
