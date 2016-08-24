package com.tunnel.web.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.model.User;
import com.tunnel.service.UserService;
import com.tunnel.util.AppConstants;
import com.tunnel.util.AuthUtil;
import com.tunnel.vo.AuthVo;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * API call ...
 */
@RestController
@Slf4j
public class AuthenticationController extends BaseController {
	
    @Autowired
    private UserService userService;

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<User> login(HttpSession session) {
//
//		log.info("login ...");
//
//		User userDetail = AuthUtil.getUserDetails();
//		session.setAttribute(AppConstants.USER_SESSION, userDetail);
//		return new ResponseEntity<>(userDetail, HttpStatus.OK);
//
//	}
//	
	
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
