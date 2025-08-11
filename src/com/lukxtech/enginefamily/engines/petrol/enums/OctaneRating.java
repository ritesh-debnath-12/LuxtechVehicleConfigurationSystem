package com.lukxtech.enginefamily.engines.petrol.enums;

import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidOctaneRatingException;

public enum OctaneRating {
    REGULAR, EXTRA, SUPREME, SUPREME_PLUS;

    public static OctaneRating fromNumber(int octaneNumber){
        return switch (octaneNumber){
            case 87 -> REGULAR;
            case 89 -> EXTRA;
            case 91 -> SUPREME;
            case 93 -> SUPREME_PLUS;
            default -> throw new InvalidOctaneRatingException("BAD OCTANE RATING! GOT: " + octaneNumber + "\n PERMISSIVE: 87, 89, 91, 93");
        };
    }
}
