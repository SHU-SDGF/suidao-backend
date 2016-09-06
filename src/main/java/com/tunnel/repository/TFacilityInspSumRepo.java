package com.tunnel.repository;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.TFacilityInspSum;

public interface TFacilityInspSumRepo extends JpaRepository<TFacilityInspSum, String> {
	//findByCreateDateAfterAndIsFromMobileTrue
	Stream<TFacilityInspSum> findByCreateDateAfterAndIsFromMobileTrue(Date createDate);
	
	Optional<TFacilityInspSum> findByDiseaseNo(String diseaseNo);
	
	long countByCreateDateAfter(Date createDate);
	
}
