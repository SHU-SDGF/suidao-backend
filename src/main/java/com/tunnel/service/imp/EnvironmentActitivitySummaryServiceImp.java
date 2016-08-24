package com.tunnel.service.imp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tunnel.model.EnvironmentActitivitySummary;
import com.tunnel.model.EnvironmentActivity;
import com.tunnel.service.EnvironmentActitivitySummaryService;
import com.tunnel.vo.CreateEnvironmentActitivitySummaryReqVo;
import com.tunnel.repository.EnvironmentActivityRepo;
import com.tunnel.repository.EnvironmentActitivitySummaryRepo;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EnvironmentActitivitySummaryServiceImp implements EnvironmentActitivitySummaryService {

	@Autowired
	private EnvironmentActitivitySummaryRepo environmentActitivitySummaryRepo;

	@Autowired
	private EnvironmentActivityRepo environmentActitivityRepo;
	
	private DateFormat format = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	@Transactional
	public CreateEnvironmentActitivitySummaryReqVo createEnvironmentActitivitySummary(
			CreateEnvironmentActitivitySummaryReqVo vo) {
		log.info("creating new activity ...");
		
		EnvironmentActitivitySummary activitySummary = environmentActitivitySummaryRepo.save(vo.getEnvironmentActitivitySummary());
		EnvironmentActivity activity = environmentActitivityRepo.save(vo.getEnvironmentActivity());

		/**
		 * logic to generate act_no
		 * 编码规则：活动类型（1位）+日期（首次发现活动的日期）8位+序号（2位）
		 */
	    // 0 代表前面补充0         
	    // 2 代表长度为2         
	    // d 代表参数为正数型         
	    String serialStr = String.format("%02d", activity.getNo()%100); 
		String actNo = activity.getActType().substring(0, 1) + format.format(new Date()) + serialStr;
		activity.setActNo(actNo);
		activitySummary.setActNo(actNo);
		
		activitySummary = environmentActitivitySummaryRepo.save(vo.getEnvironmentActitivitySummary());
		activity = environmentActitivityRepo.save(vo.getEnvironmentActivity());
		
		vo.setEnvironmentActitivitySummary(activitySummary);
		vo.setEnvironmentActivity(activity);
		
		return vo;
	}

}
