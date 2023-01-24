package com.jspiders;

public class InvalidQuanyityException extends RuntimeException {
	private String message;

	public InvalidQuanyityException(String message) {
		
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
