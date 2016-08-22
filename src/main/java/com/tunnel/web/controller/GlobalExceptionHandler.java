package com.tunnel.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tunnel.exception.AppAuthException;
import com.tunnel.exception.AppException;
import com.tunnel.exception.DuplicateException;
import com.tunnel.exception.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by jbelligund001 on 2/17/2016.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateException.class)
    public void conflict(HttpServletRequest request, HttpServletResponse response, DuplicateException ex)
            throws IOException {
        log.info("Entering the conflict handler");
        response.sendError(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public void notFound(HttpServletRequest request, HttpServletResponse response,
                         NotFoundException ex) throws IOException {
        log.info("Entering the NotFoundException handler");
        response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }


    @ExceptionHandler(AppException.class)
    public void appException(HttpServletRequest request, HttpServletResponse response,
                             AppException ex) throws IOException {
        log.info("Entering the AppException handler");
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void invalidArguments(HttpServletResponse response, MethodArgumentNotValidException ex) throws IOException {
        BindingResult result = ex.getBindingResult();
        String msg = result.getFieldErrors()
                .stream()
                .map(this::error)
                .collect(Collectors.joining(" "));

        response.sendError(HttpStatus.BAD_REQUEST.value(), msg);
    }


    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletResponse response, Exception e) throws Exception {

        log.info("Entering the default error handler");

        if (e instanceof DuplicateException || e instanceof NotFoundException
                || e instanceof MethodArgumentNotValidException || e instanceof AppException ||
                e instanceof AppAuthException) {
            throw e;
        }

        log.error(e.getMessage(), e);
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    private String error(FieldError error) {
        return (error != null) ? error.getDefaultMessage() : "";
    }

}