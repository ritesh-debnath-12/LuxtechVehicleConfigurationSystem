package com.lukxtech.powertrain.transmissionfamily.abstracts.enums;

import com.lukxtech.powertrain.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;

/**
 * <p>Transmission Type Enum</p>
 * <p>This enum represents the different types of transmissions available in the system.</p>
 * <p>Currently supported transmission types: </p>
 * <ul>
 * <li>MANUAL - Traditional manual transmission requiring driver gear selection</li>
 * <li>AMT - Automated Manual Transmission with automated gear shifting</li>
 * <li>CVT - Continuously Variable Transmission with infinite gear ratios</li>
 * <li>DCT - Dual Clutch Transmission with pre-selective gear technology</li>
 * </ul>
 *
 * <p>This enum comes with a static fromString factory method to convert string to enum values.</p>
 *
 * @author Neko
 * @since 0.0.0
 */
public enum TransmissionType {
    MANUAL, AMT, CVT, DCT;

    /**
     * <p>Factory method to convert string to TransmissionType enum</p>
     *
     * @param type -> The transmission type as string (case-insensitive)
     * @return The corresponding TransmissionType enum value
     * @throws InvalidTransmissionTypeException if the string doesn't match any valid transmission type
     */
    public static TransmissionType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "manual" -> MANUAL;
            case "amt" -> AMT;
            case "cvt" -> CVT;
            case "dct" -> DCT;
            default ->
                    throw new InvalidTransmissionTypeException("INVALID TRANSMISSION TYPE! GOT: " + type + "\nPERMISSIVE: manual, amt, cvt, dct");
        };
    }

    /**
     * <p>Returns a human-readable string representation of the transmission type</p>
     *
     * @return The display name of the transmission type
     */
    public String toString() {
        return switch (this) {
            case MANUAL -> "Manual";
            case AMT -> "Automated Manual";
            case CVT -> "Continuously Variable";
            case DCT -> "Dual Clutch";
            default -> "ERR_INVALID_TRANSMISSION";
        };
    }
}
