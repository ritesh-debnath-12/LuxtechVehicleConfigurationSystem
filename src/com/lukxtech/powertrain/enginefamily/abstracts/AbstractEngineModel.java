package com.lukxtech.powertrain.enginefamily.abstracts;

import com.lukxtech.powertrain.enginefamily.abstracts.exceptions.BadDisplacementValueException;
import com.lukxtech.powertrain.enginefamily.abstracts.exceptions.BadModelNameException;
import com.lukxtech.powertrain.common.exception.BadModelNumberException;
import com.lukxtech.powertrain.enginefamily.abstracts.exceptions.BadPowerValueException;
import com.lukxtech.powertrain.enginefamily.abstracts.exceptions.BadRPMValueException;

/**
 * <p>An abstract model for all the Engines to inherit from</p>
 * <p>All the engines(<em>regardless of type</em>) have some characteristics in common</p>
 * <p>As such, this class provides a common abstract class to inherit those characteristics</p>
 *
 * @author Neko
 * @since 0.0.0
 */
public abstract class AbstractEngineModel {
    protected String modelNo;
    protected String modelName;
    protected int displacement;
    protected int minPower;
    protected int maxPower;
    protected int maxRPM;

    /**
     * Constructor for the AbstractEngineModel class
     *
     * @param modelNo      The model number of the engine
     * @param modelName    The name of the engine model
     * @param displacement The engine displacement in cubic centimeters
     * @param minPower     The minimum power output of the engine in horsepower (0 < minPower < maxPower)
     * @param maxPower     The maximum power output of the engine in horsepower (0 < minPower < maxPower)
     * @param maxRPM       The maximum revolutions per minute of the engine
     */
    public AbstractEngineModel(String modelNo, String modelName, int displacement, int minPower, int maxPower, int maxRPM) {
        this.modelNo = modelNo;
        this.modelName = modelName;
        this.displacement = displacement;
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.maxRPM = maxRPM;
    }

    public String getModelNo() {
        return modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public int getDisplacement() {
        return displacement;
    }

    public int getMinPower() {
        return minPower;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int getMaxRPM() {
        return maxRPM;
    }

    public void setModelNo(String modelNo) throws BadModelNumberException {
        if (modelNo == null || modelNo.isEmpty())
            throw new BadModelNumberException("ALERT! MODEL NUMBER CANNOT BE NULL OR EMPTY");
        this.modelNo = modelNo;
    }

    public void setModelName(String modelName) throws BadModelNameException {
        if (modelName == null || modelName.isEmpty())
            throw new BadModelNameException("ALERT! MODEL NAME CANNOT BE NULL OR EMPTY");
        this.modelName = modelName;
    }

    public void setDisplacement(int displacement) throws BadDisplacementValueException {
        if (displacement < 0) throw new BadDisplacementValueException("ALERT! DISPLACEMENT MUST BE > 0");
        this.displacement = displacement;
    }

    public void setMinPower(int minPower) throws BadPowerValueException {
        if (minPower < 0 || minPower > maxPower)
            throw new BadPowerValueException("ALERT! MIN POWER MUST BE BETWEEN 0 AND < THAN MAX POWER");
        this.minPower = minPower;
    }

    public void setMaxPower(int maxPower) throws BadPowerValueException {
        if (maxPower < 0 || maxPower < minPower)
            throw new BadPowerValueException("ALERT! MAX POWER MUST BE BETWEEN 0 AND > THAN MIN POWER");
        this.maxPower = maxPower;
    }

    public void setMaxRPM(int maxRPM) throws BadRPMValueException {
        if (maxRPM < 0) throw new BadRPMValueException("ALERT! MAX RPM MUST BE >= 0");
        this.maxRPM = maxRPM;
    }
}
