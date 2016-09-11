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
import com.tunnel.model.Model;
import com.tunnel.model.Monomer;
import com.tunnel.model.PosDespList;
import com.tunnel.model.User;
import com.tunnel.repository.DiseaseTypeRepo;
import com.tunnel.repository.FacilityTypeRepo;
import com.tunnel.repository.FacilityRepo;
import com.tunnel.repository.ModelRepo;
import com.tunnel.repository.MonomerRepo;
import com.tunnel.repository.PosDespListRepo;
import com.tunnel.repository.UserRepo;
import com.tunnel.vo.UserVo;
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
	private ModelRepo modelRepo;

	@Autowired
	private PosDespListRepo posDespListRepo;

	@Autowired
	private MonomerRepo monomerRepo;

	@Autowired
	private UserRepo userRepo;

	@ApiOperation("列出所有枚举类型")
	@RequestMapping(value = "/whole-enum-type/list", method = RequestMethod.GET)
	@ResponseBody
	public WholeEnumTypeVo listWholeEnumType() {
		log.info("downloading whole enum type...");
		return WholeEnumTypeVo.builder().monomer(monomerRepo.findAll())
				.diseaseTypeList(diseaseTypeRepo.findByParentNoIsNull().map(e -> mapper.map(e, DiseaseTypeVo.class))
						.collect(Collectors.toList()))
				.diseaseTypeTreeVoList(diseaseTypeRepo.findByParentNoIsNull()
						.map(e -> mapper.map(e, DiseaseTypeTreeVo.class)).map(root -> {
							root.setChildren(diseaseTypeRepo.findByParentNo(root.getId())
									.map(c -> mapper.map(c, DiseaseTypeTreeVo.class)).collect(Collectors.toList()));
							return root;
						}).collect(Collectors.toList()))
				.facilityTypeList(facilityTypeRepo.findAll()).facilityList(facilityRepo.findAll())
				.modelList(modelRepo.findAll()).posDespList(posDespListRepo.findAll())
				.userList(userRepo.findAll().stream().map(this::mapUserVo).collect(Collectors.toList())).build();
	}

	@ApiOperation("列出所有用户")
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	@ResponseBody
	public List<UserVo> listUser() {
		return userRepo.findAll().stream().map(this::mapUserVo).collect(Collectors.toList());
	}

	private UserVo mapUserVo(User u) {
		UserVo vo = mapper.map(u, UserVo.class);
		vo.setPassword(null);
		return vo;
	}

	@ApiOperation("列出单体名称枚举")
	@RequestMapping(value = "/monomer-no/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Monomer> listMonomerNo() {
		return monomerRepo.findAll();
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
		return diseaseTypeRepo.findByParentNoIsNull().map(e -> mapper.map(e, DiseaseTypeTreeVo.class)).map(root -> {
			root.setChildren(diseaseTypeRepo.findByParentNo(root.getId())
					.map(c -> mapper.map(c, DiseaseTypeTreeVo.class)).collect(Collectors.toList()));
			return root;
		}).collect(Collectors.toList());
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
	public List<Model> listModelName() {
		return modelRepo.findAll();
	}

	@ApiOperation("列出位置描述列表")
	@RequestMapping(value = "/pos-desp/list", method = RequestMethod.GET)
	@ResponseBody
	public List<PosDespList> listPosDesp() {
		return posDespListRepo.findAll();
	}

}
