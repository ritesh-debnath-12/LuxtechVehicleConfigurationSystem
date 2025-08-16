package com.lukxtech.powertrain.enginefamily.engines.electric.exceptions;

public class BadVoltageValueException extends RuntimeException {
    public BadVoltageValueException(String message) {
        super(message);
    }
}
