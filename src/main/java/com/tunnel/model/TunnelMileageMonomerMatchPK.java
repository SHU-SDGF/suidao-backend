package com.tunnel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode(of = { "monomerNo", "tunnel", "mileage" })
public class TunnelMileageMonomerMatchPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "mileage")
	private String mileage;

	@Column(name = "tunnel")
	private int tunnel;

	@Column(name = "Monomer_No", nullable=false, insertable=false, updatable=false)
	private String monomerNo;
}
