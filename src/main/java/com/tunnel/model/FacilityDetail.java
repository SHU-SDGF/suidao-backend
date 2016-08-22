package com.tunnel.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the facility_details database table.
 * 
 */
@Entity
@Table(name="facility_details")
@NamedQuery(name="FacilityDetail.findAll", query="SELECT f FROM FacilityDetail f")
@Setter
@Getter
public class FacilityDetail extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private BigDecimal area;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DEL_FLG")
	private boolean delFlg;

	private BigDecimal depth;

	@Column(name="DIRECTION_INFORMATION")
	private String directionInformation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DISEASE_DATE")
	private Date diseaseDate;

	@Column(name="DISEASE_DISCRIPTION")
	private String diseaseDiscription;

	@Column(name="DISEASE_NO")
	private String diseaseNo;

	@Column(name="DISEASE_TYPE")
	private String diseaseType;

	private float dislocation;

	@Column(name="DRIP_SPEED")
	private BigDecimal dripSpeed;

	@Column(name="DROP_SPEED")
	private BigDecimal dropSpeed;

	@Column(name="FACILITY_NO")
	private String facilityNo;

	@Column(name="FACILITY_TYPE")
	private String facilityType;

	private float jointopen;

	@Column(name="LEAKAGE_LEVEL")
	private String leakageLevel;

	private BigDecimal length;

	@Column(name="LINELEAK_SPEED")
	private BigDecimal lineleakSpeed;

	private String mileage;

	@Column(name="MODEL_NAME")
	private String modelName;

	@Column(name="MONOMER_NO")
	private String monomerNo;

	@Column(name="MUDLEAK_SPEED")
	private BigDecimal mudleakSpeed;

	private String photo;

	private String pos_Desp;

	private String recorder;

	@Lob
	@Column(name="TAG_ID", columnDefinition="TEXT")
	private String tagId;

	@Column(name="UPDATE_CNT")
	private int updateCnt;

	@Column(name="UPDATE_USER")
	private String updateUser;

	@Column(name="user_id")
	private int userId;

	private BigDecimal volumn;

	private BigDecimal width;

}