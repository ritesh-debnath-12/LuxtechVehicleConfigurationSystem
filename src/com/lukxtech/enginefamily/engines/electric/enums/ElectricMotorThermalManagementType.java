package com.lukxtech.enginefamily.engines.electric.enums;

import com.lukxtech.enginefamily.engines.electric.exceptions.InvalidElectricMotorThermalManagementTypeException;

/**
 * <p>Thermal Management Type for Electric Motors Enum </p>
 * <p> This Enum represents the different types of thermal management systems used in electric motors.</p>
 * <p> Currently, applicable values: </p>
 * <ul>
 *     <li>ACTIVE_LIQUID_COOLING</li>
 *     <li>PASSIVE</li>
 * </ul>
 * <p>
 * This enum comes with a static fromString factory method to convert strings to enum values.
 */
public enum ElectricMotorThermalManagementType {
    ACTIVE_LIQUID_COOLING, PASSIVE;

    public static ElectricMotorThermalManagementType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "active_liquid_cooling" -> ACTIVE_LIQUID_COOLING;
            case "passive" -> PASSIVE;
            default ->
                    throw new InvalidElectricMotorThermalManagementTypeException("BAD THERMAL MANAGEMENT TYPE! GOT: " + type + "\nPERMISSIVE: active_liquid_cooling, passive");
        };
    }
}
