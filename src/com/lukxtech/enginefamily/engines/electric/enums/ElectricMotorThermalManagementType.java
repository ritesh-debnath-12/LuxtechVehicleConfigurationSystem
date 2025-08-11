package com.lukxtech.enginefamily.engines.electric.enums;

import com.lukxtech.enginefamily.engines.electric.exceptions.InvalidElectricMotorThermalManagementTypeException;

public enum ElectricMotorThermalManagementType {
    ACTIVE_LIQUID_COOLING, PASSIVE;

    public static ElectricMotorThermalManagementType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "active_liquid_cooling" -> ACTIVE_LIQUID_COOLING;
            case "passive" -> PASSIVE;
            default -> throw new InvalidElectricMotorThermalManagementTypeException("BAD THERMAL MANAGEMENT TYPE! GOT: " + type + "\nPERMISSIVE: active_liquid_cooling, passive");
        };
    }
}
