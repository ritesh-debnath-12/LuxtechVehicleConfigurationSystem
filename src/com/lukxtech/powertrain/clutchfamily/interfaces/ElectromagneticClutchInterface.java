package com.lukxtech.powertrain.clutchfamily.interfaces;

public interface ElectromagneticClutchInterface {
    double getMagneticCoilPower();
    void setMagneticCoilPower(double magneticCoilPower);
    double getResponseTime();
    void setResponseTime();
    int getVoltageRating();
    void setVoltageRating(int voltageRating);
}
