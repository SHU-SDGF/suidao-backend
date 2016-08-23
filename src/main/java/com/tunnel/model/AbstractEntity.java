package com.tunnel.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
abstract class AbstractEntity implements Serializable {


    private static final long serialVersionUID = -6965848061290894893L;
	
	@CreatedDate
    @NotNull
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
	
    @LastModifiedDate
    @NotNull
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt == null ? new Date() : createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt == null ? new Date() : updatedAt;
    }
}