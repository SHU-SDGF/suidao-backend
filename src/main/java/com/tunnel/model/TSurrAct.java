package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the t_surr_act database table.
 * 
 */
@Entity
@Table(name = "t_surr_act")
@NamedQuery(name = "TSurrAct.findAll", query = "SELECT t FROM TSurrAct t")
@Getter
@Setter
public class TSurrAct extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NO")
	private int id;

	@Column(name = "ACT_NO", columnDefinition = "char")
	private String actNo;

	@Column(name = "ACT_STATUS")
	private String actStatus;

	@Column(name = "ACT_TYPE")
	private String actType;

	private String audio;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSP_DATE")
	private Date inspDate;

	private String photo;

	private String recorder;

	@Column(name="synchronize", columnDefinition = "char")
	private String synChronize = "1";

	private String video;

	public TSurrAct() {
	}

}