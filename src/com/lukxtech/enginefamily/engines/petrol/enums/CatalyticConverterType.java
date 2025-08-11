package com.lukxtech.enginefamily.engines.petrol.enums;

import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidCatalyticConverterTypeException;

public enum CatalyticConverterType {
    THREE_WAY, TWO_WAY;

    public static CatalyticConverterType fromInt(int digit){
        return switch (digit){
            case 3 -> THREE_WAY;
            case 2 -> TWO_WAY;
            default -> throw new InvalidCatalyticConverterTypeException("BAD CAT CONVERTER TYPE! GOT: " + digit +"\n PERMISSIVE: 3, 2");
        };
    }
}
