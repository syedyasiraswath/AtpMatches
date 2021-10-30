/**
 * 
 */
package com.titaniam.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Syedyasiraswath
 * 
 * Entity class for the ATP_MATCHES database table.
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ATP_MATCHES")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQuery(name = "AtpMatchesEntity.findAll", query = "SELECT a FROM AtpMatchesEntity a")
public class AtpMatchesEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3056759115684873424L;

	@Id
	@Column(name = "ID_ATP")
	private Integer idAtp;
	
	@Column(name = "TOURNEY_ID")
	private String tourneyId;
	
	@Column(name = "TOURNEY_NAME")
	private String tourneyName;
	
	@Column(name = "SURFACE")
	private String surface;
	
	@Column(name = "TOURNEY_YEAR")
	private Long tourneyYear;
	
	@Column(name = "WINNER_ID")
	private Long winnerId;
	
	@Column(name = "WINNER_NAME")
	private String winnerName;
	
	@Column(name = "WINNER_IOC")
	private String winnerIoc;
	
	@Column(name = "LOSER_ID")
	private Long loserId;
	
	@Column(name = "LOSER_NAME")
	private String loserName;
	
	@Column(name = "LOSER_IOC")
	private String loserIoc;
	
	@Column(name = "ROUND")
	private String round;
	
}
