package com.tunnel.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@ControllerAdvice
public class BaseController {

    @Autowired
    private MessageSource msgSource;
    
    private Locale currentLocale = LocaleContextHolder.getLocale();
    


//   @ExceptionHandler(Exception.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Exception handleInternalError(Exception ex) {
//    	log.error("500 INTERNAL SERVER ERROR", ex);
//        return ex;
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Exception handleNotFoundException(NotFoundException ex) {
//        log.error(ex.getMessage(), ex);
//        return ex;
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ValidationErrorVo handleValidationErrors(MethodArgumentNotValidException ex) {
//        ValidationErrorVo dto = new ValidationErrorVo();
//        for (FieldError fieldError: ex.getBindingResult().getFieldErrors()) {
//            dto.addFieldError(fieldError.getField(), msg(fieldError.getDefaultMessage()));
//        }
//        return dto;
//    }

    protected String msg(String code){
        return msgSource.getMessage(code, null, currentLocale);
    }

//    @ExceptionHandler(AppAuthException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public Exception handleAuthException(AppAuthException ex) {
//        return ex;
//    }
}
