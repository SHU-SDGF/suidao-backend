package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the m_facility_list database table.
 * 
 */
@Entity
@Table(name = "m_facility_list")
@NamedQuery(name = "MFacilityList.findAll", query = "SELECT m FROM MFacilityList m")
@Getter
@Setter
public class MFacilityList extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Facility_No", columnDefinition = "nchar")
	private String facilityNo;

	@Temporal(TemporalType.DATE)
	private Date completeDate;

	@Column(name = "Contingency_Plan", columnDefinition = "nvarchar2")
	private String contingencyPlan;

	@Column(name = "Facility_Importance", columnDefinition = "char")
	private String facilityImportance;

	@Column(name = "Facility_Name", columnDefinition = "nvarchar2")
	private String facilityName;

	@Column(name = "remark", columnDefinition = "nvarchar2")
	private String remark;

	@Column(name = "subsidy_document", columnDefinition = "nvarchar2")
	private String subsidyDocument;

	@Column(name = "Supplementary_Specification", columnDefinition = "nvarchar2")
	private String supplementarySpecification;

	@Column(name = "Technical_Index", columnDefinition = "nvarchar2")
	private String technicalIndex;

	public MFacilityList() {
	}

}