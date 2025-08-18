package com.lukxtech.powertrain.clutchfamily.interfaces;

public interface ElectromagneticClutchInterface {
    double getMagneticCoilPowerW();
    void setMagneticCoilPowerW(double magneticCoilPowerW);
    int getResponseTimeMS();
    void setResponseTimeMS(int responseTimeMS);
    int getVoltageRating();
    void setVoltageRating(int voltageRating);
}
