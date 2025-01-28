package com.basicApi.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IdAlreadyExistsException extends RuntimeException{
    public IdAlreadyExistsException(String message) {
        super(message);
    }
}
