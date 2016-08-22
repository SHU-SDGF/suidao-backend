package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;



/**
 * The persistent class for the position_descriptions database table.
 * 
 */
@Entity
@Table(name="position_descriptions")
@NamedQuery(name="PositionDescription.findAll", query="SELECT p FROM PositionDescription p")
@Setter
@Getter
public class PositionDescription extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String order;
	
}