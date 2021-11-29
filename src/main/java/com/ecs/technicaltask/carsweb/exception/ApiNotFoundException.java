package com.ecs.technicaltask.carsweb.exception;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ApiNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApiNotFoundException(Throwable cause) {
		super(cause);
	}

	public ApiNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiNotFoundException(String message) {
		super(message);
	}

}
