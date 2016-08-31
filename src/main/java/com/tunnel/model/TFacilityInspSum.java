package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the t_facility_insp_sum database table.
 * 
 */
@Entity
@Table(name = "t_facility_insp_sum")
@NamedQuery(name = "TFacilityInspSum.findAll", query = "SELECT t FROM TFacilityInspSum t")
@Getter
@Setter
public class TFacilityInspSum extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DISEASE_NO")
	private String diseaseNo;
	
	private String mileage;

	@Temporal(TemporalType.DATE)
	@Column(name = "DISEASE_DATE")
	private Date diseaseDate;	

	@Column(name = "PHOTO_STANDARD")
	private String photoStandard;

	@Column(name = "TAG_ID")
	private String tagId;

	// bi-directional many-to-one association to MonomerNoList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MONOMER_NO")
	private MonomerNoList monomerNoList;

	// bi-directional many-to-one association to MFacilityList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FACILITY_NO", columnDefinition = "char")
	private MFacilityList MFacilityList;

	// bi-directional many-to-one association to FacilityTypeList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FACILITY_TYPE")
	private FacilityTypeList facilityTypeList;

	// bi-directional many-to-one association to PosDespList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POS_DESP")
	private PosDespList posDespList;

	// bi-directional many-to-one association to ModelNameList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODEL_NAME")
	private ModelNameList modelNameList;

//	// bi-directional many-to-one association to TMileageDiseaseMatch
//	@OneToMany(mappedBy = "TFacilityInspSum", fetch = FetchType.LAZY)
//	private List<TMileageDiseaseMatch> TMileageDiseaseMatches;

}