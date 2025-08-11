package com.lukxtech.enginefamily.engines.petrol;

import com.lukxtech.enginefamily.abstracts.AbstractEngineBuilder;
import com.lukxtech.enginefamily.abstracts.AbstractEngineModel;
import com.lukxtech.enginefamily.engines.petrol.enums.CatalyticConverterType;
import com.lukxtech.enginefamily.engines.petrol.enums.EmissionStandardCompliance;
import com.lukxtech.enginefamily.engines.petrol.enums.FuelInjectionType;
import com.lukxtech.enginefamily.engines.petrol.enums.OctaneRating;
import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidCatalyticConverterTypeException;
import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidEmissionStandardComplianceException;
import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidFuelInjectionTypeException;
import com.lukxtech.enginefamily.engines.petrol.exceptions.InvalidOctaneRatingException;
import com.lukxtech.enginefamily.interfaces.InternalCombustionEngineInterface;

public class PetrolEngine extends AbstractEngineModel implements InternalCombustionEngineInterface {
    private OctaneRating octaneRating;
    private FuelInjectionType fuelInjectionType;
    private EmissionStandardCompliance emissionStandardCompliance;
    private CatalyticConverterType catalyticConverterType;

    @Deprecated
    public PetrolEngine(String modelNo,
                        String modelName,
                        int displacement,
                        int minPower,
                        int maxPower,
                        int maxRPM,
                        OctaneRating octaneRating,
                        FuelInjectionType fuelInjectionType,
                        EmissionStandardCompliance emissionStandardCompliance,
                        CatalyticConverterType catalyticConverterType
        ) {
        super(modelNo, modelName, displacement, minPower, maxPower, maxRPM);
        this.octaneRating = octaneRating;
        this.fuelInjectionType = fuelInjectionType;
        this.emissionStandardCompliance = emissionStandardCompliance;
        this.catalyticConverterType = catalyticConverterType;
    }

    @Deprecated
    public PetrolEngine(String modelNo,
                        String modelName,
                        int displacement,
                        int minPower,
                        int maxPower,
                        int maxRPM,
                        int octaneRating,
                        String fuelInjectionType,
                        String emissionStandardCompliance,
                        int catalyticConverterType
    ) throws InvalidOctaneRatingException, InvalidFuelInjectionTypeException, InvalidEmissionStandardComplianceException, InvalidCatalyticConverterTypeException{
        super(modelNo, modelName, displacement, minPower, maxPower, maxRPM);
        this.octaneRating = OctaneRating.fromNumber(octaneRating);
        this.fuelInjectionType = FuelInjectionType.fromString(fuelInjectionType);
        this.emissionStandardCompliance = EmissionStandardCompliance.fromString(emissionStandardCompliance);
        this.catalyticConverterType = CatalyticConverterType.fromInt(catalyticConverterType);
    }

    public static class Builder extends AbstractEngineBuilder<PetrolEngine, Builder>{
        private OctaneRating octaneRating;
        private FuelInjectionType fuelInjectionType;
        private EmissionStandardCompliance emissionStandardCompliance;
        private CatalyticConverterType catalyticConverterType;

        public Builder octaneRating(OctaneRating octaneRating){
            this.octaneRating = octaneRating;
            return this;
        }

        public Builder octaneRating(int octaneRating) throws InvalidOctaneRatingException{
            this.octaneRating = OctaneRating.fromNumber(octaneRating);
            return this;
        }

        public Builder fuelInjectionType(FuelInjectionType fuelInjectionType){
            this.fuelInjectionType = fuelInjectionType;
            return this;
        }

        public Builder fuelInjectionType(String fuelInjectionType) throws InvalidFuelInjectionTypeException{
            this.fuelInjectionType = FuelInjectionType.fromString(fuelInjectionType);
            return this;
        }

        public Builder emissionStandardCompliance(EmissionStandardCompliance emissionStandardCompliance){
            this.emissionStandardCompliance = emissionStandardCompliance;
            return this;
        }

