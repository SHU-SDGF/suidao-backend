package com.tunnel.model;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@Setter
@Getter
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authority", referencedColumnName = "id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Authority authority;

	private String email;

	private String name;

	@Column(name = "password_digest")
	private String passwordDigest;

	public User() {
	}

}