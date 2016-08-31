package com.tunnel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode(of = { "monomerNo", "tunnel", "mileage" })
public class TunnelMileageMonomerMatchPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "MILEAGE")
	private String mileage;

	@Column(name = "TUNNEL")
	private int tunnel;

	@Column(name = "MONOMER_NO", nullable=false, insertable=false, updatable=false)
	private String monomerNo;
}
