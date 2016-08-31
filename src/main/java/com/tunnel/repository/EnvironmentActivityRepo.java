package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tunnel.model.TSurrAct;

public interface EnvironmentActivityRepo extends JpaRepository<TSurrAct, Integer>{

	public Page<TSurrAct> findAllByActNo(String actNo, Pageable pageable);
	
	public Optional<TSurrAct> findTopByActNoOrderByInspDateDesc(String actNo);
	
	public Optional<TSurrAct> findTopByActNoOrderByInspDateAsc(String actNo);
}
