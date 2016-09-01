package com.tunnel.model;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the disease_type_list database table.
 * 
 */
@Entity
@Table(name = "B_DISEASE_TYPE")
@NamedQuery(name = "DiseaseTypeList.findAll", query = "SELECT d FROM DiseaseTypeList d")
@Getter
@Setter
public class DiseaseTypeList extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DISEASE_TYPE_NO", columnDefinition = "nvarchar2")
	private String id;

	@Column(name = "CAN_AREA")
	private BigDecimal canArea;

	@Column(name = "CAN_DEPTH")
	private BigDecimal canDepth;

	@Column(name = "CAN_DISLOCATION")
	private BigDecimal canDislocation;

	@Column(name = "CAN_JOINTOPEN")
	private BigDecimal canJointopen;

	@Column(name = "CAN_LENGTH")
	private BigDecimal canLength;

	@Column(name = "CAN_WIDTH")
	private BigDecimal canWidth;

	@Column(name = "DISEASE_TYPE_NAME", columnDefinition = "nvarchar2")
	private String diseaseTypeName;

	@Column(name = "PARENT_NO", columnDefinition = "nvarchar2")
	private String parentNo;

	public DiseaseTypeList() {
	}

}