/**
 * 
 */
package com.titaniam.demo.form;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Syedyasiraswath
 * 
 * POJO class for the transaction detail form.
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDetailForm implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 8766970041810121862L;
	
	@JsonProperty("idTransaction")
	private Long idTransaction;

	@JsonProperty("transactionName")
	private String transactionName;

	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("updatedBy")
	private String updatedBy;

	@JsonProperty("createdDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date createdDate;
	
	@JsonProperty("updatedDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date updatedDate;
	
	public TransactionDetailForm() {
		//default constructor
	}

}
