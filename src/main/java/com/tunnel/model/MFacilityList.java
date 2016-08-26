package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

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
	@Column(name = "Facility_No", columnDefinition = "char")
	private String facilityNo;

	@Temporal(TemporalType.DATE)
	private Date completeDate;

	@Column(name = "Contingency_Plan")
	private String contingencyPlan;

	@Column(name = "CREATE_USER")
	@CreatedBy
	private String createUser;

	@Column(name = "Facility_Importance", columnDefinition = "char")
	private String facilityImportance;

	@Column(name = "Facility_Name")
	private String facilityName;

	@Column(name = "remark")
	private String remark;

	@Column(name = "subsidyDocument")
	private String subsidy_Document;

	@Column(name = "Supplementary_Specification")
	private String supplementarySpecification;

	@Column(name = "Technical_Index")
	private String technicalIndex;

	// bi-directional many-to-one association to TFacilityInspSum
	@OneToMany(mappedBy = "MFacilityList", fetch = FetchType.LAZY)
	private List<TFacilityInspSum> TFacilityInspSums;

	public MFacilityList() {
	}

	public TFacilityInspSum addTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().add(TFacilityInspSum);
		TFacilityInspSum.setMFacilityList(this);

		return TFacilityInspSum;
	}

	public TFacilityInspSum removeTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().remove(TFacilityInspSum);
		TFacilityInspSum.setMFacilityList(null);

		return TFacilityInspSum;
	}

}