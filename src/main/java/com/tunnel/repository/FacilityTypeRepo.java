package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.FacilityType;

public interface FacilityTypeRepo extends JpaRepository<FacilityType, String>{

	Optional<FacilityType> findById(String id);
}
