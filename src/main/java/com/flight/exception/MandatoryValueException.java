package com.flight.exception;

public class MandatoryValueException extends RuntimeException {

    public MandatoryValueException(String msg) {
        super(msg);
    }
}
