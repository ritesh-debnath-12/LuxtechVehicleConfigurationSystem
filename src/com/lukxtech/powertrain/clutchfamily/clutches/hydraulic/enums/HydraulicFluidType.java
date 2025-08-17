package com.lukxtech.powertrain.clutchfamily.clutches.hydraulic.enums;

import com.lukxtech.powertrain.clutchfamily.clutches.hydraulic.exceptions.InvalidHydraulicFluidTypeException;

public enum HydraulicFluidType {
    DOT3, DOT4, DOT5;

    public static HydraulicFluidType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "dot3" -> DOT3;
            case "dot4" -> DOT4;
            case "dot5" -> DOT5;
            default -> throw new InvalidHydraulicFluidTypeException("INVALID FLUID TYPE! GOT: " + type + "\nPERMISSIVE: dot3, dot4, dot5");
        };
    }
}
