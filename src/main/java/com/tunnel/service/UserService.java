package com.tunnel.service;

import com.tunnel.model.User;

public interface UserService {
	
	public User authenticate(String name, String password);
	
	public User verifyToken(String name, String token);

}
