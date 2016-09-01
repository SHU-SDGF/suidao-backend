package com.tunnel.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacilityInspVo2 {
	private List<TFacilityInspDetailVo> facilityInspDetailList;
	
	private List<TFacilityInspSumVo> facilityInspSumList;
}
