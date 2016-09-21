package com.tunnel.service;

import java.util.List;

import com.tunnel.vo.facilityInsp.FacilityInspVo;
import com.tunnel.vo.facilityInsp.resp.FacilityInspRespVo;

public interface FacilityInspService {

	public long getCountOfToday();
	
	public List<FacilityInspVo> downloadFacilityInsp();
	
	public List<FacilityInspRespVo> uploadFacilityInsp(List<FacilityInspVo> uploadList);
	
}
