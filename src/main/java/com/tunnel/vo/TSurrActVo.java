package com.tunnel.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TSurrActVo {

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
