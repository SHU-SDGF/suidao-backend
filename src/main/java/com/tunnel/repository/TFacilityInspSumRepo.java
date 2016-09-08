package com.tunnel.repository;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.FacilityInspSum;

public interface TFacilityInspSumRepo extends JpaRepository<FacilityInspSum, String> {
	//findByCreateDateAfterAndIsFromMobileTrue
	Stream<FacilityInspSum> findByCreateDateAfterAndIsFromMobileTrue(Date createDate);
	
	Stream<FacilityInspSum> findByCreateDateAfterAndIsFromMobileFalse(Date createDate);
	
	Optional<FacilityInspSum> findByDiseaseNo(String diseaseNo);
	
	long countByCreateDateAfter(Date createDate);
	
}
