package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the monomer_no_list database table.
 * 
 */
@Entity
@Table(name="A_MONOMER_NO_LIST")
@NamedQuery(name="Monomer.findAll", query="SELECT m FROM Monomer m")
@Getter
@Setter
public class Monomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MONOMER_NO", columnDefinition="nvarchar2")
	private String id;

	@Column(name="MONOMER_NAME", columnDefinition="nvarchar2")
	private String name;

	//bi-directional many-to-one association to FacilityInspSum
//	@OneToMany(mappedBy="monomer", fetch=FetchType.LAZY)
//	private List<FacilityInspSum> TFacilityInspSums;

//	//bi-directional many-to-one association to TunnelMileageMonomerMatch
//	@OneToMany(mappedBy="monomerNoList", fetch=FetchType.LAZY)
//	private List<TunnelMileageMonomerMatch> tunnelMileageMonomerMatches;

	public Monomer() {
	}

//	public FacilityInspSum addTFacilityInspSum(FacilityInspSum FacilityInspSum) {
//		getTFacilityInspSums().add(FacilityInspSum);
//		FacilityInspSum.setMonomerNoList(this);
//
//		return FacilityInspSum;
//	}
//
//	public FacilityInspSum removeTFacilityInspSum(FacilityInspSum FacilityInspSum) {
//		getTFacilityInspSums().remove(FacilityInspSum);
//		FacilityInspSum.setMonomerNoList(null);
//
//		return FacilityInspSum;
//	}
//
//	public TunnelMileageMonomerMatch addTunnelMileageMonomerMatch(TunnelMileageMonomerMatch tunnelMileageMonomerMatch) {
//		getTunnelMileageMonomerMatches().add(tunnelMileageMonomerMatch);
//		tunnelMileageMonomerMatch.setMonomerNoList(this);
//
//		return tunnelMileageMonomerMatch;
//	}
//
//	public TunnelMileageMonomerMatch removeTunnelMileageMonomerMatch(TunnelMileageMonomerMatch tunnelMileageMonomerMatch) {
//		getTunnelMileageMonomerMatches().remove(tunnelMileageMonomerMatch);
//		tunnelMileageMonomerMatch.setMonomerNoList(null);
//
//		return tunnelMileageMonomerMatch;
//	}

}