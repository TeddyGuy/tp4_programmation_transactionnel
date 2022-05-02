package com.javatown.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InsufficientAmountOfCopiesException extends RuntimeException{
    public InsufficientAmountOfCopiesException(){
        super("No copies remaining");
    }
}
