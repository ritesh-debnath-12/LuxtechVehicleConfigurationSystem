package com.lukxtech.enginefamily.engines.electric.records;

import com.lukxtech.enginefamily.engines.electric.exceptions.BadChargeTimeHoursParameterException;

/**
 * <p>Charging Time Hours Record</p>
 * <p>This record represents the charging time in hours for fast and slow charging.</p>
 * <p><b>NOTE:</b> fastChargeHours < slowChargeHours and both params are non zero</p>
 *
 * @param fastChargeHours The number of hours required for fast charging.
 * @param slowChargeHours The number of hours required for slow charging.
 */
public record ChargingTimeHours(int fastChargeHours, int slowChargeHours) {
    public ChargingTimeHours {
        if (fastChargeHours < 0) {
            throw new BadChargeTimeHoursParameterException("BAD FAST CHARGE! HOURS CANNOT BE NEGATIVE");
        }
        if (slowChargeHours < 0) {
            throw new BadChargeTimeHoursParameterException("BAD SLOW CHARGE! HOURS CANNOT BE NEGATIVE");
        }
        if (slowChargeHours < fastChargeHours) {
            throw new BadChargeTimeHoursParameterException("BAD CHARGE TIME PARAM! SLOW CHARGE TIME CANNOT BE LESS THAN FAST CHARGE TIME");
        }
    }
}
