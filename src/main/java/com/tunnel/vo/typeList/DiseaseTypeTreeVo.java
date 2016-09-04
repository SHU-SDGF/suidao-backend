package com.tunnel.vo.typeList;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiseaseTypeTreeVo extends DiseaseTypeVo{

	private List<DiseaseTypeTreeVo> children;
}
