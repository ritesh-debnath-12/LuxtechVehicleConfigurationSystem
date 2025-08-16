package com.lukxtech.powertrain.enginefamily.engines.electric.exceptions;

public class BadBatteryCapacityValueException extends RuntimeException {
    public BadBatteryCapacityValueException(String message) {
        super(message);
    }
}
