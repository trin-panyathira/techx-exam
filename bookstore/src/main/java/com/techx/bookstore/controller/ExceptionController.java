package com.techx.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techx.bookstore.exception.CustomeException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		var msg = exception.getMessage();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg); 
	}
	
	@ExceptionHandler(value = CustomeException.class)
	public ResponseEntity<Object> exception(CustomeException exception) {
		var msg = exception.getMessage();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg); 
	}
}
