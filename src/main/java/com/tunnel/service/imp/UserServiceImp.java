package com.tunnel.service.imp;

import java.util.Locale;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunnel.exception.AppAuthException;
import com.tunnel.model.User;
import com.tunnel.repository.UserRepo;
import com.tunnel.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private MessageSource msgSource;
    
    private Locale currentLocale = LocaleContextHolder.getLocale();
    
    private String msg(String code){
        return msgSource.getMessage(code, null, currentLocale);
    }
	
	@Override
	public User authenticate(String name, String password) {

		log.info("UserServiceImp.authenticate ...");
		User u = userRepo.findByNameAndPasswordDigest(name, Base64.encodeBase64String(password.getBytes()))
				.orElseThrow(()->new AppAuthException(msg("err.login.failed")));
		u.setToken(UUID.randomUUID().toString());
		userRepo.save(u);
		return u;
	}
	
	@Override
	public User verifyToken(String name, String token) {

		log.info("UserServiceImp.authenticate ...");
		User u = userRepo.findByNameAndToken(name, token)
				.orElseThrow(()->new AppAuthException(msg("err.login.failed.wrongToken")));
		return u;
	}

}
