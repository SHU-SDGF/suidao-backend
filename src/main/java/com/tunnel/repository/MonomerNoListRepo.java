package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.MonomerNoList;

public interface MonomerNoListRepo extends JpaRepository<MonomerNoList, String>{

	Optional<MonomerNoList> findByMonomerNo(String monomerNo);
}
