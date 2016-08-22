package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the ar_internal_metadata database table.
 * 
 */
@Entity
@Table(name="ar_internal_metadata")
@NamedQuery(name="ArInternalMetadata.findAll", query="SELECT a FROM ArInternalMetadata a")
@Setter
@Getter
public class ArInternalMetadata extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private String key;

	private String value;

}