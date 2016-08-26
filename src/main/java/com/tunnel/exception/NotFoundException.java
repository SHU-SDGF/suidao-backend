package com.tunnel.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Wayne Cao on 2/17/2016.
 */
@Getter
@Slf4j
public class NotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(String msg) {
        super(msg);
    }

    public static NotFoundException _new(String msg) {
        return new NotFoundException(msg);
    }
}