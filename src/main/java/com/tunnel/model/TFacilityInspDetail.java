package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the t_facility_insp_detail database table.
 * 
 */
@Entity
@Table(name = "t_facility_insp_detail")
@NamedQuery(name = "TFacilityInspDetail.findAll", query = "SELECT t FROM TFacilityInspDetail t")
@Getter
@Setter
public class TFacilityInspDetail extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private BigDecimal area;

	private BigDecimal depth;

	@Temporal(TemporalType.DATE)
	@Column(name = "DISEASE_DATE")
	private Date diseaseDate;

	@Column(name = "DISEASE_DISCRIPTION" , columnDefinition="nvarchar2")
	private String diseaseDiscription;

	@Column(name = "DISEASE_NO")
	private String diseaseNo;

	private BigDecimal dislocation;

	private BigDecimal jointopen;

	private BigDecimal length;

	@Column(name="PHOTO", columnDefinition="nvarchar2")
	private String photo;

	@Column(name="RECORDER", columnDefinition="nvarchar2")
	private String recorder;

	private BigDecimal width;

	// bi-directional many-to-one association to DiseaseTypeList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISEASE_TYPE")
	private DiseaseTypeList diseaseTypeList;

	// bi-directional many-to-one association to DetailTypeList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DETAIL_TYPE")
	private DetailTypeList detailTypeList;

	public TFacilityInspDetail() {
	}

}