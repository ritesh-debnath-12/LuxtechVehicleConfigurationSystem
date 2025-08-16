package com.lukxtech.powertrain.enginefamily.abstracts.exceptions;

public class BadRPMValueException extends RuntimeException {
    public BadRPMValueException(String message) {
        super(message);
    }
}
