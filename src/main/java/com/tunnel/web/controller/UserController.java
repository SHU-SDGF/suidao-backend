package com.tunnel.web.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.exception.AppException;
import com.tunnel.model.User;
import com.tunnel.service.UserService;
import com.tunnel.util.AppConstants;
import com.tunnel.util.AuthUtil;
import com.tunnel.vo.AuthVo;
import com.tunnel.vo.RegUserReqVo;

/**
 * API call ...
 */
@RestController
@Slf4j
@RequestMapping
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RegUserReqVo> register(@Validated @RequestBody RegUserReqVo reqUserVo) {

		log.info("register ...");
		try {
			RegUserReqVo rspUserVo = userService.registerUser(reqUserVo);
			return new ResponseEntity<>(rspUserVo, HttpStatus.OK);
		} catch (Exception e) {
			log.error("err.register.failed", e);
			throw new AppException(msg("err.register.failed"), e);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> login(@RequestBody AuthVo auth, HttpSession session) {

		log.info("login ...");

		User userVo = userService.authenticate(auth.getUserName(), auth.getPassword());

		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("admin"));

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(auth.getUserName(),
				auth.getPassword(), authorities);
		authToken.setDetails(userVo);

		SecurityContextHolder.getContext().setAuthentication(authToken);

		User userDetail = AuthUtil.getUserDetails();
		session.setAttribute(AppConstants.USER_SESSION, userDetail);
		return new ResponseEntity<>(userDetail, HttpStatus.OK);

	}

}
