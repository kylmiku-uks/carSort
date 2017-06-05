package com.rentalcars.carSort.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Nikolai on 5.06.2017.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String keyword) {
        super("Could not resolve keyword: '" + keyword + "'.");
    }
}
