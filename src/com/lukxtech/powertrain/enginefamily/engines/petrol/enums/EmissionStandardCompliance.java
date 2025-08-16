package com.lukxtech.powertrain.enginefamily.engines.petrol.enums;

import com.lukxtech.powertrain.enginefamily.engines.petrol.exceptions.InvalidEmissionStandardComplianceException;

/**
 * <p>Emission Standard Compliance Type Enum</p>
 * <p>This enum represents the different types of emission compliance ratings(INDIAN).</p>
 * <p>Currently applicable values:</p>
 * <ul>
 * <li>BSE_I</li>
 * <li>BSE_II</li>
 * <li>BSE_III</li>
 * <li>BSE_IV</li>
 * <li>BSE_V</li>
 * <li>BSE_VI</li>
 * </ul>
 * <p>
 * This enum comes with a static fromString factory method to convert strings to enum values.
 */
public enum EmissionStandardCompliance {
    BSE_I, BSE_II, BSE_III, BSE_IV, BSE_V, BSE_VI;

    public static EmissionStandardCompliance fromString(String rating) {
        return switch (rating) {
            case "I" -> BSE_I;
            case "II" -> BSE_II;
            case "III" -> BSE_III;
            case "IV" -> BSE_IV;
            case "V" -> BSE_V;
            case "VI" -> BSE_VI;
            default ->
                    throw new InvalidEmissionStandardComplianceException("BAD STANDARD! GOT: " + rating + "\nPERMISSIVE(BSE): I, II, III, IV, V, VI");
        };
    }
}
