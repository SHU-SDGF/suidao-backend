package com.tunnel.web.controller;

import com.tunnel.model.EnvironmentActivity;
import com.tunnel.repository.EnvironmentActivityRepo;

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
@RequestMapping("/environment-activities")
public class EnvironmentActivitiesController extends BaseController {

	@Autowired
	private EnvironmentActivityRepo environmentActivityRepo;

	@RequestMapping(value = "/list/", method = RequestMethod.GET)
	@ResponseBody
	public Page<EnvironmentActivity> get(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
		return environmentActivityRepo.findAll(pageable);
	}

	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<EnvironmentActivity> create(@RequestBody EnvironmentActivity environmentActivity) {
		return new ResponseEntity<>(environmentActivityRepo.save(environmentActivity), HttpStatus.OK);
	}


	@RequestMapping(value = "/listByActNo/{actNo}", method = RequestMethod.GET)
	@ResponseBody
	public Page<EnvironmentActivity> get(
			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable,
			@PathVariable("actNo") String actNo) {
		return environmentActivityRepo.findAllByActNo(actNo, pageable);
	}
}
