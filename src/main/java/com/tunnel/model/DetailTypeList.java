package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the detail_type_list database table.
 * 
 */
@Entity
@Table(name = "a_detail_type_list")
@NamedQuery(name = "DetailTypeList.findAll", query = "SELECT d FROM DetailTypeList d")
@Setter
@Getter
public class DetailTypeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DETAIL_TYPE", columnDefinition="nvarchar2")
	private String detailType;

	// bi-directional many-to-one association to TFacilityInspDetail
	@OneToMany(mappedBy = "detailTypeList", fetch = FetchType.LAZY)
	private List<TFacilityInspDetail> TFacilityInspDetails;

	public TFacilityInspDetail addTFacilityInspDetail(TFacilityInspDetail TFacilityInspDetail) {
		getTFacilityInspDetails().add(TFacilityInspDetail);
		TFacilityInspDetail.setDetailTypeList(this);

		return TFacilityInspDetail;
	}

	public TFacilityInspDetail removeTFacilityInspDetail(TFacilityInspDetail TFacilityInspDetail) {
		getTFacilityInspDetails().remove(TFacilityInspDetail);
		TFacilityInspDetail.setDetailTypeList(null);

		return TFacilityInspDetail;
	}

}