package com.lukxtech.enginefamily.engines.electric;

import com.lukxtech.enginefamily.abstracts.AbstractEngineBuilder;
import com.lukxtech.enginefamily.abstracts.AbstractEngineModel;
import com.lukxtech.enginefamily.engines.electric.enums.ElectricMotorThermalManagementType;
import com.lukxtech.enginefamily.engines.electric.enums.ElectricMotorType;
import com.lukxtech.enginefamily.engines.electric.exceptions.InvalidRegenerativeBrakingEfficiencyPercentException;
import com.lukxtech.enginefamily.engines.electric.exceptions.BadChargeTimeHoursParameterException;
import com.lukxtech.enginefamily.engines.electric.exceptions.BadBatteryCapacityValueException;
import com.lukxtech.enginefamily.engines.electric.exceptions.BadRangePerChargeValueException;
import com.lukxtech.enginefamily.engines.electric.exceptions.BadStateOfChargeValueException;
import com.lukxtech.enginefamily.engines.electric.exceptions.BadVoltageValueException;
import com.lukxtech.enginefamily.engines.electric.exceptions.InvalidElectricMotorThermalManagementTypeException;
import com.lukxtech.enginefamily.engines.electric.exceptions.InvalidElectricMotorTypeException;
import com.lukxtech.enginefamily.engines.electric.records.ChargingTimeHours;
import com.lukxtech.enginefamily.interfaces.ElectricVehicleInterface;

public class ElectricEngine extends AbstractEngineModel implements ElectricVehicleInterface {
    private int voltage;
    private double batteryCapacityKWh;
    private ElectricMotorType electricMotorType;
    private ChargingTimeHours chargingTimeHours;
    private double regenerativeBrakingEfficiencyPercent;
    private ElectricMotorThermalManagementType electricMotorThermalManagementType;
    private int rangePerChargeKm;
    private double stateOfChargePercent;

    @Deprecated
    public ElectricEngine(String modelNo,
                          String modelName,
                          int displacement,
                          int minPower,
                          int maxPower,
                          int maxRPM,
                          int voltage,
                          double batteryCapacityKWh,
                          ElectricMotorType electricMotorType,
                          ChargingTimeHours chargingTimeHours,
                          double regenerativeBrakingEfficiencyPercent,
                          ElectricMotorThermalManagementType electricMotorThermalManagementType,
                          int rangePerChargeKm,
                          double stateOfChargePercent
    ) {
        super(modelNo, modelName, displacement, minPower, maxPower, maxRPM);
        this.voltage = voltage;
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.electricMotorType = electricMotorType;
        this.chargingTimeHours = chargingTimeHours;
        this.regenerativeBrakingEfficiencyPercent = regenerativeBrakingEfficiencyPercent;
        this.electricMotorThermalManagementType = electricMotorThermalManagementType;
        this.rangePerChargeKm = rangePerChargeKm;
        this.stateOfChargePercent = stateOfChargePercent;
    }

    @Deprecated
    public ElectricEngine(String modelNo,
                          String modelName,
                          int displacement,
                          int minPower,
                          int maxPower,
                          int maxRPM,
                          int voltage,
                          double batteryCapacityKWh,
                          String electricMotorType,
                          int fastChargingTime,
                          int slowChargingTime,
                          double regenerativeBrakingEfficiencyPercent,
                          String electricMotorThermalManagementType,
                          int rangePerChargeKm,
                          double stateOfChargePercent
    ) throws InvalidElectricMotorTypeException, BadChargeTimeHoursParameterException, InvalidElectricMotorThermalManagementTypeException{
        super(modelNo, modelName, displacement, minPower, maxPower, maxRPM);
        this.voltage = voltage;
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.electricMotorType = ElectricMotorType.fromString(electricMotorType);
        this.chargingTimeHours = new ChargingTimeHours(fastChargingTime, slowChargingTime);
        this.regenerativeBrakingEfficiencyPercent = regenerativeBrakingEfficiencyPercent;
        this.electricMotorThermalManagementType = ElectricMotorThermalManagementType.fromString(electricMotorThermalManagementType);
        this.rangePerChargeKm = rangePerChargeKm;
        this.stateOfChargePercent = stateOfChargePercent;
    }

