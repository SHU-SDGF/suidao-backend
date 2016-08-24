package com.tunnel.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tunnel.model.EnvironmentActitivitySummary;
import com.tunnel.model.EnvironmentActivity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateEnvironmentActitivitySummaryReqVo {

	private EnvironmentActitivitySummary environmentActitivitySummary;
	
	private EnvironmentActivity environmentActivity;
}
