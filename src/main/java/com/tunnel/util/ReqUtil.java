package com.tunnel.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Wayne Cao on 2/15/2016.
 */
public class ReqUtil {

    private ReqUtil() {
    }

    public static void setErrorCode(String value) {
        request().setAttribute("errorCode",value);
    }

    public static void suppressedErrCause(Map<String,String> errorDetails) {
        request().setAttribute("suppressedCause",errorDetails);
    }

    private static HttpServletRequest request() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }
}
