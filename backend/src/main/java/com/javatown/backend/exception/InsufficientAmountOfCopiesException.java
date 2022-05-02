package com.javatown.backend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class InsufficientAmountOfCopiesException extends RuntimeException{
    public InsufficientAmountOfCopiesException(){
        super("No copies remaining");
    }
}
