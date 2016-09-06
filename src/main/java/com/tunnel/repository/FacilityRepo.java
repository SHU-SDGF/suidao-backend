package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.Facility;

public interface FacilityRepo extends JpaRepository<Facility, String> {

	Optional<Facility> findById(String id);
}
