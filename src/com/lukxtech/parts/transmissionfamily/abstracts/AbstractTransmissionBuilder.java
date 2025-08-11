package com.lukxtech.parts.transmissionfamily.abstracts;

import com.lukxtech.parts.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.BadForwardGearValueException;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;

public abstract class AbstractTransmissionBuilder<T extends AbstractTransmissionModel, B extends AbstractTransmissionBuilder<T, B>> {
    protected TransmissionType transmissionType;
    protected int forwardGears;

    public B transmissionType(TransmissionType transmissionType){
        this.transmissionType = transmissionType;
        return self();
    }

    public B transmissionType(String transmissionType){
        this.transmissionType = TransmissionType.fromString(transmissionType);
        return self();
    }

    public B forwardGears(int forwardGears){
        this.forwardGears = forwardGears;
        return self();
    }

    public void validate_initial(){
        if(transmissionType == null)    throw new InvalidTransmissionTypeException("ALERT TRANSMISSION TYPE NOT SPECIFIED! GOT: " + transmissionType);
        if(forwardGears < 0)    throw new BadForwardGearValueException("INVALID FORWARD GEAR VALUE! GOT: " + forwardGears);
    }
    public abstract void validate();
    public abstract B self();
    public abstract T build();
}
