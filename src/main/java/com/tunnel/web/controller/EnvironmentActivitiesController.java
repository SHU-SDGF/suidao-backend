package com.tunnel.web.controller;

import com.tunnel.exception.AppException;
import com.tunnel.model.TSurrAct;
import com.tunnel.model.TSurrActSum;
import com.tunnel.repository.EnvironmentActitivitySummaryRepo;
import com.tunnel.repository.EnvironmentActivityRepo;
import com.tunnel.service.EnvironmentActitivitySummaryService;
import com.tunnel.vo.EnvironmentActitivitySumAndDetailReqVo;
import com.tunnel.vo.EnvironmentActivitiesSummaryVo;
import com.tunnel.vo.EnvironmentActivitiesVo;

import io.swagger.annotations.ApiOperation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping
public class EnvironmentActivitiesController extends BaseController {

	@Autowired
	private EnvironmentActivityRepo environmentActivityRepo;

	@Autowired
	private EnvironmentActitivitySummaryRepo environmentActitivitySummaryRepo;

	@Autowired
	private EnvironmentActitivitySummaryService environmentActitivitySummaryService;

	@ApiOperation("列出一页活动和活动历史，活动历史是最新的一条活动历史")
	@RequestMapping(value = "/environment-activities-summary/list", method = RequestMethod.GET)
	@ResponseBody
	public Page<EnvironmentActivitiesSummaryVo> getEnvironmentActitivitySummaryPage(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
		return environmentActitivitySummaryRepo.findByDelFlgFalseAndLatitudeNotNull(pageable).map(sum -> {
			EnvironmentActivitiesSummaryVo sumVo = mapper.map(sum, EnvironmentActivitiesSummaryVo.class);
			TSurrAct latestAct = environmentActivityRepo
					.findTopByActNoAndDelFlgFalseOrderByInspDateDesc(sumVo.getActNo()).orElseGet(() -> new TSurrAct());
			Date inspDate = latestAct.getInspDate();
			sumVo.setInspDate(inspDate);
			String actStatus = latestAct.getActStatus();
			sumVo.setActStatus(actStatus);
			sumVo.setLatestActId(latestAct.getId());
			return sumVo;
		});
	}

	/**
	 * 根据id来找活动和活动历史 id是活动的id 活动历史是最新的一条活动历史
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id来找活动和活动历史, id是活动的id, 活动历史是最新的一条活动历史")
	@RequestMapping(value = "/environment-activities-summary/getById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public EnvironmentActitivitySumAndDetailReqVo getEnvironmentActitivitySummaryById(@PathVariable("id") String id) {
		TSurrActSum actSum = environmentActitivitySummaryRepo.findByIdAndDelFlgFalseAndLatitudeNotNull(id)
				.orElseThrow(() -> new AppException(msg("noSuchRecord")));
		TSurrAct latestAct = environmentActivityRepo.findTopByActNoAndDelFlgFalseOrderByInspDateDesc(actSum.getActNo())
				.orElseGet(() -> new TSurrAct());
		EnvironmentActitivitySumAndDetailReqVo resp = new EnvironmentActitivitySumAndDetailReqVo();

		resp.setEnvironmentActitivitySummary(actSum);
		resp.setEnvironmentActivity(latestAct);

		return resp;
	}

	@ApiOperation("根据id来创建活动和活动历史")
	@RequestMapping(value = "/environment-activities-summary/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<EnvironmentActitivitySumAndDetailReqVo> createEnvironmentActivity(
			@RequestBody EnvironmentActitivitySumAndDetailReqVo vo) {
		log.info("create a new environment activities summary");
		return new ResponseEntity<>(environmentActitivitySummaryService.createEnvironmentActitivitySummary(vo),
				HttpStatus.OK);
	}

	@ApiOperation("列出一页活动历史信息")
	@RequestMapping(value = "/environment-activities/list", method = RequestMethod.GET)
	@ResponseBody
	public Page<TSurrAct> getEnvironmentActivityPage(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
		return environmentActivityRepo.findByDelFlgFalse(pageable);
	}

	@ApiOperation("创建一条活动历史")
	@RequestMapping(value = "/environment-activities/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<EnvironmentActivitiesVo> createEnvironmentActivityDetail(
			@RequestBody TSurrAct environmentActivity) {
		TSurrActSum actSum = environmentActitivitySummaryRepo
				.findByActNoAndDelFlgFalseAndLatitudeNotNull(environmentActivity.getActNo())
				.orElseThrow(() -> new AppException("没有这个活动汇总记录 actNo"));

		TSurrAct oldestAct = environmentActivityRepo
				.findTopByActNoAndDelFlgFalseOrderByInspDateAsc(environmentActivity.getActNo())
				.orElseGet(() -> new TSurrAct());
		environmentActivity.setRecorder(oldestAct.getRecorder());
		environmentActivity.setActType(oldestAct.getActType());

		EnvironmentActivitiesVo resp = mapper.map(environmentActivityRepo.save(environmentActivity),
				EnvironmentActivitiesVo.class);
		resp.setActSumId(actSum.getId());
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@ApiOperation("根据活动编码查询活动历史")
	@RequestMapping(value = "/environment-activities/listByActNo/{actNo}", method = RequestMethod.GET)
	@ResponseBody
	public Page<TSurrAct> get(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable,
			@PathVariable("actNo") String actNo) {
		return environmentActivityRepo.findAllByActNoAndDelFlgFalse(actNo, pageable);
	}

}
