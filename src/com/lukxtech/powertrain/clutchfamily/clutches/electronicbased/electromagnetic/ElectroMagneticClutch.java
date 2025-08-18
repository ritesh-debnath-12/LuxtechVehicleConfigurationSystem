package com.lukxtech.powertrain.clutchfamily.clutches.electronicbased.electromagnetic;

import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchBuilder;
import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchModel;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchMaterialComposition;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchType;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchMaterialCompositionTypeException;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.clutches.electronicbased.electromagnetic.exceptions.BadMagneticCoilPowerValueException;
import com.lukxtech.powertrain.clutchfamily.clutches.electronicbased.electromagnetic.exceptions.BadResponseTimeException;
import com.lukxtech.powertrain.clutchfamily.clutches.electronicbased.electromagnetic.exceptions.BadVoltageRatingValueException;
import com.lukxtech.powertrain.clutchfamily.common.enums.ActuationType;
import com.lukxtech.powertrain.clutchfamily.common.enums.CoolingType;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.BadClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidActuatorTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidCoolingTypeException;
import com.lukxtech.powertrain.clutchfamily.interfaces.ClutchInterface;
import com.lukxtech.powertrain.clutchfamily.interfaces.ElectromagneticClutchInterface;

public class ElectroMagneticClutch extends AbstractClutchModel implements ClutchInterface, ElectromagneticClutchInterface {
    private ActuationType actuationType;
    private CoolingType coolingType;
    private double magneticCoilPowerW;
    private int responseTimeMS;
    private int voltageRating;

    @Deprecated
    public ElectroMagneticClutch(String modelNumber,
                                 ClutchType clutchType,
                                 int torqueCapacityNM,
                                 ClutchMaterialComposition clutchMaterialComposition,
                                 double frictionDiameterMM,
                                 long serviceLifeCycles,
                                 ActuationType actuationType,
                                 CoolingType coolingType,
                                 double magneticCoilPowerW,
                                 int responseTimeMS,
                                 int voltageRating) {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.magneticCoilPowerW = magneticCoilPowerW;
        this.responseTimeMS = responseTimeMS;
        this.voltageRating = voltageRating;
    }

