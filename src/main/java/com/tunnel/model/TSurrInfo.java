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
	@Column(name = "Surround_No", columnDefinition = "char")
	private String surroundNo;

	@Column(name = "Blueprint_Path")
	private String blueprintPath;

	@Column(name = "Building_State")
	private String buildingState;

	@Column(name = "Depth")
	private BigDecimal depth;

	@Temporal(TemporalType.DATE)
	@Column(name = "Finished_Year")
	private Date finishedYear;

	@Column(name = "Height")
	private BigDecimal height;

	@Column(name = "Mileage_No")
	private String mileageNo;

	@Column(name = "Nearest_Tunnel")
	private String nearestTunnel;

	@Column(name = "Owner_Unit")
	private String ownerUnit;

	@Column(name = "Protect_Level")
	private String protectLevel;

	@Column(name = "Surround_Name")
	private String surroundName;

	@Column(name = "Surround_Type")
	private String surroundType;

	@Column(name = "Telephone")
	private String telephone;

	@Column(name = "Usage_State")
	private String usageState;

	public TSurrInfo() {
	}

}