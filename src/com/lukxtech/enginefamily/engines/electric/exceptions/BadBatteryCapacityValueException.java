package com.lukxtech.enginefamily.engines.electric.exceptions;

public class BadBatteryCapacityValueException extends RuntimeException {
    public BadBatteryCapacityValueException(String message) {
        super(message);
    }
}
