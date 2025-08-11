package com.lukxtech.enginefamily.engines.diesel.enums;

import com.lukxtech.enginefamily.engines.diesel.exceptions.InvalidCetaneNumberException;

public enum CetaneNumber {
    REGULAR_DIESEL, PREMIUM_DIESEL, BIODIESEL_B100, BIODIESEL_BLEND_B20, SYNTHETIC_DIESEL;

    public static CetaneNumber fromInt(int cetaneNumber){
        return switch (cetaneNumber){
            case 48 -> REGULAR_DIESEL;
            case 55 -> PREMIUM_DIESEL;
            case 58 -> BIODIESEL_B100;
            case 50 -> BIODIESEL_BLEND_B20;
            case 62 -> SYNTHETIC_DIESEL;
            default -> throw new InvalidCetaneNumberException("BAD CETANE NUMBER! GOT: " + cetaneNumber + "\n PERMISSIVE: 48, 55, 58, 50, 62");
        };
    }
}
