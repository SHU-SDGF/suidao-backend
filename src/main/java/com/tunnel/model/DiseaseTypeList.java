package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the disease_type_list database table.
 * 
 */
@Entity
@Table(name = "disease_type_list")
@NamedQuery(name = "DiseaseTypeList.findAll", query = "SELECT d FROM DiseaseTypeList d")
@Getter
@Setter
public class DiseaseTypeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DISEASE_TYPE")
	private String diseaseType;

	// bi-directional many-to-one association to DiseaseTypeDetailMatch
	@OneToMany(mappedBy = "diseaseTypeList", fetch = FetchType.LAZY)
	private List<DiseaseTypeDetailMatch> diseaseTypeDetailMatches;

	// bi-directional many-to-one association to TFacilityInspDetail
	@OneToMany(mappedBy = "diseaseTypeList", fetch = FetchType.LAZY)
	private List<TFacilityInspDetail> TFacilityInspDetails;

	public DiseaseTypeList() {
	}

	public DiseaseTypeDetailMatch addDiseaseTypeDetailMatch(DiseaseTypeDetailMatch diseaseTypeDetailMatch) {
		getDiseaseTypeDetailMatches().add(diseaseTypeDetailMatch);
		diseaseTypeDetailMatch.setDiseaseTypeList(this);

		return diseaseTypeDetailMatch;
	}

	public DiseaseTypeDetailMatch removeDiseaseTypeDetailMatch(DiseaseTypeDetailMatch diseaseTypeDetailMatch) {
		getDiseaseTypeDetailMatches().remove(diseaseTypeDetailMatch);
		diseaseTypeDetailMatch.setDiseaseTypeList(null);

		return diseaseTypeDetailMatch;
	}

	public TFacilityInspDetail addTFacilityInspDetail(TFacilityInspDetail TFacilityInspDetail) {
		getTFacilityInspDetails().add(TFacilityInspDetail);
		TFacilityInspDetail.setDiseaseTypeList(this);

		return TFacilityInspDetail;
	}

	public TFacilityInspDetail removeTFacilityInspDetail(TFacilityInspDetail TFacilityInspDetail) {
		getTFacilityInspDetails().remove(TFacilityInspDetail);
		TFacilityInspDetail.setDiseaseTypeList(null);

		return TFacilityInspDetail;
	}

}