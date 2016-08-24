package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the environment_actitivity_summaries database table.
 * 
 */
@Entity
@Table(name="environment_actitivity_summaries")
@NamedQuery(name="EnvironmentActitivitySummary.findAll", query="SELECT e FROM EnvironmentActitivitySummary e")
@Setter
@Getter
public class EnvironmentActitivitySummary extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="ACT_LEVEL")
	private String actLevel;

	@Column(name="ACT_NAME")
	private String actName;

	@Column(name="ACT_NO")
	private String actNo;

	@Column(name="DEL_FLG")
	private boolean delFlg;

	@Lob
	@Column(columnDefinition="TEXT")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_DATE")
	private Date endDate;

	private BigDecimal latitude;

	private BigDecimal longtitude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_DATE")
	private Date startDate;

	private String surround_NO;

	@Column(name="SYNCHRONIZE")
	private boolean synChronize;

	@Lob
	@Column(name="TAD_ID", columnDefinition="TEXT")
	private String tadId;

	@Version
	@Column(name="UDPATE_CNT")
	private int udpateCnt;

	@LastModifiedBy
	@Column(name="UPDATE_USER")
	private String updateUser;
	
	@CreatedBy
	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="user_id")
	private int userId;

}