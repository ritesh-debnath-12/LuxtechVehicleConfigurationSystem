package com.lukxtech.enginefamily.engines.cng;

import com.lukxtech.enginefamily.abstracts.AbstractEngineBuilder;
import com.lukxtech.enginefamily.abstracts.AbstractEngineModel;
import com.lukxtech.enginefamily.engines.cng.enums.CNGRefuelingConnectorType;
import com.lukxtech.enginefamily.engines.cng.enums.GasInjectionType;
import com.lukxtech.enginefamily.engines.cng.exceptions.InvalidGasInjectionTypeException;
import com.lukxtech.enginefamily.engines.cng.exceptions.InvalidCNGRefuelingConnectorTypeException;
import com.lukxtech.enginefamily.engines.cng.exceptions.BadBiFuelBooleanException;
import com.lukxtech.enginefamily.engines.cng.exceptions.BadCylinderPressureValueException;
import com.lukxtech.enginefamily.engines.cng.exceptions.BadCNGGasTankCapacityValueException;
import com.lukxtech.enginefamily.engines.cng.exceptions.BadMaxAllowedTemperatureValueException;
import com.lukxtech.enginefamily.interfaces.InternalCombustionEngineInterface;

public class CNGEngine extends AbstractEngineModel implements InternalCombustionEngineInterface {
    private double gasTankCapacityKg;
    private GasInjectionType gasInjectionType;
    private boolean isBiFuel;
    private double cylinderPressureBar;
    private CNGRefuelingConnectorType cngRefuelingConnectorType;
    private double maxAllowedTemperatureC;

    @Deprecated
    public CNGEngine(String modelNo,
                     String modelName,
                     int displacement,
                     int minPower,
                     int maxPower,
                     int maxRPM,
                     double gasTankCapacityKg,
                     GasInjectionType gasInjectionType,
                     boolean isBiFuel,
                     double cylinderPressureBar,
                     CNGRefuelingConnectorType cngRefuelingConnectorType,
                     double maxAllowedTemperatureC
    ) {
        super(modelNo, modelName, displacement, minPower, maxPower, maxRPM);
        this.gasTankCapacityKg = gasTankCapacityKg;
        this.gasInjectionType = gasInjectionType;
        this.isBiFuel = isBiFuel;
        this.cylinderPressureBar = cylinderPressureBar;
        this.cngRefuelingConnectorType = cngRefuelingConnectorType;
        this.maxAllowedTemperatureC = maxAllowedTemperatureC;
    }

    @Deprecated
    public CNGEngine(String modelNo,
                     String modelName,
                     int displacement,
                     int minPower,
                     int maxPower,
                     int maxRPM,
                     double gasTankCapacityKg,
                     String gasInjectionType,
                     boolean isBiFuel,
                     double cylinderPressureBar,
                     String cngRefuelingConnectorType,
                     double maxAllowedTemperatureC
    ) throws InvalidGasInjectionTypeException, InvalidCNGRefuelingConnectorTypeException{
        super(modelNo, modelName, displacement, minPower, maxPower, maxRPM);
        this.gasTankCapacityKg = gasTankCapacityKg;
        this.gasInjectionType = GasInjectionType.fromString(gasInjectionType);
        this.isBiFuel = isBiFuel;
        this.cylinderPressureBar = cylinderPressureBar;
        this.cngRefuelingConnectorType = CNGRefuelingConnectorType.fromString(cngRefuelingConnectorType);
        this.maxAllowedTemperatureC = maxAllowedTemperatureC;
    }

    public static class Builder extends AbstractEngineBuilder<CNGEngine, Builder>{
        private Double gasTankCapacityKg;
        private GasInjectionType gasInjectionType;
        private Boolean isBiFuel;
        private Double cylinderPressureBar;
        private CNGRefuelingConnectorType cngRefuelingConnectorType;
        private Double maxAllowedTemperatureC;

        public Builder gasTankCapacityKg(double gasTankCapacityKg){
            this.gasTankCapacityKg = gasTankCapacityKg;
            return this;
        }

        public Builder gasInjectionType(GasInjectionType gasInjectionType){
            this.gasInjectionType = gasInjectionType;
            return this;
        }

        public Builder gasInjectionType(String gasInjectionType) throws InvalidGasInjectionTypeException{
            this.gasInjectionType = GasInjectionType.fromString(gasInjectionType);
            return this;
        }

        public Builder isBiFuel(boolean isBiFuel){
            this.isBiFuel = isBiFuel;
            return this;
        }

        public Builder cylinderPressureBar(double cylinderPressureBar){
            this.cylinderPressureBar = cylinderPressureBar;
            return this;
        }

        public Builder CNGRefuelingConnectorType(CNGRefuelingConnectorType cngRefuelingConnectorType){
            this.cngRefuelingConnectorType = cngRefuelingConnectorType;
            return this;
        }

        public Builder CNGRefuelingConnectorType(String cngRefuelingConnectorType) throws InvalidCNGRefuelingConnectorTypeException{
            this.cngRefuelingConnectorType = CNGRefuelingConnectorType.fromString(cngRefuelingConnectorType);
            return this;
        }

