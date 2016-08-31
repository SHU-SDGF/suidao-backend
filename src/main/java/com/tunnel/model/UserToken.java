package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "m_login_token")
@Setter
@Getter
public class UserToken {

	@Id
	@Column(name = "LOGIN_ID")
	private String loginId;

	@Column(name = "TOKEN")
	private String token;

	public UserToken() {
	}

	public UserToken(String loginId) {
		this.loginId = loginId;
	}

}