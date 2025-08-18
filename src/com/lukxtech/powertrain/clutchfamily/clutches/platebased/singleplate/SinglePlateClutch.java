package com.lukxtech.powertrain.clutchfamily.clutches.platebased.singleplate;

import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchBuilder;
import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchModel;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchMaterialComposition;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchType;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchMaterialCompositionTypeException;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.clutches.platebased.common.exceptions.InvalidNumberOfPlateValueException;
import com.lukxtech.powertrain.clutchfamily.common.enums.ActuationType;
import com.lukxtech.powertrain.clutchfamily.common.enums.CoolingType;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.BadClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidActuatorTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidCoolingTypeException;
import com.lukxtech.powertrain.clutchfamily.interfaces.ClutchInterface;
import com.lukxtech.powertrain.clutchfamily.interfaces.PlateBasedClutchInterface;

public class SinglePlateClutch extends AbstractClutchModel implements ClutchInterface, PlateBasedClutchInterface {
    private ActuationType actuationType;
    private CoolingType coolingType;
    private int numberOfPlates;

    @Deprecated
    public SinglePlateClutch(String modelNumber,
                             ClutchType clutchType,
                             int torqueCapacityNM,
                             ClutchMaterialComposition clutchMaterialComposition,
                             double frictionDiameterMM,
                             long serviceLifeCycles,
                             int numberOfPlates
    ) {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.numberOfPlates = numberOfPlates;
    }

    @Deprecated
    public SinglePlateClutch(String modelNumber,
                             String clutchType,
                             int torqueCapacityNM,
                             ClutchMaterialComposition clutchMaterialComposition,
                             double frictionDiameterMM,
                             long serviceLifeCycles,
                             int numberOfPlates
    ) throws InvalidClutchTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.numberOfPlates = numberOfPlates;
    }

    @Deprecated
    public SinglePlateClutch(String modelNumber,
                             String clutchType,
                             int torqueCapacityNM,
                             String clutchMaterialComposition,
                             double frictionDiameterMM,
                             long serviceLifeCycles,
                             int numberOfPlates
    ) throws InvalidClutchTypeException, InvalidClutchMaterialCompositionTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.numberOfPlates = numberOfPlates;
    }

    public static class Builder extends AbstractClutchBuilder<SinglePlateClutch, Builder> {
        private ActuationType actuationType;
        private CoolingType coolingType;
        private Integer numberOfPlates;

        public Builder actuatorType(ActuationType actuationType) {
            this.actuationType = actuationType;
            return this;
        }

        public Builder actuatorType(String actuationType) {
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

        public Builder numberOfPlates(int numberOfPlates) {
            this.numberOfPlates = numberOfPlates;
            return this;
        }

        @Override
        public void validate() {
            validate_initial();
            if (clutchType != ClutchType.SINGLE_PLATE_CLUTCH)
                throw new BadClutchTypeException("BAD CLUTCH TYPE! GOT: " + clutchType);
            if (numberOfPlates <= 0)
                throw new InvalidNumberOfPlateValueException("ALERT! PLATE NUMBER CANNOT BE LESS THAN ZERO! GOT: " + numberOfPlates);
            if (numberOfPlates == null || numberOfPlates > 1)
                throw new InvalidNumberOfPlateValueException("ALERT! FOR SINGLE PLATE CLUTCH, PLATE NUMBER HAS TO BE 1! GOT: " + numberOfPlates);
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
        public SinglePlateClutch build() {
            validate();
            return new SinglePlateClutch(
                    modelNumber,
                    clutchType,
                    torqueCapacityNM,
                    clutchMaterialComposition,
                    frictionDiameterMM,
                    serviceLifeCycles,
                    numberOfPlates
            );
        }
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
    public CoolingType getCoolingType() {
        return this.coolingType;
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
    public ActuationType getActuationType() {
        return this.actuationType;
    }

    @Override
    public void setNumberOfPlates(int numberOfPlates) {
        this.numberOfPlates = numberOfPlates;
    }

    @Override
    public int getNumberOfPlates() {
        return this.numberOfPlates;
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
                .append("Number of Plates: ").append(numberOfPlates).append("\n")
                .append("----------------------------------------\n")
                .toString();
    }
}
