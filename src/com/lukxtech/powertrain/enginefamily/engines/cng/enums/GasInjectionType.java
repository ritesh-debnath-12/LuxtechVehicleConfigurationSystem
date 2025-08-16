package com.lukxtech.powertrain.enginefamily.engines.cng.enums;

import com.lukxtech.powertrain.enginefamily.engines.cng.exceptions.InvalidGasInjectionTypeException;


/**
 * <p>Gas Injection Types</p>
 * <p>This enum represents the different types of gas injection systems.</p>
 * <p>Currently applicable values:</p>
 * <ul>
 * <li>SEQUENTIAL</li>
 * <li>SEQUENTIAL_DIRECT</li>
 * <li>VENTURI</li>
 * </ul>
 * <p>
 * This enum comes with a static fromString factory method to convert strings to enum values.
 */
public enum GasInjectionType {
    SEQUENTIAL, SEQUENTIAL_DIRECT, VENTURI;

    public static GasInjectionType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "sequential" -> SEQUENTIAL;
            case "sequential_direct" -> SEQUENTIAL_DIRECT;
            case "venturi" -> VENTURI;
            default ->
                    throw new InvalidGasInjectionTypeException("BAD GAS INJECTION TYPE! GOT: " + type + "\nPERMISSIVE: sequential, sequential_direct, venturi");
        };
    }
}
