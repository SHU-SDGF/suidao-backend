package com.tunnel.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = -6965848061290894893L;
	
	@Column(name = "CREATE_USER")
	@CreatedBy
	private String createUser;

	@Column(name = "UPDATE_CNT")
	@Version
	private Long updateCnt;
	
	@Column(name = "DEL_FLG", columnDefinition = "char")
	private String delFlg = "0";
	
	@CreatedDate
	@NotNull
	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@LastModifiedDate
	@NotNull
	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	public void setCreatedAt(Date createDate) {
		this.createDate = createDate == null ? new Date() : createDate;
	}

	public void setUpdatedAt(Date updateDate) {
		this.updateDate = updateDate == null ? new Date() : updateDate;
	}
}