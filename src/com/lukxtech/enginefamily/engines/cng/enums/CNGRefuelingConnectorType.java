package com.lukxtech.enginefamily.engines.cng.enums;

import com.lukxtech.enginefamily.engines.cng.exceptions.InvalidCNGRefuelingConnectorTypeException;

/**
 * <p>CNG Refueling Connector Types</p>
 * <p>This enum represents the different types of CNG refueling connectors.</p>
 * <p>Currently applicable values:</p>
 * <ul>
 * <li>TYPE_1</li>
 * <li>TYPE_2</li>
 * <li>TYPE_3</li>
 * <li>OTHER</li>
 * </ul>
 * <p>
 * This enum comes with a static fromString factory method to convert strings to enum values.
 */
public enum CNGRefuelingConnectorType {
    TYPE_1, TYPE_2, TYPE_3, OTHER;

    public static CNGRefuelingConnectorType fromString(String type) {
        return switch (type.toLowerCase().trim()) {
            case "type_1" -> TYPE_1;
            case "type_2" -> TYPE_2;
            case "type_3" -> TYPE_3;
            default ->
                    throw new InvalidCNGRefuelingConnectorTypeException("BAD CNG CONNECTOR! GOT: " + type + "\nPERMISSIVE: type_1, type_2, type_3");
        };
    }
}
