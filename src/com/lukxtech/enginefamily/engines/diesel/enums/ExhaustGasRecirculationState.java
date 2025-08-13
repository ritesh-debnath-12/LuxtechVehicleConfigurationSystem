package com.lukxtech.enginefamily.engines.diesel.enums;

import com.lukxtech.enginefamily.engines.diesel.exceptions.InvalidExhaustGasRecirculationStateException;

/**
 * <p>Exhaust Gas Recirculation State Enum</p>
 * <p>This enum represents the different states of the exhaust gas recirculation (EGR) system.</p>
 * <p>Currently, applicable values: </p>
 * <ul>
 * <li>OFF</li>
 * <li>ON</li>
 * <li>VARIABLE</li>
 * </ul>
 *
 * <p>This enum comes with a static fromString factory method to convert String to enum values.</p>
 */
public enum ExhaustGasRecirculationState {
    OFF, ON, VARIABLE;

    public static ExhaustGasRecirculationState fromString(String state) {
        return switch (state.toLowerCase().trim()) {
            case "off" -> OFF;
            case "on" -> ON;
            case "variable" -> VARIABLE;
            default ->
                    throw new InvalidExhaustGasRecirculationStateException("BAD EGR STATE! GOT: " + state + "\n PERMISSIVE: off, on, variable");
        };
    }
}
