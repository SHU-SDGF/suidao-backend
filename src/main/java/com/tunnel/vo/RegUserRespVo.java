package com.tunnel.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tunnel.enums.UserTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Returned on registering a user successfully
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
public class RegUserRespVo implements Serializable {

	private static final long serialVersionUID = -2882123535378655056L;

	private String firstName;

    private String lastName;

    private String loginId;

    private String guid;

    private String mailId;
    
    private String token;

    private UserTypeEnum userType;

    public RegUserRespVo() {
    }
}