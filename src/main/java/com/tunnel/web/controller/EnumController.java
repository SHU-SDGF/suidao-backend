package com.tunnel.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tunnel.model.FacilityType;
import com.tunnel.model.Facility;
import com.tunnel.model.ModelNameList;
import com.tunnel.model.Monomer;
import com.tunnel.model.PosDespList;
import com.tunnel.repository.DiseaseTypeRepo;
import com.tunnel.repository.FacilityTypeRepo;
import com.tunnel.repository.FacilityRepo;
import com.tunnel.repository.ModelNameListRepo;
import com.tunnel.repository.MonomerRepo;
import com.tunnel.repository.PosDespListRepo;
import com.tunnel.vo.typeList.DiseaseTypeTreeVo;
import com.tunnel.vo.typeList.DiseaseTypeVo;
import com.tunnel.vo.typeList.WholeEnumTypeVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/enum")
public class EnumController extends BaseController {

	@Autowired
	private DiseaseTypeRepo diseaseTypeRepo;

	@Autowired
	private FacilityTypeRepo facilityTypeRepo;

	@Autowired
	private FacilityRepo facilityRepo;

	@Autowired
	private ModelNameListRepo modelNameListRepo;

	@Autowired
	private PosDespListRepo posDespListRepo;
	
	@Autowired
	private MonomerRepo monomerRepo;

	@ApiOperation("列出所有枚举类型")
	@RequestMapping(value = "/whole-enum-type/list", method = RequestMethod.GET)
	@ResponseBody
	public WholeEnumTypeVo listWholeEnumType() {
		return WholeEnumTypeVo.builder()
				.monomer(monomerRepo.findAll().stream().map(e -> mapper.map(e, Monomer.class))
				.collect(Collectors.toList()))
				.diseaseTypeList(diseaseTypeRepo.findByParentIsNull().map(e -> mapper.map(e, DiseaseTypeVo.class))
						.collect(Collectors.toList()))
				.diseaseTypeTreeVoList(diseaseTypeRepo.findByParentIsNull()
						.map(e -> mapper.map(e, DiseaseTypeTreeVo.class)).collect(Collectors.toList()))
				.facilityTypeList(facilityTypeRepo.findAll()).facilityList(facilityRepo.findAll())
				.modelNameList(modelNameListRepo.findAll()).posDespList(posDespListRepo.findAll()).build();
	}
	
	@ApiOperation("列出单体名称枚举")
	@RequestMapping(value = "/monomer-no/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Monomer> listMonomerNo() {
		return monomerRepo.findAll().stream().map(e -> mapper.map(e, Monomer.class))
				.collect(Collectors.toList());
	}

	@ApiOperation("列出病害类型枚举")
	@RequestMapping(value = "/disease-type/list", method = RequestMethod.GET)
	@ResponseBody
	public List<DiseaseTypeVo> listDiseaseType() {
		return diseaseTypeRepo.findAll().stream().map(e -> mapper.map(e, DiseaseTypeVo.class))
				.collect(Collectors.toList());
	}

	@ApiOperation("列出病害类型枚举树状结构")
	@RequestMapping(value = "/disease-type/listTree", method = RequestMethod.GET)
	@ResponseBody
	public List<DiseaseTypeTreeVo> listDiseaseTypeTree() {
		return diseaseTypeRepo.findByParentIsNull().map(e -> mapper.map(e, DiseaseTypeTreeVo.class))
				.collect(Collectors.toList());
	}

	@ApiOperation("列出设施小类枚举")
	@RequestMapping(value = "/facility-type/list", method = RequestMethod.GET)
	@ResponseBody
	public List<FacilityType> ListFacilityType() {
		return facilityTypeRepo.findAll();
	}

	@ApiOperation("列出设施信息")
	@RequestMapping(value = "/facility/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Facility> listFacility() {
		return facilityRepo.findAll();
	}

	@ApiOperation("列出模型名字列表")
	@RequestMapping(value = "/model-name/list", method = RequestMethod.GET)
	@ResponseBody
	public List<ModelNameList> listModelName() {
		return modelNameListRepo.findAll();
	}

	@ApiOperation("列出位置描述列表")
	@RequestMapping(value = "/pos-desp/list", method = RequestMethod.GET)
	@ResponseBody
	public List<PosDespList> listPosDesp() {
		return posDespListRepo.findAll();
	}

}
