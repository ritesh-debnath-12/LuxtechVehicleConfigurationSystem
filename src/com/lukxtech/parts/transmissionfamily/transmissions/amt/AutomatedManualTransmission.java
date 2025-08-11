package com.lukxtech.parts.transmissionfamily.transmissions.amt;

import com.lukxtech.parts.transmissionfamily.abstracts.AbstractTransmissionBuilder;
import com.lukxtech.parts.transmissionfamily.abstracts.AbstractTransmissionModel;
import com.lukxtech.parts.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;
import com.lukxtech.parts.transmissionfamily.interfaces.AMTInterface;
import com.lukxtech.parts.transmissionfamily.transmissions.amt.enums.AMTModelType;
import com.lukxtech.parts.transmissionfamily.transmissions.amt.exceptions.InvalidAMTModelTypeException;
import com.lukxtech.parts.transmissionfamily.common.exceptions.BadGearRatioListException;

import java.util.ArrayList;

public class AutomatedManualTransmission extends AbstractTransmissionModel implements AMTInterface {
    private AMTModelType amtModelType;
    private ArrayList<Double> gearRatioList;

    @Deprecated
    public AutomatedManualTransmission(TransmissionType transmissionType, int forwardGears, AMTModelType amtModelType, ArrayList<Double> gearRatioList) {
        super(transmissionType, forwardGears);
        this.amtModelType = amtModelType;
        this.gearRatioList = gearRatioList;
    }
    @Deprecated
    public AutomatedManualTransmission(String transmissionType, String modelNumber, int forwardGears, AMTModelType amtModelType) {
        super(transmissionType, forwardGears);
        this.amtModelType = amtModelType;
        this.gearRatioList = getGearRatioData();
    }
    @Deprecated
    public AutomatedManualTransmission(String transmissionType, String modelNumber, int forwardGears, String amtModelType) {
        super(transmissionType, forwardGears);
        this.amtModelType = AMTModelType.fromString(amtModelType);
        this.gearRatioList = getGearRatioData();
    }
    public static class Builder extends AbstractTransmissionBuilder<AutomatedManualTransmission, Builder>{
        private AMTModelType amtModelType;
        private ArrayList<Double> gearRatioList;

        public Builder amtModelType(AMTModelType amtModelType){
            this.amtModelType = amtModelType;
            return this;
        }

        public Builder amtModelType(String amtModelType) throws InvalidAMTModelTypeException {
            this.amtModelType = AMTModelType.fromString(amtModelType);
            return this;
        }

        public Builder gearRatioList(ArrayList<Double> gearRatioList){
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
            return this;
        }

        @Override
        public void validate(){
            validate_initial();
            if(transmissionType != TransmissionType.AMT) throw new InvalidTransmissionTypeException("ALERT! INVALID TRANSMISSION TYPE RECIEVED! GOT: " + transmissionType);
            if(amtModelType == null) throw new InvalidAMTModelTypeException("ALERT! AMT MODEL TYPE NOT SPECIFIED! GOT: " + amtModelType);
            if(gearRatioList == null || gearRatioList.isEmpty() || gearRatioList.size() != forwardGears)   throw new BadGearRatioListException("ALERT! BAD GEAR RATIO VALUES, GOT: " + gearRatioList);
        }

        @Override
        public Builder self(){
            return this;
        }

        @Override
        public AutomatedManualTransmission build() {
            validate();
            return new AutomatedManualTransmission(
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
    public void setGearRatioList(){
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
                .append("Transmission Type: ").append(transmissionType).append("\n")
                .append("Model #: ").append(amtModelType).append("\n")
                .append("Forward Gears: ").append(forwardGears).append("\n")
                .append("Gear Ratio: \n");
        printGearRatio(gearRatioBuilder);
        gearRatioBuilder.append("----------------------------------\n");
        return (initialBuilder.toString() + gearRatioBuilder.toString());
    }
}
