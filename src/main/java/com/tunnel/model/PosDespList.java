package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the pos_desp_list database table.
 * 
 */
@Entity
@Table(name = "pos_desp_list")
@NamedQuery(name = "PosDespList.findAll", query = "SELECT p FROM PosDespList p")
@Getter
@Setter
public class PosDespList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pos_Desp;

	// bi-directional many-to-one association to TFacilityInspSum
	@OneToMany(mappedBy = "posDespList", fetch=FetchType.LAZY)
	private List<TFacilityInspSum> TFacilityInspSums;

	public PosDespList() {
	}

	public TFacilityInspSum addTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().add(TFacilityInspSum);
		TFacilityInspSum.setPosDespList(this);

		return TFacilityInspSum;
	}

	public TFacilityInspSum removeTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().remove(TFacilityInspSum);
		TFacilityInspSum.setPosDespList(null);

		return TFacilityInspSum;
	}

}