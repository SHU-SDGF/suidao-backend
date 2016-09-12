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
public class FacilityInspDetailVo extends BaseVo{
	
	private long id;

	private BigDecimal area;

	private BigDecimal depth;

	private Date diseaseDate;

	private String diseaseDescription;

	private String diseaseNo;

	private BigDecimal dislocation;

	private BigDecimal jointopen;

	private BigDecimal length;

	private String photo;

	private String recorder;

	private BigDecimal width;

	private String diseaseTypeId; //必填

	private String detailTypeId;
	
	private String monomerId; //必填
	
	private String facilityId; //必填
	
	private String facilityTypeId; 
	
	private String synFlg;
}