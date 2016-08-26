package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tunnel.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	Optional<User> findByLoginIdAndPassword(String name, String password);
	
	Optional<User> findByLoginIdAndToken(String loginId, String token);
	
	User findOneByLoginIdAndPassword(String name, String password);

}
