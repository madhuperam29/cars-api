package com.ecs.technicaltask.carsweb.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ApiErrorResponse {
	
	private int status;
	private String message;
	private String timestamp;

}
