package com.tunnel.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tunnel.model.FacilityInspDetail;

public interface FacilityInspDetailRepo extends JpaRepository<FacilityInspDetail, Integer>{

	@Query("SELECT COUNT(t) FROM FacilityInspDetail t WHERE t.createDate > ?1")
	Long selectCountSinceDate(Date sinceDate); 
	
	Stream<FacilityInspDetail> findByCreateDateAfter(Date createDate);
	
	@Query("SELECT t FROM FacilityInspDetail t WHERE t.createDate > ?1 and t.diseaseNo = ?2 "
			+ "ORDER BY t.createDate ")
	Stream<FacilityInspDetail> findByDiseaseNoCreateDateAfter(Date createDate,String diseaseNo); 
}
