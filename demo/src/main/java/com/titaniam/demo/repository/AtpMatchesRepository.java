/**
 * 
 */
package com.titaniam.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.titaniam.demo.entity.AtpMatchesEntity;

/**
 * @author Syedyasiraswath
 *
 */
@Repository
public interface AtpMatchesRepository
		extends JpaRepository<AtpMatchesEntity, Long>, JpaSpecificationExecutor<AtpMatchesEntity> {

	/**
	 * @param tourneyYear
	 * @return
	 */
	@Query("select entity from AtpMatchesEntity entity where tourneyYear = :tourneyYear")
	public List<AtpMatchesEntity> findAllByYear(@Param("tourneyYear") Long tourneyYear);

	/**
	 * @param tourneyYear
	 * @param surface
	 * @return
	 */
	@Query(value = "SELECT WINNER_ID, COUNT(*) FROM ATP_MATCHES WHERE SURFACE = :surface  AND TOURNEY_YEAR = :tourneyYear AND ROUND = 'F' GROUP BY WINNER_ID ORDER BY WINNER_ID", nativeQuery = true)
	public List<Object[]> findByYearAndSurface(@Param("tourneyYear") Long tourneyYear, @Param("surface") String surface);
	
	/**
	 * @param fromYear
	 * @param toYear
	 * @param surface
	 * @return
	 */
	@Query(value = "SELECT WINNER_ID, COUNT(*) FROM ATP_MATCHES WHERE SURFACE = :surface  AND TOURNEY_YEAR >= :fromYear AND TOURNEY_YEAR <= :toYear AND ROUND = 'F' GROUP BY WINNER_ID ORDER BY WINNER_ID", nativeQuery = true)
	public List<Object[]> findByBetweenYearsAndSurface(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear, @Param("surface") String surface);

}
