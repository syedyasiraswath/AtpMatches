/**
 * 
 */
package com.titaniam.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.titaniam.demo.form.ResultOneForm;
import com.titaniam.demo.form.SurfaceResultForm;
import com.titaniam.demo.form.SurfaceYearResultForm;
import com.titaniam.demo.service.AtpMatchesService;

/**
 * @author Syedyasiraswath
 *
 */
@RestController
@RequestMapping("secured/api/controller")
public class AtpMatchesController {

	Logger logger = LoggerFactory.getLogger(AtpMatchesController.class);

	@Autowired
	private AtpMatchesService atpMatchesService;

	/**
	 * @param idTransaction
	 * @return
	 * @throws TransactionDetailException
	 */
	@GetMapping(value = "/country", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResultOneForm>> getByYear(@RequestParam("year") Long year) {
		List<ResultOneForm> forms = atpMatchesService.getByYear(year);
		logger.info(forms.toString());
		return new ResponseEntity<List<ResultOneForm>>(forms, HttpStatus.OK);
	}

	/**
	 * @param year
	 * @param surface
	 * @return
	 */
	@GetMapping(value = "/winners", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SurfaceResultForm> getByYearAndSurface(@RequestParam("year") Long year,
			@RequestParam("surface") String surface) {
		SurfaceResultForm form = atpMatchesService.getByYearAndSurface(year, surface);
		logger.info(form.toString());
		return new ResponseEntity<SurfaceResultForm>(form, HttpStatus.OK);
	}

	/**
	 * @param fromYear
	 * @param toYear
	 * @param surface
	 * @return
	 */
	@GetMapping(value = "/winners/between/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SurfaceYearResultForm> getByBetweenYearsAndSurface(@RequestParam("from-year") Long fromYear,
			@RequestParam("to-year") Long toYear, @RequestParam("surface") String surface) {
		SurfaceYearResultForm form = atpMatchesService.findByBetweenYearsAndSurface(fromYear,toYear,surface);
		logger.info(form.toString()); 
		return new ResponseEntity<SurfaceYearResultForm>(form, HttpStatus.OK);
	}

}
