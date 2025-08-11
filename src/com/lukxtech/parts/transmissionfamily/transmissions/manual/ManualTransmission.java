package com.lukxtech.parts.transmissionfamily.transmissions.manual;

import com.lukxtech.parts.transmissionfamily.abstracts.AbstractTransmissionBuilder;
import com.lukxtech.parts.transmissionfamily.abstracts.AbstractTransmissionModel;
import com.lukxtech.parts.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;
import com.lukxtech.parts.transmissionfamily.interfaces.ManualInterface;
import com.lukxtech.parts.transmissionfamily.transmissions.manual.enums.ManualModelType;
import com.lukxtech.parts.transmissionfamily.common.exceptions.BadGearRatioListException;
import com.lukxtech.parts.transmissionfamily.transmissions.manual.exceptions.InvalidManualModelTypeException;

import java.util.ArrayList;

public class ManualTransmission extends AbstractTransmissionModel implements ManualInterface {
    private ManualModelType manualModelType;
    private ArrayList<Double> gearRatioList;
    
    @Deprecated
    public ManualTransmission(TransmissionType transmissionType, int forwardGears, ArrayList<Double> gearRatioList, ManualModelType manualModelType) {
        super(transmissionType, forwardGears);
        this.gearRatioList = gearRatioList;
        this.manualModelType = manualModelType;
    }
    @Deprecated
    public ManualTransmission(String transmissionType, int forwardGears, ManualModelType manualModelType) throws InvalidTransmissionTypeException {
        super(transmissionType, forwardGears);
        this.manualModelType = manualModelType;
        this.gearRatioList = getGearRatioData();
    }
    @Deprecated
    public ManualTransmission(String transmissionType, int forwardGears, String manualModelType) throws InvalidManualModelTypeException, InvalidTransmissionTypeException {
        super(transmissionType, forwardGears);
        this.manualModelType = ManualModelType.fromString(manualModelType);
        this.gearRatioList = getGearRatioData();
    }
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
            return this;
        }

        @Override
        public void validate(){
            validate_initial();
            if(transmissionType != TransmissionType.MANUAL) throw new InvalidTransmissionTypeException("ALERT! INVALID TRANSMISSION TYPE RECIEVED! GOT: " + transmissionType);
            if(manualModelType == null) throw new InvalidManualModelTypeException("ALERT! MANUAL MODEL TYPE NOT SPECIFIED! GOT: " + manualModelType);
            if(gearRatioList == null || gearRatioList.isEmpty() || gearRatioList.size() != forwardGears)   throw new BadGearRatioListException("ALERT! BAD GEAR RATIO VALUES, GOT: " + gearRatioList);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public ManualTransmission build() {
            validate();
            return new ManualTransmission(
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
    public void setManualModelType(String manualModelType){
        this.manualModelType = ManualModelType.fromString(manualModelType);
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
                .append("Model #: ").append(manualModelType).append("\n")
                .append("Forward Gears: ").append(forwardGears).append("\n")
                .append("Gear Ratio: \n");
        printGearRatio(gearRatioBuilder);
        gearRatioBuilder.append("----------------------------------\n");
        return (initialBuilder.toString() + gearRatioBuilder.toString());
    }
}
