package com.tunnel.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tunnel.model.TFacilityInspDetail;

public interface FacilityInspDetailRepo extends JpaRepository<TFacilityInspDetail, Integer>{

	@Query("SELECT COUNT(t) FROM TFacilityInspDetail t WHERE t.createDate > ?1")
	Long selectCountSinceDate(Date sinceDate); 
}
