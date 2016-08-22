package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the act_statuses database table.
 * 
 */
@Entity
@Table(name="act_statuses")
@NamedQuery(name="ActStatus.findAll", query="SELECT a FROM ActStatus a")
@Setter
@Getter
public class ActStatus extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String order;

}