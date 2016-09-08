package com.tunnel.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the model_name_list database table.
 * 
 */
@Entity
@Table(name="a_model_name_list")
@NamedQuery(name="Model.findAll", query="SELECT m FROM Model m")
@Getter
@Setter
public class Model implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MODEL_ID", columnDefinition="nvarchar2")
	private String id;
	
	@Column(name="MODEL_NAME", columnDefinition="nvarchar2")
	private String modelName;

	public Model() {
	}

}