package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
	private String surround_No;

	@Column(name = "Blueprint_Path")
	private String blueprint_Path;

	@Column(name = "Building_State")
	private String building_State;

	@Column(name = "Depth")
	private BigDecimal depth;

	@Temporal(TemporalType.DATE)
	@Column(name = "Finished_Year")
	private Date finished_Year;

	@Column(name = "Height")
	private BigDecimal height;

	@Column(name = "Mileage_No")
	private String mileage_No;

	@Column(name = "Nearest_Tunnel")
	private String nearest_Tunnel;

	@Column(name = "Owner_Unit")
	private String owner_Unit;

	@Column(name = "Protect_Level")
	private String protect_Level;

	@Column(name = "Surround_Name")
	private String surround_Name;

	@Column(name = "Surround_Type")
	private String surround_Type;

	@Column(name = "Telephone")
	private String telephone;

	@Column(name = "Usage_State")
	private String usage_State;

	// bi-directional many-to-one association to TSurrActSum
	@OneToMany(mappedBy = "TSurrInfo", fetch = FetchType.LAZY)
	private List<TSurrActSum> TSurrActSums;

	public TSurrInfo() {
	}

	public TSurrActSum addTSurrActSum(TSurrActSum TSurrActSum) {
		getTSurrActSums().add(TSurrActSum);
		TSurrActSum.setTSurrInfo(this);

		return TSurrActSum;
	}

	public TSurrActSum removeTSurrActSum(TSurrActSum TSurrActSum) {
		getTSurrActSums().remove(TSurrActSum);
		TSurrActSum.setTSurrInfo(null);

		return TSurrActSum;
	}

}