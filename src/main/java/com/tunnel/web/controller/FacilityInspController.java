package com.tunnel.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.model.TFacilityInspDetail;
import com.tunnel.model.TFacilityInspSum;
import com.tunnel.repository.FacilityInspDetailRepo;
import com.tunnel.repository.TFacilityInspSumRepo;
import com.tunnel.vo.FacilityInspVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping
public class FacilityInspController extends BaseController {

	@Autowired
	private FacilityInspDetailRepo facilityInspDetailRepo;

	@Autowired
	private TFacilityInspSumRepo facilityInspSumRepo;

	@ApiOperation("给出当前巡检表数据最大ID值")
	@RequestMapping(value = "/facility-insp/getMaxFacilityInspDetailId", method = RequestMethod.GET)
	public long getMaxFacilityInspDetailId() {
		return 1;// max id number
	}

	@ApiOperation("列出2年内地下巡检详细信息以及汇总信息")
	@RequestMapping(value = "/facility-insp/list", method = RequestMethod.GET)
	public FacilityInspVo listFacilityInsp() {
		log.info("enter listFacilityInsp...");
		FacilityInspVo result = new FacilityInspVo();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -2);//2年前
//		cal.add(Calendar.MONTH, -6);// 半年前
		Date sinceDate = cal.getTime();

		result.setFacilityInspDetailList(
				facilityInspDetailRepo.findByCreateDateAfter(sinceDate).collect(Collectors.toList()));
		result.setFacilityInspSumList(
				facilityInspSumRepo.findByCreateDateAfter(sinceDate).collect(Collectors.toList()));
		return result;
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
