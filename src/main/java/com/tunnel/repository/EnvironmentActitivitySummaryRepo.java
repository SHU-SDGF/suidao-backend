package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tunnel.model.TSurrActSum;

public interface EnvironmentActitivitySummaryRepo extends JpaRepository<TSurrActSum, String>{

	public Page<TSurrActSum> findByDelFlgFalseAndLatitudeNotNull(Pageable page);
	
	public Optional<TSurrActSum> findByIdAndDelFlgFalseAndLatitudeNotNull(String id);
}
