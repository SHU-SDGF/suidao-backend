package com.tunnel.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Getter
@Setter
public class MailParametersVo implements Serializable{
	
	private static final long serialVersionUID = -4702736245422316162L;
	
	private Long id;

	private String appName;

	private String from;

	private String subject;

	private String content;

	private List<String> to;

	private List<String> cc;

	private List<String> bcc;
	
	public void setTos(String to){
		if(isNotBlank(to)){
			this.to=asList(to.split(","));
		}
	}
	
	public void setCcs(String cc){
		if(isNotBlank(cc)){
			this.cc=asList(cc.split(","));
		}
	}
	
	public void setBccs(String bcc){
		if(isNotBlank(bcc)){
			this.bcc=asList(bcc.split(","));
		}
	}
	
	public String getTos(){
		if(to == null || to.isEmpty()) return null;
		return to.toString().trim().replace("[", "").replace("]", "");
	}
	
	public String getCCs(){
		if(cc == null || cc.isEmpty()) return null;
		return cc.toString().trim().replace("[", "").replace("]", "");
	}
	
	public String getBccs(){
		if(bcc == null || bcc.isEmpty()) return null;
		return bcc.toString().trim().replace("[", "").replace("]", "");
	}
}
