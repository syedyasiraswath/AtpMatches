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
public class SurfaceResultForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 16293539424996073L;

	@JsonProperty("year")
	private Long year;

	@JsonProperty("surface")
	private String surface;

	@JsonProperty("winnerResultForm")
	private List<WinnerResultForm> winnerResultForm = new ArrayList<>();

	public SurfaceResultForm() {
		// default constructor
	}

}
