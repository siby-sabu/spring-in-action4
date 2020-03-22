package com.spittr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Spittle not found", value = HttpStatus.NOT_FOUND)
public class SpittleNotFoundException  extends RuntimeException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 12345L;

	public SpittleNotFoundException() {
		super();
	}

}
