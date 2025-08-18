package com.lukxtech.powertrain.clutchfamily.clutches.dual;

import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchBuilder;
import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchModel;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchMaterialComposition;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchType;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchMaterialCompositionTypeException;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.clutches.dual.exceptions.BadEngagementTimeValueException;
import com.lukxtech.powertrain.clutchfamily.clutches.dual.exceptions.BadNumberOfClutchValueException;
import com.lukxtech.powertrain.clutchfamily.common.enums.ActuationType;
import com.lukxtech.powertrain.clutchfamily.common.enums.CoolingType;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.BadClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidActuatorTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidCoolingTypeException;
import com.lukxtech.powertrain.clutchfamily.interfaces.ClutchInterface;
import com.lukxtech.powertrain.clutchfamily.interfaces.DualClutchInterface;

public class DualClutch extends AbstractClutchModel implements ClutchInterface, DualClutchInterface {
    private ActuationType actuationType;
    private CoolingType coolingType;
    private int numberOfClutch;
    private int engagementTimeMS;

    @Deprecated
    public DualClutch(String modelNumber,
                      ClutchType clutchType,
                      int torqueCapacityNM,
                      ClutchMaterialComposition clutchMaterialComposition,
                      double frictionDiameterMM,
                      long serviceLifeCycles,
                      ActuationType actuationType,
                      CoolingType coolingType,
                      int numberOfClutch,
                      int engagementTimeMS) {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.numberOfClutch = numberOfClutch;
        this.engagementTimeMS = engagementTimeMS;
    }

    @Deprecated
    public DualClutch(String modelNumber,
                      String clutchType,
                      int torqueCapacityNM,
                      ClutchMaterialComposition clutchMaterialComposition,
                      double frictionDiameterMM,
                      long serviceLifeCycles,
                      ActuationType actuationType,
                      CoolingType coolingType,
                      int numberOfClutch,
                      int engagementTimeMS
    ) throws InvalidClutchTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.numberOfClutch = numberOfClutch;
        this.engagementTimeMS = engagementTimeMS;
    }

    @Deprecated
    public DualClutch(String modelNumber,
                      String clutchType,
                      int torqueCapacityNM,
                      String clutchMaterialComposition,
                      double frictionDiameterMM,
                      long serviceLifeCycles,
                      ActuationType actuationType,
                      CoolingType coolingType,
                      int numberOfClutch,
                      int engagementTimeMS
    ) throws InvalidClutchTypeException, InvalidClutchMaterialCompositionTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.numberOfClutch = numberOfClutch;
        this.engagementTimeMS = engagementTimeMS;
    }

    public static class Builder extends AbstractClutchBuilder<DualClutch, Builder> {
        private ActuationType actuationType;
        private CoolingType coolingType;
        private Integer numberOfClutch;
        private Integer engagementTimeMS;

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

        public Builder numberOfClutch(int numberOfClutch) {
            this.numberOfClutch = numberOfClutch;
            return this;
        }

        public Builder engagementTimeMS(int engagementTimeMS) {
            this.engagementTimeMS = engagementTimeMS;
            return this;
        }

        @Override
        public void validate() {
            validate_initial();
            if (clutchType != ClutchType.DUAL_CLUTCH)
                throw new BadClutchTypeException("BAD CLUTCH TYPE! GOT: " + clutchType);
            if (actuationType == null)
                throw new InvalidActuatorTypeException("ALERT! ACTUATOR UNIT NOT SPECIFIED! GOT: " + actuationType);
            if (coolingType == null)
                throw new InvalidCoolingTypeException("ALERT! COOLING TYPE NOT SPECIFIED! GOT: " + coolingType);
            if (numberOfClutch <= 0)
                throw new BadNumberOfClutchValueException("ALERT! NUMBER OF CLUTCH CANNOT BE LESS THAN OR EQUAL TO 0! GOT: " + numberOfClutch);
            if (numberOfClutch != 2)
                throw new BadNumberOfClutchValueException("ALERT! NUMBER OF CLUTCH IN A DUAL CLUTCH SYSTEM NEEDS TO BE 2! GOT: " + numberOfClutch);
            if (engagementTimeMS <= 0)
                throw new BadEngagementTimeValueException("ALERT! ENGAGEMENT TIME CANNOT BE LESS THAN OR EQUAL TO ZERO! GOT: " + engagementTimeMS);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public DualClutch build() {
            validate();
            return new DualClutch(
                    modelNumber,
                    clutchType,
                    torqueCapacityNM,
                    clutchMaterialComposition,
                    frictionDiameterMM,
                    serviceLifeCycles,
                    actuationType,
                    coolingType,
                    numberOfClutch,
                    engagementTimeMS
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

    public int getNumberOfClutch() {
        return numberOfClutch;
    }

    public void setNumberOfClutch(int numberOfClutch) {
        this.numberOfClutch = numberOfClutch;
    }

    public int getEngagementTimeMS() {
        return engagementTimeMS;
    }

    @Override
    public void setEngagementTimeMS(int engagementTimeMS) {
        this.engagementTimeMS = engagementTimeMS;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder
                .append("----------------------------------------\n")
                .append("Model Number: ").append(modelNumber).append("\n")
                .append("Clutch Type: ").append(clutchType).append("\n")
                .append("Torque Capacity(NM): ").append(torqueCapacityNM).append("\n")
                .append("Clutch Material Composition: ").append(clutchMaterialComposition).append("\n")
                .append("Friction Diameter(mm): ").append(frictionDiameterMM).append("\n")
                .append("Service Life Cycle: ").append(serviceLifeCycles).append("\n")
                .append("Number of Clutch: ").append(numberOfClutch).append("\n")
                .append("Engagement Time(ms): ").append(engagementTimeMS).append("\n")
                .append("----------------------------------------\n")
                .toString();
    }
}
