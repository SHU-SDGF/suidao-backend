package com.tunnel.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the disease_type database table.
 * 
 */
@Entity
@Table(name = "B_DISEASE_TYPE")
@NamedQuery(name = "DiseaseType.findAll", query = "SELECT d FROM DiseaseType d")
@Getter
@Setter
public class DiseaseType extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DISEASE_TYPE_NO", columnDefinition = "nvarchar2")
	private String id;

	@Column(name = "DISEASE_TYPE_NAME", columnDefinition = "nvarchar2")
	private String diseaseTypeName;

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

	// @OneToMany
	// @JoinColumn(name = "PARENT_NO", columnDefinition = "nvarchar2")
	// @OrderColumn(name = "DISEASE_TYPE_NAME")
	// private List<DiseaseType> children;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_NO", referencedColumnName = "DISEASE_TYPE_NO")
	private DiseaseType parent;

	@NotNull
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private Set<DiseaseType> children = new HashSet<DiseaseType>();

	// @Column(name = "PARENT_NO", columnDefinition = "nvarchar2")
	// private String parentNo;

	public DiseaseType() {
	}

}