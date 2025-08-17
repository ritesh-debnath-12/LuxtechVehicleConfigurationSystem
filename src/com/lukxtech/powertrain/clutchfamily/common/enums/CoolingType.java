package com.lukxtech.powertrain.clutchfamily.common.enums;

import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidCoolingTypeException;

public enum CoolingType {
    WET, DRY; // very vague, can it not be oil, water, IDK carbon-pad or something?

    public static CoolingType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "wet" -> WET;
            case "dry" -> DRY;
            default -> throw new InvalidCoolingTypeException("INVALID COOLING TYPE! GOT: " + type + "\nPERMISSIVE: wet, dry");
        };
    }
}
