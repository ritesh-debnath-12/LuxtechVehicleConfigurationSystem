package com.lukxtech.powertrain.enginefamily.engines.diesel;

import com.lukxtech.powertrain.enginefamily.abstracts.AbstractEngineBuilder;
import com.lukxtech.powertrain.enginefamily.abstracts.AbstractEngineModel;
import com.lukxtech.powertrain.enginefamily.engines.diesel.enums.CetaneNumber;
import com.lukxtech.powertrain.enginefamily.engines.diesel.enums.ExhaustGasRecirculationState;
import com.lukxtech.powertrain.enginefamily.engines.diesel.enums.FuelPumpType;
import com.lukxtech.powertrain.enginefamily.engines.diesel.enums.TurbochargerType;
import com.lukxtech.powertrain.enginefamily.engines.diesel.exceptions.InvalidCetaneNumberException;
import com.lukxtech.powertrain.enginefamily.engines.diesel.exceptions.InvalidExhaustGasRecirculationStateException;
import com.lukxtech.powertrain.enginefamily.engines.diesel.exceptions.InvalidFuelPumpTypeException;
import com.lukxtech.powertrain.enginefamily.engines.diesel.exceptions.InvalidTurbochargerTypeException;
import com.lukxtech.powertrain.enginefamily.engines.diesel.exceptions.InvalidGlowPlugCountException;
import com.lukxtech.powertrain.enginefamily.engines.diesel.exceptions.InvalidParticulateFilterDataException;
import com.lukxtech.powertrain.enginefamily.interfaces.InternalCombustionEngineInterface;

/**
 * <h3>Diesel Engine Model</h3>
 * <p>This class represents a diesel engine model.</p>
 * <p>It extends the AbstractEngineModel class and implements the InternalCombustionEngineInterface.</p>
 *
 * @author Neko
 * @see AbstractEngineModel
 * @see InternalCombustionEngineInterface
 * @since 0.0.0
 */
public class DieselEngine extends AbstractEngineModel implements InternalCombustionEngineInterface {
    private CetaneNumber cetaneNumber;
    private TurbochargerType turbochargerType;
    private int glowPlugCount;
    private FuelPumpType fuelPumpType;
    private boolean isParticulateFilterPresent;
    private ExhaustGasRecirculationState exhaustGasRecirculationState;

