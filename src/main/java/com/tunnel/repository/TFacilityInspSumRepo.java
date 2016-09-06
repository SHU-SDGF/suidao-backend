package com.tunnel.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.TFacilityInspSum;

public interface TFacilityInspSumRepo extends JpaRepository<TFacilityInspSum, String> {
	//findByCreateDateAfterAndIsFromMobileTrue
	Stream<TFacilityInspSum> findByCreateDateAfterAndIsFromMobileTrue(Date createDate);
	
	long countByCreateDateAfter(Date createDate);
	
}
