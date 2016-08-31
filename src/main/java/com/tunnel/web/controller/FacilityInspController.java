package com.tunnel.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.repository.FacilityInspDetailRepo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/facility-insp")
public class FacilityInspController extends BaseController{
	
	private FacilityInspDetailRepo facilityInspDetailRepo;

	public long getMaxFacilityInspDetailId(){
		return facilityInspDetailRepo.count();
	}
	
}
