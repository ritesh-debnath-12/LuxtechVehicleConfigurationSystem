package com.lukxtech.parts.transmissionfamily.transmissions.amt.enums;

import com.lukxtech.parts.transmissionfamily.transmissions.amt.exceptions.InvalidAMTModelTypeException;

public enum AMTModelType {
    AMTP4, AMTD5;

    public static AMTModelType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "amtp4" -> AMTP4;
            case "amtd5" -> AMTD5;
            default -> throw new InvalidAMTModelTypeException("BAD AMT TYPE! GOT: " + type + "\nPERMISSIVE: amtp4, amtd5");
        };
    }
}
