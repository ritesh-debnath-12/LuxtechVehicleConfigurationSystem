package com.lukxtech.powertrain.transmissionfamily.transmissions.manual;

import com.lukxtech.powertrain.transmissionfamily.abstracts.AbstractTransmissionBuilder;
import com.lukxtech.powertrain.transmissionfamily.abstracts.AbstractTransmissionModel;
import com.lukxtech.powertrain.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.powertrain.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;
import com.lukxtech.powertrain.transmissionfamily.interfaces.ManualInterface;
import com.lukxtech.powertrain.transmissionfamily.transmissions.manual.enums.ManualModelType;
import com.lukxtech.powertrain.transmissionfamily.common.exceptions.BadGearRatioListException;
import com.lukxtech.powertrain.transmissionfamily.transmissions.manual.exceptions.InvalidManualModelTypeException;

import java.util.ArrayList;

/**
 * <h3>Manual Transmission Model</h3>
 * <p>This class represents a manual transmission system.</p>
 * <p>Manual transmissions require direct driver input for gear selection and provide</p>
 * <p>complete control over the vehicle's gear changes.</p>
 * <p>It extends the AbstractTransmissionModel class and implements the ManualInterface.</p>
 *
 * @author Neko
 * @see AbstractTransmissionModel
 * @see ManualInterface
 * @see ManualModelType
 * @since 0.0.0
 */
public class ManualTransmission extends AbstractTransmissionModel implements ManualInterface {
    private ManualModelType manualModelType;
    private ArrayList<Double> gearRatioList;

    /**
     * <p>Constructor for the ManualTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be MANUAL)
     * @param forwardGears     -> The number of forward gears available
     * @param gearRatioList    -> List of gear ratios for each forward gear
     * @param manualModelType  -> The specific manual transmission model type
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link ManualModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public ManualTransmission(String modelNumber, TransmissionType transmissionType, int forwardGears, ArrayList<Double> gearRatioList, ManualModelType manualModelType) {
        super(modelNumber, transmissionType, forwardGears);
        this.gearRatioList = gearRatioList;
        this.manualModelType = manualModelType;
    }

    /**
     * <p>Constructor for the ManualTransmission class with String transmission type</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission as string
     * @param forwardGears     -> The number of forward gears available
     * @param manualModelType  -> The specific manual transmission model type
     * @throws InvalidTransmissionTypeException if transmission type is invalid
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public ManualTransmission(String modelNumber, String transmissionType, int forwardGears, ManualModelType manualModelType) throws InvalidTransmissionTypeException {
        super(modelNumber, transmissionType, forwardGears);
        this.manualModelType = manualModelType;
        this.gearRatioList = getGearRatioData();
    }

    /**
     * <p>Constructor for the ManualTransmission class with String inputs</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission as string
     * @param forwardGears     -> The number of forward gears available
     * @param manualModelType  -> The specific manual transmission model type as string
     * @throws InvalidManualModelTypeException  if manual model type is invalid
     * @throws InvalidTransmissionTypeException if transmission type is invalid
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public ManualTransmission(String modelNumber, String transmissionType, int forwardGears, String manualModelType) throws InvalidManualModelTypeException, InvalidTransmissionTypeException {
        super(modelNumber, transmissionType, forwardGears);
        this.manualModelType = ManualModelType.fromString(manualModelType);
        this.gearRatioList = getGearRatioData();
    }

    /**
     * Builder for the ManualTransmission class
     *
     * <p>Usage</p>
     * <pre>
     * ManualTransmission transmission = new ManualTransmission.Builder()
     *         .modelNumber("LUKX-TRANSMISSION-AE856")
     *         .transmissionType(TransmissionType.MANUAL)
     *         .forwardGears(6)
     *         .manualModelType(ManualModelType.MP6)
     *         .gearRatioList(gearRatios)
     *         .build();
     * </pre>
     *
     * <p>NOTE: Feel free to substitute enum values as strings</p>
     */
    public static class Builder extends AbstractTransmissionBuilder<ManualTransmission, Builder> {
        private ManualModelType manualModelType;
        private ArrayList<Double> gearRatioList;

