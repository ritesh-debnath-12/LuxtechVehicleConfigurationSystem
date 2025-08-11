package com.lukxtech.enginefamily.engines.petrol.enums;

import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidFuelInjectionTypeException;

public enum FuelInjectionType {
    CARBURETOR, MULTI_POINT_INJECTION, DIRECT_INJECTION;

    public static FuelInjectionType fromString(String type){
        return switch(type.toLowerCase().trim()){
            case "carburetor" -> CARBURETOR;
            case "multi_point_injection" -> MULTI_POINT_INJECTION;
            case "direct_injection" -> DIRECT_INJECTION;
            default -> throw new InvalidFuelInjectionTypeException("BAD INJECTION TYPE! GOT: " + type + "\nPERMISSIVE: carburetor, multi_point_injection, direct_injection");
        };
    }
}