    /**
     * <p>Constructor for the DieselEngine class</p>
     *
     * @param modelNo                      -> The model number of the engine
     * @param modelName                    -> The name of the engine model
     * @param displacement                 -> The engine displacement in cubic centimeters
     * @param minPower                     -> The minimum power output of the engine in horsepower (0 < minPower < maxPower)
     * @param maxPower                     -> The maximum power output of the engine in horsepower (0 < minPower < maxPower)
     * @param maxRPM                       -> The maximum revolutions per minute of the engine
     * @param cetaneNumber                 -> The cetane number of the engine
     * @param turbochargerType             -> The type of turbocharger used
     * @param glowPlugCount                -> The number of glow plugs
     * @param fuelPumpType                 -> The type of fuel pump used
     * @param isParticulateFilterPresent   -> Whether the engine has a particulate filter
     * @param exhaustGasRecirculationState -> The state of the exhaust gas recirculation system
     *
     *                                     <p> -- ENUMS -- </p>
     *                                     <ul>
     *                                         <li>{@link CetaneNumber}</li>
     *                                         <li>{@link TurbochargerType}</li>
     *                                         <li>{@link FuelPumpType}</li>
     *                                         <li>{@link ExhaustGasRecirculationState}</li>
     *                                     </ul>
     *
     *                                     <p> -- BUILDER -- </p>
     *                                     <ul>
     *                                         <li>{@link Builder}</li>
     *                                     </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public DieselEngine(String modelNo,
                        String modelName,
                        int displacement,
                        int minPower,
                        int maxPower,
                        int maxRPM,
                        CetaneNumber cetaneNumber,
                        TurbochargerType turbochargerType,
                        int glowPlugCount,
                        FuelPumpType fuelPumpType,
                        boolean isParticulateFilterPresent,
                        ExhaustGasRecirculationState exhaustGasRecirculationState
    ) {
        super(modelNo, modelName, displacement, minPower, maxPower, maxRPM);
        this.cetaneNumber = cetaneNumber;
        this.turbochargerType = turbochargerType;
        this.glowPlugCount = glowPlugCount;
        this.fuelPumpType = fuelPumpType;
        this.isParticulateFilterPresent = isParticulateFilterPresent;
        this.exhaustGasRecirculationState = exhaustGasRecirculationState;
    }

    /**
     * <p>Constructor for the DieselEngine class</p>
     *
     * @param modelNo                      -> The model number of the engine
     * @param modelName                    -> The name of the engine model
     * @param displacement                 -> The engine displacement in cubic centimeters
     * @param minPower                     -> The minimum power output of the engine in horsepower (0 < minPower < maxPower)
     * @param maxPower                     -> The maximum power output of the engine in horsepower (0 < minPower < maxPower)
     * @param maxRPM                       -> The maximum revolutions per minute of the engine
     * @param cetaneNumber                 -> The cetane number of the engine
     * @param turbochargerType             -> The type of turbocharger used
     * @param glowPlugCount                -> The number of glow plugs
     * @param fuelPumpType                 -> The type of fuel pump used
     * @param isParticulateFilterPresent   -> Whether the engine has a particulate filter
     * @param exhaustGasRecirculationState -> The state of the exhaust gas recirculation system
     * @throws InvalidCetaneNumberException                 if the cetane number is invalid
     * @throws InvalidTurbochargerTypeException             if the turbocharger type is invalid
     * @throws InvalidFuelPumpTypeException                 if the fuel pump type is invalid
     * @throws InvalidExhaustGasRecirculationStateException if the exhaust gas recirculation state is invalid
     *                                                      <p>
     *                                                      * <p> -- ENUMS -- </p>
     *                                                      <ul>
     *                                                          <li>{@link CetaneNumber}</li>
     *                                                          <li>{@link TurbochargerType}</li>
     *                                                          <li>{@link FuelPumpType}</li>
     *                                                          <li>{@link ExhaustGasRecirculationState}</li>
     *                                                      </ul>
     *
     *                                                      <p> -- BUILDER -- </p>
     *                                                      <ul>
     *                                                          <li>{@link Builder}</li>
     *                                                      </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public DieselEngine(String modelNo,
                        String modelName,
                        int displacement,
                        int minPower,
                        int maxPower,
                        int maxRPM,
                        int cetaneNumber,
                        String turbochargerType,
                        int glowPlugCount,
                        String fuelPumpType,
                        boolean isParticulateFilterPresent,
                        String exhaustGasRecirculationState
    ) throws InvalidCetaneNumberException, InvalidTurbochargerTypeException, InvalidFuelPumpTypeException, InvalidExhaustGasRecirculationStateException {
        super(modelNo, modelName, displacement, minPower, maxPower, maxRPM);
        this.cetaneNumber = CetaneNumber.fromInt(cetaneNumber);
        this.turbochargerType = TurbochargerType.fromString(turbochargerType);
        this.glowPlugCount = glowPlugCount;
        this.fuelPumpType = FuelPumpType.fromString(fuelPumpType);
        this.isParticulateFilterPresent = isParticulateFilterPresent;
        this.exhaustGasRecirculationState = ExhaustGasRecirculationState.fromString(exhaustGasRecirculationState);
    }

    /**
     * Builder for the DieselEngine class
     *
     * <p>Usage</p>
     * <pre>
     * DieselEngine dieselEngine = new DieselEngine.Builder()
     *         .modelNo("LUKX-DI_96CFKX")
     *         .modelName("Halloween Weed")
     *         .displacement(2998)
     *         .cetaneNumber(58)
     *         .minPower(10)
     *         .maxPower(180)
     *         .maxRPM(4500)
     *         .cetaneNumber(48)
     *         .turbochargerType(TurbochargerType.VARIABLE_GEOMETRY)
     *         .fuelPumpType(FuelPumpType.INLINE)
     *         .glowPlugCount(2)
     *         .isParticulateFilterPresent(false)
     *         .exhaustGasRecirculationState(ExhaustGasRecirculationState.OFF)
     *         .build();
     * </pre>
     *
     * <p>NOTE: Feel free to substitute enum values as strings or int</p>
     */
    public static class Builder extends AbstractEngineBuilder<DieselEngine, Builder> {
        private CetaneNumber cetaneNumber;
        private TurbochargerType turbochargerType;
        private Integer glowPlugCount;
        private FuelPumpType fuelPumpType;
        private Boolean isParticulateFilterPresent;
        private ExhaustGasRecirculationState exhaustGasRecirculationState;

        public Builder cetaneNumber(CetaneNumber cetaneNumber) {
            this.cetaneNumber = cetaneNumber;
            return this;
        }

        public Builder cetaneNumber(int cetaneNumber) {
            this.cetaneNumber = CetaneNumber.fromInt(cetaneNumber);
            return this;
        }

        public Builder turbochargerType(TurbochargerType turbochargerType) {
            this.turbochargerType = turbochargerType;
            return this;
        }

        public Builder turbochargerType(String turbochargerType) {
            this.turbochargerType = TurbochargerType.fromString(turbochargerType);
            return this;
        }

        public Builder fuelPumpType(FuelPumpType fuelPumpType) {
            this.fuelPumpType = fuelPumpType;
            return this;
        }

        public Builder fuelPumpType(String fuelPumpType) {
            this.fuelPumpType = FuelPumpType.fromString(fuelPumpType);
            return this;
        }

        public Builder glowPlugCount(int glowPlugCount) {
            this.glowPlugCount = glowPlugCount;
            return this;
        }

        public Builder isParticulateFilterPresent(boolean isParticulateFilterPresent) {
            this.isParticulateFilterPresent = isParticulateFilterPresent;
            return this;
        }

