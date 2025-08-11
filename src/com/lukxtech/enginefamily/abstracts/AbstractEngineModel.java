package com.lukxtech.enginefamily.abstracts;

public abstract class AbstractEngineModel {
    protected String modelNo;
    protected String modelName;
    protected int displacement;
    protected int minPower;
    protected int maxPower;
    protected int maxRPM;

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

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void setMinPower(int minPower) {
        this.minPower = minPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public void setMaxRPM(int maxRPM) {
        this.maxRPM = maxRPM;
    }
}
