package com.lukxtech.powertrain.enginefamily.engines.cng.exceptions;

public class BadCylinderPressureValueException extends RuntimeException {
    public BadCylinderPressureValueException(String message) {
        super(message);
    }
}
