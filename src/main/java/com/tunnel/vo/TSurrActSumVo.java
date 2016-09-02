package com.tunnel.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TSurrActSumVo extends BaseVo{

	private long id;

	private String actLevel;

	private String actName;

	private String actNo;

	private String description;

	private Date endDate;

	private BigDecimal latitude;

	private BigDecimal longtitude;

	private Date startDate;

//	private String synChronize;

	private String tagId;

	private TSurrInfoVo TSurrInfo;
}
