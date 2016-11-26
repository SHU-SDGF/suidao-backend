package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the t_surr_info database table.
 * 
 */
@Entity
@Table(name = "t_surr_info")
@NamedQuery(name = "TSurrInfo.findAll", query = "SELECT t FROM TSurrInfo t")
@Getter
@Setter
public class TSurrInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "SURROUND_NO", columnDefinition = "nchar")
	private String surroundNo;

	@Column(name = "BLUEPRINT_PATH", columnDefinition = "nvarchar2")
	private String blueprintPath;

	@Column(name = "BUILDING_STATE", columnDefinition = "nvarchar2")
	private String buildingState;

	@Column(name = "DEPTH")
	private BigDecimal depth;

	@Temporal(TemporalType.DATE)
	@Column(name = "FINISHED_YEAR")
	private Date finishedYear;

	@Column(name = "HEIGHT")
	private BigDecimal height;

	@Column(name = "MILEAGE_NO", columnDefinition = "nvarchar2")
	private String mileageNo;

	@Column(name = "NEAREST_TUNNEL", columnDefinition = "nvarchar2")
	private String nearestTunnel;

	@Column(name = "OWNER_UNIT", columnDefinition = "nvarchar2")
	private String ownerUnit;

	@Column(name = "PROTECT_LEVEL", columnDefinition = "nvarchar2")
	private String protectLevel;

	@Column(name = "SURROUND_NAME", columnDefinition = "nvarchar2")
	private String surroundName;

	@Column(name = "Surround_Type", columnDefinition = "nvarchar2")
	private String surroundType;

	@Column(name = "TELEPHONE", columnDefinition="nvarchar2")
	private String telephone;

	@Column(name = "USAGE_STATE", columnDefinition="nvarchar2")
	private String usageState;

	public TSurrInfo() {
	}

}