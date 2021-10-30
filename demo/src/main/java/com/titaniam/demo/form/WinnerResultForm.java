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
 * POJO class for the Winner result form.
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WinnerResultForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1871253169938442535L;

	@JsonProperty("winnerId")
	private Long winnerId;

	@JsonProperty("count")
	private Integer count;

	public WinnerResultForm() {
		// default constructor
	}

}
