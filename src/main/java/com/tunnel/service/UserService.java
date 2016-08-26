package com.tunnel.service;

import com.tunnel.model.User;
import com.tunnel.vo.RegUserReqVo;

public interface UserService {
	
	public User authenticate(String name, String password);
	
	public User verifyToken(String name, String token);
	
	public RegUserReqVo registerUser(RegUserReqVo reqUserVo);

}
