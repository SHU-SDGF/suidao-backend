package com.tunnel.web.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.model.FacilityInspDetail;
import com.tunnel.model.FacilityInspSum;
//import com.tunnel.repository.DiseaseTypeRepo;
import com.tunnel.repository.FacilityInspDetailRepo;
//import com.tunnel.repository.FacilityTypeRepo;
//import com.tunnel.repository.FacilityRepo;
//import com.tunnel.repository.ModelRepo;
//import com.tunnel.repository.MonomerRepo;
//import com.tunnel.repository.PosDespListRepo;
import com.tunnel.repository.TFacilityInspSumRepo;
import com.tunnel.service.FacilityInspService;
import com.tunnel.vo.facilityInsp.FacilityInspVo;
import com.tunnel.vo.facilityInsp.FacilityInspDetailVo;
import com.tunnel.vo.facilityInsp.FacilityInspSumVo;
import com.tunnel.vo.facilityInsp.resp.FacilityInspRespVo;
import com.tunnel.vo.facilityInsp.resp.TFacilityInspDetailRespVo;
import com.tunnel.vo.facilityInsp.resp.TFacilityInspSumRespVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
//import static org.apache.commons.lang3.StringUtils.isNotBlank;

@RestController
@Slf4j
@RequestMapping
public class FacilityInspController extends BaseController {

	

	@Autowired
	private FacilityInspService facilityInspService;




	@ApiOperation("给出今天的巡查活动总数，用于病害编号的后三位流水号， 病害编号diseaseNo=巡检日期（8位）+流水号（3位）")
	@RequestMapping(value = "/facility-insp/getCountOfToday", method = RequestMethod.GET)
	public long getCountOfToday() {
		return facilityInspService.getCountOfToday();
	}

	@ApiOperation("返回前台地下巡检详细信息以及汇总信息")
	@RequestMapping(value = "/facility-insp/download", method = RequestMethod.GET)
	public List<FacilityInspVo> downloadFacilityInsp() {
		log.info("enter listFacilityInsp...");

		return facilityInspService.downloadFacilityInsp();
	}

	// @ApiOperation("返回前台2年内地下巡检详细信息以及汇总信息, 第二种数据返回格式")
	// @RequestMapping(value = "/facility-insp/download2", method =
	// RequestMethod.GET)
	// public FacilityInspVo2 downloadFacilityInsp2() {
	// log.info("enter listFacilityInsp...");
	// FacilityInspVo2 result = new FacilityInspVo2();
	//
	// Date sinceDate = new DateTime().minusYears(2).toDate();
	//
	// result.setFacilityInspDetailList(facilityInspDetailRepo.findByCreateDateAfter(sinceDate)
	// .map(d -> mapper.map(d,
	// FacilityInspDetailVo.class)).collect(Collectors.toList()));
	// result.setFacilityInspSumList(facilityInspSumRepo.findByCreateDateAfter(sinceDate)
	// .map(s -> mapper.map(s,
	// FacilityInspSumVo.class)).collect(Collectors.toList()));
	// return result;
	// }

	@ApiOperation("处理前台上传的地下巡检详细信息以及汇总信息")
	@RequestMapping(value = "/facility-insp/upload", method = RequestMethod.POST)
	public List<FacilityInspRespVo> uploadFacilityInsp(@RequestBody List<FacilityInspVo> uploadList) {
		log.info("enter uploadFacilityInsp...");
		return facilityInspService.uploadFacilityInsp(uploadList);
	}

	// @ApiOperation("列出一页地下巡检详细信息")
	// @RequestMapping(value = "/facility-insp-detail/list", method =
	// RequestMethod.GET)
	// public Page<FacilityInspDetail> getFacilityInspDetailPage(
	// @PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC)
	// Pageable pageable) {
	// return facilityInspDetailRepo.findAll(pageable);
	// }
	//
	// @ApiOperation("列出一页地下巡检汇总信息")
	// @RequestMapping(value = "/facility-insp-summary/list", method =
	// RequestMethod.GET)
	// public Page<FacilityInspSum> getFacilityInspSumPage(
	// @PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC)
	// Pageable pageable) {
	// return facilityInspSumRepo.findAll(pageable);
	// }
}
