package com.lukxtech.enginefamily.engines.diesel.enums;

import com.lukxtech.enginefamily.engines.diesel.exceptions.InvalidExhaustGasRecirculationStateException;

public enum ExhaustGasRecirculationState {
    OFF, ON, VARIABLE;

    public static ExhaustGasRecirculationState fromString(String state) {
        return switch (state.toLowerCase().trim()) {
            case "off" -> OFF;
            case "on" -> ON;
            case "variable" -> VARIABLE;
            default -> throw new InvalidExhaustGasRecirculationStateException("BAD EGR STATE! GOT: " + state + "\n PERMISSIVE: off, on, variable");
        };
    }
}
