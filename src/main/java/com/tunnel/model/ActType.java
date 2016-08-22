package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the act_types database table.
 * 
 */
@Entity
@Table(name="act_types")
@NamedQuery(name="ActType.findAll", query="SELECT a FROM ActType a")
@Setter
@Getter
public class ActType extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;


	private String name;

	private String order;

}