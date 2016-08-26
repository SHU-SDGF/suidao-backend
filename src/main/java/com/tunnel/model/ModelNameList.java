package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the model_name_list database table.
 * 
 */
@Entity
@Table(name="model_name_list")
@NamedQuery(name="ModelNameList.findAll", query="SELECT m FROM ModelNameList m")
@Getter
@Setter
public class ModelNameList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MODEL_NAME")
	private String modelName;

	//bi-directional many-to-one association to TFacilityInspSum
	@OneToMany(mappedBy="modelNameList", fetch=FetchType.LAZY)
	private List<TFacilityInspSum> TFacilityInspSums;

	public ModelNameList() {
	}

	public TFacilityInspSum addTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().add(TFacilityInspSum);
		TFacilityInspSum.setModelNameList(this);

		return TFacilityInspSum;
	}

	public TFacilityInspSum removeTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().remove(TFacilityInspSum);
		TFacilityInspSum.setModelNameList(null);

		return TFacilityInspSum;
	}

}