        public Builder emissionStandardCompliance(String emissionStandardCompliance) throws InvalidEmissionStandardComplianceException{
            this.emissionStandardCompliance = EmissionStandardCompliance.fromString(emissionStandardCompliance);
            return this;
        }

        public Builder catalyticConverterType(CatalyticConverterType catalyticConverterType){
            this.catalyticConverterType = catalyticConverterType;
            return this;
        }

        public Builder catalyticConverterType(int catalyticConverterType) throws InvalidCatalyticConverterTypeException{
            this.catalyticConverterType = CatalyticConverterType.fromInt(catalyticConverterType);
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public void validate() {
            validate_initial();

            if(octaneRating == null)    throw new InvalidOctaneRatingException("ALERT! OCTANE NUMBER NOT SPECIFIED! NULL_EXCEPTION");
            if(fuelInjectionType == null)   throw new InvalidFuelInjectionTypeException("ALERT! FUEL INJECTION TYPE NOT SPECIFIED! NULL_EXCEPTION");
            if(emissionStandardCompliance == null)   throw new InvalidEmissionStandardComplianceException("ALERT! EMISSION STANDARD COMPLIANCE NOT SPECIFIED! NULL_EXCEPTION");
            if(catalyticConverterType == null)   throw new InvalidCatalyticConverterTypeException("ALERT! CATALYTIC CONVERTER TYPE NOT SPECIFIED! NULL_EXCEPTION");
        }

        @Override
        public PetrolEngine build() {
            validate();
            return new PetrolEngine(
                    modelNo,
                    modelName,
                    displacement,
                    minPower,
                    maxPower,
                    maxRPM,
                    octaneRating,
                    fuelInjectionType,
                    emissionStandardCompliance,
                    catalyticConverterType
            );
        }
    }

    @Override
    public String getModelNo() {
        return super.getModelNo();
    }
    @Override
    public void setModelNo(String modelNo) {
        super.setModelNo(modelNo);
    }
    @Override
    public int getDisplacement() {
        return super.getDisplacement();
    }
    @Override
    public void setDisplacement(int displacement) {
        super.setDisplacement(displacement);
    }
    @Override
    public int getMinPower() {
        return super.getMinPower();
    }
    @Override
    public void setMinPower(int minPower) {
        super.setMinPower(minPower);
    }
    @Override
    public int getMaxPower() {
        return super.getMaxPower();
    }
    @Override
    public void setMaxPower(int maxPower) {
        super.setMaxPower(maxPower);
    }
    @Override
    public int getMaxRPM() {
        return super.getMaxRPM();
    }
    @Override
    public void setMaxRPM(int maxRPM) {
        super.setMaxRPM(maxRPM);
    }
    public OctaneRating getOctaneRating() {
        return octaneRating;
    }
    public void setOctaneRating(OctaneRating octaneRating) {
        this.octaneRating = octaneRating;
    }
    public FuelInjectionType getFuelInjectionType() {
        return fuelInjectionType;
    }
    public void setFuelInjectionType(FuelInjectionType fuelInjectionType) {
        this.fuelInjectionType = fuelInjectionType;
    }
    public EmissionStandardCompliance getEmissionStandardCompliance() {
        return emissionStandardCompliance;
    }
    public void setEmissionStandardCompliance(EmissionStandardCompliance emissionStandardCompliance) {
        this.emissionStandardCompliance = emissionStandardCompliance;
    }
    public CatalyticConverterType getCatalyticConverterType() {
        return catalyticConverterType;
    }
    public void setCatalyticConverterType(CatalyticConverterType catalyticConverterType) {
        this.catalyticConverterType = catalyticConverterType;
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
                .append("Octane Rating: ").append(octaneRating).append("\n")
                .append("Fuel Injection Type: ").append(fuelInjectionType).append("\n")
                .append("Emission Standard Compliance: ").append(emissionStandardCompliance).append("\n")
                .append("Catalytic Converter Type: ").append(catalyticConverterType).append("\n")
                .append("--------------------------------------------\n")
                .toString();
    }
}
