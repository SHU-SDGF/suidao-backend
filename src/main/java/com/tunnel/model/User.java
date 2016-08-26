package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "m_login")
@Setter
@Getter
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOGIN_ID")
	private String loginId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "IS_ADMIN", columnDefinition = "char")
	private String isAdmin;

	@Column(name = "GENDER", columnDefinition = "char")
	private String gender;

	@Column(name = "TEL_NO")
	private String telNo;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "TOKEN")
	private String token;


	@Column(name = "CREATE_USER")
	@CreatedBy
	private String createUser;

	public User() {
	}

}