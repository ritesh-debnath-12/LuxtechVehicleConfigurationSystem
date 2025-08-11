package com.lukxtech.parts.transmissionfamily.abstracts;

import com.lukxtech.parts.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;

import java.util.ArrayList;

public abstract class AbstractTransmissionModel {
    protected TransmissionType transmissionType;
    protected int forwardGears;

    protected AbstractTransmissionModel(TransmissionType transmissionType, int forwardGears) {
        this.transmissionType = transmissionType;
        this.forwardGears = forwardGears;
    }

    protected AbstractTransmissionModel(String transmissionType, int forwardGears) throws InvalidTransmissionTypeException{
        this.transmissionType = TransmissionType.fromString(transmissionType);
        this.forwardGears = forwardGears;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public void setTransmissionType(String transmissionType) throws InvalidTransmissionTypeException {
        this.transmissionType = TransmissionType.fromString(transmissionType);
    }

    public int getForwardGears() {
        return forwardGears;
    }

    public void setForwardGears(int forwardGears) {
        this.forwardGears = forwardGears;
    }

    protected abstract ArrayList<Double> getGearRatioData();
}
