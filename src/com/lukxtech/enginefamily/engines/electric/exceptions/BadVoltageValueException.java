package com.lukxtech.enginefamily.engines.electric.exceptions;

public class BadVoltageValueException extends RuntimeException {
    public BadVoltageValueException(String message) {
        super(message);
    }
}
