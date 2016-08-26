package com.tunnel.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Wayne Cao on 2/17/2016.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangePwdResponseVo {

    public static enum Type {
        SUCCESS, INFO, WARNING, ERROR
    }

    private String message;
    private Type type;
    private String errorCode;

    private ChangePwdResponseVo() {
    }

    public static ChangePwdResponseVo withErrorCode(String message, String errorCode) {

        ChangePwdResponseVo changePwdResponseVo = new ChangePwdResponseVo();
        changePwdResponseVo.message = message;
        changePwdResponseVo.type = Type.ERROR;
        changePwdResponseVo.errorCode = errorCode;

        return changePwdResponseVo;
    }

    public static ChangePwdResponseVo withSuccessMsg(String message) {

        ChangePwdResponseVo changePwdResponseVo = new ChangePwdResponseVo();
        changePwdResponseVo.message = message;
        changePwdResponseVo.type = Type.SUCCESS;

        return changePwdResponseVo;
    }

    public static ChangePwdResponseVo withErrorMsg(String message) {

        ChangePwdResponseVo changePwdResponseVo = new ChangePwdResponseVo();
        changePwdResponseVo.message = message;
        changePwdResponseVo.type = Type.ERROR;
        return changePwdResponseVo;
    }
}

