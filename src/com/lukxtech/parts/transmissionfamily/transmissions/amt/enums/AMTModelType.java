package com.lukxtech.parts.transmissionfamily.transmissions.amt.enums;

import com.lukxtech.parts.transmissionfamily.transmissions.amt.exceptions.InvalidAMTModelTypeException;

/**
 * <p>AMT Model Type Enum</p>
 * <p>This enum represents the different types of Automated Manual Transmission models available.</p>
 * <p>Currently supported AMT model types: </p>
 * <ul>
 * <li>AMTP4 - Automated Manual Petrol 4-speed transmission</li>
 * <li>AMTD5 - Automated Manual Diesel 5-speed transmission</li>
 * </ul>
 *
 * <p>This enum comes with a static fromString factory method to convert string to enum values.</p>
 *
 * @author Neko
 * @since 0.0.0
 */
public enum AMTModelType {
    AMTP4, AMTD5;

    /**
     * <p>Factory method to convert string to AMTModelType enum</p>
     *
     * @param type -> The AMT model type as string (case-insensitive)
     * @return The corresponding AMTModelType enum value
     * @throws InvalidAMTModelTypeException if the string doesn't match any valid AMT model type
     */
    public static AMTModelType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "amtp4" -> AMTP4;
            case "amtd5" -> AMTD5;
            default ->
                    throw new InvalidAMTModelTypeException("BAD AMT TYPE! GOT: " + type + "\nPERMISSIVE: amtp4, amtd5");
        };
    }
}
