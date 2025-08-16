package com.lukxtech.powertrain.clutchfamily.abstracts;

import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchMaterialComposition;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchType;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchMaterialCompositionTypeException;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.InvalidClutchTypeException;

/**
 * <h3>Abstract Clutch Model</h3>
 * <p>This abstract class serves as the base for all transmission models in the system.</p>
 * <p>It provides common attributes and methods that are shared across all transmission types.</p>
 * <p>All concrete transmission implementations must extend this class.</p>
 *
 * @author Neko
 * @see ClutchType
 * @see ClutchMaterialComposition
 * @since 1.1.4
 */
public abstract class AbstractClutchModel {
    protected String modelNumber;
    protected ClutchType clutchType;
    protected int torqueCapacityNM;
    protected ClutchMaterialComposition clutchMaterialComposition;
    protected double frictionDiameterMM;
    protected long serviceLifeCycles;

    /**
     * <p>Constructor for the AbstractClutchModel class</p>
     *
     * @param modelNumber               -> The model number of the clutch
     * @param clutchType                -> The type of clutch(See:  {@link ClutchType})
     * @param torqueCapacityNM          -> Max torque it can handle(Nm)
     * @param clutchMaterialComposition -> Clutch Manufactured material (See:  {@link ClutchMaterialComposition})
     * @param frictionDiameterMM        -> Size of friction surface (mm)
     * @param serviceLifeCycles         -> Expected number of engagement cycles
     */
    protected AbstractClutchModel(String modelNumber, ClutchType clutchType, int torqueCapacityNM, ClutchMaterialComposition clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles) {
        this.modelNumber = modelNumber;
        this.clutchType = clutchType;
        this.torqueCapacityNM = torqueCapacityNM;
        this.clutchMaterialComposition = clutchMaterialComposition;
        this.frictionDiameterMM = frictionDiameterMM;
        this.serviceLifeCycles = serviceLifeCycles;
    }

    /**
     * <p>Constructor for the AbstractClutchModel class</p>
     *
     * @param modelNumber               -> The model number of the clutch
     * @param clutchType                -> The type of clutch(See:  {@link ClutchType})
     * @param torqueCapacityNM          -> Max torque it can handle(Nm)
     * @param clutchMaterialComposition -> Clutch Manufactured material (See:  {@link ClutchMaterialComposition})
     * @param frictionDiameterMM        -> Size of friction surface (mm)
     * @param serviceLifeCycles         -> Expected number of engagement cycles
     * @throws InvalidClutchTypeException if clutch type given doesn't match with corresponding enum
     */
    protected AbstractClutchModel(String modelNumber, String clutchType, int torqueCapacityNM, ClutchMaterialComposition clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles) throws InvalidClutchTypeException {
        this.modelNumber = modelNumber;
        this.clutchType = ClutchType.fromString(clutchType);
        this.torqueCapacityNM = torqueCapacityNM;
        this.clutchMaterialComposition = clutchMaterialComposition;
        this.frictionDiameterMM = frictionDiameterMM;
        this.serviceLifeCycles = serviceLifeCycles;
    }

    /**
     * <p>Constructor for the AbstractClutchModel class</p>
     *
     * @param modelNumber               -> The model number of the clutch
     * @param clutchType                -> The type of clutch(See:  {@link ClutchType})
     * @param torqueCapacityNM          -> Max torque it can handle(Nm)
     * @param clutchMaterialComposition -> Clutch Manufactured material (See:  {@link ClutchMaterialComposition})
     * @param frictionDiameterMM        -> Size of friction surface (mm)
     * @param serviceLifeCycles         -> Expected number of engagement cycles
     * @throws InvalidClutchTypeException                    if clutch type given doesn't match with corresponding enum
     * @throws InvalidClutchMaterialCompositionTypeException if clutch material given doesn't match with corresponding enum
     */
    protected AbstractClutchModel(String modelNumber, String clutchType, int torqueCapacityNM, String clutchMaterialComposition, double frictionDiameterMM, long serviceLifeCycles) throws InvalidClutchTypeException, InvalidClutchMaterialCompositionTypeException {
        this.modelNumber = modelNumber;
        this.clutchType = ClutchType.fromString(clutchType);
        this.torqueCapacityNM = torqueCapacityNM;
        this.clutchMaterialComposition = ClutchMaterialComposition.fromString(clutchMaterialComposition);
        this.frictionDiameterMM = frictionDiameterMM;
        this.serviceLifeCycles = serviceLifeCycles;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public ClutchType getClutchType() {
        return clutchType;
    }

    public void setClutchType(String clutchType) throws InvalidClutchTypeException{
        this.clutchType = ClutchType.fromString(clutchType);
    }

    public void setClutchType(ClutchType clutchType) {
        this.clutchType = clutchType;
    }

    public int getTorqueCapacity() {
        return torqueCapacityNM;
    }

    public void setTorqueCapacity(int torqueCapacity) {
        this.torqueCapacityNM = torqueCapacity;
    }

    public ClutchMaterialComposition getClutchMaterialComposition() {
        return clutchMaterialComposition;
    }

    public void setClutchMaterialComposition(String clutchMaterialComposition) throws InvalidClutchMaterialCompositionTypeException{
        this.clutchMaterialComposition = ClutchMaterialComposition.fromString(clutchMaterialComposition);
    }

    public void setClutchMaterialComposition(ClutchMaterialComposition clutchMaterialComposition) {
        this.clutchMaterialComposition = clutchMaterialComposition;
    }

    public double getFrictionDiameterMM() {
        return frictionDiameterMM;
    }

    public void setFrictionDiameterMM(double frictionDiameterMM) {
        this.frictionDiameterMM = frictionDiameterMM;
    }

    public long getServiceLifeCycles() {
        return serviceLifeCycles;
    }

    public void setServiceLifeCycles(long serviceLifeCycles) {
        this.serviceLifeCycles = serviceLifeCycles;
    }
}
