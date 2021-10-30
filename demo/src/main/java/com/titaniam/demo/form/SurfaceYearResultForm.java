/**
 * 
 */
package com.titaniam.demo.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Syedyasiraswath
 * 
 * POJO class for the Surface result form.
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurfaceYearResultForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5451774687873279476L;

	@JsonProperty("from")
	private Long from;
	
	@JsonProperty("to")
	private Long to;

	@JsonProperty("surface")
	private String surface;

	@JsonProperty("winnerResultForm")
	private List<WinnerResultForm> winnerResultForm = new ArrayList<>();

	public SurfaceYearResultForm() {
		// default constructor
	}

}
