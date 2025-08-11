package com.lukxtech.parts.transmissionfamily.transmissions.dct;

import com.lukxtech.parts.transmissionfamily.abstracts.AbstractTransmissionBuilder;
import com.lukxtech.parts.transmissionfamily.abstracts.AbstractTransmissionModel;
import com.lukxtech.parts.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;
import com.lukxtech.parts.transmissionfamily.common.exceptions.BadGearRatioListException;
import com.lukxtech.parts.transmissionfamily.interfaces.DCTInterface;
import com.lukxtech.parts.transmissionfamily.transmissions.cvt.ContinuouslyVariableTransmission;
import com.lukxtech.parts.transmissionfamily.transmissions.cvt.exceptions.InvalidCVTModelTypeException;
import com.lukxtech.parts.transmissionfamily.transmissions.dct.enums.DCTModelType;
import com.lukxtech.parts.transmissionfamily.transmissions.dct.exceptions.InvalidDCTModelTypeException;

import java.util.ArrayList;

public class DualClutchTransmission extends AbstractTransmissionModel implements DCTInterface {
    private DCTModelType dctModelType;
    private ArrayList<Double> gearRatioList;

    @Deprecated
    public DualClutchTransmission(TransmissionType transmissionType, int forwardGears, DCTModelType dctModelType, ArrayList<Double> gearRatioList) {
        super(transmissionType, forwardGears);
        this.dctModelType = dctModelType;
        this.gearRatioList = gearRatioList;
    }

    @Deprecated
    public DualClutchTransmission(String transmissionType, int forwardGears, DCTModelType dctModelType, ArrayList<Double> gearRatioList) throws InvalidTransmissionTypeException {
        super(transmissionType, forwardGears);
        this.dctModelType = dctModelType;
        this.gearRatioList = gearRatioList;
    }

    @Deprecated
    public DualClutchTransmission(String transmissionType, int forwardGears, String dctModelType, ArrayList<Double> gearRatioList){
        super(transmissionType, forwardGears);
        this.dctModelType = DCTModelType.fromString(dctModelType);
        this.gearRatioList = gearRatioList;
    }

    public static class Builder extends AbstractTransmissionBuilder<DualClutchTransmission, Builder>{
        private DCTModelType dctModelType;
        private ArrayList<Double> gearRatioList;

        public Builder dctModelType(DCTModelType dctModelType){
            this.dctModelType = dctModelType;
            return this;
        }

        public Builder dctModelType(String dctModelType) throws InvalidDCTModelTypeException{
            this.dctModelType = DCTModelType.fromString(dctModelType);
            return this;
        }

        public Builder gearRatioList(ArrayList<Double> gearRatioList){
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
            return this;
        }

        @Override
        public void validate(){
            validate_initial();
            if(transmissionType != TransmissionType.DCT) throw new InvalidTransmissionTypeException("ALERT! INVALID TRANSMISSION TYPE RECIEVED! GOT: " + transmissionType);
            if(dctModelType == null) throw new InvalidCVTModelTypeException("ALERT! AMT MODEL TYPE NOT SPECIFIED! GOT: " + dctModelType);
            if(gearRatioList == null || gearRatioList.isEmpty() || gearRatioList.size() != forwardGears)   throw new BadGearRatioListException("ALERT! BAD GEAR RATIO VALUES, GOT: " + gearRatioList);
        }

        @Override
        public Builder self(){
            return this;
        }

        @Override
        public DualClutchTransmission build(){
            validate();
            return new DualClutchTransmission(
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

    public void setGearRatioList(){
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
