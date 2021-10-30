/**
 * 
 */
package com.titaniam.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Syedyasiraswath
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({AtpMatchesException.class})
	public ResponseEntity<Object> handleAll(AtpMatchesException ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "Error Occured");
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
