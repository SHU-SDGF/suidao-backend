package com.tunnel.exception;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tunnel.util.ReqUtil;

import org.springframework.web.client.HttpStatusCodeException;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileUploadServiceException extends RuntimeException{

    private static ObjectMapper mapper = new ObjectMapper();

    private static TypeReference errMapType = new TypeReference<HashMap<String, String>>() {
    };

	public FileUploadServiceException(String message) {
		super(message);
	}

    public FileUploadServiceException(String msg, HttpStatusCodeException ex) {
        super(msg, ex);
        ReqUtil.suppressedErrCause(errDetails(ex));
    }

    private static Map<String,String> errDetails(HttpStatusCodeException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), errMapType);
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

}