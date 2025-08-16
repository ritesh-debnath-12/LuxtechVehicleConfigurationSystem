package com.lukxtech.powertrain.transmissionfamily.transmissions.cvt;

import com.lukxtech.powertrain.transmissionfamily.abstracts.AbstractTransmissionBuilder;
import com.lukxtech.powertrain.transmissionfamily.abstracts.AbstractTransmissionModel;
import com.lukxtech.powertrain.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.powertrain.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;
import com.lukxtech.powertrain.transmissionfamily.common.exceptions.BadGearRatioListException;
import com.lukxtech.powertrain.transmissionfamily.interfaces.CVTInterface;
import com.lukxtech.powertrain.transmissionfamily.transmissions.cvt.enums.CVTModelType;
import com.lukxtech.powertrain.transmissionfamily.transmissions.cvt.exceptions.InvalidCVTModelTypeException;

import java.util.ArrayList;

/**
 * <h3>Continuously Variable Transmission Model</h3>
 * <p>This class represents a Continuously Variable Transmission (CVT) system.</p>
 * <p>CVT transmissions provide infinite gear ratios within a specific range, enabling</p>
 * <p>smooth acceleration without discrete gear shifts and optimal engine RPM maintenance.</p>
 * <p>It extends the AbstractTransmissionModel class and implements the CVTInterface.</p>
 *
 * @author Neko
 * @see AbstractTransmissionModel
 * @see CVTInterface
 * @see CVTModelType
 * @since 0.0.0
 */
public class ContinuouslyVariableTransmission extends AbstractTransmissionModel implements CVTInterface {
    private CVTModelType cvtModelType;
    private ArrayList<Double> gearRatioList;

    /**
     * <p>Constructor for the ContinuouslyVariableTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be CVT)
     * @param forwardGears     -> The number of forward gears available
     * @param cvtModelType     -> The specific manual transmission model type
     * @param gearRatioList    -> List of gear ratios for each forward gear
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link CVTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public ContinuouslyVariableTransmission(String modelNumber, TransmissionType transmissionType, int forwardGears, CVTModelType cvtModelType, ArrayList<Double> gearRatioList) {
        super(modelNumber, transmissionType, forwardGears);
        this.cvtModelType = cvtModelType;
        this.gearRatioList = gearRatioList;
    }

    /**
     * <p>Constructor for the ContinuouslyVariableTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be CVT)
     * @param forwardGears     -> The number of forward gears available
     * @param cvtModelType     -> The specific manual transmission model type
     * @param gearRatioList    -> List of gear ratios for each forward gear
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link CVTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public ContinuouslyVariableTransmission(String modelNumber, String transmissionType, int forwardGears, CVTModelType cvtModelType, ArrayList<Double> gearRatioList) throws InvalidTransmissionTypeException {
        super(modelNumber, transmissionType, forwardGears);
        this.cvtModelType = cvtModelType;
        this.gearRatioList = gearRatioList;
    }

    /**
     * <p>Constructor for the ContinuouslyVariableTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be CVT)
     * @param forwardGears     -> The number of forward gears available
     * @param cvtModelType     -> The specific manual transmission model type
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link CVTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public ContinuouslyVariableTransmission(String modelNumber, String transmissionType, int forwardGears, String cvtModelType) throws InvalidTransmissionTypeException {
        super(modelNumber, transmissionType, forwardGears);
        this.cvtModelType = CVTModelType.fromString(cvtModelType);
        this.gearRatioList = getGearRatioData();
    }

    /**
     * Builder for the ContinuouslyVariableTransmission class
     *
     * <p>Usage</p>
     * <pre>
     *     ContinuouslyVariableTransmission cvtTransmission = new ContinuouslyVariableTransmission.Builder()
     *                 .modelNumber("LUKX-TRANSMISSION-YK21")
     *                 .transmissionType("cvt")
     *                 .cvtModelType("cvt6")
     *                 .forwardGears(4)
     *                 .gearRatioList(cvtTransmissionGearRatio)
     *                 .build();
     * </pre>
     *
     * <p>NOTE: Feel free to substitute enum values as strings</p>
     */
    public static class Builder extends AbstractTransmissionBuilder<ContinuouslyVariableTransmission, Builder> {
        private CVTModelType cvtModelType;
        private ArrayList<Double> gearRatioList;

        public Builder cvtModelType(CVTModelType cvtModelType) {
            this.cvtModelType = cvtModelType;
            return this;
        }

        public Builder cvtModelType(String cvtModelType) throws InvalidCVTModelTypeException {
            this.cvtModelType = CVTModelType.fromString(cvtModelType);
            return this;
        }

        public Builder gearRatioList(ArrayList<Double> gearRatioList) {
            this.gearRatioList = gearRatioList;
            return this;
        }

        public Builder gearRatioList() {
            gearRatioList = new ArrayList<Double>();
            java.util.Scanner sc = new java.util.Scanner(java.lang.System.in); // this makes me feel more programmer, don't ask
            System.out.println("Please Enter Gear Ratio Values: [" + transmissionType + ", " + cvtModelType + ", " + forwardGears + "]");
            for (int i = 0; i < forwardGears; i++) {
                System.out.println("Gear " + (i + 1) + ": ");
                gearRatioList.add(sc.nextDouble());
            }
            return this;
        }

        @Override
        public void validate() {
            validate_initial();
            if (transmissionType != TransmissionType.CVT)
                throw new InvalidTransmissionTypeException("ALERT! INVALID TRANSMISSION TYPE RECIEVED! GOT: " + transmissionType);
            if (cvtModelType == null)
                throw new InvalidCVTModelTypeException("ALERT! AMT MODEL TYPE NOT SPECIFIED! GOT: " + cvtModelType);
            if (gearRatioList == null || gearRatioList.isEmpty() || gearRatioList.size() != forwardGears)
                throw new BadGearRatioListException("ALERT! BAD GEAR RATIO VALUES, GOT: " + gearRatioList);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public ContinuouslyVariableTransmission build() {
            validate();
            return new ContinuouslyVariableTransmission(
                    modelNumber,
                    transmissionType,
                    forwardGears,
                    cvtModelType,
                    gearRatioList
            );
        }
    }

    public CVTModelType getCvtModelType() {
        return cvtModelType;
    }

    public void setCvtModelType(CVTModelType cvtModelType) {
        this.cvtModelType = cvtModelType;
    }

    public void setCvtModelType(String cvtModelType) throws InvalidCVTModelTypeException {
        this.cvtModelType = CVTModelType.fromString(cvtModelType);
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
            builderInstance.append("\t\t#)Gear Ratio ").append(counter).append(": ").append(x).append("\n");
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
        sc.close();
        return tmp;
    }

    @Override
    public String toString() {
        StringBuilder initialBuilder = new StringBuilder();
        StringBuilder gearRatioBuilder = new StringBuilder();
        initialBuilder.append("----------------------------------\n")
                .append("Model Number: ").append(modelNumber).append("\n")
                .append("Transmission Type: ").append(transmissionType).append("\n")
                .append("Model #: ").append(cvtModelType).append("\n")
                .append("Key Specifications: ").append("\n")
                .append("\t*)Forward Gears: ").append(forwardGears).append("\n")
                .append("\t*)Gear Ratio: \n");
        printGearRatio(gearRatioBuilder);
        gearRatioBuilder.append("----------------------------------\n");
        return (initialBuilder.toString() + gearRatioBuilder.toString());
    }

}
