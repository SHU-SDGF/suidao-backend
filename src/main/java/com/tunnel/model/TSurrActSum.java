package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the t_surr_act_sum database table.
 * 
 */
@Entity
@Table(name = "t_surr_act_sum")
@NamedQuery(name = "TSurrActSum.findAll", query = "SELECT t FROM TSurrActSum t")
@Getter
@Setter
public class TSurrActSum extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "ACT_LEVEL", columnDefinition = "char")
	private String actLevel;

	@Column(name = "ACT_NAME")
	private String actName;

	@Column(name = "ACT_NO", columnDefinition = "char")
	private String actNo;

	@Column(name = "CREATE_USER")
	@CreatedBy
	private String createUser;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	private BigDecimal latitude;

	@Column(name="longitude")
	private BigDecimal longtitude;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name="synchronize", columnDefinition = "char")
	private String synChronize;

	@Column(name = "TAG_ID")
	private String tagId;

	// bi-directional many-to-one association to TSurrInfo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Surround_No")
	private TSurrInfo TSurrInfo;

	public TSurrActSum() {
	}

}