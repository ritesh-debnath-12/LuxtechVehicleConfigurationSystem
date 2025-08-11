package com.lukxtech.parts.transmissionfamily.abstracts.enums;

import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;

public enum TransmissionType {
    MANUAL, AMT, CVT, DCT;

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
