package com.tunnel.vo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSurrActSumVo {

	private int id;

	private String actLevel;

	private String actName;

	private String actNo;

	private String createUser;

	private String description;

	private Date endDate;

	private BigDecimal latitude;

	private BigDecimal longtitude;

	private Date startDate;

	private String synChronize;

	private String tagId;

	private TSurrInfoVo TSurrInfo;
}
