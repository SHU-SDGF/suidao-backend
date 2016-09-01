package com.tunnel.vo;

import java.util.List;

import com.tunnel.model.TFacilityInspDetail;
import com.tunnel.model.TFacilityInspSum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FacilityInspVo {

	private List<TFacilityInspDetail> facilityInspDetailList;
	
	private List<TFacilityInspSum> facilityInspSumList;
}
