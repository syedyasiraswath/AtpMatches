/**
 * 
 */
package com.titaniam.demo.form;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Syedyasiraswath
 * 
 * POJO class for the result of problem statement 1
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultOneForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3703195654351990562L;

	@JsonProperty("countryCode")
	private String countryCode;

	@JsonProperty("count")
	private Integer count;

	public ResultOneForm() {
		//default constructor
	}

}
