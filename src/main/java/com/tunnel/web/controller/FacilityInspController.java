package com.tunnel.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.model.TFacilityInspDetail;
import com.tunnel.model.TFacilityInspSum;
import com.tunnel.model.TSurrAct;
import com.tunnel.repository.FacilityInspDetailRepo;
import com.tunnel.repository.TFacilityInspSumRepo;
import com.tunnel.vo.EnvironmentActivitiesSummaryVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping
public class FacilityInspController extends BaseController{
	
	@Autowired
	private FacilityInspDetailRepo facilityInspDetailRepo;
	
	@Autowired
	private TFacilityInspSumRepo facilityInspSumRepo;

	@ApiOperation("给出当前巡检表数据最大ID值")
	@RequestMapping(value = "/facility-insp/getMaxFacilityInspDetailId", method = RequestMethod.GET)
	public long getMaxFacilityInspDetailId(){
		return 1;//max id number
	}
	
	@ApiOperation("列出一页地下巡检详细信息")
	@RequestMapping(value = "/facility-insp-detail/list", method = RequestMethod.GET)
	public Page<TFacilityInspDetail> getFacilityInspDetailPage(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
		return facilityInspDetailRepo.findAll(pageable);
	}
	
	@ApiOperation("列出一页地下巡检汇总信息")
	@RequestMapping(value = "/facility-insp-summary/list", method = RequestMethod.GET)
	public Page<TFacilityInspSum> getFacilityInspSumPage(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
		return facilityInspSumRepo.findAll(pageable);
	}
}
