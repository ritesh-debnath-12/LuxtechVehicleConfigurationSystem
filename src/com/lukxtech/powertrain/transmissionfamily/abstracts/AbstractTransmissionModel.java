package com.lukxtech.powertrain.transmissionfamily.abstracts;

import com.lukxtech.powertrain.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.powertrain.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;

import java.util.ArrayList;

/**
 * <h3>Abstract Transmission Model</h3>
 * <p>This abstract class serves as the base for all transmission models in the system.</p>
 * <p>It provides common attributes and methods that are shared across all transmission types.</p>
 * <p>All concrete transmission implementations must extend this class.</p>
 *
 * @author Neko
 * @see TransmissionType
 * @since 0.0.0
 */
public abstract class AbstractTransmissionModel {
    protected String modelNumber;
    protected TransmissionType transmissionType;
    protected int forwardGears;

    /**
     * <p>Constructor for the AbstractTransmissionModel class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (MANUAL, AMT, CVT, DCT)
     * @param forwardGears     -> The number of forward gears available in the transmission
     */
    protected AbstractTransmissionModel(String modelNumber, TransmissionType transmissionType, int forwardGears) {
        this.modelNumber = modelNumber;
        this.transmissionType = transmissionType;
        this.forwardGears = forwardGears;
    }

    /**
     * <p>Constructor for the AbstractTransmissionModel class with String transmission type</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission as string (manual, amt, cvt, dct)
     * @param forwardGears     -> The number of forward gears available in the transmission
     * @throws InvalidTransmissionTypeException if the transmission type string is invalid
     */
    protected AbstractTransmissionModel(String modelNumber, String transmissionType, int forwardGears) throws InvalidTransmissionTypeException {
        this.modelNumber = modelNumber;
        this.transmissionType = TransmissionType.fromString(transmissionType);
        this.forwardGears = forwardGears;
    }

    /**
     * <p>Gets the model number of the transmission</p>
     *
     * @return Model number in String
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * <p>Gets the model number of the transmission</p>
     *
     * @param modelNumber -> The model number in String to set
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * <p>Gets the transmission type</p>
     *
     * @return The transmission type enum value
     */
    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    /**
     * <p>Sets the transmission type</p>
     *
     * @param transmissionType -> The transmission type enum to set
     */
    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    /**
     * <p>Sets the transmission type using string input</p>
     *
     * @param transmissionType -> The transmission type as string (manual, amt, cvt, dct)
     * @throws InvalidTransmissionTypeException if the transmission type string is invalid
     */
    public void setTransmissionType(String transmissionType) throws InvalidTransmissionTypeException {
        this.transmissionType = TransmissionType.fromString(transmissionType);
    }

    /**
     * <p>Gets the number of forward gears</p>
     *
     * @return The number of forward gears available in the transmission
     */
    public int getForwardGears() {
        return forwardGears;
    }

    /**
     * <p>Sets the number of forward gears</p>
     *
     * @param forwardGears -> The number of forward gears to set
     */
    public void setForwardGears(int forwardGears) {
        this.forwardGears = forwardGears;
    }

    /**
     * <p>Abstract method to get gear ratio data for the transmission</p>
     * <p>Each concrete implementation must provide its own gear ratio calculation logic</p>
     *
     * @return ArrayList containing gear ratio values for each forward gear
     */
    protected abstract ArrayList<Double> getGearRatioData();
}
