package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the facilities database table.
 * 
 */
@Entity
@Table(name="facilities")
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
@Setter
@Getter
public class Facility extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name="FACILITY_NO")
	@Id
	private String facilityNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="COMPLETE_DATE")
	private Date completeDate;

	@Lob
	@Column(name="CONTINGENCY_PLAN", columnDefinition="TEXT")
	private String contingencyPlan;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DEL_FLG")
	private boolean delFlg;

	@Column(name="FACILITY_IMPORTANCE")
	private String facilityImportance;

	@Column(name="FACILITY_NAME")
	private String facilityName;

	@Column(name="MODEL_EXIST")
	private String modelExist;

	@Lob
	@Column(columnDefinition="TEXT")
	private String remark;

	@Lob
	@Column(name="SUBSIDY_DOCUMENT", columnDefinition="TEXT")
	private String subsidyDocument;

	@Lob
	@Column(name="SUPPLEMENTARY_SPECIFICATION", columnDefinition="TEXT")
	private String supplementarySpecification;

	@Lob
	@Column(name="TECHNICAL_INDEX", columnDefinition="TEXT")
	private String technicalIndex;

	@Column(name="UPDATE_CNT")
	private int updateCnt;

	@Column(name="UPDATE_USER")
	private String updateUser;

}