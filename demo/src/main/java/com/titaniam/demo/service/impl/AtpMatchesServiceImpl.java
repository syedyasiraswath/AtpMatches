/**
 * 
 */
package com.titaniam.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titaniam.demo.entity.AtpMatchesEntity;
import com.titaniam.demo.form.ResultOneForm;
import com.titaniam.demo.form.SurfaceResultForm;
import com.titaniam.demo.form.SurfaceYearResultForm;
import com.titaniam.demo.form.WinnerResultForm;
import com.titaniam.demo.repository.AtpMatchesRepository;
import com.titaniam.demo.service.AtpMatchesService;

/**
 * @author Syedyasiraswath
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpMatchesServiceImpl implements AtpMatchesService {

	@Autowired
	private AtpMatchesRepository atpMatchesRepository;

	/**
	 *
	 */
	@Override
	public List<ResultOneForm> getByYear(Long year) {
		List<ResultOneForm> forms = new ArrayList<>();
		List<AtpMatchesEntity> allList = atpMatchesRepository.findAllByYear(year);
		if (CollectionUtils.isNotEmpty(allList)) {
			HashMap<String, Set<Long>> map = new HashMap<>();
			for (AtpMatchesEntity atpMatchesEntity : allList) {
				if (map.get(atpMatchesEntity.getWinnerIoc()) == null) {
					Set<Long> s1 = new HashSet<>();
					s1.add(atpMatchesEntity.getWinnerId());
					map.put(atpMatchesEntity.getWinnerIoc(), s1);
				} else {
					Set<Long> s2 = map.get(atpMatchesEntity.getWinnerIoc());
					s2.add(atpMatchesEntity.getWinnerId());
					map.put(atpMatchesEntity.getWinnerIoc(), s2);
				}
			}
			for (AtpMatchesEntity atpMatchesEntity : allList) {
				if (map.get(atpMatchesEntity.getLoserIoc()) == null) {
					Set<Long> s1 = new HashSet<>();
					s1.add(atpMatchesEntity.getLoserId());
					map.put(atpMatchesEntity.getLoserIoc(), s1);
				} else {
					Set<Long> s2 = map.get(atpMatchesEntity.getLoserIoc());
					s2.add(atpMatchesEntity.getLoserId());
					map.put(atpMatchesEntity.getLoserIoc(), s2);
				}
			}
			HashMap<String, Integer> countMap = new HashMap<>();
			Set<Entry<String, Set<Long>>> entrySet = map.entrySet();
			for (Entry<String, Set<Long>> entry : entrySet) {
				if (countMap.get(entry.getKey()) == null) {
					Set<Long> s3 = entry.getValue();
					countMap.put(entry.getKey(), s3.size());
				}
			}
			Set<Entry<String, Integer>> entrySet1 = countMap.entrySet();
			for (Entry<String, Integer> entry : entrySet1) {
				ResultOneForm form = new ResultOneForm();
				form.setCount(entry.getValue());
				form.setCountryCode(entry.getKey());
				forms.add(form);
			}

		}
		return forms;
	}

	/**
	 *
	 */
	@Override
	public SurfaceResultForm getByYearAndSurface(Long year, String surface) {
		SurfaceResultForm form = new SurfaceResultForm();
		List<Object[]> list = atpMatchesRepository.findByYearAndSurface(year, surface);
		if (CollectionUtils.isNotEmpty(list)) {
			form.setSurface(surface);
			form.setYear(year);
			List<WinnerResultForm> winnerForms = new ArrayList<>();
			for (Object[] objects : list) {
				WinnerResultForm winnerForm = new WinnerResultForm();
				winnerForm.setCount(Integer.parseInt(objects[1].toString()));
				winnerForm.setWinnerId(Long.parseLong(objects[0].toString()));
				winnerForms.add(winnerForm);
			}
			form.setWinnerResultForm(winnerForms);
		}
		return form;
	}

	/**
	 *
	 */
	@Override
	public SurfaceYearResultForm findByBetweenYearsAndSurface(Long fromYear, Long toYear, String surface) {
		SurfaceYearResultForm form = new SurfaceYearResultForm();
		List<Object[]> list = atpMatchesRepository.findByBetweenYearsAndSurface(fromYear, toYear, surface);
		if (CollectionUtils.isNotEmpty(list)) {
			form.setSurface(surface);
			form.setFrom(fromYear);
			form.setTo(toYear);
			List<WinnerResultForm> winnerForms = new ArrayList<>();
			for (Object[] objects : list) {
				WinnerResultForm winnerForm = new WinnerResultForm();
				winnerForm.setCount(Integer.parseInt(objects[1].toString()));
				winnerForm.setWinnerId(Long.parseLong(objects[0].toString()));
				winnerForms.add(winnerForm);
			}
			form.setWinnerResultForm(winnerForms);
		}
		return form;
	}

}