        public Builder exhaustGasRecirculationState(ExhaustGasRecirculationState exhaustGasRecirculationState) {
            this.exhaustGasRecirculationState = exhaustGasRecirculationState;
            return this;
        }

        public Builder exhaustGasRecirculationState(String exhaustGasRecirculationState) {
            this.exhaustGasRecirculationState = ExhaustGasRecirculationState.fromString(exhaustGasRecirculationState);
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public void validate() {
            validate_initial(); // This always needs to be the first to be validated
            if (cetaneNumber == null)
                throw new InvalidCetaneNumberException("ALERT! CETANE NUMBER NOT SPECIFIED! NULL_EXCEPTION");
            if (turbochargerType == null)
                throw new InvalidTurbochargerTypeException("ALERT! TURBOCHARGER TYPE NOT SPECIFIED! INVALID_EXCEPTION");
            if (fuelPumpType == null)
                throw new InvalidFuelPumpTypeException("ALERT! FUEL PUMP TYPE NOT SPECIFIED! NULL_EXCEPTION");
            if (glowPlugCount == null)
                throw new InvalidGlowPlugCountException("ALERT! GLOW PLUG COUNT NOT SPECIFIED! NULL_EXCEPTION");
            if (isParticulateFilterPresent == null)
                throw new InvalidParticulateFilterDataException("ALERT! PARTICULATE FILTER DATA NOT FOUND!");
            if (exhaustGasRecirculationState == null)
                throw new InvalidExhaustGasRecirculationStateException("ALERT! GAS RECIRCULATION STATE NOT SPECIFIED! NULL_EXCEPTION");
        }

        @Override
        public DieselEngine build() {
            validate();
            return new DieselEngine(
                    modelNo,
                    modelName,
                    displacement,
                    minPower,
                    maxPower,
                    maxRPM,
                    cetaneNumber,
                    turbochargerType,
                    glowPlugCount,
                    fuelPumpType,
                    isParticulateFilterPresent,
                    exhaustGasRecirculationState
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

    public CetaneNumber getCetaneNumber() {
        return cetaneNumber;
    }

    public void setCetaneNumber(int cetaneNumber) throws InvalidCetaneNumberException {
        this.cetaneNumber = CetaneNumber.fromInt(cetaneNumber);
    }

    public void setCetaneNumber(CetaneNumber cetaneNumber) {
        this.cetaneNumber = cetaneNumber;
    }

    public TurbochargerType getTurbochargerType() {
        return turbochargerType;
    }

    public void setTurbochargerType(String turbochargerType) throws InvalidTurbochargerTypeException {
        this.turbochargerType = TurbochargerType.fromString(turbochargerType);
    }

    public void setTurbochargerType(TurbochargerType turbochargerType) {
        this.turbochargerType = turbochargerType;
    }

    public int getGlowPlugCount() {
        return glowPlugCount;
    }

    public void setGlowPlugCount(int glowPlugCount) {
        this.glowPlugCount = glowPlugCount;
    }

    public FuelPumpType getFuelPumpType() {
        return fuelPumpType;
    }

    public void setFuelPumpType(FuelPumpType fuelPumpType) {
        this.fuelPumpType = fuelPumpType;
    }

    public boolean isParticulateFilterPresent() {
        return isParticulateFilterPresent;
    }

    public void setParticulateFilterPresent(boolean particulateFilterPresent) {
        isParticulateFilterPresent = particulateFilterPresent;
    }

    public ExhaustGasRecirculationState getExhaustGasRecirculationState() {
        return exhaustGasRecirculationState;
    }

    public void setExhaustGasRecirculationState(String exhaustGasRecirculationState) throws InvalidExhaustGasRecirculationStateException {
        this.exhaustGasRecirculationState = ExhaustGasRecirculationState.fromString(exhaustGasRecirculationState);
    }

    public void setExhaustGasRecirculationState(ExhaustGasRecirculationState exhaustGasRecirculationState) {
        this.exhaustGasRecirculationState = exhaustGasRecirculationState;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append("--------------------------------------------\n")
                .append("Model No: ").append(modelNo).append("\n")
                .append("Model Name: ").append(modelName).append("\n")
                .append("Displacement: ").append(displacement).append("\n")
                .append("Min. Power: ").append(minPower).append("\n")
                .append("Max. Power: ").append(maxPower).append("\n")
                .append("Max RPM: ").append(maxRPM).append("\n")
                .append("Cetane Rating: ").append(cetaneNumber).append("\n")
                .append("TurboCharger Type: ").append(turbochargerType).append("\n")
                .append("Glow Plug Count: ").append(glowPlugCount).append("\n")
                .append("Fuel Pump Type: ").append(fuelPumpType).append("\n")
                .append("Particulate Filter Present?: ").append(isParticulateFilterPresent).append("\n")
                .append("Exhaust Gas Recirculation State: ").append(exhaustGasRecirculationState).append("\n")
                .append("--------------------------------------------\n")
                .toString();
    }
}
