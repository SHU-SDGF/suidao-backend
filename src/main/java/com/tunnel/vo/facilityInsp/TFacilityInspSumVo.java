package com.tunnel.vo.facilityInsp;

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
	private String id;

	private String diseaseNo;
	
	private String mileage;

	private Date diseaseDate;

	private String photoStandard;

	private String tagId;

	private MonomerNoListVo monomerNoList;

	private MFacilityListVo MFacilityList;

	private FacilityTypeVo facilityType;

	private PosDespListVo posDespList;

	private ModelNameListVo modelNameList;
	
	boolean isNewCreated;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ModelNameListVo {
	private String modelName;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class PosDespListVo {
	private String posDesp;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class MonomerNoListVo {
	private String monomerNo;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class MFacilityListVo {
	private String facilityNo;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class FacilityTypeVo {
	private String facilityType;
}