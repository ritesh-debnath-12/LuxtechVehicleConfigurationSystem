package com.lukxtech.parts.transmissionfamily.transmissions.dct.enums;

import com.lukxtech.parts.transmissionfamily.transmissions.dct.exceptions.InvalidDCTModelTypeException;

/**
 * <p>DCT Model Type Enum</p>
 * <p>This enum represents the different types of Dual Clutch Transmission models available.</p>
 * <p>Currently supported DCT model types: </p>
 * <ul>
 * <li>DCT8 - 8-speed Dual Clutch Transmission with advanced pre-selective technology</li>
 * </ul>
 * 
 * <p>This enum comes with a static fromString factory method to convert string to enum values.</p>
 * <p>Note: DCT transmissions use two separate clutches for odd and even gears, enabling fastest gear changes.</p>
 * 
 * @author Neko
 * @since 0.0.0
 */
public enum DCTModelType {
    DCT8;

    /**
     * <p>Factory method to convert string to DCTModelType enum</p>
     * 
     * @param type -> The DCT model type as string (case-insensitive)
     * @return The corresponding DCTModelType enum value
     * @throws InvalidDCTModelTypeException if the string doesn't match any valid DCT model type
     */
    public static DCTModelType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "dct8" -> DCT8;
            default -> throw new InvalidDCTModelTypeException("INVALID DCT MODEL TYPE! GOT: " + type + "\nPERMISSIVE: dct8");
        };
    }
}
