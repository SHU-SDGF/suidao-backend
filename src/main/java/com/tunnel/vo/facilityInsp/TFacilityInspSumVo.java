package com.tunnel.vo.facilityInsp;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tunnel.vo.BaseVo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TFacilityInspSumVo extends BaseVo{

	private String diseaseNo;
	
	private String mileage;

	private Date diseaseDate;

	private String photoStandard;

	private String tagId;

	private MonomerVo monomer;

	private FacilityVo facility;

	private FacilityTypeVo facilityType;

	private PosDespListVo posDespList;

	private ModelNameListVo modelNameList;
	
	private BigDecimal latitude;
	
	private BigDecimal langitude;
	
	private Boolean isNewCreated;
	
	private Boolean isNeedRepair;
	
	/**
	 * start detail
	 */
	
	private BigDecimal area;

	private BigDecimal depth;

	private String diseaseDiscription;

	private BigDecimal dislocation;

	private BigDecimal jointopen;

	private BigDecimal length;

	private String photo;

	private String recorder;

	private BigDecimal width;

	private DiseaseTypeVo diseaseType;

	private DiseaseTypeVo detailType;
	
	/** 
	 * end detail
	 */
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ModelNameListVo {
	private String id;
	private String modelName;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class PosDespListVo {
	private String id;
	private String posDesp;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class MonomerVo {
	private String id;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class FacilityVo {
	private String id;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class FacilityTypeVo {
	private String id;
	private String facilityType;
}