package com.tunnel.web.controller;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.exception.AppAuthException;
import com.tunnel.exception.AppException;
import com.tunnel.model.User;
import com.tunnel.repository.UserRepo;
import com.tunnel.service.UserService;
import com.tunnel.util.AppConstants;
import com.tunnel.util.AuthUtil;
import com.tunnel.vo.RegUserReqVo;

import javax.servlet.http.HttpSession;

/**
 * API call ...
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserRepo userRepo;
    
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RegUserReqVo> register(@Validated @RequestBody RegUserReqVo user) {

		log.info("register ...");
		try {
			user.setPasswordDigest(Base64.encodeBase64String(user.getPasswordDigest().getBytes()));
			User u = mapper.map(user, User.class);
			RegUserReqVo v = mapper.map(userRepo.save(u), RegUserReqVo.class); 
			return new ResponseEntity<>(v, HttpStatus.OK);
		} catch (Exception e) {
			log.error("err.register.failed", e);
			throw new AppException(msg("err.register.failed"), e);
		}
	}

}
