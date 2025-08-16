package com.lukxtech.powertrain.enginefamily;

import com.lukxtech.powertrain.enginefamily.engines.cng.CNGEngine;
import com.lukxtech.powertrain.enginefamily.engines.petrol.PetrolEngine;
import com.lukxtech.powertrain.enginefamily.engines.diesel.DieselEngine;
import com.lukxtech.powertrain.enginefamily.engines.electric.ElectricEngine;

public class EngineImpl {
    public static void main(String[] args) {
        // DIESEL ENGINE MANUAL TESTING
        DieselEngine dieselEngine = new DieselEngine.Builder()
                .modelNo("LUKX-DI_96CFKX")
                .modelName("Halloween Weed")
                .displacement(2998)
                .cetaneNumber(58)
                .minPower(10)
                .maxPower(180)
                .maxRPM(4500)
                .cetaneNumber(48)
                .turbochargerType("variable_geometry")
                .fuelPumpType("inline")
                .glowPlugCount(2)
                .isParticulateFilterPresent(false)
                .exhaustGasRecirculationState("OFF")
                .build();

        System.out.println(dieselEngine);


        // PETROL ENGINE MANUAL TESTING
        PetrolEngine petrolEngine = new PetrolEngine.Builder()
                .modelNo("LUKX-PF-82YELF")
                .modelName("Across the Rubicon")
                .displacement(3000)
                .minPower(50)
                .maxPower(200)
                .maxRPM(5000)
                .octaneRating(93)
                .fuelInjectionType("multi_point_injection")
                .emissionStandardCompliance("VI")
                .catalyticConverterType(3)
                .build();
        System.out.println(petrolEngine);


        // ELECTRIC ENGINE MANUAL TESTING
        ElectricEngine electricEngine = new ElectricEngine.Builder()
                .modelNo("LUKX-EY-96TSLA")
                .modelName("Dreamy White Maiden")
                .displacement(6000)
                .minPower(100)
                .maxPower(200)
                .maxRPM(15000)
                .voltage(400)
                .batteryCapacityKWh(75.0)
                .electricMotorType("brushless_dc")
                .chargingTimeHours(1, 8)
                .regenerativeBrakingEfficiencyPercent(76.4d)
                .electricMotorThermalManagementType("passive")
                .rangePerChargeKm(350)
                .stateOfChargePercent(84.2d)
                .build();
        System.out.println(electricEngine);


        // CNG ENGINE MANUAL TESTING
        CNGEngine cngEngine = new CNGEngine.Builder()
                .modelNo("LUKX-CNG-21AUTO")
                .modelName("Reckless Cowboy")
                .displacement(1000)
                .minPower(60)
                .maxPower(100)
                .maxRPM(3000)
                .gasTankCapacityKg(10d)
                .gasInjectionType("venturi")
                .isBiFuel(false)
                .cylinderPressureBar(580)
                .CNGRefuelingConnectorType("type_1")
                .maxAllowedTemperatureC(102.6)
                .build();

        System.out.println(cngEngine);
    }
}
