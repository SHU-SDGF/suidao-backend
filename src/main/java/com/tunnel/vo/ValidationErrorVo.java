package com.tunnel.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationErrorVo {

    private List<ErrorVo> fieldErrors = new ArrayList<>();

    public ValidationErrorVo() {
    }

    public void addFieldError(String path, String message) {
        ErrorVo error = new ErrorVo(path, message);
        fieldErrors.add(error);
    }


    @Getter
    @AllArgsConstructor
    class ErrorVo {

        private String field;

        private String message;
    }
}