package com.tunnel.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the schema_migrations database table.
 * 
 */
@Entity
@Table(name="schema_migrations")
@NamedQuery(name="SchemaMigration.findAll", query="SELECT s FROM SchemaMigration s")
@Setter
@Getter
public class SchemaMigration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String version;

}