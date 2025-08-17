package com.lukxtech.powertrain.clutchfamily.abstracts;


import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchMaterialComposition;
import com.lukxtech.powertrain.clutchfamily.abstracts.enums.ClutchType;
import com.lukxtech.powertrain.clutchfamily.abstracts.exceptions.*;
import com.lukxtech.powertrain.common.exception.BadModelNumberException;

/**
 * <h3>Abstract Transmission Builder</h3>
 * <p>This abstract class provides the Builder pattern implementation for all transmission types.</p>
 * <p>It defines common building methods and validation logic shared across all transmission builders.</p>
 * <p>All concrete transmission builders must extend this class.</p>
 *
 * @param <T> The transmission model type that this builder will create
 * @param <B> The builder type for method chaining (self-type)
 * @author Neko
 * @see AbstractClutchModel
 * @see ClutchType
 * @see ClutchMaterialComposition
 * @since 1.1.4
 */
public abstract class AbstractClutchBuilder<T extends AbstractClutchModel, B extends AbstractClutchBuilder<T, B>> {
    protected String modelNumber;
    protected ClutchType clutchType;
    protected int torqueCapacityNM;
    protected ClutchMaterialComposition clutchMaterialComposition;
    protected double frictionDiameterMM;
    protected long serviceLifeCycles;

    public B modelNumber(String modelNumber){
        this.modelNumber = modelNumber;
        return self();
    }

    public B clutchType(ClutchType clutchType){
        this.clutchType = clutchType;
        return self();
    }

    public B clutchType(String clutchType){
        this.clutchType = ClutchType.fromString(clutchType);
        return self();
    }

    public B torqueCapacityNM(int torqueCapacityNM){
        this.torqueCapacityNM = torqueCapacityNM;
        return self();
    }

    public B clutchMaterialComposition(ClutchMaterialComposition clutchMaterialComposition){
        this.clutchMaterialComposition = clutchMaterialComposition;
        return self();
    }

    public B clutchMaterialComposition(String clutchMaterialComposition){
        this.clutchMaterialComposition = ClutchMaterialComposition.fromString(clutchMaterialComposition);
        return self();
    }

    public B frictionDiameterMM(double frictionDiameterMM){
        this.frictionDiameterMM = frictionDiameterMM;
        return self();
    }

    public B serviceLifeCycles(long serviceLifeCycles){
        this.serviceLifeCycles = serviceLifeCycles;
        return self();
    }

    public void validate_initial(){
        if (modelNumber == null || modelNumber.isEmpty())
            throw new BadModelNumberException("MODEL NUMBER NOT SPECIFIED! GOT: " + modelNumber);
        if(clutchType == null)
            throw new InvalidClutchTypeException("ALERT! CLUTCH TYPE NOT SPECIFIED! GOT: " + clutchType);
        if(torqueCapacityNM <= 0)
            throw new InvalidTorqueCapacityValueException("ALERT! TORQUE CAPACITY CANNOT BE LESS THAN OR EQUAL TO ZERO! GOT: " + torqueCapacityNM);
        if(clutchMaterialComposition == null)
            throw new InvalidClutchMaterialCompositionTypeException("ALERT! CLUTCH MATERIAL NOT SPECIFIED! GOT: " + clutchMaterialComposition);
        if(frictionDiameterMM <= 0)
            throw new InvalidFrictionDiameterValueException("ALERT! FRICTION DIAMETER CANNOT BE LESS THAN OR EQUAL TO ZERO! GOT: " + frictionDiameterMM);
        if(serviceLifeCycles <= 0)
            throw new InvalidServiceLifeCycleValueException("ALERT! SERVICE LIFE CYCLE CANNOT BE LESS THAN OR EQUAL TO ZERO! GOT: " + serviceLifeCycles);
    }

    public abstract void validate();
    public abstract B self();
    public abstract T build();
}
