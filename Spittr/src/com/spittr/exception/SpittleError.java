package com.spittr.exception;

public class SpittleError {
	
	private String message;
	private int code;
	
	
	public SpittleError(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public int getCode() {
		return code;
	}

}
