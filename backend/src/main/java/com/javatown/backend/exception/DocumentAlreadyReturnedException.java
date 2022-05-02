package com.javatown.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DocumentAlreadyReturnedException extends RuntimeException{
    public DocumentAlreadyReturnedException(){
        super("The document has already been returned");
    }
}
