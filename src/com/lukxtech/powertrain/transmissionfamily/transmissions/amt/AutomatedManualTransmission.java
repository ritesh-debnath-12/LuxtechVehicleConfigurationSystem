package com.lukxtech.powertrain.transmissionfamily.transmissions.amt;

import com.lukxtech.powertrain.transmissionfamily.abstracts.AbstractTransmissionBuilder;
import com.lukxtech.powertrain.transmissionfamily.abstracts.AbstractTransmissionModel;
import com.lukxtech.powertrain.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.powertrain.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;
import com.lukxtech.powertrain.transmissionfamily.interfaces.AMTInterface;
import com.lukxtech.powertrain.transmissionfamily.transmissions.amt.enums.AMTModelType;
import com.lukxtech.powertrain.transmissionfamily.transmissions.amt.exceptions.InvalidAMTModelTypeException;
import com.lukxtech.powertrain.transmissionfamily.common.exceptions.BadGearRatioListException;

import java.util.ArrayList;

/**
 * <h3>Automated Manual Transmission Model</h3>
 * <p>This class represents an Automated Manual Transmission (AMT) system.</p>
 * <p>AMT transmissions combine the efficiency of manual transmissions with automated</p>
 * <p>gear shifting, reducing driver intervention while maintaining discrete gear ratios.</p>
 * <p>It extends the AbstractTransmissionModel class and implements the AMTInterface.</p>
 *
 * @author Neko
 * @see AbstractTransmissionModel
 * @see AMTInterface
 * @see AMTModelType
 * @since 0.0.0
 */
public class AutomatedManualTransmission extends AbstractTransmissionModel implements AMTInterface {
    private AMTModelType amtModelType;
    private ArrayList<Double> gearRatioList;

    /**
     * <p>Constructor for the AutomatedManualTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be AMT)
     * @param forwardGears     -> The number of forward gears available
     * @param amtModelType     -> The specific manual transmission model type
     * @param gearRatioList    -> List of gear ratios for each forward gear
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link AMTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public AutomatedManualTransmission(String modelNumber, TransmissionType transmissionType, int forwardGears, AMTModelType amtModelType, ArrayList<Double> gearRatioList) {
        super(modelNumber, transmissionType, forwardGears);
        this.amtModelType = amtModelType;
        this.gearRatioList = gearRatioList;
    }

    /**
     * <p>Constructor for the AutomatedManualTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be AMT)
     * @param forwardGears     -> The number of forward gears available
     * @param amtModelType     -> The specific manual transmission model type
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link AMTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public AutomatedManualTransmission(String modelNumber, String transmissionType, int forwardGears, AMTModelType amtModelType) {
        super(modelNumber, transmissionType, forwardGears);
        this.amtModelType = amtModelType;
        this.gearRatioList = getGearRatioData();
    }

    /**
     * <p>Constructor for the AutomatedManualTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be AMT)
     * @param forwardGears     -> The number of forward gears available
     * @param amtModelType     -> The specific manual transmission model type
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link AMTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public AutomatedManualTransmission(String modelNumber, String transmissionType, int forwardGears, String amtModelType) {
        super(modelNumber, transmissionType, forwardGears);
        this.amtModelType = AMTModelType.fromString(amtModelType);
        this.gearRatioList = getGearRatioData();
    }

    /**
     * Builder for the AutomatedManualTransmission class
     *
     * <p>Usage</p>
     * <pre>
     * AutomatedManualTransmission amtTransmission = new AutomatedManualTransmission.Builder()
     *                 .modelNumber("LUKX-TRANSMISSION-RX37")
     *                 .transmissionType("amt")
     *                 .amtModelType("amtp4")
     *                 .forwardGears(4)
     *                 .gearRatioList(amtTransmissionGearRatio)
     *                 .build();
     * </pre>
     *
     * <p>NOTE: Feel free to substitute enum values as strings</p>
     */
    public static class Builder extends AbstractTransmissionBuilder<AutomatedManualTransmission, Builder> {
        private AMTModelType amtModelType;
        private ArrayList<Double> gearRatioList;

        public Builder amtModelType(AMTModelType amtModelType) {
            this.amtModelType = amtModelType;
            return this;
        }

        public Builder amtModelType(String amtModelType) throws InvalidAMTModelTypeException {
            this.amtModelType = AMTModelType.fromString(amtModelType);
            return this;
        }

        public Builder gearRatioList(ArrayList<Double> gearRatioList) {
            this.gearRatioList = gearRatioList;
            return this;
        }

        public Builder gearRatioList() {
            gearRatioList = new ArrayList<Double>();
            java.util.Scanner sc = new java.util.Scanner(java.lang.System.in); // this makes me feel more programmer, don't ask
            System.out.println("Please Enter Gear Ratio Values: [" + transmissionType + ", " + amtModelType + ", " + forwardGears + "]");
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
            if (transmissionType != TransmissionType.AMT)
                throw new InvalidTransmissionTypeException("ALERT! INVALID TRANSMISSION TYPE RECIEVED! GOT: " + transmissionType);
            if (amtModelType == null)
                throw new InvalidAMTModelTypeException("ALERT! AMT MODEL TYPE NOT SPECIFIED! GOT: " + amtModelType);
            if (gearRatioList == null || gearRatioList.isEmpty() || gearRatioList.size() != forwardGears)
                throw new BadGearRatioListException("ALERT! BAD GEAR RATIO VALUES, GOT: " + gearRatioList);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public AutomatedManualTransmission build() {
            validate();
            return new AutomatedManualTransmission(
                    modelNumber,
                    transmissionType,
                    forwardGears,
                    amtModelType,
                    gearRatioList
            );
        }
    }

    public AMTModelType getAmtModelType() {
        return amtModelType;
    }

    public void setAmtModelType(AMTModelType amtModelType) {
        this.amtModelType = amtModelType;
    }

    public void setAmtModelType(String amtModelType) {
        this.amtModelType = AMTModelType.fromString(amtModelType);
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
                .append("Model #: ").append(amtModelType).append("\n")
                .append("Forward Gears: ").append(forwardGears).append("\n")
                .append("Gear Ratio: \n");
        printGearRatio(gearRatioBuilder);
        gearRatioBuilder.append("----------------------------------\n");
        return (initialBuilder.toString() + gearRatioBuilder.toString());
    }
}
