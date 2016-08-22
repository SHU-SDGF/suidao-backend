package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;



/**
 * The persistent class for the detail_types database table.
 * 
 */
@Entity
@Table(name="detail_types")
@NamedQuery(name="DetailType.findAll", query="SELECT d FROM DetailType d")
@Setter
@Getter
public class DetailType extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="disease_type_id")
	private int diseaseTypeId;

	private String name;

	private String order;

}