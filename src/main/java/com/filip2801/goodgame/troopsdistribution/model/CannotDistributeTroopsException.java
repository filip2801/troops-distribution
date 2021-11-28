package com.filip2801.goodgame.troopsdistribution.model;

public class CannotDistributeTroopsException extends RuntimeException {

    CannotDistributeTroopsException(String message) {
        super(message);
    }
}
