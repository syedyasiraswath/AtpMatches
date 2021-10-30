/**
 * 
 */
package com.titaniam.demo.service;

import java.util.List;

import com.titaniam.demo.form.ResultOneForm;
import com.titaniam.demo.form.SurfaceResultForm;
import com.titaniam.demo.form.SurfaceYearResultForm;

/**
 * @author Syedyasiraswath
 * 
 * Interface for Atp Matches Service.
 *
 */
public interface AtpMatchesService {

	/**
	 * @param year
	 * @return
	 */
	public List<ResultOneForm> getByYear(Long year);
	
	/**
	 * @param year
	 * @param surface
	 * @return
	 */
	public SurfaceResultForm getByYearAndSurface(Long year, String surface);

	/**
	 * @param fromYear
	 * @param toYear
	 * @param surface
	 * @return
	 */
	public SurfaceYearResultForm findByBetweenYearsAndSurface(Long fromYear, Long toYear, String surface);

	

}
