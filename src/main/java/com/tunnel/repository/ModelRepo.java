package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunnel.model.Model;

public interface ModelRepo extends JpaRepository<Model,String>{

	Optional<Model> findById(String id);
}
