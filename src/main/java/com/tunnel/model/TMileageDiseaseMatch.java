//package com.tunnel.model;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//import org.springframework.data.annotation.CreatedBy;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//
///**
// * The persistent class for the t_mileage_disease_match database table.
// * 
// */
//@Entity
//@Table(name = "t_mileage_disease_match")
//@NamedQuery(name = "TMileageDiseaseMatch.findAll", query = "SELECT t FROM TMileageDiseaseMatch t")
//@Getter
//@Setter
//public class TMileageDiseaseMatch implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	private int match_ID;
//
//	@Column(name = "CREATE_USER")
//	@CreatedBy
//	private String createUser;
//
//	@Column(name = "DISEASE_NO")
//	private String diseaseNo;
//
//	@Column(name = "LOCATION_X")
//	private BigDecimal locationX;
//
//	@Column(name = "LOCATION_Y")
//	private BigDecimal locationY;
//
//
//	// bi-directional many-to-one association to TFacilityInspSum
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "MILEAGE")
//	private TFacilityInspSum TFacilityInspSum;
//
//	public TMileageDiseaseMatch() {
//	}
//
//}