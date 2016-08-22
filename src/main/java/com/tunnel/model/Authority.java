package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;



/**
 * The persistent class for the authorities database table.
 * 
 */
@Entity
@Table(name="authorities")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
@Setter
@Getter
public class Authority extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private int order;

}