    public static class Builder extends AbstractEngineBuilder<ElectricEngine, Builder>{
        private Integer voltage;
        private Double batteryCapacityKWh;
        private ElectricMotorType electricMotorType;
        private ChargingTimeHours chargingTimeHours;
        private Double regenerativeBrakingEfficiencyPercent;
        private ElectricMotorThermalManagementType electricMotorThermalManagementType;
        private Integer rangePerChargeKm;
        private Double stateOfChargePercent;

        public Builder voltage(int voltage){
            this.voltage = voltage;
            return this;
        }

        public Builder batteryCapacityKWh(double batteryCapacityKWh){
            this.batteryCapacityKWh = batteryCapacityKWh;
            return this;
        }

        public Builder electricMotorType(ElectricMotorType electricMotorType){
            this.electricMotorType = electricMotorType;
            return this;
        }

        public Builder electricMotorType(String electricMotorType) throws InvalidElectricMotorTypeException{
            this.electricMotorType = ElectricMotorType.fromString(electricMotorType);
            return this;
        }

        public Builder chargingTimeHours(ChargingTimeHours chargingTimeHours){
            this.chargingTimeHours = chargingTimeHours;
            return this;
        }

        public Builder chargingTimeHours(int fastChargingTime, int slowChargingTime) throws BadChargeTimeHoursParameterException{
            this.chargingTimeHours = new ChargingTimeHours(fastChargingTime, slowChargingTime);
            return this;
        }

        public Builder regenerativeBrakingEfficiencyPercent(double regenerativeBrakingEfficiencyPercent){
            this.regenerativeBrakingEfficiencyPercent = regenerativeBrakingEfficiencyPercent;
            return this;
        }

        public Builder electricMotorThermalManagementType(ElectricMotorThermalManagementType electricMotorThermalManagementType){
            this.electricMotorThermalManagementType = electricMotorThermalManagementType;
            return this;
        }

        public Builder electricMotorThermalManagementType(String electricMotorThermalManagementType) throws InvalidElectricMotorThermalManagementTypeException{
            this.electricMotorThermalManagementType = ElectricMotorThermalManagementType.fromString(electricMotorThermalManagementType);
            return this;
        }

        public Builder rangePerChargeKm(int rangePerChargeKm){
            this.rangePerChargeKm = rangePerChargeKm;
            return this;
        }

        public Builder stateOfChargePercent(double stateOfChargePercent){
            this.stateOfChargePercent = stateOfChargePercent;
            return this;
        }


        @Override
        public Builder self() {
            return this;
        }
        @Override
        public void validate() {
            validate_initial();

            if ((voltage == null) || (voltage < 0)) throw new BadVoltageValueException("ALERT! BAD VOLTAGE VALUE! GOT: " + voltage);
            if((batteryCapacityKWh == null) || (batteryCapacityKWh < 0))    throw new BadBatteryCapacityValueException("ALERT! BAD BATTERY CAPACITY VALUE! GOT: " + batteryCapacityKWh);
            if(electricMotorType == null)   throw new InvalidElectricMotorTypeException("ALERT! ELECTRIC MOTOR TYPE NOT SPECIFIED! NULL_EXCEPTION");
            if(chargingTimeHours == null)   throw new BadChargeTimeHoursParameterException("ALERT! CHARGING TIME HOURS NOT SPECIFIED! GOT: " + chargingTimeHours);
            if(regenerativeBrakingEfficiencyPercent == null)    throw new InvalidRegenerativeBrakingEfficiencyPercentException("ALERT! REGENERATIVE BRAKING EFFICIENCY NOT SPECIFIED! NULL_EXCEPTION");
            if(electricMotorThermalManagementType == null)      throw new InvalidElectricMotorThermalManagementTypeException("ALERT! ELECTRIC MOTOR THERMAL MANAGEMENT TYPE NOT SPECIFIED! NULL_EXCEPTION");
            if(rangePerChargeKm == null || rangePerChargeKm < 0)    throw new BadRangePerChargeValueException("ALERT! INVALID RANGE PER CHARGE VALUE! GOT: " + rangePerChargeKm);
            if(stateOfChargePercent == null || stateOfChargePercent < 0 || stateOfChargePercent > 100)  throw new BadStateOfChargeValueException("ALERT! INVALID STATE OF CHARGE VALUE! GOT: " + stateOfChargePercent);
        }
        @Override
        public ElectricEngine build() {
            validate();
            return new ElectricEngine(
                    modelNo,
                    modelName,
                    displacement,
                    minPower,
                    maxPower,
                    maxRPM,
                    voltage,
                    batteryCapacityKWh,
                    electricMotorType,
                    chargingTimeHours,
                    regenerativeBrakingEfficiencyPercent,
                    electricMotorThermalManagementType,
                    rangePerChargeKm,
                    stateOfChargePercent);
        }
    }

