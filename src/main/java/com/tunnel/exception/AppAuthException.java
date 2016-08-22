package com.tunnel.exception;

import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

/**
 * Exception thrown while authenticating user
 */
public class AppAuthException extends AuthenticationException {

	private static final long serialVersionUID = -3754957408216752119L;

    @Getter
    private final String msg;

    public AppAuthException(String message) {
        super(message);
        this.msg = message;
    }

    public AppAuthException(String msg, Exception ex) {
        super(msg, ex);
        this.msg = msg;
    }
}
