package com.project.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	// Exception Handlers

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NotFoundException e) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(e.getMessage());
		response.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(e.getMessage());
		response.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
