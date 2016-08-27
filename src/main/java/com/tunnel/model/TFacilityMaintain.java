package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

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
@NamedQuery(name = "TFacilityMaintain.findAll", query = "SELECT t FROM TFacilityMaintain t")
@Getter
@Setter
public class TFacilityMaintain extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FM_NO")
	private String fmNo;

	@Column(name = "DISEASE_NO")
	private String diseaseNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "FINISH_DATE")
	private Date finishDate;

	@Column(name = "MAINTAIN_MAN")
	private String maintainMan;

	@Column(name = "QUOTA_NO")
	private String quotaNo;

	@Column(name = "REPAIR_AMOUNT")
	private BigDecimal repairAmount;

	@Column(name = "REPAIR_CONTENT")
	private String repairContent;

	@Column(name = "REPAIR_FEE")
	private BigDecimal repairFee;

	public TFacilityMaintain() {
	}

}