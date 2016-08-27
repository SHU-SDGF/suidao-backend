package com.tunnel.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnvironmentActivitiesSummaryVo extends TSurrActSumVo{

	private Date inspDate;
	
	private String actStatus;
}
