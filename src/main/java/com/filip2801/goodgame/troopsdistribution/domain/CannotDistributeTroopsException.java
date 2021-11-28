package com.filip2801.goodgame.troopsdistribution.domain;

public class CannotDistributeTroopsException extends RuntimeException {

    CannotDistributeTroopsException(String message) {
        super(message);
    }
}
