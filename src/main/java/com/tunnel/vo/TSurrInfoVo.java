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
public class TSurrInfoVo {

	private String surroundNo;

	private String blueprintPath;

	private String buildingState;

	private BigDecimal depth;

	private Date finishedYear;

	private BigDecimal height;

	private String mileageNo;

	private String nearestTunnel;

	private String ownerUnit;

	private String protectLevel;

	private String surroundName;

	private String surroundType;

	private String telephone;

	private String usageState;
}
