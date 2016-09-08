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
import com.tunnel.repository.DiseaseTypeRepo;
import com.tunnel.repository.FacilityInspDetailRepo;
import com.tunnel.repository.FacilityTypeRepo;
import com.tunnel.repository.FacilityRepo;
import com.tunnel.repository.ModelRepo;
import com.tunnel.repository.MonomerRepo;
import com.tunnel.repository.PosDespListRepo;
import com.tunnel.repository.TFacilityInspSumRepo;
import com.tunnel.vo.facilityInsp.FacilityInspVo;
import com.tunnel.vo.facilityInsp.FacilityInspDetailVo;
import com.tunnel.vo.facilityInsp.FacilityInspSumVo;
import com.tunnel.vo.facilityInsp.resp.FacilityInspRespVo;
import com.tunnel.vo.facilityInsp.resp.TFacilityInspDetailRespVo;
import com.tunnel.vo.facilityInsp.resp.TFacilityInspSumRespVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@RestController
@Slf4j
@RequestMapping
public class FacilityInspController extends BaseController {

	@Autowired
	private FacilityInspDetailRepo facilityInspDetailRepo;

	@Autowired
	private TFacilityInspSumRepo facilityInspSumRepo;

	@Autowired
	private MonomerRepo monomerRepo;

	@Autowired
	private FacilityRepo facilityRepo;

	@Autowired
	private FacilityTypeRepo facilityTypeRepo;

	@Autowired
	private PosDespListRepo posDespListRepo;

	@Autowired
	private ModelRepo modelRepo;

	@Autowired
	private DiseaseTypeRepo diseaseTypeRepo;

	private FacilityInspDetail saveFacilityInspDetail(FacilityInspDetailVo detail) {
		FacilityInspDetail detailEntity = mapper.map(detail, FacilityInspDetail.class);
		detailEntity.setId(null);
		String id = detailEntity.getDetailType().getId();
		if (detailEntity.getDetailType() != null && isNotBlank(id)) {
			detailEntity.setDetailType(diseaseTypeRepo.findById(id).orElse(null));
		} else {
			detailEntity.setDetailType(null);
		}

		id = detailEntity.getDiseaseType().getId();
		if (detailEntity.getDiseaseType() != null && isNotBlank(id)) {
			detailEntity.setDiseaseType(diseaseTypeRepo.findById(id).orElse(null));
		} else {
			detailEntity.setDiseaseType(null);
		}

		detailEntity = facilityInspDetailRepo.save(detailEntity);
		return detailEntity;
	}

	private FacilityInspSum updateFacilityInspSum(FacilityInspSumVo sum) {
		FacilityInspSum sumEntity = facilityInspSumRepo.findByDiseaseNo(sum.getDiseaseNo())
				.orElseThrow(() -> new RuntimeException("没有这个diseaseNo"));
		sumEntity.setArea(sum.getArea());
		sumEntity.setDepth(sum.getDepth());
		sumEntity.setDiseaseDiscription(sum.getDiseaseDiscription());
		sumEntity.setDislocation(sum.getDislocation());
		sumEntity.setJointopen(sum.getJointopen());
		sumEntity.setLength(sum.getLength());
		sumEntity.setPhoto(sum.getPhoto());
		sumEntity.setRecorder(sum.getRecorder());
		sumEntity.setWidth(sum.getWidth());
//		String id = sumEntity.getDetailType().getId();
//		if (sumEntity.getDetailType() != null && isNotBlank(id)) {
//			sumEntity.setDetailType(diseaseTypeRepo.findById(id).orElse(null));
//		} else {
//			sumEntity.setDetailType(null);
//		}
//
//		id = sumEntity.getDiseaseType().getId();
//		if (sumEntity.getDiseaseType() != null && isNotBlank(id)) {
//			sumEntity.setDiseaseType(diseaseTypeRepo.findById(id).orElse(null));
//		} else {
//			sumEntity.setDiseaseType(null);
//		}
		return facilityInspSumRepo.save(sumEntity);
	}

