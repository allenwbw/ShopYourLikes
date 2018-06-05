package com.ucla.shopyourlikes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * custom exception for INTERNAL_SERVER_ERRO
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException{

    /**
     *
     * @param message custom message
     */
    public AppException(String message) {
        super(message);
    }

    /**
     *
     * @param message custom message
     * @param cause root cause of the exception
     */
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
