package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Setter
@Getter
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int authority;

	private String email;

	private String name;

	@Column(name="password_digest")
	private String passwordDigest;

	public User() {
	}
	
}