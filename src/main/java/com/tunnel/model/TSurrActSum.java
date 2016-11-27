package com.tunnel.model;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the T_SURR_ACT_LIST database table.
 * 
 */
@Entity
@Table(name = "T_SURR_ACT_LIST")
@NamedQuery(name = "TSurrActSum.findAll", query = "SELECT t FROM TSurrActSum t")
@Getter
@Setter
public class TSurrActSum extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_SURR_ACT_LIST_ID_GENERATOR", sequenceName="SEQ_T_SURR_ACT_LIST")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_SURR_ACT_LIST_ID_GENERATOR")
	@Column(name = "ID")
	private long id;

	@Column(name = "ACT_LEVEL", columnDefinition = "nvarchar2")
	private String actLevel;

	@Column(name = "ACT_NAME", columnDefinition = "nvarchar2")
	private String actName;

	@Column(name = "ACT_NO", columnDefinition = "char")
	private String actNo;

	@Column(name = "DESCRIPTION", columnDefinition = "nvarchar2")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "LATITUDE")
	private String latitude;

	@Column(name = "LONGITUDE")
	private String longtitude;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	 @Column(name="synchronize", columnDefinition = "char")
	 private String synChronize = "0";

	@Column(name = "TAG_ID", columnDefinition = "nvarchar2")
	private String tagId = "0";

//	// bi-directional many-to-one association to TSurrInfo
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "SURROUND_NO")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private TSurrInfo TSurrInfo;

	public TSurrActSum() {
	}

}