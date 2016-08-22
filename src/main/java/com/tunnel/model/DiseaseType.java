package com.tunnel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the disease_types database table.
 * 
 */
@Entity
@Table(name="disease_types")
@NamedQuery(name="DiseaseType.findAll", query="SELECT d FROM DiseaseType d")
@Setter
@Getter
public class DiseaseType extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String order;

}