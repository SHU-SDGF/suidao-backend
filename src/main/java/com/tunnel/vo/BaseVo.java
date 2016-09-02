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
public class BaseVo {

	private String createUser;

	private Long updateCnt;
	
	private boolean delFlg;
	
	private Date createDate;

	private Date updateDate;
}
