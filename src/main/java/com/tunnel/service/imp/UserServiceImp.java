package com.tunnel.service.imp;

import java.util.Locale;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunnel.exception.AppAuthException;
import com.tunnel.model.User;
import com.tunnel.repository.UserRepo;
import com.tunnel.service.UserService;
import com.tunnel.vo.RegUserReqVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private MessageSource msgSource;
	
    @Autowired
    protected ModelMapper mapper;
    
    private Locale currentLocale = LocaleContextHolder.getLocale();
    
    private String msg(String code){
        return msgSource.getMessage(code, null, currentLocale);
    }
	
	@Override
	public User authenticate(String name, String password) {

		log.info("UserServiceImp.authenticate ...");
		User u = userRepo.findByLoginIdAndPassword(name, Base64.encodeBase64String(password.getBytes()))
				.orElseThrow(()->new AppAuthException(msg("err.login.failed")));
		u.setToken(UUID.randomUUID().toString());
		userRepo.save(u);
		return u;
	}
	
	@Override
	public User verifyToken(String loginId, String token) {

		log.info("UserServiceImp.authenticate ...");
		User u = userRepo.findByLoginIdAndToken(loginId, token)
				.orElseThrow(()->new AppAuthException(msg("err.login.failed.wrongToken")));
		return u;
	}
	
	public RegUserReqVo registerUser(RegUserReqVo reqUserVo) {
		reqUserVo.setPassword(Base64.encodeBase64String(reqUserVo.getPassword().getBytes()));
		User u = mapper.map(reqUserVo, User.class);
		RegUserReqVo rspUserVo = mapper.map(userRepo.save(u), RegUserReqVo.class);
		return rspUserVo;
	}

}
