//package com.tunnel.model;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//import lombok.Getter;
//import lombok.Setter;
//
//
///**
// * The persistent class for the tunnel_mileage_monomer_match database table.
// * 
// */
//@Entity
//@Table(name="tunnel_mileage_monomer_match")
//@NamedQuery(name="TunnelMileageMonomerMatch.findAll", query="SELECT t FROM TunnelMileageMonomerMatch t")
//@Setter
//@Getter
//public class TunnelMileageMonomerMatch implements Serializable {
//	private static final long serialVersionUID = 1L;
//	
//	@EmbeddedId
//	private TunnelMileageMonomerMatchPK id;
//
//	@Column(name="FACILITY_NO", columnDefinition = "char")
//	private String facilityNo;
//
//	//bi-directional many-to-one association to MonomerNoList
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="MONOMER_NO", nullable=false, insertable=false, updatable=false)
//	private MonomerNoList monomerNoList;
//
//	public TunnelMileageMonomerMatch() {
//	}
//
//}