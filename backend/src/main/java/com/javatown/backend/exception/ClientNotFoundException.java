package com.javatown.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(long id) {
        super("Could not find client with id : " + id);
    }
}
