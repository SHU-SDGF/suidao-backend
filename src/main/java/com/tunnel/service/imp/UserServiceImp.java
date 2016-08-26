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
import com.tunnel.model.MLoginRolePK;
import com.tunnel.model.User;
import com.tunnel.model.UserRole;
import com.tunnel.repository.UserRepo;
import com.tunnel.repository.UserRoleRepo;
import com.tunnel.repository.RoleRepo;
import com.tunnel.service.UserService;
import com.tunnel.vo.RegUserReqVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private MessageSource msgSource;

	@Autowired
	protected ModelMapper mapper;

	private Locale currentLocale = LocaleContextHolder.getLocale();

	private String msg(String code) {
		return msgSource.getMessage(code, null, currentLocale);
	}

	@Override
	public User authenticate(String name, String password) {

		log.info("UserServiceImp.authenticate ...");
		User u = userRepo.findByLoginIdAndPassword(name, Base64.encodeBase64String(password.getBytes()))
				.orElseThrow(() -> new AppAuthException(msg("err.login.failed")));
		u.setToken(UUID.randomUUID().toString());
		userRepo.save(u);
		return u;
	}

	@Override
	public User verifyToken(String loginId, String token) {

		log.info("UserServiceImp.authenticate ...");
		User u = userRepo.findByLoginIdAndToken(loginId, token)
				.orElseThrow(() -> new AppAuthException(msg("err.login.failed.wrongToken")));
		return u;
	}

	@Override
	public User registerUser(RegUserReqVo reqVo) {
		reqVo.setPassword(Base64.encodeBase64String(reqVo.getPassword().getBytes()));
		UserRole userRole = UserRole.builder().loginId(reqVo.getLoginId())
				.role(roleRepo.findOne(reqVo.getRoleId()))
				.id(new MLoginRolePK(reqVo.getLoginId(), reqVo.getRoleId()))
				.build();
		userRoleRepo.save(userRole);
		
		User user = userRepo.save(mapper.map(reqVo, User.class));

		return user;
	}

}
