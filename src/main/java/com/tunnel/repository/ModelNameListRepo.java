package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.ModelNameList;

public interface ModelNameListRepo extends JpaRepository<ModelNameList,String>{

	Optional<ModelNameList> findById(String id);
}
