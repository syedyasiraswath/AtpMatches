/**
 * 
 */
package com.titaniam.demo.exception;

import java.io.Serializable;

/**
 * @author Syedyasiraswath
 * 
 * Custom Exception for Atp Matches.
 *
 */
public class AtpMatchesException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7329150168706836589L;

	/**
	 * Default constructor
	 */
	public AtpMatchesException() {
		super();
	}

	/**
	 * @param msg: Error message
	 * 
	 */
	public AtpMatchesException(String msg) {
		super(msg);
	}

	/**
	 * @param msg: Error message
	 * @param e:   Exception type
	 */
	public AtpMatchesException(String msg, Exception e) {
		super(msg, e);
	}

}
