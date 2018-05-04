package com.ucla.shopyourlikes.security;

import org.springframework.security.core.AuthenticationException;

public class SylAuthenticationException extends AuthenticationException {

    public SylAuthenticationException(String msg) {
        super(msg);
    }
}
