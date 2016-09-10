package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tunnel.model.User;

public interface UserRepo extends CrudRepository<User, String>{
	
	Optional<User> findByLoginIdAndPassword(String loginId, String password);
	
	Optional<User> findByLoginId(String loginId);
	
//	Optional<User> findByLoginIdAndToken(String loginId, String token);
	
	User findOneByLoginIdAndPassword(String loginId, String password);

}
