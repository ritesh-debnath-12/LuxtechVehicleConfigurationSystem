package com.lukxtech.enginefamily.engines.electric.records;

import com.lukxtech.enginefamily.engines.electric.exceptions.BadChargeTimeHoursParameterException;

public record ChargingTimeHours(int fastChargeHours, int slowChargeHours) {
    public ChargingTimeHours{
        if(fastChargeHours < 0){
            throw new BadChargeTimeHoursParameterException("BAD FAST CHARGE! HOURS CANNOT BE NEGATIVE");
        }
        if(slowChargeHours < 0){
            throw new BadChargeTimeHoursParameterException("BAD SLOW CHARGE! HOURS CANNOT BE NEGATIVE");
        }
        if(slowChargeHours < fastChargeHours){
            throw new BadChargeTimeHoursParameterException("BAD CHARGE TIME PARAM! SLOW CHARGE TIME CANNOT BE LESS THAN FAST CHARGE TIME");
        }
    }
}
