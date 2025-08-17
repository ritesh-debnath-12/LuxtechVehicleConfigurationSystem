package com.lukxtech.powertrain.clutchfamily.interfaces;

import com.lukxtech.powertrain.clutchfamily.common.enums.ActuationType;
import com.lukxtech.powertrain.clutchfamily.common.enums.CoolingType;

public interface ClutchInterface {
    ActuationType getActuationType();
    void setActuationType(String actuationType);
    void setActuationType(ActuationType actuationType);
    CoolingType getCoolingType();
    void setCoolingType(String coolingType);
    void setCoolingType(CoolingType coolingType);
}
