package com.ecs.technicaltask.carsweb.exception;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(String message) {
		super(message);
	}

}
