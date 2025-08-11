package com.lukxtech.enginefamily.engines.electric.enums;

import com.lukxtech.enginefamily.engines.electric.exceptions.InvalidElectricMotorTypeException;

public enum ElectricMotorType {
    AC_INDUCTION, PERMANENT_MAGNET, BRUSHLESS_DC;

    public static ElectricMotorType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "ac_induction" -> AC_INDUCTION;
            case "permanent_magnet" -> PERMANENT_MAGNET;
            case "brushless_dc" -> BRUSHLESS_DC;
            default -> throw new InvalidElectricMotorTypeException("BAD ELECTRIC MOTOR TYPE! GOT: " + type + "\nPERMISSIVE: ac_induction, permanent_magnet, brushless_dc");
        };
    }
}
