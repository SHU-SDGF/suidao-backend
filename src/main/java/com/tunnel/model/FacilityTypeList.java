package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the facility_type_list database table.
 * 
 */
@Entity
@Table(name = "facility_type_list")
@NamedQuery(name = "FacilityTypeList.findAll", query = "SELECT f FROM FacilityTypeList f")
@Getter
@Setter
public class FacilityTypeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FACILITY_TYPE")
	private String facilityType;

	// bi-directional many-to-one association to TFacilityInspSum
	@OneToMany(mappedBy = "facilityTypeList", fetch = FetchType.LAZY)
	private List<TFacilityInspSum> TFacilityInspSums;

	public FacilityTypeList() {
	}

	public TFacilityInspSum addTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().add(TFacilityInspSum);
		TFacilityInspSum.setFacilityTypeList(this);

		return TFacilityInspSum;
	}

	public TFacilityInspSum removeTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().remove(TFacilityInspSum);
		TFacilityInspSum.setFacilityTypeList(null);

		return TFacilityInspSum;
	}

}