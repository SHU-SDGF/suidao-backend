package com.tunnel.vo.facilityInsp.resp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TFacilityInspDetailRespVo {

	private long id;
	
	private boolean success;
	
	private String message;

	private String diseaseNo;

	private String photo;

//	private String synFlg;
	
	public TFacilityInspDetailRespVo(){
		
	}
	
	public TFacilityInspDetailRespVo(long id){
		this.id = id;
	}
}
