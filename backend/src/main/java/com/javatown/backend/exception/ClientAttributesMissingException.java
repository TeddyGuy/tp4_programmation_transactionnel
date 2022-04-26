package com.javatown.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientAttributesMissingException extends RuntimeException{
    public ClientAttributesMissingException(String message) {
        super("Missing the following attributes : " + message);
    }
}
