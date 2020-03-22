package com.spittr.exception.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spittr.exception.DuplicateSpitterException;

@ControllerAdvice
@Component
public class AppWideExceptionHandler {
	
	
	@ExceptionHandler(value = DuplicateSpitterException.class)
	public String handleDuplicateSpittle() {
		System.out.println("Duplicate spittle found");
		return "error/duplicate";
	}
	

}
