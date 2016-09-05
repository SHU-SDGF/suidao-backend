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
public class TFacilityInspDetailVo extends BaseVo{
	
	private long id;

	private BigDecimal area;

	private BigDecimal depth;

	private Date diseaseDate;

	private String diseaseDiscription;

	private String diseaseNo;

	private BigDecimal dislocation;

	private BigDecimal jointopen;

	private BigDecimal length;

	private String photo;

	private String recorder;

	private BigDecimal width;

	private DiseaseTypeVo diseaseType;

	private DiseaseTypeVo detailType;
	
	boolean isNewCreated;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class DiseaseTypeVo {
	private String id;
}