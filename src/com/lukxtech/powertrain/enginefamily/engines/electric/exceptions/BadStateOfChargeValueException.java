package com.lukxtech.powertrain.enginefamily.engines.electric.exceptions;

public class BadStateOfChargeValueException extends RuntimeException {
    public BadStateOfChargeValueException(String message) {
        super(message);
    }
}
