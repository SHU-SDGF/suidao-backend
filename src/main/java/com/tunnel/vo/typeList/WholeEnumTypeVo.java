package com.tunnel.vo.typeList;


import java.util.List;

import com.tunnel.model.FacilityType;
import com.tunnel.model.MFacilityList;
import com.tunnel.model.ModelNameList;
import com.tunnel.model.PosDespList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class WholeEnumTypeVo {

	//病害类型枚举
	private List<DiseaseTypeVo> diseaseTypeList;
	
	//病害类型枚举树状结构
	private List<DiseaseTypeTreeVo> diseaseTypeTreeVoList;
	
	//设施小类枚举
	private List<FacilityType> facilityTypeList;
	
	//设施信息
	private List<MFacilityList> facilityList;
	
	//模型名字列表
	private List<ModelNameList> modelNameList;
	
	//位置描述列表
	private List<PosDespList> posDespList;
}
