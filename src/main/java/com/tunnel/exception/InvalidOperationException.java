package com.tunnel.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Wayne Cao on 2/17/2016.
 */
@Getter
@Slf4j
public class InvalidOperationException extends RuntimeException {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOperationException(String msg) {
        super(msg);
    }

}