        public Builder manualModelType(ManualModelType manualModelType) {
            this.manualModelType = manualModelType;
            return this;
        }

        public Builder manualModelType(String manualModelType) throws InvalidManualModelTypeException {
            this.manualModelType = ManualModelType.fromString(manualModelType);
            return this;
        }

        public Builder gearRatioList(ArrayList<Double> gearRatioList) {
            this.gearRatioList = gearRatioList;
            return this;
        }

        public Builder gearRatioList() {
            gearRatioList = new ArrayList<Double>();
            java.util.Scanner sc = new java.util.Scanner(java.lang.System.in); // this makes me feel more programmer, don't ask
            System.out.println("Please Enter Gear Ratio Values: [" + transmissionType + ", " + manualModelType + ", " + forwardGears + "]");
            for (int i = 0; i < forwardGears; i++) {
                System.out.println("Gear " + (i + 1) + ": ");
                gearRatioList.add(sc.nextDouble());
            }
            sc.close();
            return this;
        }

        @Override
        public void validate() {
            validate_initial();
            if (transmissionType != TransmissionType.MANUAL)
                throw new InvalidTransmissionTypeException("ALERT! INVALID TRANSMISSION TYPE RECIEVED! GOT: " + transmissionType);
            if (manualModelType == null)
                throw new InvalidManualModelTypeException("ALERT! MANUAL MODEL TYPE NOT SPECIFIED! GOT: " + manualModelType);
            if (gearRatioList == null || gearRatioList.isEmpty() || gearRatioList.size() != forwardGears)
                throw new BadGearRatioListException("ALERT! BAD GEAR RATIO VALUES, GOT: " + gearRatioList);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public ManualTransmission build() {
            validate();
            return new ManualTransmission(
                    modelNumber,
                    transmissionType,
                    forwardGears,
                    gearRatioList,
                    manualModelType
            );
        }
    }

    public ManualModelType getManualModelType() {
        return manualModelType;
    }

    public void setManualModelType(ManualModelType manualModelType) {
        this.manualModelType = manualModelType;
    }

    public void setManualModelType(String manualModelType) {
        this.manualModelType = ManualModelType.fromString(manualModelType);
    }

    public ArrayList<Double> getGearRatioList() {
        return gearRatioList;
    }

    public void setGearRatioList(ArrayList<Double> gearRatioList) {
        this.gearRatioList = gearRatioList;
    }

    public void setGearRatioList() {
        this.gearRatioList = getGearRatioData();
    }

    private void printGearRatio(StringBuilder builderInstance) {
        int counter = 0;
        for (double x : gearRatioList) {
            counter++;
            builderInstance.append("\tGear Ratio ").append(counter).append(": ").append(x).append("\n");
        }
    }

    @Override
    protected ArrayList<Double> getGearRatioData() {
        gearRatioList = new ArrayList<Double>();
        java.util.Scanner sc = new java.util.Scanner(java.lang.System.in); // this makes me feel more programmer, don't ask
        System.out.println("Please Enter Gear Ratio Values: ");
        ArrayList<Double> tmp = new ArrayList<Double>();
        for (int i = 0; i < forwardGears; i++) {
            System.out.println("Gear " + (i + 1) + ": ");
            tmp.add(sc.nextDouble());
        }
        return tmp;
    }

    @Override
    public String toString() {
        StringBuilder initialBuilder = new StringBuilder();
        StringBuilder gearRatioBuilder = new StringBuilder();
        initialBuilder.append("----------------------------------\n")
                .append("Model Number: ").append(modelNumber).append("\n")
                .append("Transmission Type: ").append(transmissionType).append("\n")
                .append("Model #: ").append(manualModelType).append("\n")
                .append("Forward Gears: ").append(forwardGears).append("\n")
                .append("Gear Ratio: \n");
        printGearRatio(gearRatioBuilder);
        gearRatioBuilder.append("----------------------------------\n");
        return (initialBuilder.toString() + gearRatioBuilder.toString());
    }
}
