package com.tunnel.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jbelligund001 on 6/29/2016.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitiationVo {

    private String componentName;

    private String msg;

    private String initiated;
    
    private String execId;

    public InitiationVo() {
    }

    public InitiationVo(String componentName,String msg) {
        this.componentName = componentName;
        this.msg = msg;
    }
}
