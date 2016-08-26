package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the m_login_role database table.
 * 
 */
@Entity
@Table(name = "m_login_role")
@NamedQuery(name = "MLoginRole.findAll", query = "SELECT m FROM MLoginRole m")
@Setter
@Getter
public class MLoginRole extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MLoginRolePK id;

	@Column(name = "CREATE_USER")
	@CreatedBy
	private String createUser;

	// bi-directional many-to-one association to MRole
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable=false, insertable=false, updatable=false)
	private MRole MRole;

	public MLoginRole() {
	}

}