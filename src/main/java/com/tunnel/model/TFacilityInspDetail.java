package com.tunnel.model;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
	@SequenceGenerator(name="T_FACILITY_INSP_DETAIL_ID_GENERATOR", sequenceName="SEQ_T_FACILITY_INSP_DETAIL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_FACILITY_INSP_DETAIL_ID_GENERATOR")
	private Long id;

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

	// bi-directional many-to-one association to DiseaseType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISEASE_TYPE", referencedColumnName="DISEASE_TYPE_NO")
	@NotFound(action = NotFoundAction.IGNORE)
	private DiseaseType diseaseType;

	// bi-directional many-to-one association to DetailType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DETAIL_TYPE", referencedColumnName="DISEASE_TYPE_NO")
	@NotFound(action = NotFoundAction.IGNORE)
	private DiseaseType detailType;

	public TFacilityInspDetail() {
	}

}