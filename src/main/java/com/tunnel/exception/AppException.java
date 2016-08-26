package com.tunnel.exception;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tunnel.util.ReqUtil;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wayne Cao on 2/17/2016.
 */
@Getter
@Slf4j
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final ObjectMapper mapper = new ObjectMapper();

    private static final TypeReference errMapType = new TypeReference<HashMap<String, String>>() {
    };

    public AppException(String msg) {
        super(msg);
    }

    public AppException(String msg, Throwable ex) {
        super(msg, ex);
        if(ex instanceof HttpClientErrorException){
            ReqUtil.suppressedErrCause(errDetails((HttpClientErrorException)ex));
        }
    }

    private static Map<String,String> errDetails(HttpClientErrorException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), errMapType);
        } catch (IOException e) {
            log.error("Error while marshalling error details",e);
            return Collections.emptyMap();
        }
    }
}