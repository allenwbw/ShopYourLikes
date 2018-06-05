package com.ucla.shopyourlikes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  custom BadRequestException for HttpStatus.BAD_REQUES
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
     *
     * @param message custom message
     */
    public BadRequestException(String message) {
        super(message);
    }

    /**
     *
     * @param message custom message
     * @param cause root cause of the exception
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}