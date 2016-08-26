package com.tunnel.vo;

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

	@NotBlank
	private String roleId;

	private String userName;

	private String isAdmin;

	private String gender;

	private String telNo;

	private String mobile;

	private String address;

}