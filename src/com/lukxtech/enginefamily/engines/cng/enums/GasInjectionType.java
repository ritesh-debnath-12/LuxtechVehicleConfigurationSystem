package com.lukxtech.enginefamily.engines.cng.enums;

import com.lukxtech.enginefamily.engines.cng.exceptions.InvalidGasInjectionTypeException;

public enum GasInjectionType {
    SEQUENTIAL, SEQUENTIAL_DIRECT, VENTURI;

    public static GasInjectionType fromString(String type){
        return switch(type.toLowerCase().trim()){
            case "sequential" -> SEQUENTIAL;
            case "sequential_direct" -> SEQUENTIAL_DIRECT;
            case "venturi" -> VENTURI;
            default -> throw new InvalidGasInjectionTypeException("BAD GAS INJECTION TYPE! GOT: " + type + "\nPERMISSIVE: sequential, sequential_direct, venturi");
        };
    }
}
