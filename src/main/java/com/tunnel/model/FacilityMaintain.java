package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the t_facility_maintain database table.
 * 
 */
@Entity
@Table(name = "t_facility_maintain")
@NamedQuery(name = "FacilityMaintain.findAll", query = "SELECT t FROM FacilityMaintain t")
@Getter
@Setter
public class FacilityMaintain extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FM_NO", columnDefinition = "nvarchar2")
	private String fmNo;

	@Column(name = "DISEASE_NO")
	private String diseaseNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "FINISH_DATE")
	private Date finishDate;

//	@Column(name = "MAINTAIN_MAN")
//	private String maintainMan;

	@Column(name = "QUOTA_NO", columnDefinition="nvarchar2")
	private String quotaNo;

	@Column(name = "REPAIR_AMOUNT")
	private BigDecimal repairAmount;

	@Column(name = "REPAIR_CONTENT", columnDefinition = "nvarchar2")
	private String repairContent;

	@Column(name = "REPAIR_FEE")
	private BigDecimal repairFee;

	public FacilityMaintain() {
	}

}