package com.lukxtech.powertrain.clutchfamily.clutches.hydraulic;

import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchBuilder;
import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchModel;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchMaterialComposition;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchType;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchMaterialCompositionTypeException;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.clutches.hydraulic.enums.HydraulicFluidType;
import com.lukxtech.powertrain.clutchfamily.clutches.hydraulic.exceptions.InvalidHydraulicFluidTypeException;
import com.lukxtech.powertrain.clutchfamily.common.enums.ActuationType;
import com.lukxtech.powertrain.clutchfamily.common.enums.CoolingType;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.BadClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidActuatorTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidCoolingTypeException;
import com.lukxtech.powertrain.clutchfamily.interfaces.ClutchInterface;
import com.lukxtech.powertrain.clutchfamily.interfaces.HydraulicClutchInterface;

public class HydraulicClutch extends AbstractClutchModel implements ClutchInterface, HydraulicClutchInterface {
    private ActuationType actuationType;
    private CoolingType coolingType;
    private HydraulicFluidType fluidType;

    @Deprecated
    public HydraulicClutch(String modelNumber, ClutchType clutchType, int torqueCapacityNM, ClutchMaterialComposition clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles, ActuationType actuationType, CoolingType coolingType, HydraulicFluidType fluidType) {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.fluidType = fluidType;
    }

    @Deprecated
    public HydraulicClutch(String modelNumber, String clutchType, int torqueCapacityNM, ClutchMaterialComposition clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles, ActuationType actuationType, CoolingType coolingType, HydraulicFluidType fluidType) throws InvalidClutchTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.fluidType = fluidType;
    }

    @Deprecated
    public HydraulicClutch(String modelNumber, String clutchType, int torqueCapacityNM, String clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles, ActuationType actuationType, CoolingType coolingType, HydraulicFluidType fluidType) throws InvalidClutchTypeException, InvalidClutchMaterialCompositionTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.fluidType = fluidType;
    }

    public static class Builder extends AbstractClutchBuilder<HydraulicClutch, Builder> {
        private ActuationType actuationType;
        private CoolingType coolingType;
        private HydraulicFluidType fluidType;

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

        public Builder fluidType(HydraulicFluidType fluidType) {
            this.fluidType = fluidType;
            return this;
        }

        public Builder fluidType(String fluidType) {
            this.fluidType = HydraulicFluidType.fromString(fluidType);
            return this;
        }

        @Override
        public void validate() {
            validate_initial();
            if (clutchType != ClutchType.HYDRAULIC_CLUTCH)
                throw new BadClutchTypeException("BAD CLUTCH TYPE! GOT: " + clutchType);
            if (fluidType == null)
                throw new InvalidHydraulicFluidTypeException("ALERT! FLUID TYPE NOT SPECIFIED! GOT: " + fluidType);
            if (actuationType == null)
                throw new InvalidActuatorTypeException("ALERT! ACTUATOR UNIT NOT SPECIFIED! GOT: " + actuationType);
            if (coolingType == null)
                throw new InvalidCoolingTypeException("ALERT! COOLING TYPE NOT SPECIFIED! GOT: " + coolingType);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public HydraulicClutch build() {
            validate();
            return new HydraulicClutch(
                    modelNumber,
                    clutchType,
                    torqueCapacityNM,
                    clutchMaterialComposition,
                    frictionDiameterMM,
                    serviceLifeCycles,
                    actuationType,
                    coolingType,
                    fluidType
            );
        }
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
    public HydraulicFluidType getFluidType() {
        return fluidType;
    }

    @Override
    public void setFluidType(HydraulicFluidType fluidType) {
        this.fluidType = fluidType;
    }

    @Override
    public void setFluidType(String fluidType) {
        this.fluidType = HydraulicFluidType.fromString(fluidType);
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
                .append("Fluid Type: ").append(fluidType).append("\n")
                .append("----------------------------------------\n")
                .toString();
    }
}
