package com.tunnel.vo;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegUserReqVo {

	@NotBlank
	private String loginId;

	@NotBlank
	private String password;

	private String userName;

	private String isAdmin;

	private String gender;

	private String telNo;

	private String mobile;

	private String address;
	
}