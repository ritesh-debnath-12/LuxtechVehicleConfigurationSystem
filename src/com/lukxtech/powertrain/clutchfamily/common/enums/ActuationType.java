package com.lukxtech.powertrain.clutchfamily.common.enums;

import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidActuatorTypeException;

public enum ActuationType {
    MECHANICAL, HYDRAULIC, ELECTRONIC, ELECTRO_MECHANICAL, ELECTRO_MAGNETIC;

    public static ActuationType fromString(String type){
        return switch(type.toLowerCase().trim()){
            case "mechanical" -> MECHANICAL;
            case "hydraulic" -> HYDRAULIC;
            case "electronic" -> ELECTRONIC;
            case "electro_mechanical" -> ELECTRO_MECHANICAL;
            case "electro_magnetic" -> ELECTRO_MAGNETIC;
            default -> throw new InvalidActuatorTypeException("ALERT! INVALID ACTUATOR TYPE! GOT: " + type + "\nPERMISSIVE: mechanical, hydraulic, electronic, electro_mechanical, electro_magnetic");
        };
    }
}
