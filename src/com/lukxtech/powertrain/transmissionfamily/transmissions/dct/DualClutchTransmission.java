package com.lukxtech.powertrain.transmissionfamily.transmissions.dct;

import com.lukxtech.powertrain.transmissionfamily.abstracts.AbstractTransmissionBuilder;
import com.lukxtech.powertrain.transmissionfamily.abstracts.AbstractTransmissionModel;
import com.lukxtech.powertrain.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.powertrain.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;
import com.lukxtech.powertrain.transmissionfamily.common.exceptions.BadGearRatioListException;
import com.lukxtech.powertrain.transmissionfamily.interfaces.DCTInterface;
import com.lukxtech.powertrain.transmissionfamily.transmissions.cvt.exceptions.InvalidCVTModelTypeException;
import com.lukxtech.powertrain.transmissionfamily.transmissions.dct.enums.DCTModelType;
import com.lukxtech.powertrain.transmissionfamily.transmissions.dct.exceptions.InvalidDCTModelTypeException;

import java.util.ArrayList;

/**
 * <h3>Dual Clutch Transmission Model</h3>
 * <p>This class represents a Dual Clutch Transmission (DCT) system.</p>
 * <p>DCT transmissions use two separate clutches for odd and even gears, enabling</p>
 * <p>pre-selection of the next gear and providing the fastest gear changes among automatic transmissions.</p>
 * <p>It extends the AbstractTransmissionModel class and implements the DCTInterface.</p>
 *
 * @author Neko
 * @see AbstractTransmissionModel
 * @see DCTInterface
 * @see DCTModelType
 * @since 1.1.2
 */
public class DualClutchTransmission extends AbstractTransmissionModel implements DCTInterface {
    private DCTModelType dctModelType;
    private ArrayList<Double> gearRatioList;

    /**
     * <p>Constructor for the DualClutchTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be DCT)
     * @param forwardGears     -> The number of forward gears available
     * @param dctModelType     -> The specific manual transmission model type
     * @param gearRatioList    -> List of gear ratios for each forward gear
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link DCTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public DualClutchTransmission(String modelNumber, TransmissionType transmissionType, int forwardGears, DCTModelType dctModelType, ArrayList<Double> gearRatioList) {
        super(modelNumber, transmissionType, forwardGears);
        this.dctModelType = dctModelType;
        this.gearRatioList = gearRatioList;
    }

    /**
     * <p>Constructor for the DualClutchTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be DCT)
     * @param forwardGears     -> The number of forward gears available
     * @param dctModelType     -> The specific manual transmission model type
     * @param gearRatioList    -> List of gear ratios for each forward gear
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link DCTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public DualClutchTransmission(String modelNumber, String transmissionType, int forwardGears, DCTModelType dctModelType, ArrayList<Double> gearRatioList) throws InvalidTransmissionTypeException {
        super(modelNumber, transmissionType, forwardGears);
        this.dctModelType = dctModelType;
        this.gearRatioList = gearRatioList;
    }

    /**
     * <p>Constructor for the DualClutchTransmission class</p>
     *
     * @param modelNumber      -> The model number of the transmission
     * @param transmissionType -> The type of transmission (should be DCT)
     * @param forwardGears     -> The number of forward gears available
     * @param dctModelType     -> The specific manual transmission model type
     *
     *                         <p> -- ENUMS -- </p>
     *                         <ul>
     *                             <li>{@link DCTModelType}</li>
     *                         </ul>
     *
     *                         <p> -- BUILDER -- </p>
     *                         <ul>
     *                             <li>{@link Builder}</li>
     *                         </ul>
     * @deprecated This constructor is deprecated. Please use the builder instead.
     */
    @Deprecated
    public DualClutchTransmission(String modelNumber, String transmissionType, int forwardGears, String dctModelType) {
        super(modelNumber, transmissionType, forwardGears);
        this.dctModelType = DCTModelType.fromString(dctModelType);
        this.gearRatioList = getGearRatioData();
    }

    /**
     * Builder for the DualClutchTransmission class
     *
     * <p>Usage</p>
     * <pre>
     *     DualClutchTransmission dctTransmission = new DualClutchTransmission.Builder()
     *                 .modelNumber("LUKX-TRANSMISSION-CK99")
     *                 .transmissionType("dct")
     *                 .dctModelType("dct8")
     *                 .forwardGears(8)
     *                 .gearRatioList(dctTransmissionGearRatio)
     *                 .build();
     * </pre>
     *
     * <p>NOTE: Feel free to substitute enum values as strings</p>
     */
    public static class Builder extends AbstractTransmissionBuilder<DualClutchTransmission, Builder> {
        private DCTModelType dctModelType;
        private ArrayList<Double> gearRatioList;

        public Builder dctModelType(DCTModelType dctModelType) {
            this.dctModelType = dctModelType;
            return this;
        }

        public Builder dctModelType(String dctModelType) throws InvalidDCTModelTypeException {
            this.dctModelType = DCTModelType.fromString(dctModelType);
            return this;
        }

        public Builder gearRatioList(ArrayList<Double> gearRatioList) {
            this.gearRatioList = gearRatioList;
            return this;
        }

        public Builder gearRatioList() {
            gearRatioList = new ArrayList<Double>();
            java.util.Scanner sc = new java.util.Scanner(java.lang.System.in); // this makes me feel more programmer, don't ask
            System.out.println("Please Enter Gear Ratio Values: [" + transmissionType + ", " + dctModelType + ", " + forwardGears + "]");
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
            if (transmissionType != TransmissionType.DCT)
                throw new InvalidTransmissionTypeException("ALERT! INVALID TRANSMISSION TYPE RECIEVED! GOT: " + transmissionType);
            if (dctModelType == null)
                throw new InvalidCVTModelTypeException("ALERT! AMT MODEL TYPE NOT SPECIFIED! GOT: " + dctModelType);
            if (gearRatioList == null || gearRatioList.isEmpty() || gearRatioList.size() != forwardGears)
                throw new BadGearRatioListException("ALERT! BAD GEAR RATIO VALUES, GOT: " + gearRatioList);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public DualClutchTransmission build() {
            validate();
            return new DualClutchTransmission(
                    modelNumber,
                    transmissionType,
                    forwardGears,
                    dctModelType,
                    gearRatioList
            );
        }
    }

    public DCTModelType getDctModelType() {
        return dctModelType;
    }

    public void setDctModelType(DCTModelType dctModelType) {
        this.dctModelType = dctModelType;
    }

    public void setDctModelType(String dctModelType) throws InvalidDCTModelTypeException {
        this.dctModelType = DCTModelType.fromString(dctModelType);
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
        return tmp;
    }

    @Override
    public String toString() {
        StringBuilder initialBuilder = new StringBuilder();
        StringBuilder gearRatioBuilder = new StringBuilder();
        initialBuilder.append("----------------------------------\n")
                .append("Model Number: ").append(modelNumber).append("\n")
                .append("Transmission Type: ").append(transmissionType).append("\n")
                .append("Model #: ").append(dctModelType).append("\n")
                .append("Key Specifications: ").append("\n")
                .append("\t*)Forward Gears: ").append(forwardGears).append("\n")
                .append("\t*)Gear Ratio: \n");
        printGearRatio(gearRatioBuilder);
        gearRatioBuilder.append("----------------------------------\n");
        return (initialBuilder.toString() + gearRatioBuilder.toString());
    }
}
