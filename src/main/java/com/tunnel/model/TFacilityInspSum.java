package com.tunnel.model;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the t_facility_insp_sum database table.
 * 
 */
@Entity
@Table(name = "T_FACILITY_INSP")
@NamedQuery(name = "TFacilityInspSum.findAll", query = "SELECT t FROM TFacilityInspSum t")
@Getter
@Setter
public class TFacilityInspSum extends AbstractEntity {
	private static final long serialVersionUID = 1L;

//	@Id
//	@SequenceGenerator(name="T_FACILITY_INSP_SUM_ID_GENERATOR", sequenceName="SEQ_T_FACILITY_INSP_SUM")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_FACILITY_INSP_SUM_ID_GENERATOR")
//	private long id;

	@Id
	@Column(name = "DISEASE_NO")
	private String diseaseNo;
	
	@Column(name="MILEAGE", columnDefinition = "nvarchar2")
	private String mileage;

	@Temporal(TemporalType.DATE)
	@Column(name = "DISEASE_DATE")
	private Date diseaseDate;	

	@Column(name = "PHOTO_STANDARD")
	private String photoStandard;

	@Column(name = "TAG_ID")
	private String tagId;
	
	@Column(name="DATA_SOURCE")
	private String dataSource = "M";
	
	@Column(name="IS_NEED_REPAIR" , columnDefinition = "char")
	private boolean isNeedRepair = false;

	// bi-directional many-to-one association to Monomer
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MONOMER_NO")
	@NotFound(action = NotFoundAction.IGNORE)
	private Monomer monomer;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FACILITY_NO", columnDefinition = "nchar")
	@NotFound(action = NotFoundAction.IGNORE)
	private Facility Facility;

	// bi-directional many-to-one association to FacilityType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FACILITY_TYPE")
	@NotFound(action = NotFoundAction.IGNORE)
	private FacilityType facilityType;

	// bi-directional many-to-one association to PosDespList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POS_DESP", referencedColumnName="POS_DESP_ID")
	@NotFound(action = NotFoundAction.IGNORE)
	private PosDespList posDespList;

	// bi-directional many-to-one association to ModelNameList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODEL_NAME", referencedColumnName="MODEL_ID")
	@NotFound(action = NotFoundAction.IGNORE)
	private ModelNameList modelNameList;
	
//	// bi-directional many-to-one association to TMileageDiseaseMatch
//	@OneToMany(mappedBy = "TFacilityInspSum", fetch = FetchType.LAZY)
//	private List<TMileageDiseaseMatch> TMileageDiseaseMatches;
	
	
	/**
	 * 
	 *  start detail 
	 * 
	 * */ 
	
	
	private BigDecimal area;

	private BigDecimal depth;

	@Column(name = "DISEASE_DISCRIPTION" , columnDefinition="nvarchar2")
	private String diseaseDiscription;

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
	
	
	
	
	

}