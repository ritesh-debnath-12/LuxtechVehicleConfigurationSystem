package com.lukxtech.enginefamily.engines.diesel.enums;

import com.lukxtech.enginefamily.engines.diesel.exceptions.InvalidCetaneNumberException;

/**
 * <p>Cetane Number Enum</p>
 * <p>This enum represents the different types of cetane numbers for diesel fuels.</p>
 * <p>Currently, applicable values: </p>
 * <ul>
 * <li>REGULAR_DIESEL(48)</li>
 * <li>PREMIUM_DIESEL(55)</li>
 * <li>BIODIESEL_B100(58)</li>
 * <li>BIODIESEL_BLEND_B20(50)</li>
 * <li>SYNTHETIC_DIESEL(62)</li>
 * </ul>
 * 
 * This enum comes with a static fromInt factory method to convert int to enum values.
 */
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