        public Builder maxAllowedTemperatureC(double maxAllowedTemperatureC){
            this.maxAllowedTemperatureC = maxAllowedTemperatureC;
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public void validate() {
            validate_initial();
            if(gasTankCapacityKg == null || gasTankCapacityKg < 0)  throw new BadCNGGasTankCapacityValueException("ALERT! INVALID CNG GAS TANK CAPACITY! GOT: " + gasTankCapacityKg);
            if(gasInjectionType == null)    throw new InvalidGasInjectionTypeException("ALERT! CNG GAS INJECTION TYPE NOT SPECIFIED! NULL_EXCEPTION");
            if(isBiFuel == null)    throw new BadBiFuelBooleanException("ALERT! INVALID BI FUEL SPECIFIED! GOT: " + isBiFuel);
            if(cylinderPressureBar == null) throw new BadCylinderPressureValueException("ALERT! INVALID CYLINDER PRESSURE SPECIFIED! GOT: " + cylinderPressureBar);
            if(cngRefuelingConnectorType == null)   throw new InvalidCNGRefuelingConnectorTypeException("ALERT! CNG REFUELING CONNECTOR TYPE NOT SPECIFIED! NULL_EXCEPTION");
            if(maxAllowedTemperatureC == null)  throw new BadMaxAllowedTemperatureValueException("ALERT! INVALID MAX ALLOWED TEMPERATURE SPECIFIED! GOT: " + maxAllowedTemperatureC);
        }

        @Override
        public CNGEngine build(){
            validate();
            return new CNGEngine(modelNo,
                                modelName,
                                displacement,
                                minPower,
                                maxPower,
                                maxRPM,
                                gasTankCapacityKg,
                                gasInjectionType,
                                isBiFuel,
                                cylinderPressureBar,
                                cngRefuelingConnectorType,
                                maxAllowedTemperatureC
            );
        }
    }

    @Override
    public String getModelNo() {
        return super.getModelNo();
    }
    @Override
    public int getDisplacement() {
        return super.getDisplacement();
    }
    @Override
    public int getMinPower() {
        return super.getMinPower();
    }
    @Override
    public int getMaxPower() {
        return super.getMaxPower();
    }
    @Override
    public int getMaxRPM() {
        return super.getMaxRPM();
    }
    @Override
    public void setModelNo(String modelNo) {
        super.setModelNo(modelNo);
    }
    @Override
    public void setDisplacement(int displacement) {
        super.setDisplacement(displacement);
    }
    @Override
    public void setMinPower(int minPower) {
        super.setMinPower(minPower);
    }
    @Override
    public void setMaxPower(int maxPower) {
        super.setMaxPower(maxPower);
    }
    @Override
    public void setMaxRPM(int maxRPM) {
        super.setMaxRPM(maxRPM);
    }
    public double getGasTankCapacityKg() {
        return gasTankCapacityKg;
    }
    public void setGasTankCapacityKg(double gasTankCapacityKg) {
        this.gasTankCapacityKg = gasTankCapacityKg;
    }
    public GasInjectionType getGasInjectionType() {
        return gasInjectionType;
    }
    public void setGasInjectionType(GasInjectionType gasInjectionType) {
        this.gasInjectionType = gasInjectionType;
    }
    public boolean isBiFuel() {
        return isBiFuel;
    }
    public void setBiFuel(boolean biFuel) {
        isBiFuel = biFuel;
    }
    public double getCylinderPressureBar() {
        return cylinderPressureBar;
    }
    public void setCylinderPressureBar(double cylinderPressureBar) {
        this.cylinderPressureBar = cylinderPressureBar;
    }
    public CNGRefuelingConnectorType getCngRefuelingConnectorType() {
        return cngRefuelingConnectorType;
    }
    public void setCngRefuelingConnectorType(CNGRefuelingConnectorType cngRefuelingConnectorType) {
        this.cngRefuelingConnectorType = cngRefuelingConnectorType;
    }
    public double getMaxAllowedTemperatureC() {
        return maxAllowedTemperatureC;
    }
    public void setMaxAllowedTemperatureC(double maxAllowedTemperatureC) {
        this.maxAllowedTemperatureC = maxAllowedTemperatureC;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        return builder.append("--------------------------------------------\n")
                .append("Model No: ").append(modelNo).append("\n")
                .append("Model Name: ").append(modelName).append("\n")
                .append("Displacement: ").append(displacement).append("\n")
                .append("Min. Power: ").append(minPower).append("\n")
                .append("Max. Power: ").append(maxPower).append("\n")
                .append("Max RPM: ").append(maxRPM).append("\n")
                .append("Gas Tank Capacity (Kg): ").append(gasTankCapacityKg).append("\n")
                .append("Gas Injection Type: ").append(gasInjectionType).append("\n")
                .append("Supports Bi Fuel Config: ").append(isBiFuel).append("\n")
                .append("Cylinder Pressure (bar): ").append(cylinderPressureBar).append("\n")
                .append("Refueling Connector Type: ").append(cngRefuelingConnectorType).append("\n")
                .append("Max Allowed Temperature (C): ").append(maxAllowedTemperatureC).append("\n")
                .append("--------------------------------------------\n")
                .toString();
    }
}
