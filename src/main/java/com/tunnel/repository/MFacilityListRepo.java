package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.MFacilityList;

public interface MFacilityListRepo extends JpaRepository<MFacilityList, String> {

	Optional<MFacilityList> findByFacilityNo(String facilityNo);
}
