package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.Monomer;

public interface MonomerRepo extends JpaRepository<Monomer, String>{

	Optional<Monomer> findById(String id);
}
