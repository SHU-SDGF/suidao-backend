package com.tunnel.util;

import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tunnel.model.User;

import javax.servlet.http.HttpSession;
import com.tunnel.vo.UserVo;

public class WebUtils {

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(false);
		if (session == null) {
			throw new CredentialsExpiredException("Unauthorized access");
		}
		return session;
	}

	public static HttpSession createNewSession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		return session;
	}

	public static UserVo loggedInUser() {
		UserVo uservo = AuthUtil.getUserDetails();
		if(uservo==null){
			throw new CredentialsExpiredException("Unauthorized access");
		}
		return uservo;
	}
}