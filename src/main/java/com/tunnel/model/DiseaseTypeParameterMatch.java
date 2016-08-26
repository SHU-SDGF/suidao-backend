package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the disease_type_parameter_match database table.
 * 
 */
@Entity
@Table(name = "disease_type_parameter_match")
@NamedQuery(name = "DiseaseTypeParameterMatch.findAll", query = "SELECT d FROM DiseaseTypeParameterMatch d")
@Getter
@Setter
public class DiseaseTypeParameterMatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MATCH_ID")
	private int matchId;

	@Column(name = "DISEASE_TYPE")
	private String diseaseType;

	private String parameter;

	public DiseaseTypeParameterMatch() {
	}

}