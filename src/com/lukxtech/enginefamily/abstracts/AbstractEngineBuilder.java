package com.lukxtech.enginefamily.abstracts;

import com.lukxtech.enginefamily.abstracts.exceptions.*;

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


    public void validate_initial(){
        if(modelNo == null || modelNo.isBlank())    throw new BadModelNumberException("BAD MODEL NUMBER! GOT: " + modelNo);
        if(modelName == null || modelName.isBlank())    throw new BadModelNameException("BAD MODEL NAME! GOT: " + modelName);
        if(displacement <= 0)   throw new BadDisplacementValueException("BAD DISPLACEMENT VALUE! GOT: " + displacement);
        if(minPower < 0)    throw new BadPowerValueException("BAD MINIMUM POWER! GOT: "+ minPower + " ALSO, MAX POWER: " + maxPower);
        if((maxPower <= minPower) || (maxPower < 0) || (maxPower == minPower))  throw new BadPowerValueException("BAD MAX POWER! GOT: " + maxPower + " ALSO, MIN POWER: " + minPower);
        if(maxRPM <= 0)     throw new BadRPMValueException("BAD RPM VALUE! GOT: " + maxRPM);
    }
    public abstract void validate();
    public abstract B self();
    public abstract T build();
}
