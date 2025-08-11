package com.lukxtech.enginefamily.engines.diesel.enums;

import com.lukxtech.enginefamily.engines.diesel.exceptions.InvalidTurbochargerTypeException;

public enum TurbochargerType {
    NONE, SINGLE, TWIN, VARIABLE_GEOMETRY;

    public static TurbochargerType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "none" -> NONE;
            case "single" -> SINGLE;
            case "twin" -> TWIN;
            case "variable_geometry" -> VARIABLE_GEOMETRY;
            default -> throw new InvalidTurbochargerTypeException("BAD TURBOCHARGER TYPE! GOT: " + type + "\nPERMISSIVE: none, single, twin, variable_geometry");
        };
    }
}
