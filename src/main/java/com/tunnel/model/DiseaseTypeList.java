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
@Table(name = "A_DISEASE_TYPE_LIST")
@NamedQuery(name = "DiseaseTypeList.findAll", query = "SELECT d FROM DiseaseTypeList d")
@Getter
@Setter
public class DiseaseTypeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DISEASE_TYPE", columnDefinition="nvarchar2")
	private String diseaseType;

	// bi-directional many-to-one association to TFacilityInspDetail
	@OneToMany(mappedBy = "diseaseTypeList", fetch = FetchType.LAZY)
	private List<TFacilityInspDetail> TFacilityInspDetails;

	public DiseaseTypeList() {
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