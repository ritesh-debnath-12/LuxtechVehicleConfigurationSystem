package com.lukxtech.parts.transmissionfamily.transmissions.dct.enums;

import com.lukxtech.parts.transmissionfamily.transmissions.dct.exceptions.InvalidDCTModelTypeException;

public enum DCTModelType {
    DCT8;

    public static DCTModelType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "dct8" -> DCT8;
            default -> throw new InvalidDCTModelTypeException("INVALID DCT MODEL TYPE! GOT: " + type + "\nPERMISSIVE: dct8");
        };
    }
}
