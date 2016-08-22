package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


/**
 * The persistent class for the defect_locations database table.
 * 
 */
@Entity
@Table(name="defect_locations")
@NamedQuery(name="DefectLocation.findAll", query="SELECT d FROM DefectLocation d")
@Setter
@Getter
public class DefectLocation extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="DISEASE_NO")
	@Id
	private String diseaseNo;

	private String mileage;

	private BigDecimal threeD_X;

	private BigDecimal threeD_Y;

	private BigDecimal threeD_Z;

	private BigDecimal twoD_X;

	private BigDecimal twoD_Y;
	
}