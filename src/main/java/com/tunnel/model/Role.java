package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the m_role database table.
 * 
 */
@Entity
@Table(name = "m_role")
@NamedQuery(name = "Role.findAll", query = "SELECT m FROM Role m")
@Getter
@Setter
public class Role extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLE_ID")
	private String roleId;

	@Column(name = "CREATE_USER")
	@CreatedBy
	private String createUser;

	@Column(name = "ROLE_NAME")
	private String roleName;
	
	// bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<UserRole> loginRoles;

	public Role() {
	}

	public UserRole addMLoginRole(UserRole loginRole) {
		getLoginRoles().add(loginRole);
		loginRole.setRole(this);

		return loginRole;
	}

	public UserRole removeMLoginRole(UserRole loginRole) {
		getLoginRoles().remove(loginRole);
		loginRole.setRole(null);

		return loginRole;
	}

}