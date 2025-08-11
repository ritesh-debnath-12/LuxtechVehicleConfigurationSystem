package com.lukxtech.enginefamily.engines.cng.enums;

import com.lukxtech.enginefamily.engines.cng.exceptions.InvalidCNGRefuelingConnectorTypeException;

public enum CNGRefuelingConnectorType {
    TYPE_1, TYPE_2, TYPE_3, OTHER;

    public static CNGRefuelingConnectorType fromString(String type){
        return switch(type.toLowerCase().trim()){
            case "type_1" -> TYPE_1;
            case "type_2" -> TYPE_2;
            case "type_3" -> TYPE_3;
            default -> throw new InvalidCNGRefuelingConnectorTypeException("BAD CNG CONNECTOR! GOT: " + type + "\nPERMISSIVE: type_1, type_2, type_3");
        };
    }
}
