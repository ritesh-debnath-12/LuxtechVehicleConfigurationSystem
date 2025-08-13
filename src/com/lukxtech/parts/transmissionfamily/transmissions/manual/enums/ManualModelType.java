package com.lukxtech.parts.transmissionfamily.transmissions.manual.enums;

import com.lukxtech.parts.transmissionfamily.transmissions.manual.exceptions.InvalidManualModelTypeException;

/**
 * <p>Manual Model Type Enum</p>
 * <p>This enum represents the different types of manual transmission models available.</p>
 * <p>Currently supported manual transmission model types: </p>
 * <ul>
 * <li>MP4 - Manual Petrol 4-speed transmission</li>
 * <li>MP5 - Manual Petrol 5-speed transmission</li>
 * <li>MP6 - Manual Petrol 6-speed transmission</li>
 * <li>MD5 - Manual Diesel 5-speed transmission</li>
 * <li>MD6 - Manual Diesel 6-speed transmission</li>
 * </ul>
 *
 * <p>This enum comes with a static fromString factory method to convert string to enum values.</p>
 *
 * @author Neko
 * @since 0.0.0
 */
public enum ManualModelType {
    MP4, MP5, MP6, MD5, MD6;

    /**
     * <p>Factory method to convert string to ManualModelType enum</p>
     *
     * @param type -> The manual model type as string (case-insensitive)
     * @return The corresponding ManualModelType enum value
     * @throws InvalidManualModelTypeException if the string doesn't match any valid manual model type
     */
    public static ManualModelType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "mp4" -> MP4;
            case "mp5" -> MP5;
            case "mp6" -> MP6;
            case "md5" -> MD5;
            case "md6" -> MD6;
            default ->
                    throw new InvalidManualModelTypeException("BAD MANUAL MODEL TYPE! GOT: " + type + "\nPERMISSIVE: mp4, mp5, mp6, md5, md6");
        };
    }
}
