package com.tunnel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tunnel.model.UserToken;

public interface UserTokenRepo extends CrudRepository<UserToken, String>{

	Optional<UserToken> findByLoginId(String loginId);
	
	Optional<UserToken> findByLoginIdAndToken(String loginId, String token);
}
