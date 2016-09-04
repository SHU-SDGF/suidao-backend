package com.tunnel.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.DiseaseType;

public interface DiseaseTypeRepo extends JpaRepository<DiseaseType, String>{

	Stream<DiseaseType> findByParentIsNull();
}
