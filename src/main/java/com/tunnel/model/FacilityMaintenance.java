package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the facility_maintenances database table.
 * 
 */
@Entity
@Table(name="facility_maintenances")
@NamedQuery(name="FacilityMaintenance.findAll", query="SELECT f FROM FacilityMaintenance f")
@Setter
@Getter
public class FacilityMaintenance extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="FM_NO")
	@Id
	private String fmNo;

	@Column(name="QUOTA_NO")
	private String quotaNo;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DEL_FLG")
	private boolean delFlg;

	@Column(name="DISEASE_NO")
	private String diseaseNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FINISH_DATE")
	private Date finishDate;

	@Column(name="REPAIR_AMOUNT")
	private int repairAmount;

	@Column(name="REPAIR_CONTENT")
	private String repairContent;

	@Column(name="REPAIR_FEE")
	private BigDecimal repairFee;

	@Column(name="UPDATE_CNT")
	private int updateCnt;

	@Column(name="UPDATE_USER")
	private String updateUser;

	@Column(name="user_id")
	private int userId;

}