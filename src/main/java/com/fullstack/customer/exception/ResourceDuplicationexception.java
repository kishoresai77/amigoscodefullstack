package com.fullstack.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT)
public class ResourceDuplicationexception extends RuntimeException {
    public ResourceDuplicationexception(String message) {
        super(message);
    }
}
