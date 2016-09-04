package com.tunnel.vo.typeList;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiseaseTypeVo {

	private String id;

	private String diseaseTypeName;

	private BigDecimal canArea;

	private BigDecimal canDepth;

	private BigDecimal canDislocation;

	private BigDecimal canJointopen;

	private BigDecimal canLength;

	private BigDecimal canWidth;

}
