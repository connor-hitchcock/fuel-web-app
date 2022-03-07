package model;

import java.util.HashMap;
import java.util.Map;

public class CarDetail {
    public enum FuelType {
        PETROL91,
        PETROL95,
        PETROL100,
        DIESEL,
        HYBRID,
        ELECTRIC
    }

    private String licensePlate;    //unique and non-null primary identifier, the car's license plate
    private float engineSize;       //engine displacement in litres
    private int horsepower;         //engine horsepower
    private int torque;             //engine torque
    private FuelType fuelType;      //the fuel the engine takes
    private float fuelEcoUrban;     //fuel economy l/100km in the city
    private float fuelEcoRural;     //fuel economy l/100km on the highway
    private String make;            //the make of the car e.g. Toyota
    private String model;           //the model of the car e.g. Corolla
    private int year;               //the year the car was made
    private String country;         //the country the car is driven in

    public CarDetail(String licensePlate, float engineSize, int horsePower, int torque, FuelType fuelType,
                     float fuelEcoUrban, float fuelEcoRural, String make, String model, int year, String country) {
        this.licensePlate = licensePlate;
        this.engineSize = engineSize;
        this.horsepower = horsePower;
        this.torque = torque;
        this.fuelType = fuelType;
        this.fuelEcoUrban = fuelEcoUrban;
        this.fuelEcoRural = fuelEcoRural;
        this.make = make;
        this.model = model;
        this.year = year;
        this.country = country;
    }

    public Map<String, Object> getCarDetailMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("licensePlate", licensePlate);
        map.put("engineSize", engineSize);
        map.put("horsepower", horsepower);
        map.put("torque", torque);
        map.put("fuelType", fuelType);
        map.put("fuelEcoUrban", fuelEcoUrban);
        map.put("fuelEcoRural", fuelEcoRural);
        map.put("make", make);
        map.put("model", model);
        map.put("year", year);
        map.put("country", country);
        return map;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(float engineSize) {
        this.engineSize = engineSize;
    }

    public int getHorsePower() {
        return horsepower;
    }

    public void setHorsePower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public float getFuelEcoUrban() {
        return fuelEcoUrban;
    }

    public void setFuelEcoUrban(int fuelEcoUrban) {
        this.fuelEcoUrban = fuelEcoUrban;
    }

    public float getFuelEcoRural() {
        return fuelEcoRural;
    }

    public void setFuelEcoRural(int fuelEcoRural) {
        this.fuelEcoRural = fuelEcoRural;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("%s %s %dHP %dnm %.1fL Engine, %.1fL/100km Urban, %.1fL/100km Rural",
                this.make, this.model, this.horsepower, this.torque, this.engineSize, this.fuelEcoUrban, this.fuelEcoRural);
    }
}
