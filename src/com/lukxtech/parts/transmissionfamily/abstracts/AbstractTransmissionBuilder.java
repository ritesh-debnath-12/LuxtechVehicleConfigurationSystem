package com.lukxtech.parts.transmissionfamily.abstracts;

import com.lukxtech.parts.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.BadForwardGearValueException;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;

/**
 * <h3>Abstract Transmission Builder</h3>
 * <p>This abstract class provides the Builder pattern implementation for all transmission types.</p>
 * <p>It defines common building methods and validation logic shared across all transmission builders.</p>
 * <p>All concrete transmission builders must extend this class.</p>
 * 
 * @param <T> The transmission model type that this builder will create
 * @param <B> The builder type for method chaining (self-type)
 * 
 * @see AbstractTransmissionModel
 * @see TransmissionType
 * @author Neko
 * @since 0.0.0
 */
public abstract class AbstractTransmissionBuilder<T extends AbstractTransmissionModel, B extends AbstractTransmissionBuilder<T, B>> {
    protected TransmissionType transmissionType;
    protected int forwardGears;

    /**
     * <p>Sets the transmission type using enum value</p>
     * 
     * @param transmissionType -> The transmission type enum (MANUAL, AMT, CVT, DCT)
     * @return The builder instance for method chaining
     */
    public B transmissionType(TransmissionType transmissionType){
        this.transmissionType = transmissionType;
        return self();
    }

    /**
     * <p>Sets the transmission type using string value</p>
     * 
     * @param transmissionType -> The transmission type as string (manual, amt, cvt, dct)
     * @return The builder instance for method chaining
     * @throws InvalidTransmissionTypeException if the transmission type string is invalid
     */
    public B transmissionType(String transmissionType){
        this.transmissionType = TransmissionType.fromString(transmissionType);
        return self();
    }

    /**
     * <p>Sets the number of forward gears for the transmission</p>
     * 
     * @param forwardGears -> The number of forward gears (must be positive)
     * @return The builder instance for method chaining
     */
    public B forwardGears(int forwardGears){
        this.forwardGears = forwardGears;
        return self();
    }

    /**
     * <p>Initial validation for common transmission builder parameters</p>
     * <p>Validates transmission type and forward gear count</p>
     * 
     * @throws InvalidTransmissionTypeException if transmission type is null
     * @throws BadForwardGearValueException if forward gears is negative
     */
    public void validate_initial(){
        if(transmissionType == null)    throw new InvalidTransmissionTypeException("ALERT TRANSMISSION TYPE NOT SPECIFIED! GOT: " + transmissionType);
        if(forwardGears < 0)    throw new BadForwardGearValueException("INVALID FORWARD GEAR VALUE! GOT: " + forwardGears);
    }
    /**
     * <p>Abstract method for complete validation of builder parameters</p>
     * <p>Each concrete builder must implement its specific validation logic</p>
     * 
     * @throws Various transmission-specific exceptions based on validation failures
     */
    public abstract void validate();
    
    /**
     * <p>Returns the builder instance for method chaining (self-type)</p>
     * 
     * @return The builder instance
     */
    public abstract B self();
    
    /**
     * <p>Builds and returns the transmission instance</p>
     * <p>Performs validation before construction</p>
     * 
     * @return The constructed transmission model instance
     * @throws Various exceptions if validation fails
     */
    public abstract T build();
}
