package com.javatown.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DocumentAttributeMissingException extends RuntimeException{
    public DocumentAttributeMissingException(String message){
        super("Missing the following attributes : " + message);
    }
}