package com.tunnel.model;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the environment_activities database table.
 * 
 */
@Entity
@Table(name="environment_activities")
@NamedQuery(name="EnvironmentActivity.findAll", query="SELECT e FROM EnvironmentActivity e")
@Setter
@Getter
public class EnvironmentActivity extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NO")
	private int id;

	@Column(name="ACT_NO")
	private String actNo;

	@Column(name="ACT_STATUS")
	private String actStatus;

	@Column(name="ACT_TYPE")
	private String actType;

	private String audio;

	@Column(name="DEL_FLG")
	private boolean delFlg;

	@Lob
	@Column(columnDefinition="TEXT")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSP_DATE")
	private Date inspDate;

	private String photo;

	private String recorder;

	@Column(name="SYNCHRONIZE")
	private boolean synChronize;

	@CreatedBy
	@Column(name="CREATE_USER")
	private String createUser;
	
	@Version
	@Column(name="UPDATE_CNT")
	private int updateCnt;

	@LastModifiedBy
	@Column(name="UPDATE_USER")
	private String updateUser;

	@Column(name="user_id")
	private int userId;

	private String video;
}