package com.lukxtech.parts.transmissionfamily.transmissions.cvt.enums;

import com.lukxtech.parts.transmissionfamily.transmissions.cvt.exceptions.InvalidCVTModelTypeException;

public enum CVTModelType {
    CVT6;

    public static CVTModelType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "cvt6" -> CVT6;
            default -> throw new InvalidCVTModelTypeException("INVALID CVT MODEL TYPE! GOT: " + type + "\nPERMISSIVE: cvt6");
        };
    }
}
