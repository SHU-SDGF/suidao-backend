package com.tunnel.service.imp;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tunnel.model.FacilityInspDetail;
import com.tunnel.model.FacilityInspSum;
import com.tunnel.repository.FacilityInspDetailRepo;
import com.tunnel.repository.TFacilityInspSumRepo;
import com.tunnel.service.FacilityInspService;
import com.tunnel.vo.facilityInsp.FacilityInspDetailVo;
import com.tunnel.vo.facilityInsp.FacilityInspSumVo;
import com.tunnel.vo.facilityInsp.FacilityInspVo;
import com.tunnel.vo.facilityInsp.resp.FacilityInspRespVo;
import com.tunnel.vo.facilityInsp.resp.TFacilityInspDetailRespVo;
import com.tunnel.vo.facilityInsp.resp.TFacilityInspSumRespVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FacilityInspServiceImpl implements FacilityInspService{

	@Autowired
	private FacilityInspDetailRepo facilityInspDetailRepo;

	@Autowired
	private TFacilityInspSumRepo facilityInspSumRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	// @Autowired
	// private MonomerRepo monomerRepo;
	//
	// @Autowired
	// private FacilityRepo facilityRepo;
	//
	// @Autowired
	// private FacilityTypeRepo facilityTypeRepo;
	//
	// @Autowired
	// private PosDespListRepo posDespListRepo;
	//
	// @Autowired
	// private ModelRepo modelRepo;
	//
	// @Autowired
	// private DiseaseTypeRepo diseaseTypeRepo;

	private FacilityInspDetail saveFacilityInspDetail(FacilityInspDetailVo detail) {
		FacilityInspDetail detailEntity = mapper.map(detail, FacilityInspDetail.class);
		detailEntity.setId(null);
		// String id = detailEntity.getDetailType().getId();
		// if (detailEntity.getDetailType() != null && isNotBlank(id)) {
		// detailEntity.setDetailType(diseaseTypeRepo.findById(id).orElse(null));
		// } else {
		// detailEntity.setDetailType(null);
		// }
		//
		// id = detailEntity.getDiseaseType().getId();
		// if (detailEntity.getDiseaseType() != null && isNotBlank(id)) {
		// detailEntity.setDiseaseType(diseaseTypeRepo.findById(id).orElse(null));
		// } else {
		// detailEntity.setDiseaseType(null);
		// }

		detailEntity = facilityInspDetailRepo.save(detailEntity);
		return detailEntity;
	}

	private FacilityInspSum updateFacilityInspSum(FacilityInspSumVo sum) {
		FacilityInspSum sumEntity = facilityInspSumRepo.findByDiseaseNo(sum.getDiseaseNo())
				.orElseThrow(() -> new RuntimeException("没有这个diseaseNo"));
		sumEntity.setArea(sum.getArea());
		sumEntity.setDepth(sum.getDepth());
		sumEntity.setDiseaseDescription(sum.getDiseaseDescription());
		sumEntity.setDislocation(sum.getDislocation());
		sumEntity.setJointopen(sum.getJointopen());
		sumEntity.setLength(sum.getLength());
		sumEntity.setPhoto(sum.getPhoto());
		sumEntity.setRecorder(sum.getRecorder());
		sumEntity.setWidth(sum.getWidth());
		// String id = sumEntity.getDetailType().getId();
		// if (sumEntity.getDetailType() != null && isNotBlank(id)) {
		// sumEntity.setDetailType(diseaseTypeRepo.findById(id).orElse(null));
		// } else {
		// sumEntity.setDetailType(null);
		// }
		//
		// id = sumEntity.getDiseaseType().getId();
		// if (sumEntity.getDiseaseType() != null && isNotBlank(id)) {
		// sumEntity.setDiseaseType(diseaseTypeRepo.findById(id).orElse(null));
		// } else {
		// sumEntity.setDiseaseType(null);
		// }
		return facilityInspSumRepo.save(sumEntity);
	}
	
	private FacilityInspSum saveFacilityInspSum(FacilityInspSumVo sum) {
		FacilityInspSum sumEntity = mapper.map(sum, FacilityInspSum.class);
		// String id = sumEntity.getMonomer().getId();
		// if (sumEntity.getMonomer() != null && isNotBlank(id)) {
		// sumEntity.setMonomer(monomerRepo.findById(id).orElse(null));
		// } else {
		// sumEntity.setMonomer(null);
		// }
		//
		// id = sumEntity.getFacility().getId();
		// if (sumEntity.getFacility() != null && isNotBlank(id)) {
		// sumEntity.setFacility(facilityRepo.findById(id).orElseThrow(() -> new
		// RuntimeException("找不到这个设施号")));
		// } else {
		// throw new RuntimeException("找不到这个设施号");
		// }
		//
		// id = sumEntity.getFacilityType().getId();
		// if (sumEntity.getFacilityType() != null && isNotBlank(id)) {
		// sumEntity.setFacilityType(facilityTypeRepo.findById(id).orElse(null));
		// } else {
		// sumEntity.setFacilityType(null);
		// }
		//
		// id = sumEntity.getPosDespList().getId();
		// if (sumEntity.getPosDespList() != null && isNotBlank(id)) {
		// sumEntity.setPosDespList(posDespListRepo.findById(id).orElse(null));
		// } else {
		// sumEntity.setPosDespList(null);
		// }
		//
		// id = sumEntity.getModelNameList().getId();
		// if (sumEntity.getModelNameList() != null && isNotBlank(id)) {
		// sumEntity.setModelNameList(modelRepo.findById(id).orElse(null));
		// } else {
		// sumEntity.setModelNameList(null);
		// }
		//
		// id = sumEntity.getDetailType().getId();
		// if (sumEntity.getDetailType() != null && isNotBlank(id)) {
		// sumEntity.setDetailType(diseaseTypeRepo.findById(id).orElse(null));
		// } else {
		// sumEntity.setDetailType(null);
		// }
		//
		// id = sumEntity.getDiseaseType().getId();
		// if (sumEntity.getDiseaseType() != null && isNotBlank(id)) {
		// sumEntity.setDiseaseType(diseaseTypeRepo.findById(id).orElse(null));
		// } else {
		// sumEntity.setDiseaseType(null);
		// }

		sumEntity = facilityInspSumRepo.save(sumEntity);
		return sumEntity;
	}
	
	public long getCountOfToday(){
		return facilityInspSumRepo.countByCreateDateAfter(new DateTime().withTimeAtStartOfDay().toDate());
	}
	
	public List<FacilityInspVo> downloadFacilityInsp() {
		log.info("enter listFacilityInsp service ...");
		Date sinceDate = new DateTime().minusYears(5).toDate();

		// 如果数据量太大，则修改oracle 设置
		// alter system set open_cursors=3000 scope=both;
		return facilityInspSumRepo.findByCreateDateAfterAndIsFromMobileTrue(sinceDate).limit(2999).map(e -> {
			FacilityInspVo resp = new FacilityInspVo();
			FacilityInspSumVo sumVo = mapper.map(e, FacilityInspSumVo.class);
			sumVo.setSynFlg("0");
			resp.setFacilityInspSum(sumVo);
			resp.setFacilityInspDetailList(facilityInspDetailRepo
					.findByDiseaseNoCreateDateAfter(sinceDate, e.getDiseaseNo()).limit(5).map(d -> {
				FacilityInspDetailVo vo = mapper.map(d, FacilityInspDetailVo.class);
				vo.setSynFlg("0");
				return vo;
			}).collect(Collectors.toList()));
			return resp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public List<FacilityInspRespVo> uploadFacilityInsp(List<FacilityInspVo> uploadList){
		return uploadList.stream().map(facilityInsp -> {

			FacilityInspRespVo resp = new FacilityInspRespVo();
			/***** start saving sum *****/
			FacilityInspSumVo sum = facilityInsp.getFacilityInspSum();
			TFacilityInspSumRespVo respSum = new TFacilityInspSumRespVo(sum.getDiseaseNo());
			try {
				if (sum.getSynFlg().equals("1")) {
					saveFacilityInspSum(sum);
				} else if (sum.getSynFlg().equals("2")) {
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
					if (detail.getSynFlg().equals("1")) {
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
}