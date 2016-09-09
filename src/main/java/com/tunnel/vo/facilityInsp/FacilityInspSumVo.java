package com.tunnel.vo.facilityInsp;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tunnel.vo.BaseVo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacilityInspSumVo extends BaseVo{

	private String diseaseNo;
	
	private String mileage;

	private Date diseaseDate;

	private String photoStandard;

	private String tagId;
	
	private BigDecimal latitude;
	
	private BigDecimal langitude;

	private String monomerId;

	private String facilityId;

	private String facilityTypeId;

	private String posDespId;

	private String modelId;
	
	private boolean isNewCreated;
	
	private boolean isNeedRepair;
	
	private boolean isFromMobile = true;
	
	/**
	 * start detail
	 */
	
	private BigDecimal area;

	private BigDecimal depth;

	private String diseaseDescription;

	private BigDecimal dislocation;

	private BigDecimal jointopen;

	private BigDecimal length;

	private String photo;

	private String recorder;

	private BigDecimal width;

	private String diseaseTypeId;

	private String detailTypeId;
	
	/** 
	 * end detail
	 */
}