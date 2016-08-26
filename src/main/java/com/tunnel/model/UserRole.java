package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the m_login_role database table.
 * 
 */
@Entity
@Table(name = "m_login_role")
@NamedQuery(name = "UserRole.findAll", query = "SELECT m FROM UserRole m")
@Setter
@Getter
@Builder
@AllArgsConstructor
public class UserRole extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MLoginRolePK id;
	
	// bi-directional many-to-one association to Role
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "LOGIN_ID", nullable=false, insertable=false, updatable=false)
//	private User user;
	@Column(name="LOGIN_ID" , nullable=false, insertable=false, updatable=false)
	private String loginId;
	
	// bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable=false, insertable=false, updatable=false)
	private Role role;

	@Column(name = "CREATE_USER")
	@CreatedBy
	private String createUser;

	public UserRole() {
	}

}