package com.tunnel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tunnel.model.EnvironmentActivity;

public interface EnvironmentActivityRepo extends JpaRepository<EnvironmentActivity, Integer>{

	public Page<EnvironmentActivity> findAllByActNo(String actNo, Pageable pageable);
}
