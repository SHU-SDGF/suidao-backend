package com.tunnel.web.controller;

import com.tunnel.model.EnvironmentActitivitySummary;
import com.tunnel.repository.EnvironmentActitivitySummaryRepo;
import com.tunnel.service.EnvironmentActitivitySummaryService;
import com.tunnel.vo.CreateEnvironmentActitivitySummaryReqVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping()
public class EnvironmentActitivitySummaryController extends BaseController {

	@Autowired
	private EnvironmentActitivitySummaryRepo environmentActitivitySummaryRepo;

	@Autowired
	private EnvironmentActitivitySummaryService environmentActitivitySummaryService;

	@RequestMapping(value = "/environment-activities-summary/list/", method = RequestMethod.GET)
	@ResponseBody
	public Page<EnvironmentActitivitySummary> get(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
		return environmentActitivitySummaryRepo.findAll(pageable);
	}

	@RequestMapping(value = "/createEnvironmentActivity/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CreateEnvironmentActitivitySummaryReqVo> create(
			@RequestBody CreateEnvironmentActitivitySummaryReqVo vo) {
		log.info("create a new environment activities summary");
		return new ResponseEntity<>(environmentActitivitySummaryService.createEnvironmentActitivitySummary(vo),
				HttpStatus.OK);
	}

}
