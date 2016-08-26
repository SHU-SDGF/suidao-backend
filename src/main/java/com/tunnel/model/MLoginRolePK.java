package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The primary key class for the m_login_role database table.
 * 
 */
@Embeddable
@Setter
@Getter
public class MLoginRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="LOGIN_ID")
	private String loginId;

	@Column(name="ROLE_ID", insertable=false, updatable=false)
	private String roleId;

	public MLoginRolePK() {
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MLoginRolePK)) {
			return false;
		}
		MLoginRolePK castOther = (MLoginRolePK)other;
		return 
			this.loginId.equals(castOther.loginId)
			&& this.roleId.equals(castOther.roleId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.loginId.hashCode();
		hash = hash * prime + this.roleId.hashCode();
		
		return hash;
	}
}