package com.lukxtech.powertrain.transmissionfamily.transmissions.cvt.enums;

import com.lukxtech.powertrain.transmissionfamily.transmissions.cvt.exceptions.InvalidCVTModelTypeException;

/**
 * <p>CVT Model Type Enum</p>
 * <p>This enum represents the different types of Continuously Variable Transmission models available.</p>
 * <p>Currently supported CVT model types: </p>
 * <ul>
 * <li>CVT6 - 6-speed simulation Continuously Variable Transmission</li>
 * </ul>
 *
 * <p>This enum comes with a static fromString factory method to convert string to enum values.</p>
 * <p>Note: CVT transmissions don't have traditional discrete gears but simulate gear steps for driver familiarity.</p>
 *
 * @author Neko
 * @since 0.0.0
 */
public enum CVTModelType {
    CVT6;

    /**
     * <p>Factory method to convert string to CVTModelType enum</p>
     *
     * @param type -> The CVT model type as string (case-insensitive)
     * @return The corresponding CVTModelType enum value
     * @throws InvalidCVTModelTypeException if the string doesn't match any valid CVT model type
     */
    public static CVTModelType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "cvt6" -> CVT6;
            default ->
                    throw new InvalidCVTModelTypeException("INVALID CVT MODEL TYPE! GOT: " + type + "\nPERMISSIVE: cvt6");
        };
    }
}
