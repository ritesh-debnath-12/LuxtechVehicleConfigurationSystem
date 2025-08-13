package com.lukxtech.enginefamily.engines.diesel.enums;

import com.lukxtech.enginefamily.engines.diesel.exceptions.InvalidTurbochargerTypeException;

/**
 * <p> Turbocharger Type Enum</p>
 * <p>This enum represents the different types of turbochargers used in diesel engines.</p>
 * <p>Currently, applicable values: </p>
 * <ul>
 * <li>NONE</li>
 * <li>SINGLE</li>
 * <li>TWIN</li>
 * <li>VARIABLE_GEOMETRY</li>
 * </ul>
 *
 * <p>This enum comes with a static fromString factory method to convert String to enum values.</p>
 */
public enum TurbochargerType {
    NONE, SINGLE, TWIN, VARIABLE_GEOMETRY;

    public static TurbochargerType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "none" -> NONE;
            case "single" -> SINGLE;
            case "twin" -> TWIN;
            case "variable_geometry" -> VARIABLE_GEOMETRY;
            default ->
                    throw new InvalidTurbochargerTypeException("BAD TURBOCHARGER TYPE! GOT: " + type + "\nPERMISSIVE: none, single, twin, variable_geometry");
        };
    }
}
