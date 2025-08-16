package com.lukxtech.powertrain.clutchfamily.abstracts.enums;

import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchTypeException;

/**
 * <p>ClutchType enum</p>
 * </p>This details various types of Clucthes available</p>
 * <p>CURRENTLY:</p>
 * <ul>
 *     <li>SINGLE_PLATE_CLUTCH</li>
 *     <li>MULTI_PLATE_CLUTCH</li>
 *     <li>HYDRAULIC_CLUTCH</li>
 *     <li>ELECTRONIC_CLUTCH</li>
 *     <li>DUAL_CLUTCH</li>
 *     <li>ELECTROMAGNETIC_CLUTCH</li>
 * </ul>
 *
 * NOTE: This enum comes with factory methods to convert String to itself
 */
public enum ClutchType {
    SINGLE_PLATE_CLUTCH, MULTI_PLATE_CLUTCH, HYDRAULIC_CLUTCH, ELECTRONIC_CLUTCH,
    DUAL_CLUTCH, ELECTROMAGNETIC_CLUTCH;

    public static ClutchType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "single_plate_clutch" -> SINGLE_PLATE_CLUTCH;
            case "multi_plate_clutch" -> MULTI_PLATE_CLUTCH;
            case "hydraulic_clutch" -> HYDRAULIC_CLUTCH;
            case "electronic_clutch" -> ELECTRONIC_CLUTCH;
            case "dual_clutch" -> DUAL_CLUTCH;
            case "electromagnetic_clutch" -> ELECTROMAGNETIC_CLUTCH;
            default -> throw new InvalidClutchTypeException("INVALID CLUTCH TYPE! GOT: " + type);
        };
    }
}
