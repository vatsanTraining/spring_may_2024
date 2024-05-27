package com.example.demo.utillity;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exceptions.ElementNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

	
	@ExceptionHandler(value = ElementNotFoundException.class)
	public ErrorMessage handleElementNotFoundException(Exception ex,WebRequest req) {
		
		return new ErrorMessage(ex.getMessage(),req.getDescription(false),LocalDateTime.now());
	}
	
	@ExceptionHandler(value = Exception.class)
	public ErrorMessage handleOtherExceptions(Exception ex,WebRequest req) {
		
		return new ErrorMessage(req.getDescription(false),ex.getMessage(),LocalDateTime.now());
	}
	
}
