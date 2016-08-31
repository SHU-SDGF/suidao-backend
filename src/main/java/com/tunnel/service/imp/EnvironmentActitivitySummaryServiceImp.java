package com.tunnel.service.imp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tunnel.model.TSurrActSum;
import com.tunnel.model.TSurrAct;
import com.tunnel.service.EnvironmentActitivitySummaryService;
import com.tunnel.vo.EnvironmentActitivitySumAndDetailReqVo;
import com.tunnel.repository.EnvironmentActivityRepo;
import com.tunnel.repository.SurrInfoRepo;
import com.tunnel.repository.EnvironmentActitivitySummaryRepo;

import lombok.extern.slf4j.Slf4j;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@Slf4j
public class EnvironmentActitivitySummaryServiceImp implements EnvironmentActitivitySummaryService {

	@Autowired
	private EnvironmentActitivitySummaryRepo environmentActitivitySummaryRepo;

	@Autowired
	private EnvironmentActivityRepo environmentActitivityRepo;

	@Autowired
	private SurrInfoRepo surrInfoRepo;

	private DateFormat format = new SimpleDateFormat("yyyyMMdd");

	@Override
	@Transactional
	public EnvironmentActitivitySumAndDetailReqVo createEnvironmentActitivitySummary(
			EnvironmentActitivitySumAndDetailReqVo vo) {
		log.info("creating new activity ...");

		TSurrActSum activitySummary = vo.getEnvironmentActitivitySummary();
		TSurrAct activity = vo.getEnvironmentActivity();

		/**
		 * logic to generate act_no 编码规则：活动类型（1位）+日期（首次发现活动的日期）8位+序号（2位）
		 */
		// 0 代表前面补充0
		// 2 代表长度为2
		// d 代表参数为正数型
		String serialStr = String.format("%02d", environmentActitivitySummaryRepo.count() % 100);
		String actNo = activity.getActivityType().substring(0, 1) + format.format(new Date()) + serialStr;
		activity.setActNo(actNo);
		activitySummary.setActNo(actNo);

		//周边环境
//		if (activitySummary.getTSurrInfo() == null || isBlank(activitySummary.getTSurrInfo().getSurroundNo())) {
//			activitySummary.setTSurrInfo(null);
//		} else {
//			activitySummary.setTSurrInfo(surrInfoRepo.getOne(activitySummary.getTSurrInfo().getSurroundNo()));
//		}
		
		//删除标记
		activitySummary.setDelFlg(false);
		activitySummary.setDelFlg(false);

		activitySummary = environmentActitivitySummaryRepo.saveAndFlush(activitySummary);
		activity = environmentActitivityRepo.saveAndFlush(activity);

		vo.setEnvironmentActitivitySummary(activitySummary);
		vo.setEnvironmentActivity(activity);

		return vo;
	}

}
