package com.tunnel.service.imp;

import java.util.Locale;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunnel.exception.AppAuthException;
import com.tunnel.model.MLoginRolePK;
import com.tunnel.model.User;
import com.tunnel.model.UserRole;
import com.tunnel.model.UserToken;
import com.tunnel.repository.UserRepo;
import com.tunnel.repository.UserRoleRepo;
import com.tunnel.repository.UserTokenRepo;
import com.tunnel.repository.RoleRepo;
import com.tunnel.service.UserService;
import com.tunnel.util.ParseMD5Util;
import com.tunnel.vo.RegUserReqVo;
import com.tunnel.vo.UserVo;

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

	@Autowired
	private UserTokenRepo userTokenRepo;

	private Locale currentLocale = LocaleContextHolder.getLocale();

	private String msg(String code) {
		return msgSource.getMessage(code, null, currentLocale);
	}

	@Override
	public UserVo authenticate(String loginId, String password) {

		log.info("UserServiceImp.authenticate ...");
		User u = userRepo.findByLoginIdAndPassword(loginId, ParseMD5Util.parseStrToMd5U32(password))
				.orElseThrow(() -> new AppAuthException(msg("err.login.failed")));
		UserToken ut = userTokenRepo.findByLoginId(loginId).orElseGet(() -> new UserToken(loginId));
		ut.setToken(UUID.randomUUID().toString());
		userTokenRepo.save(ut);

		UserVo uv = mapper.map(u, UserVo.class);
		uv.setPassword(null);
		uv.setToken(ut.getToken());
		return uv;
	}
	
	@Override
	public UserVo searchByLoginId(String loginId){
		User u = userRepo.findByLoginId(loginId)
				.orElseThrow(() -> new AppAuthException("不存在此用户，登录id" + loginId));
		UserVo uv = mapper.map(u, UserVo.class);
		uv.setPassword(null);
		return uv;
	}

	@Override
	public UserVo verifyToken(String loginId, String token) {

		log.info("UserServiceImp.authenticate ...");
		UserToken ut = userTokenRepo.findByLoginIdAndToken(loginId, token)
				.orElseThrow(() -> new AppAuthException(msg("err.login.failed.wrongToken")));
		return mapper.map(userRepo.findOne(ut.getLoginId()), UserVo.class);
	}

	@Override
	public User registerUser(RegUserReqVo reqVo) {
		reqVo.setPassword(ParseMD5Util.parseStrToMd5U32(reqVo.getPassword()));
		UserRole userRole = UserRole.builder().loginId(reqVo.getLoginId()).role(roleRepo.findOne(reqVo.getRoleId()))
				.id(new MLoginRolePK(reqVo.getLoginId(), reqVo.getRoleId())).build();
		userRoleRepo.save(userRole);

		User user = userRepo.save(mapper.map(reqVo, User.class));

		return user;
	}

	// public static void main(String[] args){
	// System.out.println(ParseMD5Util.parseStrToMd5U32("ADMIN123"));
	// }

}
