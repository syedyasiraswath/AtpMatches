/**
 * 
 */
package com.titaniam.demo.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * @author Syedyasiraswath
 *
 */
@Data
public class ApiError {
	
	private HttpStatus status;
	private String message;
	private List<String> errors;
	
	/**
	 * @param status
	 * @param message
	 * @param errors
	 */
	public ApiError(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}
	
	/**
	 * @param status
	 * @param message
	 * @param error
	 */
	public ApiError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

}
