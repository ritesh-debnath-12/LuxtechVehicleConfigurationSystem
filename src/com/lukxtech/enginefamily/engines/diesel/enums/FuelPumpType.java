package com.lukxtech.enginefamily.engines.diesel.enums;

import com.lukxtech.enginefamily.engines.diesel.exceptions.InvalidFuelPumpTypeException;

public enum FuelPumpType {
    INLINE, ROTARY, COMMON_RAIL;

    public static FuelPumpType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "inline" -> INLINE;
            case "rotary" -> ROTARY;
            case "common_rail" -> COMMON_RAIL;
            default -> throw new InvalidFuelPumpTypeException("BAD FUEL PUMP! GOT: " + type + "\nPERMISSIVE: inline, rotary, common_rail");
        };
    }
}
