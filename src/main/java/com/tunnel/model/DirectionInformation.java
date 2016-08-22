package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the direction_informations database table.
 * 
 */
@Entity
@Table(name="direction_informations")
@NamedQuery(name="DirectionInformation.findAll", query="SELECT d FROM DirectionInformation d")
@Setter
@Getter
public class DirectionInformation extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String order;

}