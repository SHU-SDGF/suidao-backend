package com.tunnel.web.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.model.TFacilityInspDetail;
import com.tunnel.model.TFacilityInspSum;
import com.tunnel.repository.FacilityInspDetailRepo;
import com.tunnel.repository.TFacilityInspSumRepo;
import com.tunnel.vo.facilityInsp.FacilityInspVo;
import com.tunnel.vo.facilityInsp.TFacilityInspDetailVo;
import com.tunnel.vo.facilityInsp.TFacilityInspSumVo;
import com.tunnel.vo.facilityInsp.resp.FacilityInspRespVo;
import com.tunnel.vo.facilityInsp.resp.TFacilityInspDetailRespVo;
import com.tunnel.vo.facilityInsp.resp.TFacilityInspSumRespVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

@RestController
@Slf4j
@RequestMapping
public class FacilityInspController extends BaseController {

	@Autowired
	private FacilityInspDetailRepo facilityInspDetailRepo;

	@Autowired
	private TFacilityInspSumRepo facilityInspSumRepo;

	@ApiOperation("给出今天的巡查活动总数，用于病害编号的后三位流水号， 病害编号diseaseNo=巡检日期（8位）+流水号（3位）")
	@RequestMapping(value = "/facility-insp/getCountOfToday", method = RequestMethod.GET)
	public long getCountOfToday() {
		return facilityInspSumRepo.countByCreateDateAfter(new DateTime().withTimeAtStartOfDay().toDate());
	}

	// public static void main(String args[]) {
	// System.out.println(new Date());
	// DateTime st = new DateTime();
	// Calendar cal = Calendar.getInstance();
	// cal.add(Calendar.DATE, -1);
	// System.out.println(cal.getTime());
	//
	// System.out.println(st.withTimeAtStartOfDay().toDate());
	//
	// System.out.println(st.minusMonths(6).toDate());
	// }

	@ApiOperation("返回前台2年内地下巡检详细信息以及汇总信息")
	@RequestMapping(value = "/facility-insp/download", method = RequestMethod.GET)
	public List<FacilityInspVo> downloadFacilityInsp() {
		log.info("enter listFacilityInsp...");

		Date sinceDate = new DateTime().minusYears(2).toDate();

		return facilityInspSumRepo.findByCreateDateAfter(sinceDate).map(e -> {
			FacilityInspVo resp = new FacilityInspVo();
			resp.setFacilityInspSum(mapper.map(e, TFacilityInspSumVo.class));
			resp.setFacilityInspDetailList(
					facilityInspDetailRepo.findByDiseaseNoCreateDateAfter(sinceDate, e.getDiseaseNo())
							.map(d -> mapper.map(d, TFacilityInspDetailVo.class)).collect(Collectors.toList()));
			return resp;
		}).collect(Collectors.toList());
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
	// TFacilityInspDetailVo.class)).collect(Collectors.toList()));
	// result.setFacilityInspSumList(facilityInspSumRepo.findByCreateDateAfter(sinceDate)
	// .map(s -> mapper.map(s,
	// TFacilityInspSumVo.class)).collect(Collectors.toList()));
	// return result;
	// }

	@ApiOperation("处理前台上传的地下巡检详细信息以及汇总信息")
	@RequestMapping(value = "/facility-insp/upload", method = RequestMethod.POST)
	public List<FacilityInspRespVo> uploadFacilityInsp(@RequestBody List<FacilityInspVo> uploadList) {
		log.info("enter uploadFacilityInsp...");
		return uploadList.stream().map(facilityInsp -> {

			FacilityInspRespVo resp = new FacilityInspRespVo();
			/***** start saving sum *****/
			TFacilityInspSumVo sum = facilityInsp.getFacilityInspSum();
			TFacilityInspSumRespVo respSum = new TFacilityInspSumRespVo();
			if (sum.isNewCreated()) {
				try {
					TFacilityInspSum sumEntity = mapper.map(sum, TFacilityInspSum.class);
					sumEntity = facilityInspSumRepo.save(sumEntity);
					respSum = mapper.map(sumEntity, TFacilityInspSumRespVo.class);
					respSum.setSuccess(true);
				} catch (Exception e) {
					respSum = mapper.map(sum, TFacilityInspSumRespVo.class);
					respSum.setSuccess(false);
					respSum.setMessage(e.getMessage());
				}
			} else {
				respSum = mapper.map(sum, TFacilityInspSumRespVo.class);
				respSum.setSuccess(true);
			}
			resp.setFacilityInspRespSum(respSum);
			/***** end saving sum *****/

			/***** start saving detail list ****/
			List<TFacilityInspDetailVo> detailList = facilityInsp.getFacilityInspDetailList();
			List<TFacilityInspDetailRespVo> respDetailList = detailList.stream().map(detail -> {
				TFacilityInspDetailRespVo detailRespVo = new TFacilityInspDetailRespVo();
				if (detail.isNewCreated()) {
					try {
						TFacilityInspDetail detailEntity = mapper.map(detail, TFacilityInspDetail.class);
						detailEntity.setId(0);
						detailEntity = facilityInspDetailRepo.save(detailEntity);
						detailRespVo = mapper.map(detailEntity, TFacilityInspDetailRespVo.class);
						detailRespVo.setSuccess(true);
					} catch (Exception e) {
						detailRespVo = mapper.map(detail, TFacilityInspDetailRespVo.class);
						detailRespVo.setSuccess(true);
						detailRespVo.setMessage(e.getMessage());
					}
				} else {
					detailRespVo = mapper.map(detail, TFacilityInspDetailRespVo.class);
					detailRespVo.setSuccess(true);
				}
				return detailRespVo;
			}).collect(Collectors.toList());
			resp.setFacilityInspDetailRespList(respDetailList);
			/***** end saving detail list ****/

			return resp;
			
		}).collect(Collectors.toList());
	}

//	@ApiOperation("列出一页地下巡检详细信息")
//	@RequestMapping(value = "/facility-insp-detail/list", method = RequestMethod.GET)
//	public Page<TFacilityInspDetail> getFacilityInspDetailPage(
//			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
//		return facilityInspDetailRepo.findAll(pageable);
//	}
//
//	@ApiOperation("列出一页地下巡检汇总信息")
//	@RequestMapping(value = "/facility-insp-summary/list", method = RequestMethod.GET)
//	public Page<TFacilityInspSum> getFacilityInspSumPage(
//			@PageableDefault(value = 10, sort = { "id" }, direction = Direction.DESC) Pageable pageable) {
//		return facilityInspSumRepo.findAll(pageable);
//	}
}
