package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.PosDespList;

public interface PosDespListRepo extends JpaRepository<PosDespList, String>{

	Optional<PosDespList> findById(String id);
}
