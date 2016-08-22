package com.tunnel.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.model.User;
import com.tunnel.util.AppConstants;
import com.tunnel.util.AuthUtil;

import javax.servlet.http.HttpSession;

/**
 * API call ...
 */
@RestController
@Slf4j
public class AuthenticationController extends BaseController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> login(HttpSession session) {

		log.info("login ...");

		User userDetail = AuthUtil.getUserDetails();
		session.setAttribute(AppConstants.USER_SESSION, userDetail);
		return new ResponseEntity<>(userDetail, HttpStatus.OK);

	}

}
