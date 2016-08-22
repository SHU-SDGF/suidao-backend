package com.tunnel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Overrides the default error controller to return a json response
 */
@RestController
@RequestMapping("/error")
public class AppErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping
    public Map<String, Object> error(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        if (response.getStatus() == 200) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return getErrorAttributes(request, response, false);
    }

    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        return (parameter != null) && !"false".equalsIgnoreCase(parameter);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest aRequest, HttpServletResponse response,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(aRequest);

        Map<String, Object> errorAttrs = this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
        errorAttrs.remove("exception");

        if(response.getStatus()==400){
            errorAttrs.remove("errors");
        }

        String errorCode = (String) aRequest.getAttribute("errorCode");
        if (isNotBlank(errorCode)) {
            errorAttrs.put("errorCode", errorCode);
        }

        if (aRequest.getAttribute("suppressedCause") != null) {
            final HashMap<String, String> errDetails = (HashMap<String, String>) aRequest.getAttribute("suppressedCause");
            errorAttrs.put("suppressedErrDetails", errDetails);
            errorAttrs.put("suppressedErrCode", errDetails.get("errorCode"));
            errorAttrs.put("message", errDetails.get("message"));
            errorAttrs.put("errorCode", errDetails.get("errorCode"));
        }

        return errorAttrs;
    }

    private boolean isNotBlank(String errorCode) {
        return (errorCode != null && errorCode.trim().length() != 0);
    }
}