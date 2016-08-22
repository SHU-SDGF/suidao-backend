package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tunnel.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	Optional<User> findByNameAndPasswordDigest(String name, String passwordDigest);
	
	User findOneByNameAndPasswordDigest(String name, String passwordDigest);

}
