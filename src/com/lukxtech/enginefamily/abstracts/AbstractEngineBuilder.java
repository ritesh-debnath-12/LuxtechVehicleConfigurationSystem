package com.lukxtech.enginefamily.abstracts;

import com.lukxtech.enginefamily.abstracts.exceptions.*;

/**
 * <p>An generic abstract builder for all the Engines to inherit from</p>
 * @param T -> The type of the engine model that this builder will create
 * @param B -> The type of the builder itself
 *
 * This class greatly reduces boilerplate code for creating engine models
 * @author Neko
 * @since 0.0.0
 */
public abstract class AbstractEngineBuilder<T extends AbstractEngineModel, B extends AbstractEngineBuilder<T, B>> {
    protected String modelNo;
    protected String modelName;
    protected int displacement;
    protected int minPower;
    protected int maxPower;
    protected int maxRPM;

    public B modelNo(String modelNo) {
        this.modelNo = modelNo;
        return self();
    }
    public B modelName(String modelName){
        this.modelName = modelName;
        return self();
    }
    public B displacement(int displacement) {
        this.displacement = displacement;
        return self();
    }
    public B minPower(int minPower) {
        this.minPower = minPower;
        return self();
    }
    public B maxPower(int maxPower) {
        this.maxPower = maxPower;
        return self();
    }
    public B maxRPM(int maxRPM) {
        this.maxRPM = maxRPM;
        return self();
    }

    /**
     * Validates the initial parameters for the engine model.
     * @throws BadModelNameException -> If the model name is invalid
     * @throws BadModelNumberException -> If the model number is invalid
     * @throws BadDisplacementValueException -> If the displacement value is invalid
     * @throws BadPowerValueException -> If the power values are invalid
     * @throws BadRPMValueException -> If the RPM value is invalid
     */
    public void validate_initial() throws BadModelNameException, BadModelNumberException, BadDisplacementValueException, BadPowerValueException, BadRPMValueException {
        if(modelNo == null || modelNo.isBlank())    throw new BadModelNumberException("BAD MODEL NUMBER! GOT: " + modelNo);
        if(modelName == null || modelName.isBlank())    throw new BadModelNameException("BAD MODEL NAME! GOT: " + modelName);
        if(displacement <= 0)   throw new BadDisplacementValueException("BAD DISPLACEMENT VALUE! GOT: " + displacement);
        if(minPower < 0)    throw new BadPowerValueException("BAD MINIMUM POWER! GOT: "+ minPower + " ALSO, MAX POWER: " + maxPower);
        if((maxPower <= minPower) || (maxPower < 0) || (maxPower == minPower))  throw new BadPowerValueException("BAD MAX POWER! GOT: " + maxPower + " ALSO, MIN POWER: " + minPower);
        if(maxRPM <= 0)     throw new BadRPMValueException("BAD RPM VALUE! GOT: " + maxRPM);
    }

    /**
     * <p>Abstract Method for validating the engine model.</p>
     * <p>DO NOT VALIDATE COMMON ATTRIBUTES: modelNo, modelName, displacement, minPower, maxPower, maxRPM</p>
     *
     * <p>NOTE: Please call validate_initial as the first step in your validation process.</p>
     */
    public abstract void validate();
    
    /**
     * <p>Returns the current builder instance.</p>
     * @return B -> The current builder instance
     */
    public abstract B self();

    /**
     * Builds the engine model.
     * @return T -> The constructed engine model
     */
    public abstract T build();
}