    @Override
    public String getModelNo() {
        return super.getModelNo();
    }
    @Override
    public int getDisplacement() {
        return super.getDisplacement();
    }
    @Override
    public int getMinPower() {
        return super.getMinPower();
    }
    @Override
    public int getMaxPower() {
        return super.getMaxPower();
    }
    @Override
    public int getMaxRPM() {
        return super.getMaxRPM();
    }
    @Override
    public void setModelNo(String modelNo) {
        super.setModelNo(modelNo);
    }
    @Override
    public void setDisplacement(int displacement) {
        super.setDisplacement(displacement);
    }
    @Override
    public void setMinPower(int minPower) {
        super.setMinPower(minPower);
    }
    @Override
    public void setMaxPower(int maxPower) {
        super.setMaxPower(maxPower);
    }
    @Override
    public void setMaxRPM(int maxRPM) {
        super.setMaxRPM(maxRPM);
    }
    public int getVoltage() {
        return voltage;
    }
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    public double getBatteryCapacityKWh() {
        return batteryCapacityKWh;
    }
    public void setBatteryCapacityKWh(double batteryCapacityKWh) {
        this.batteryCapacityKWh = batteryCapacityKWh;
    }
    public ElectricMotorType getElectricMotorType() {
        return electricMotorType;
    }
    public void setElectricMotorType(ElectricMotorType electricMotorType) {
        this.electricMotorType = electricMotorType;
    }
    public ChargingTimeHours getChargingTimeHours() {
        return chargingTimeHours;
    }
    public void setChargingTimeHours(ChargingTimeHours chargingTimeHours) {
        this.chargingTimeHours = chargingTimeHours;
    }
    public double getRegenerativeBrakingEfficiencyPercent() {
        return regenerativeBrakingEfficiencyPercent;
    }
    public void setRegenerativeBrakingEfficiencyPercent(double regenerativeBrakingEfficiencyPercent) {
        this.regenerativeBrakingEfficiencyPercent = regenerativeBrakingEfficiencyPercent;
    }
    public ElectricMotorThermalManagementType getElectricMotorThermalManagementType() {
        return electricMotorThermalManagementType;
    }
    public void setElectricMotorThermalManagementType(ElectricMotorThermalManagementType electricMotorThermalManagementType) {
        this.electricMotorThermalManagementType = electricMotorThermalManagementType;
    }
    public int getRangePerChargeKm() {
        return rangePerChargeKm;
    }
    public void setRangePerChargeKm(int rangePerChargeKm) {
        this.rangePerChargeKm = rangePerChargeKm;
    }
    public double getStateOfChargePercent() {
        return stateOfChargePercent;
    }
    public void setStateOfChargePercent(double stateOfChargePercent) {
        this.stateOfChargePercent = stateOfChargePercent;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        return builder.append("--------------------------------------------\n")
                .append("Model No: ").append(modelNo).append("\n")
                .append("Model Name: ").append(modelName).append("\n")
                .append("Displacement: ").append(displacement).append("\n")
                .append("Min. Power: ").append(minPower).append("\n")
                .append("Max. Power: ").append(maxPower).append("\n")
                .append("Max RPM: ").append(maxRPM).append("\n")
                .append("Voltage: ").append(voltage).append("\n")
                .append("Battery Capacity (KWh): ").append(batteryCapacityKWh).append("\n")
                .append("Electric Motor Type: ").append(electricMotorType).append("\n")
                .append("Charging Time(Hours): ").append(chargingTimeHours).append("\n")
                .append("Regenerative Braking Efficiency (%): ").append(regenerativeBrakingEfficiencyPercent).append("\n")
                .append("Thermal Management Type: ").append(electricMotorThermalManagementType).append("\n")
                .append("Range per Charge (KM): ").append(rangePerChargeKm).append("\n")
                .append("State of Charge (%): ").append(stateOfChargePercent).append("\n")
                .append("--------------------------------------------\n")
                .toString();
    }
}
