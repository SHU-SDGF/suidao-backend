package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tunnel.model.Authority;

public interface AuthorityRepo extends CrudRepository<Authority, Integer>{
	
	Optional<Authority> findById(Integer id);

}
