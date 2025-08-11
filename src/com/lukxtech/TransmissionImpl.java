package com.lukxtech;

import com.lukxtech.parts.transmissionfamily.transmissions.amt.AutomatedManualTransmission;
import com.lukxtech.parts.transmissionfamily.transmissions.cvt.ContinuouslyVariableTransmission;
import com.lukxtech.parts.transmissionfamily.transmissions.dct.DualClutchTransmission;
import com.lukxtech.parts.transmissionfamily.transmissions.manual.ManualTransmission;

import java.util.ArrayList;
import java.util.List;

public class TransmissionImpl {
    public static void main(String[] args) {
        // MANUAL TRANSMISSION MANUAL TESTING
        ArrayList<Double> manualTransmissionGearRatio = new ArrayList<>(
                List.of(2.54, 1.92, 1.51, 1.0)
        );
        ManualTransmission manualTransmission = new ManualTransmission.Builder()
                .transmissionType("manual")
                .manualModelType("mp4")
                .forwardGears(4)
                .gearRatioList(manualTransmissionGearRatio)
                .build();
        System.out.println(manualTransmission);


        // AMT MANUAL TESTING
        ArrayList<Double> amtTransmissionGearRatio = new ArrayList<>(
                List.of(2.54, 1.92, 1.51, 1.0)
        );
        AutomatedManualTransmission amtTransmission = new AutomatedManualTransmission.Builder()
                .transmissionType("amt")
                .amtModelType("amtp4")
                .forwardGears(4)
                .gearRatioList(amtTransmissionGearRatio)
                .build();
        System.out.println(amtTransmission);


        // CVT MANUAL TESTING
        ArrayList<Double> cvtTransmissionGearRatio = new ArrayList<>(
                List.of(2.54, 1.92, 1.51, 1.0)
        );
        ContinuouslyVariableTransmission cvtTransmission = new ContinuouslyVariableTransmission.Builder()
                .transmissionType("cvt")
                .cvtModelType("cvt6")
                .forwardGears(4)
                .gearRatioList(cvtTransmissionGearRatio)
                .build();
        System.out.println(cvtTransmission);


        // DCT MANUAL TESTING
        ArrayList<Double> dctTransmissionGearRatio = new ArrayList<>(
                List.of(4.71, 3.14, 2.10, 1.66, 1.28, 1d, 0.83, 0.66)
        );
        DualClutchTransmission dctTransmission = new DualClutchTransmission.Builder()
                .transmissionType("dct")
                .dctModelType("dct8")
                .forwardGears(8)
                .gearRatioList(dctTransmissionGearRatio)
                .build();
        System.out.println(dctTransmission);
    }
}
