package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the T_SURR_ACT_RECORD database table.
 * 
 */
@Entity
@Table(name = "T_SURR_ACT_RECORD")
@NamedQuery(name = "TSurrAct.findAll", query = "SELECT t FROM TSurrAct t")
@Getter
@Setter
public class TSurrAct extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_SURR_ACT_RECORD_ID_GENERATOR", sequenceName="SEQ_T_SURR_ACT_RECORD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_SURR_ACT_RECORD_ID_GENERATOR")
	@Column(name="ID")
	private int id;

	@Column(name = "ACT_NO", columnDefinition = "char")
	private String actNo;

	@Column(name = "ACT_STATUS", columnDefinition="nvarchar2")
	private String actStatus;

	@Column(name = "ACTIVITY_TYPE", columnDefinition="nvarchar2")
	private String actType;

	@Column(name = "AUDIO", columnDefinition="nvarchar2")
	private String audio;

	@Column(name = "DESCRIPTION", columnDefinition="nvarchar2")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSP_DATE")
	private Date inspDate;

	@Column(name = "PHOTO", columnDefinition="nvarchar2")
	private String photo;
	
	@Column(name = "RECORDER", columnDefinition="nvarchar2")
	private String recorder;

	@Column(name="synchronize", columnDefinition = "char")
	private String synChronize = "0";

	@Column(name = "VIDEO", columnDefinition="nvarchar2")
	private String video;

	public TSurrAct() {
	}

}