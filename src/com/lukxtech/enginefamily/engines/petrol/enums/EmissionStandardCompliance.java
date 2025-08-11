package com.lukxtech.enginefamily.engines.petrol.enums;

import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidEmissionStandardComplianceException;

public enum EmissionStandardCompliance {
    BSE_I, BSE_II, BSE_III, BSE_IV, BSE_V, BSE_VI;

    public static EmissionStandardCompliance fromString(String rating){
        return switch (rating){
            case "I" -> BSE_I;
            case "II" -> BSE_II;
            case "III" -> BSE_III;
            case "IV" -> BSE_IV;
            case "V" -> BSE_V;
            case "VI" -> BSE_VI;
            default -> throw new InvalidEmissionStandardComplianceException("BAD STANDARD! GOT: " + rating + "\nPERMISSIVE(BSE): I, II, III, IV, V, VI");
        };
    }
}
