package com.lukxtech.parts.transmissionfamily.transmissions.cvt;

import com.lukxtech.parts.transmissionfamily.abstracts.AbstractTransmissionBuilder;
import com.lukxtech.parts.transmissionfamily.abstracts.AbstractTransmissionModel;
import com.lukxtech.parts.transmissionfamily.abstracts.enums.TransmissionType;
import com.lukxtech.parts.transmissionfamily.abstracts.exceptions.InvalidTransmissionTypeException;
import com.lukxtech.parts.transmissionfamily.common.exceptions.BadGearRatioListException;
import com.lukxtech.parts.transmissionfamily.interfaces.CVTInterface;
import com.lukxtech.parts.transmissionfamily.transmissions.cvt.enums.CVTModelType;
import com.lukxtech.parts.transmissionfamily.transmissions.cvt.exceptions.InvalidCVTModelTypeException;

import java.util.ArrayList;

public class ContinuouslyVariableTransmission extends AbstractTransmissionModel implements CVTInterface {
    private CVTModelType cvtModelType;
    private ArrayList<Double> gearRatioList;

    @Deprecated
    public ContinuouslyVariableTransmission(TransmissionType transmissionType, int forwardGears, CVTModelType cvtModelType, ArrayList<Double> gearRatioList) {
        super(transmissionType, forwardGears);
        this.cvtModelType = cvtModelType;
        this.gearRatioList = gearRatioList;
    }

    @Deprecated
    public ContinuouslyVariableTransmission(String transmissionType, int forwardGears, CVTModelType cvtModelType, ArrayList<Double> gearRatioList) throws InvalidTransmissionTypeException {
        super(transmissionType, forwardGears);
        this.cvtModelType = cvtModelType;
        this.gearRatioList = gearRatioList;
    }

    @Deprecated
    public ContinuouslyVariableTransmission(String transmissionType, int forwardGears, String cvtModelType, ArrayList<Double> gearRatioList) throws InvalidTransmissionTypeException {
        super(transmissionType, forwardGears);
        this.cvtModelType = CVTModelType.fromString(cvtModelType);
        this.gearRatioList = gearRatioList;
    }

    public static class Builder extends AbstractTransmissionBuilder<ContinuouslyVariableTransmission, Builder>{
        private CVTModelType cvtModelType;
        private ArrayList<Double> gearRatioList;

        public Builder cvtModelType(CVTModelType cvtModelType){
            this.cvtModelType = cvtModelType;
            return this;
        }

        public Builder cvtModelType(String cvtModelType) throws InvalidCVTModelTypeException {
            this.cvtModelType = CVTModelType.fromString(cvtModelType);
            return this;
        }

        public Builder gearRatioList(ArrayList<Double> gearRatioList){
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
        public void validate(){
            validate_initial();
            if(transmissionType != TransmissionType.CVT) throw new InvalidTransmissionTypeException("ALERT! INVALID TRANSMISSION TYPE RECIEVED! GOT: " + transmissionType);
            if(cvtModelType == null) throw new InvalidCVTModelTypeException("ALERT! AMT MODEL TYPE NOT SPECIFIED! GOT: " + cvtModelType);
            if(gearRatioList == null || gearRatioList.isEmpty() || gearRatioList.size() != forwardGears)   throw new BadGearRatioListException("ALERT! BAD GEAR RATIO VALUES, GOT: " + gearRatioList);
        }

        @Override
        public Builder self(){
            return this;
        }

        @Override
        public ContinuouslyVariableTransmission build() {
            validate();
            return new ContinuouslyVariableTransmission(
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

    public void setCvtModelType(String cvtModelType) throws InvalidCVTModelTypeException{
        this.cvtModelType = CVTModelType.fromString(cvtModelType);
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
                .append("Model #: ").append(cvtModelType).append("\n")
                .append("Key Specifications: ").append("\n")
                .append("\t*)Forward Gears: ").append(forwardGears).append("\n")
                .append("\t*)Gear Ratio: \n");
        printGearRatio(gearRatioBuilder);
        gearRatioBuilder.append("----------------------------------\n");
        return (initialBuilder.toString() + gearRatioBuilder.toString());
    }

}
