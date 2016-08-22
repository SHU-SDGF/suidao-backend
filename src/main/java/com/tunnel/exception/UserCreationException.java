package com.tunnel.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jbelligund001 on 2/17/2016.
 */
@Getter
@Slf4j
public class UserCreationException extends AppException {

    /**
     * Thrown while user creation error
     *
     * @param msg Error msg
     * @param ex  The stacktrace
     */
    public UserCreationException(String msg, Exception ex) {
        super(msg, ex);
    }

}