package com.tunnel.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo {

	private String loginId;
	
	private String password;
	
	private String userName;
	
	private String isAdmin;
	
	private String gender;

	private String telNo;

	private String mobile;

	private String address;
	
	private String token;
}
