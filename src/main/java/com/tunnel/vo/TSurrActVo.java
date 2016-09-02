package com.tunnel.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TSurrActVo extends BaseVo{

	private int id;

	private String actNo;

	private String actStatus;

	private String actType;

	private String audio;

	private String description;

	private Date inspDate;

	private String photo;
	
	private String recorder;

//	@Column(name="synchronize", columnDefinition = "char")
//	private String synChronize = "1";

	private String video;
}
