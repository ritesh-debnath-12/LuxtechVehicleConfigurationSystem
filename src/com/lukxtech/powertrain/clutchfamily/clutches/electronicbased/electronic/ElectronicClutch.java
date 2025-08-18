package com.lukxtech.powertrain.clutchfamily.clutches.electronicbased.electronic;

import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchBuilder;
import com.lukxtech.powertrain.clutchfamily.abstracts.AbstractClutchModel;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchMaterialComposition;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchType;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchMaterialCompositionTypeException;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.clutches.electronicbased.electronic.exceptions.BadControlModuleVersionException;
import com.lukxtech.powertrain.clutchfamily.common.enums.ActuationType;
import com.lukxtech.powertrain.clutchfamily.common.enums.CoolingType;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.BadClutchTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidActuatorTypeException;
import com.lukxtech.powertrain.clutchfamily.common.exceptions.InvalidCoolingTypeException;
import com.lukxtech.powertrain.clutchfamily.interfaces.ClutchInterface;
import com.lukxtech.powertrain.clutchfamily.interfaces.ElectronicControlBasedClutchInterface;

public class ElectronicClutch extends AbstractClutchModel implements ClutchInterface, ElectronicControlBasedClutchInterface {
    //    private ArrayList<Sensor> sensorList;
    private ActuationType actuationType;
    private CoolingType coolingType;
    private String controlModuleVersion;

    @Deprecated
    public ElectronicClutch(String modelNumber, ClutchType clutchType, int torqueCapacityNM, ClutchMaterialComposition clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles, ActuationType actuationType, CoolingType coolingType, String controlModuleVersion) {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.controlModuleVersion = controlModuleVersion;
    }

    @Deprecated
    public ElectronicClutch(String modelNumber, String clutchType, int torqueCapacityNM, ClutchMaterialComposition clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles, ActuationType actuationType, CoolingType coolingType, String controlModuleVersion) throws InvalidClutchTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.controlModuleVersion = controlModuleVersion;
    }

    @Deprecated
    public ElectronicClutch(String modelNumber, String clutchType, int torqueCapacityNM, String clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles, ActuationType actuationType, CoolingType coolingType, String controlModuleVersion) throws InvalidClutchTypeException, InvalidClutchMaterialCompositionTypeException {
        super(modelNumber, clutchType, torqueCapacityNM, clutchMaterialComposition, frictionDiameterMM, serviceLifeCycles);
        this.actuationType = actuationType;
        this.coolingType = coolingType;
        this.controlModuleVersion = controlModuleVersion;
    }

    public static class Builder extends AbstractClutchBuilder<ElectronicClutch, Builder> {
        private ActuationType actuationType;
        private CoolingType coolingType;
        private String controlModuleVersion;

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

        public Builder controlModuleVersion(String controlModuleVersion) {
            this.controlModuleVersion = controlModuleVersion;
            return this;
        }

        @Override
        public void validate() {
            validate_initial();
            if (clutchType != ClutchType.ELECTRONIC_CLUTCH)
                throw new BadClutchTypeException("BAD CLUTCH TYPE! GOT: " + clutchType);
            if (actuationType == null)
                throw new InvalidActuatorTypeException("ALERT! ACTUATOR UNIT NOT SPECIFIED! GOT: " + actuationType);
            if (coolingType == null)
                throw new InvalidCoolingTypeException("ALERT! COOLING TYPE NOT SPECIFIED! GOT: " + coolingType);
            if (controlModuleVersion == null || controlModuleVersion.isEmpty())
                throw new BadControlModuleVersionException("ALERT! CONTROL MODULE VERSION NOT SPECIFIED! GOT: " + controlModuleVersion);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public ElectronicClutch build() {
            validate();
            return new ElectronicClutch(
                    modelNumber,
                    clutchType,
                    torqueCapacityNM,
                    clutchMaterialComposition,
                    frictionDiameterMM,
                    serviceLifeCycles,
                    actuationType,
                    coolingType,
                    controlModuleVersion
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
    public String getControlModuleVersion() {
        return controlModuleVersion;
    }

    @Override
    public void setControlModuleVersion(String controlModuleVersion) {
        this.controlModuleVersion = controlModuleVersion;
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
                .append("Control Module Version: ").append(controlModuleVersion).append("\n")
                .append("----------------------------------------\n")
                .toString();
    }
}
