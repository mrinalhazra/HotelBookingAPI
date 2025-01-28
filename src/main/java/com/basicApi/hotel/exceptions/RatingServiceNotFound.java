package com.basicApi.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RatingServiceNotFound extends RuntimeException {

    public RatingServiceNotFound(String message) {
        super(message);
    }
}
