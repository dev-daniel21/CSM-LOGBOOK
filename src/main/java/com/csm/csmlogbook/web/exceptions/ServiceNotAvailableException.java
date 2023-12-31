package com.csm.csmlogbook.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public
class ServiceNotAvailableException extends RuntimeException{


    public ServiceNotAvailableException(String message) {
        super(message);
    }
}
