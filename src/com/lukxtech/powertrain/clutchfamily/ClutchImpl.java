package com.lukxtech.powertrain.clutchfamily;

import com.lukxtech.powertrain.clutchfamily.clutches.dual.DualClutch;
import com.lukxtech.powertrain.clutchfamily.clutches.electronicbased.electromagnetic.ElectroMagneticClutch;
import com.lukxtech.powertrain.clutchfamily.clutches.electronicbased.electronic.ElectronicClutch;
import com.lukxtech.powertrain.clutchfamily.clutches.hydraulic.HydraulicClutch;
import com.lukxtech.powertrain.clutchfamily.clutches.platebased.multiplate.MultiPlateClutch;
import com.lukxtech.powertrain.clutchfamily.clutches.platebased.singleplate.SinglePlateClutch;

public class ClutchImpl {
    public static void main(String[] args) {
        // SINGLE PLATE CLUTCH MANUAL TESTING
        SinglePlateClutch spc = new SinglePlateClutch.Builder()
                .modelNumber("LUKX-CLUTCH-SPC21")
                .clutchType("single_plate_clutch")
                .clutchMaterialComposition("organic")
                .numberOfPlates(1)
                .actuatorType("mechanical")
                .coolingType("wet")
                .torqueCapacityNM(5400)
                .frictionDiameterMM(554)
                .serviceLifeCycles(9999999)
                .build();

        System.out.println(spc);


        // MULTI PLATE CLUTCH MANUAL TESTING
        MultiPlateClutch mpc = new MultiPlateClutch.Builder()
                .modelNumber("LUKX-CLUTCH-MPC15")
                .torqueCapacityNM(5400)
                .clutchType("multi_plate_clutch")
                .clutchMaterialComposition("organic")
                .frictionDiameterMM(554)
                .serviceLifeCycles(9999999)
                .numberOfPlates(2)
                .actuatorType("mechanical")
                .coolingType("wet")
                .build();

        System.out.println(mpc);


        // HYDRAULIC CLUTCH MANUAL TESTING
        HydraulicClutch hc = new HydraulicClutch.Builder()
                .modelNumber("LUKX-CLUTCH-HC211")
                .clutchType("hydraulic_clutch")
                .torqueCapacityNM(3200)
                .clutchMaterialComposition("ceramic")
                .frictionDiameterMM(255)
                .serviceLifeCycles(100000)
                .fluidType("dot4")
                .actuationType("hydraulic")
                .coolingType("dry")
                .build();

        System.out.println(hc);


        // DUAL CLUTCH MANUAL TESTING
        DualClutch dc = new DualClutch.Builder()
                .modelNumber("LUKX-CLUTCH-DC782")
                .clutchType("dual_clutch")
                .torqueCapacityNM(3200)
                .clutchMaterialComposition("ceramic")
                .frictionDiameterMM(255)
                .serviceLifeCycles(100000)
                .actuationType("hydraulic")
                .coolingType("dry")
                .numberOfClutch(2)
                .engagementTimeMS(54)
                .build();

        System.out.println(dc);


        // ELECTRONIC CLUTCH MANUAL TESTING
        ElectronicClutch ec = new ElectronicClutch.Builder()
                .modelNumber("LUKX-CLUTCH-DC782")
                .clutchType("electronic_clutch")
                .torqueCapacityNM(3200)
                .clutchMaterialComposition("ceramic")
                .frictionDiameterMM(255)
                .serviceLifeCycles(100000)
                .actuationType("hydraulic")
                .coolingType("dry")
                .controlModuleVersion("CMV-1.1.5+build_28")
                .build();

        System.out.println(ec);


        // ELECTROMAGNETIC CLUTCH MANUAL TESTING
        ElectroMagneticClutch emc = new ElectroMagneticClutch.Builder()
                .modelNumber("LUKX-CLUTCH-SPC21")
                .clutchType("electromagnetic_clutch")
                .torqueCapacityNM(3200)
                .clutchMaterialComposition("organic")
                .actuationType("mechanical")
                .frictionDiameterMM(554)
                .serviceLifeCycles(200000)
                .coolingType("wet")
                .magneticCoilPowerW(4500)
                .responseTimeMS(10)
                .voltageRating(220)
                .build();

        System.out.println(emc);
    }
}
