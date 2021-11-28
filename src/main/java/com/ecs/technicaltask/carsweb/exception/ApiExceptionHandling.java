package com.ecs.technicaltask.carsweb.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ecs.technicaltask.carsweb.util.ApiDateTime;

@ControllerAdvice
public class ApiExceptionHandling {

	@Autowired
	ApiErrorResponse errorResponse;

	@Autowired
	ApiDateTime timestamp;

	/**
	 * Adding generic exception handling
	 */

	public ResponseEntity<ApiErrorResponse> handleException(Exception exc) {
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimestamp(timestamp.getCurrentDate());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Custom error response
	 */

	public ResponseEntity<ApiErrorResponse> handleException(ApiException exc) {

		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimestamp(timestamp.getCurrentDate());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
