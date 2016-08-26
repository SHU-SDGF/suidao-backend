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
@Table(name="monomer_no_list")
@NamedQuery(name="MonomerNoList.findAll", query="SELECT m FROM MonomerNoList m")
@Getter
@Setter
public class MonomerNoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String no;

	private String monomer_No;

	//bi-directional many-to-one association to TFacilityInspSum
	@OneToMany(mappedBy="monomerNoList", fetch=FetchType.LAZY)
	private List<TFacilityInspSum> TFacilityInspSums;

	//bi-directional many-to-one association to TunnelMileageMonomerMatch
	@OneToMany(mappedBy="monomerNoList", fetch=FetchType.LAZY)
	private List<TunnelMileageMonomerMatch> tunnelMileageMonomerMatches;

	public MonomerNoList() {
	}

	public TFacilityInspSum addTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().add(TFacilityInspSum);
		TFacilityInspSum.setMonomerNoList(this);

		return TFacilityInspSum;
	}

	public TFacilityInspSum removeTFacilityInspSum(TFacilityInspSum TFacilityInspSum) {
		getTFacilityInspSums().remove(TFacilityInspSum);
		TFacilityInspSum.setMonomerNoList(null);

		return TFacilityInspSum;
	}

	public TunnelMileageMonomerMatch addTunnelMileageMonomerMatch(TunnelMileageMonomerMatch tunnelMileageMonomerMatch) {
		getTunnelMileageMonomerMatches().add(tunnelMileageMonomerMatch);
		tunnelMileageMonomerMatch.setMonomerNoList(this);

		return tunnelMileageMonomerMatch;
	}

	public TunnelMileageMonomerMatch removeTunnelMileageMonomerMatch(TunnelMileageMonomerMatch tunnelMileageMonomerMatch) {
		getTunnelMileageMonomerMatches().remove(tunnelMileageMonomerMatch);
		tunnelMileageMonomerMatch.setMonomerNoList(null);

		return tunnelMileageMonomerMatch;
	}

}