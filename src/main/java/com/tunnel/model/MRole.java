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
@NamedQuery(name = "MRole.findAll", query = "SELECT m FROM MRole m")
@Getter
@Setter
public class MRole extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLE_ID")
	private String roleId;

	@Column(name = "CREATE_USER")
	@CreatedBy
	private String createUser;

	@Column(name = "ROLE_NAME")
	private String roleName;
	
	// bi-directional many-to-one association to MLoginRole
	@OneToMany(mappedBy = "MRole", fetch = FetchType.LAZY)
	private List<MLoginRole> MLoginRoles;

	public MRole() {
	}

	public MLoginRole addMLoginRole(MLoginRole MLoginRole) {
		getMLoginRoles().add(MLoginRole);
		MLoginRole.setMRole(this);

		return MLoginRole;
	}

	public MLoginRole removeMLoginRole(MLoginRole MLoginRole) {
		getMLoginRoles().remove(MLoginRole);
		MLoginRole.setMRole(null);

		return MLoginRole;
	}

}