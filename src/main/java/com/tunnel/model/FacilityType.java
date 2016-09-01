package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the facility_type database table.
 * 
 */
@Entity
@Table(name = "A_FACILITY_TYPE")
@NamedQuery(name = "FacilityType.findAll", query = "SELECT f FROM FacilityType f")
@Getter
@Setter
public class FacilityType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FACILITY_TYPE")
	private String id;
	
	@Column(name = "FACILITY_TYPE_NAME")
	private String facilityType;

	public FacilityType() {
	}

}