	private FacilityInspSum saveFacilityInspSum(FacilityInspSumVo sum) {
		FacilityInspSum sumEntity = mapper.map(sum, FacilityInspSum.class);
//		String id = sumEntity.getMonomer().getId();
//		if (sumEntity.getMonomer() != null && isNotBlank(id)) {
//			sumEntity.setMonomer(monomerRepo.findById(id).orElse(null));
//		} else {
//			sumEntity.setMonomer(null);
//		}
//
//		id = sumEntity.getFacility().getId();
//		if (sumEntity.getFacility() != null && isNotBlank(id)) {
//			sumEntity.setFacility(facilityRepo.findById(id).orElseThrow(() -> new RuntimeException("找不到这个设施号")));
//		} else {
//			throw new RuntimeException("找不到这个设施号");
//		}
//
//		id = sumEntity.getFacilityType().getId();
//		if (sumEntity.getFacilityType() != null && isNotBlank(id)) {
//			sumEntity.setFacilityType(facilityTypeRepo.findById(id).orElse(null));
//		} else {
//			sumEntity.setFacilityType(null);
//		}
//
//		id = sumEntity.getPosDespList().getId();
//		if (sumEntity.getPosDespList() != null && isNotBlank(id)) {
//			sumEntity.setPosDespList(posDespListRepo.findById(id).orElse(null));
//		} else {
//			sumEntity.setPosDespList(null);
//		}
//
//		id = sumEntity.getModelNameList().getId();
//		if (sumEntity.getModelNameList() != null && isNotBlank(id)) {
//			sumEntity.setModelNameList(modelRepo.findById(id).orElse(null));
//		} else {
//			sumEntity.setModelNameList(null);
//		}
//
//		id = sumEntity.getDetailType().getId();
//		if (sumEntity.getDetailType() != null && isNotBlank(id)) {
//			sumEntity.setDetailType(diseaseTypeRepo.findById(id).orElse(null));
//		} else {
//			sumEntity.setDetailType(null);
//		}
//
//		id = sumEntity.getDiseaseType().getId();
//		if (sumEntity.getDiseaseType() != null && isNotBlank(id)) {
//			sumEntity.setDiseaseType(diseaseTypeRepo.findById(id).orElse(null));
//		} else {
//			sumEntity.setDiseaseType(null);
//		}

		sumEntity = facilityInspSumRepo.save(sumEntity);
		return sumEntity;
	}

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

		// 如果数据量太大，则修改oracle 设置
		// alter system set open_cursors=3000 scope=both;
		return facilityInspSumRepo.findByCreateDateAfterAndIsFromMobileTrue(sinceDate).map(e -> {
			FacilityInspVo resp = new FacilityInspVo();
			resp.setFacilityInspSum(mapper.map(e, FacilityInspSumVo.class));
			resp.setFacilityInspDetailList(
					facilityInspDetailRepo.findByDiseaseNoCreateDateAfter(sinceDate, e.getDiseaseNo())
							.map(d -> mapper.map(d, FacilityInspDetailVo.class)).collect(Collectors.toList()));
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
		return uploadList.stream().map(facilityInsp -> {

			FacilityInspRespVo resp = new FacilityInspRespVo();
			/***** start saving sum *****/
			FacilityInspSumVo sum = facilityInsp.getFacilityInspSum();
			TFacilityInspSumRespVo respSum = new TFacilityInspSumRespVo(sum.getDiseaseNo());
			try {
				if (sum.isNewCreated()) {
					saveFacilityInspSum(sum);
				} else {
					updateFacilityInspSum(sum);
				}
				respSum.setSuccess(true);
			} catch (Exception e) {
				log.error("error saving/updating facility insp sum", e);
				respSum.setSuccess(false);
				respSum.setMessage(e.getMessage());
			}

			resp.setFacilityInspRespSum(respSum);
			/***** end saving sum *****/

			/***** start saving detail list ****/
			List<FacilityInspDetailVo> detailList = facilityInsp.getFacilityInspDetailList();
			List<TFacilityInspDetailRespVo> respDetailList = detailList.stream().map(detail -> {
				TFacilityInspDetailRespVo detailRespVo = new TFacilityInspDetailRespVo(detail.getId());
				try {
					if (detail.isNewCreated()) {
						saveFacilityInspDetail(detail);
					}
					detailRespVo.setSuccess(true);
				} catch (Exception e) {
					log.error("error saving facility insp detail", e);
					detailRespVo.setSuccess(false);
					detailRespVo.setMessage(e.getMessage());
				}
				return detailRespVo;
			}).collect(Collectors.toList());
			resp.setFacilityInspDetailRespList(respDetailList);
			/***** end saving detail list ****/

			return resp;

		}).collect(Collectors.toList());
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
