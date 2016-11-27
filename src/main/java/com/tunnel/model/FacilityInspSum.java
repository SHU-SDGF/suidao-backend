package com.tunnel.model;

import javax.persistence.*;

//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;

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
@NamedQuery(name = "FacilityInspSum.findAll", query = "SELECT t FROM FacilityInspSum t")
@Getter
@Setter
public class FacilityInspSum extends AbstractEntity {
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
	private String tagId = "0";
	
	private BigDecimal latitude;
	
	@Column(name="langitude")
	private BigDecimal longitude;
	
	@Column(name="IS_FROM_MOBILE",  columnDefinition = "char")
	private boolean isFromMobile = true;
	
	@Column(name="IS_NEED_REPAIR" , columnDefinition = "char")
	private boolean isNeedRepair = false;

//	// bi-directional many-to-one association to Monomer
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "MONOMER_NO")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private Monomer monomer;
	
	@Column(name="MONOMER_NO", columnDefinition="nvarchar2")
	private String monomerId;

	// bi-directional many-to-one association to Facility
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "FACILITY_NO", columnDefinition = "nchar")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private Facility Facility;

	@Column(name = "FACILITY_NO", columnDefinition = "nchar")
	private String facilityId;
	
	// bi-directional many-to-one association to FacilityType
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "FACILITY_TYPE")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private FacilityType facilityType;

	@Column(name="FACILITY_TYPE", columnDefinition="nvarchar2")
	private String facilityTypeId;
	
	// bi-directional many-to-one association to PosDespList
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "POS_DESP", referencedColumnName="POS_DESP_ID")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private PosDespList posDespList;

	@Column(name="POS_DESP")
	private String posDespId;
	
	// bi-directional many-to-one association to Model
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "MODEL_NAME", referencedColumnName="MODEL_ID")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private Model modelNameList;
	
	@Column(name="MODEL_NAME", columnDefinition="nvarchar2")
	private String modelId;
	
//	// bi-directional many-to-one association to TMileageDiseaseMatch
//	@OneToMany(mappedBy = "FacilityInspSum", fetch = FetchType.LAZY)
//	private List<TMileageDiseaseMatch> TMileageDiseaseMatches;
	
	
	/**
	 * 
	 *  start detail 
	 * 
	 * */ 
	
	
	private BigDecimal area;

	private BigDecimal depth;

	@Column(name = "DISEASE_DISCRIPTION" , columnDefinition="nvarchar2")
	private String diseaseDescription;

	private BigDecimal dislocation;

	private BigDecimal jointopen;

	private BigDecimal length;

	@Column(name="PHOTO", columnDefinition="nvarchar2")
	private String photo;

	@Column(name="RECORDER", columnDefinition="nvarchar2")
	private String recorder;

	private BigDecimal width;

	// bi-directional many-to-one association to DiseaseType
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "DISEASE_TYPE", referencedColumnName="DISEASE_TYPE_NO")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private DiseaseType diseaseType;
	
	@Column(name = "DISEASE_TYPE", columnDefinition = "nvarchar2")
	private String diseaseTypeId;

	// bi-directional many-to-one association to DetailType
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "DETAIL_TYPE", referencedColumnName="DISEASE_TYPE_NO")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private DiseaseType detailType;
	
	@Column(name = "DETAIL_TYPE", columnDefinition = "nvarchar2")
	private String detailTypeId;

}