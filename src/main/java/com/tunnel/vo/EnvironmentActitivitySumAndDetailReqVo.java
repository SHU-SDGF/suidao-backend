package com.tunnel.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tunnel.model.TSurrActSum;
import com.tunnel.model.TSurrAct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnvironmentActitivitySumAndDetailReqVo {

	private TSurrActSum environmentActitivitySummary;
	
	private TSurrAct environmentActivity;
}
