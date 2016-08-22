package com.tunnel.enums;

import lombok.Getter;

@Getter
public enum EmailTemplateTypeEnum {
	
	EXTERNAL_USER_REGISTERATION("external-user-registeration.tmpl"),
	EXTERNAL_USER_CREDENTIAL("external-user-credential.tmpl");
	
	
    private String templateFileName;
    
	private EmailTemplateTypeEnum(String templateFileName) {
		this.templateFileName = templateFileName;
	}

}
