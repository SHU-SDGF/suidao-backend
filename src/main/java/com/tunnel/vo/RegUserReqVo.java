package com.tunnel.vo;

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

	private Authority authority;

	@NotBlank(message = "{RegUserReqVo.email.NotBlank}")
    @Email
	private String email;

	@NotBlank(message = "{RegUserReqVo.name.NotBlank}")
	private String name;

	@NotBlank(message = "{RegUserReqVo.passwordDigest.NotBlank}")
	private String passwordDigest;
	
	@Setter
	@Getter
	public static class Authority {
		
		private int id;

		private String name;

		private int order;
		
	}
	
}