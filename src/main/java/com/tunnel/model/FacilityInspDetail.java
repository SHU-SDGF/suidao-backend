package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the T_DISEASE_RECORD database table.
 * 
 */
@Entity
@Table(name = "T_DISEASE_RECORD")
@NamedQuery(name = "FacilityInspDetail.findAll", query = "SELECT t FROM FacilityInspDetail t")
@Getter
@Setter
public class FacilityInspDetail extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_DISEASE_RECORD_ID_GENERATOR", sequenceName="SEQ_T_DISEASE_RECORD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_DISEASE_RECORD_ID_GENERATOR")
	private Long id;
	
	@Column(name = "DISEASE_NO")
	private String diseaseNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DISEASE_DATE")
	private Date diseaseDate;
	
	@Column(name="MONOMER_NO", columnDefinition="nvarchar2")
	private String monomerId;
	
	@Column(name = "FACILITY_NO", columnDefinition = "nchar")
	private String facilityId;
	
	@Column(name="FACILITY_TYPE", columnDefinition="nvarchar2")
	private String facilityTypeId;

	@Column(name = "DISEASE_DISCRIPTION" , columnDefinition="nvarchar2")
	private String diseaseDescription;
	
	@Column(name = "DISEASE_TYPE", columnDefinition = "nvarchar2")
	private String diseaseTypeId;	
	
	private BigDecimal area;

	private BigDecimal depth;

	private BigDecimal dislocation;

	private BigDecimal jointopen;

	private BigDecimal length;

	private BigDecimal width;

	@Column(name="PHOTO", columnDefinition="nvarchar2")
	private String photo;

	@Column(name="RECORDER", columnDefinition="nvarchar2")
	private String recorder;

	// bi-directional many-to-one association to DiseaseType
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "DISEASE_TYPE", referencedColumnName="DISEASE_TYPE_NO")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private DiseaseType diseaseType;

	// bi-directional many-to-one association to DetailType
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "DETAIL_TYPE", referencedColumnName="DISEASE_TYPE_NO")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private DiseaseType detailType;

	@Column(name = "DETAIL_TYPE", columnDefinition = "nvarchar2")
	private String detailTypeId;
	
	public FacilityInspDetail() {
	}

}