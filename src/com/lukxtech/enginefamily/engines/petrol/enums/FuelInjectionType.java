package com.lukxtech.enginefamily.engines.petrol.enums;

import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidFuelInjectionTypeException;

/**
 * <p>Fuel Injection Type Enum</p>
 * <p>This enum represents the different types of fuel injection systems.</p>
 * <p>Currently applicable values:</p>
 * <ul>
 * <li>CARBURETOR</li>
 * <li>MULTI_POINT_INJECTION</li>
 * <li>DIRECT_INJECTION</li>
 * </ul>
 * <p>
 * This enum comes with a static fromString factory method to convert strings to enum values.
 */
public enum FuelInjectionType {
    CARBURETOR, MULTI_POINT_INJECTION, DIRECT_INJECTION;

    public static FuelInjectionType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "carburetor" -> CARBURETOR;
            case "multi_point_injection" -> MULTI_POINT_INJECTION;
            case "direct_injection" -> DIRECT_INJECTION;
            default ->
                    throw new InvalidFuelInjectionTypeException("BAD INJECTION TYPE! GOT: " + type + "\nPERMISSIVE: carburetor, multi_point_injection, direct_injection");
        };
    }
}
