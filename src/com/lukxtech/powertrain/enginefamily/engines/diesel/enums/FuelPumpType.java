package com.lukxtech.powertrain.enginefamily.engines.diesel.enums;

import com.lukxtech.powertrain.enginefamily.engines.diesel.exceptions.InvalidFuelPumpTypeException;

/**
 * <p>Fuel Pump Type Enum</p>
 * <p>This enum represents the different types of fuel pumps used in diesel engines.</p>
 * <p>Currently, applicable values: </p>
 * <ul>
 * <li>INLINE</li>
 * <li>ROTARY</li>
 * <li>COMMON_RAIL</li>
 * </ul>
 *
 * <p>This enum comes with a static fromString factory method to convert String to enum values.</p>
 */
public enum FuelPumpType {
    INLINE, ROTARY, COMMON_RAIL;

    public static FuelPumpType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "inline" -> INLINE;
            case "rotary" -> ROTARY;
            case "common_rail" -> COMMON_RAIL;
            default ->
                    throw new InvalidFuelPumpTypeException("BAD FUEL PUMP! GOT: " + type + "\nPERMISSIVE: inline, rotary, common_rail");
        };
    }
}
