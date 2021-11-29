package com.ecs.technicaltask.carsweb.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecs.technicaltask.carsweb.util.ApiDateTime;

@ControllerAdvice
public class ApiExceptionHandling {

	@Autowired
	ApiErrorResponse errorResponse;

	@Autowired
	ApiDateTime timestamp;

	/**
	 * Custom error response
	 */
	@ExceptionHandler(value = ApiNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleException(ApiNotFoundException exc) {

		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimestamp(timestamp.getCurrentDate());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
