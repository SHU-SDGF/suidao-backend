package com.tunnel.service;

import com.tunnel.model.User;
import com.tunnel.vo.RegUserReqVo;
import com.tunnel.vo.UserVo;

public interface UserService {
	
	public UserVo authenticate(String name, String password);
	
	public User verifyToken(String name, String token);
	
	public User registerUser(RegUserReqVo reqUserVo);
	
	public UserVo searchByLoginId(String loginId);

}
