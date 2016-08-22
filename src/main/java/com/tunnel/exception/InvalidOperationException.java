package com.tunnel.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jbelligund001 on 2/17/2016.
 */
@Getter
@Slf4j
public class InvalidOperationException extends RuntimeException {


    public InvalidOperationException(String msg) {
        super(msg);
    }

}