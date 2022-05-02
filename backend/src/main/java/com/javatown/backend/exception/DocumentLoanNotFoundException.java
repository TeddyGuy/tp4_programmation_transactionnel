package com.javatown.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DocumentLoanNotFoundException extends RuntimeException{
    public DocumentLoanNotFoundException(long id){
        super("Could not find document loan with id : " + id);
    }
}
