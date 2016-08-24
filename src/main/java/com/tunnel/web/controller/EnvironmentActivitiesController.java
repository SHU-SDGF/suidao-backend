package com.tunnel.web.controller;

import com.tunnel.model.EnvironmentActitivitySummary;
import com.tunnel.model.EnvironmentActivity;
import com.tunnel.repository.EnvironmentActitivitySummaryRepo;
import com.tunnel.repository.EnvironmentActivityRepo;
import com.tunnel.service.EnvironmentActitivitySummaryService;
import com.tunnel.vo.CreateEnvironmentActitivitySummaryReqVo;

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

	@RequestMapping(value = "/createEnvironmentActivity", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CreateEnvironmentActitivitySummaryReqVo> createEnvironmentActivity(
			@RequestBody CreateEnvironmentActitivitySummaryReqVo vo) {
		log.info("create a new environment activities summary");
		return new ResponseEntity<>(environmentActitivitySummaryService.createEnvironmentActitivitySummary(vo),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/environment-activities/list", method = RequestMethod.GET)
	@ResponseBody
	public Page<EnvironmentActivity> getEnvironmentActivityPage(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
		return environmentActivityRepo.findAll(pageable);
	}

	@RequestMapping(value = "/environment-activities/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<EnvironmentActivity> createEnvironmentActivityDetail(@RequestBody EnvironmentActivity environmentActivity) {
		return new ResponseEntity<>(environmentActivityRepo.save(environmentActivity), HttpStatus.OK);
	}


	@RequestMapping(value = "/environment-activities/listByActNo/{actNo}", method = RequestMethod.GET)
	@ResponseBody
	public Page<EnvironmentActivity> get(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable,
			@PathVariable("actNo") String actNo) {
		return environmentActivityRepo.findAllByActNo(actNo, pageable);
	}
	
	@RequestMapping(value = "/environment-activities-summary/list", method = RequestMethod.GET)
	@ResponseBody
	public Page<EnvironmentActitivitySummary> getEnvironmentActitivitySummaryPage(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
		return environmentActitivitySummaryRepo.findAll(pageable);
	}

}