    @Deprecated
    public ElectroMagneticClutch(String modelNumber,
                                 String clutchType,
                                 int torqueCapacityNM,
                                 ClutchMaterialComposition clutchMaterialComposition,
                                 double frictionDiameterMM,
                                 long serviceLifeCycles,
                                 ActuationType actuationType,
                                 CoolingType coolingType,
                                 double magneticCoilPowerW,
                                 int responseTimeMS,
                                 int voltageRating
    ) throws InvalidClutchTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.magneticCoilPowerW = magneticCoilPowerW;
        this.responseTimeMS = responseTimeMS;
        this.voltageRating = voltageRating;
    }

    @Deprecated
    public ElectroMagneticClutch(String modelNumber,
                                 String clutchType,
                                 int torqueCapacityNM,
                                 String clutchMaterialComposition,
                                 double frictionDiameterMM,
                                 long serviceLifeCycles,
                                 ActuationType actuationType,
                                 CoolingType coolingType,
                                 double magneticCoilPowerW,
                                 int responseTimeMS,
                                 int voltageRating
    ) throws InvalidClutchTypeException, InvalidClutchMaterialCompositionTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.magneticCoilPowerW = magneticCoilPowerW;
        this.responseTimeMS = responseTimeMS;
        this.voltageRating = voltageRating;
    }

    public static class Builder extends AbstractClutchBuilder<ElectroMagneticClutch, Builder> {
        private ActuationType actuationType;
        private CoolingType coolingType;
        private Double magneticCoilPowerW;
        private Integer responseTimeMS;
        private Integer voltageRating;

        public Builder actuationType(ActuationType actuationType) {
            this.actuationType = actuationType;
            return this;
        }

        public Builder actuationType(String actuationType) {
            this.actuationType = ActuationType.fromString(actuationType);
            return this;
        }

        public Builder coolingType(CoolingType coolingType) {
            this.coolingType = coolingType;
            return this;
        }

        public Builder coolingType(String coolingType) {
            this.coolingType = CoolingType.fromString(coolingType);
            return this;
        }

        public Builder magneticCoilPowerW(double magneticCoilPowerW) {
            this.magneticCoilPowerW = magneticCoilPowerW;
            return this;
        }

        public Builder responseTimeMS(int responseTimeMS) {
            this.responseTimeMS = responseTimeMS;
            return this;
        }

        public Builder voltageRating(int voltageRating) {
            this.voltageRating = voltageRating;
            return this;
        }

        @Override
        public void validate() {
            validate_initial();
            if (clutchType != ClutchType.ELECTROMAGNETIC_CLUTCH)
                throw new BadClutchTypeException("BAD CLUTCH TYPE! GOT: " + clutchType);
            if (actuationType == null)
                throw new InvalidActuatorTypeException("ALERT! ACTUATOR UNIT NOT SPECIFIED! GOT: " + actuationType);
            if (coolingType == null)
                throw new InvalidCoolingTypeException("ALERT! COOLING TYPE NOT SPECIFIED! GOT: " + coolingType);
            if (magneticCoilPowerW <= 0)
                throw new BadMagneticCoilPowerValueException("ALERT! MAGNETIC COIL POWER CANNOT BE LESS THAN OR EQUAL TO ZERO! GOT: " + magneticCoilPowerW);
            if (responseTimeMS <= 0)
                throw new BadResponseTimeException("ALERT! RESPONSE TIME CANNOT BE LESS THAN OR EQUAL TO ZERO! GOT: " + responseTimeMS);
            if (voltageRating <= 0)
                throw new BadVoltageRatingValueException("ALERT! VOLTAGE RATING CANNOT BE LESS THAN OR EQUAL TO ZERO! GOT: " + voltageRating);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public ElectroMagneticClutch build() {
            validate();
            return new ElectroMagneticClutch(
                    modelNumber,
                    clutchType,
                    torqueCapacityNM,
                    clutchMaterialComposition,
                    frictionDiameterMM,
                    serviceLifeCycles,
                    actuationType,
                    coolingType,
                    magneticCoilPowerW,
                    responseTimeMS,
                    voltageRating
            );
        }
    }

    @Override
    public double getMagneticCoilPowerW() {
        return magneticCoilPowerW;
    }

    @Override
    public int getResponseTimeMS() {
        return responseTimeMS;
    }

    @Override
    public int getVoltageRating() {
        return voltageRating;
    }

    @Override
    public ActuationType getActuationType() {
        return actuationType;
    }

    @Override
    public void setActuationType(ActuationType actuationType) {
        this.actuationType = actuationType;
    }

    @Override
    public void setActuationType(String actuationType) {
        this.actuationType = ActuationType.fromString(actuationType);
    }

    @Override
    public CoolingType getCoolingType() {
        return coolingType;
    }

    @Override
    public void setCoolingType(CoolingType coolingType) {
        this.coolingType = coolingType;
    }

    @Override
    public void setCoolingType(String coolingType) {
        this.coolingType = CoolingType.fromString(coolingType);
    }

    @Override
    public void setMagneticCoilPowerW(double magneticCoilPowerW) {
        this.magneticCoilPowerW = magneticCoilPowerW;
    }

    @Override
    public void setResponseTimeMS(int responseTimeMS) {
        this.responseTimeMS = responseTimeMS;
    }

    @Override
    public void setVoltageRating(int voltageRating) {
        this.voltageRating = voltageRating;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        return builder
                .append("----------------------------------------\n")
                .append("Model Number: ").append(modelNumber).append("\n")
                .append("Clutch Type: ").append(clutchType).append("\n")
                .append("Torque Capacity(NM): ").append(torqueCapacityNM).append("\n")
                .append("Clutch Material Composition: ").append(clutchMaterialComposition).append("\n")
                .append("Friction Diameter(mm): ").append(frictionDiameterMM).append("\n")
                .append("Service Life Cycle: ").append(serviceLifeCycles).append("\n")
                .append("Magnetic Coil Power(W): ").append(magneticCoilPowerW).append("\n")
                .append("Response Time(ms): ").append(responseTimeMS).append("\n")
                .append("Voltage Rating(V): ").append(voltageRating).append("\n")
                .append("----------------------------------------\n")
                .toString();
    }
}
