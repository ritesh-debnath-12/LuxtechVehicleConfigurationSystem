package com.lukxtech.powertrain.clutchfamily.interfaces;

import com.lukxtech.powertrain.clutchfamily.clutches.hydraulic.enums.HydraulicFluidType;

public interface HydraulicClutchInterface {
    HydraulicFluidType getFluidType();
    void setFluidType(String fluidType);
    void setFluidType(HydraulicFluidType fluidType);
}
