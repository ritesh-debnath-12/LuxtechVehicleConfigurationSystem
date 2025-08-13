package com.lukxtech.enginefamily.engines.petrol.enums;

import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidOctaneRatingException;

/**
 * <p>Octane Rating Enum</p>
 * <p>This enum represents different grades of fuel w.r.t octane ratings.</p>
 * <p>Off-topic: Octane and Cetane Ratings are things I don't fully comprehend yet</p>
 * <p>Currently applicable values:</p>
 * <ul>
 * <li>REGULAR</li>
 * <li>EXTRA</li>
 * <li>SUPREME</li>
 * <li>SUPREME_PLUS</li>
 * </ul>
 * <p>
 * This enum comes with a static fromNumber factory method to convert int to enum values.
 */
public enum OctaneRating {
    REGULAR, EXTRA, SUPREME, SUPREME_PLUS;

    public static OctaneRating fromNumber(int octaneNumber) {
        return switch (octaneNumber) {
            case 87 -> REGULAR;
            case 89 -> EXTRA;
            case 91 -> SUPREME;
            case 93 -> SUPREME_PLUS;
            default ->
                    throw new InvalidOctaneRatingException("BAD OCTANE RATING! GOT: " + octaneNumber + "\n PERMISSIVE: 87, 89, 91, 93");
        };
    }
}
