package com.tunnel.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tunnel.vo.surrAct.TSurrActSumVo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnvironmentActivitiesSummaryVo extends TSurrActSumVo{

	private Date inspDate;
	
	private String actStatus;
	
	private String actType;
	
	private long latestActId;
}
