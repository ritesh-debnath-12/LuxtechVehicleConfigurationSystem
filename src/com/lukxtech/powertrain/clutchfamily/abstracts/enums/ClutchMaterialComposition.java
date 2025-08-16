package com.lukxtech.powertrain.clutchfamily.abstracts.enums;

import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchMaterialCompositionTypeException;

/**
 * <p>ClutchMaterialComposition enum</p>
 * </p>This details various types of materials used to manufacture clutches</p>
 * <p>CURRENTLY:</p>
 * <ul>
 *     <li>ORGANIC</li>
 *     <li>CERAMIC</li>
 *     <li>CARBON</li>
 * </ul>
 *
 * NOTE: This enum comes with factory methods to convert String to itself
 */
public enum ClutchMaterialComposition {
    ORGANIC, CERAMIC, CARBON;

    public static ClutchMaterialComposition fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "organic" -> ORGANIC;
            case "ceramic" -> CERAMIC;
            case "carbon" -> CARBON;
            default -> throw new InvalidClutchMaterialCompositionTypeException("INVALID CLUTCH MATERIAL TYPE! GOT: " + type);
        };
    }
}
