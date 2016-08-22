package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;



/**
 * The persistent class for the monomers database table.
 * 
 */
@Entity
@Table(name="monomers")
@NamedQuery(name="Monomer.findAll", query="SELECT m FROM Monomer m")
@Setter
@Getter
public class Monomer extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String order;
	
}