//package com.tunnel.model;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//import lombok.Getter;
//import lombok.Setter;
//
///**
// * The persistent class for the disease_type_detail_match database table.
// * 
// */
//@Entity
//@Table(name = "a_disease_type_detail_match")
//@NamedQuery(name = "DiseaseTypeDetailMatch.findAll", query = "SELECT d FROM DiseaseTypeDetailMatch d")
//@Getter
//@Setter
//public class DiseaseTypeDetailMatch implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name = "MATCH_ID")
//	private int matchId;
//
//	// bi-directional many-to-one association to DetailType
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "DETAIL_TYPE")
//	private DetailType detailTypeList;
//
//	// bi-directional many-to-one association to DiseaseType
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "DISEASE_TYPE")
//	private DiseaseType diseaseTypeList;
//
//	public DiseaseTypeDetailMatch() {
//	}
//
//}