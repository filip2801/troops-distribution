package com.filip2801.goodgame.troopsdistribution.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class CannotDistributeTroopsException extends RuntimeException {

    CannotDistributeTroopsException(String message) {
        super(message);
    }
}
