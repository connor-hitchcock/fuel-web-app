package com.connor.fuel.model;

import java.util.*;

public class CarDetail {
    public enum FuelType {
        PETROL91,
        PETROL95,
        PETROL100,
        DIESEL,
        HYBRID,
        ELECTRIC
    }

    /**
     * Converts the string equivalent of the FuelType enum to the FuelType enum.
     * @param fuelTypeStr the string version of the FuelType enum.
     * @return the FuelType enum
     */
    public static FuelType strToFuelType(String fuelTypeStr) {
        FuelType fuelType = null;
        if (Objects.equals(fuelTypeStr, "PETROL91")) {
            fuelType = FuelType.PETROL91;
        } else if (Objects.equals(fuelTypeStr, "PETROL95")) {
            fuelType = FuelType.PETROL95;
        } else if (Objects.equals(fuelTypeStr, "PETROL100")) {
            fuelType = FuelType.PETROL100;
        } else if (Objects.equals(fuelTypeStr, "DIESEL")) {
            fuelType = FuelType.DIESEL;
        } else if (Objects.equals(fuelTypeStr, "HYBRID")) {
            fuelType = FuelType.HYBRID;
        } else if (Objects.equals(fuelTypeStr, "ELECTRIC")) {
            fuelType = FuelType.ELECTRIC;
        }
        return fuelType;
    }

    /**
     * Converts the FuelType enum to the String equivalent.
     * @param fuelType the FuelType enum
     * @return the string version of the FuelType enum.
     */
    public static String fuelTypeToStr(FuelType fuelType) {
        String fuelTypeStr = null;
        if (fuelType.equals(FuelType.PETROL91)) {
            fuelTypeStr = "PETROL91";
        } else if (fuelType.equals(FuelType.PETROL95)) {
            fuelTypeStr = "PETROL95";
        } else if (fuelType.equals(FuelType.PETROL100)) {
            fuelTypeStr = "PETROL100";
        } else if (fuelType.equals(FuelType.DIESEL)) {
            fuelTypeStr = "DIESEL";
        } else if (fuelType.equals(FuelType.HYBRID)) {
            fuelTypeStr = "HYBRID";
        } else if (fuelType.equals(FuelType.ELECTRIC)) {
            fuelTypeStr = "ELECTRIC";
        }
        return fuelTypeStr;
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

    public CarDetail(String licensePlate, float engineSize, int horsepower, int torque, FuelType fuelType,
                     float fuelEcoUrban, float fuelEcoRural, String make, String model, int year, String country) {
        this.licensePlate = licensePlate;
        this.engineSize = engineSize;
        this.horsepower = horsepower;
        this.torque = torque;
        this.fuelType = fuelType;
        this.fuelEcoUrban = fuelEcoUrban;
        this.fuelEcoRural = fuelEcoRural;
        this.make = make;
        this.model = model;
        this.year = year;
        this.country = country;
    }

    /**
     * Creates a CarDetail object from a map of said object.
     * @param carDetailMap the map of a CarDetail object
     */
    public CarDetail(Map<String, Object> carDetailMap) {
        this.licensePlate = (String) carDetailMap.get("licensePlate");
        this.engineSize = (float) carDetailMap.get("engineSize");
        this.horsepower = (int) carDetailMap.get("horsepower");
        this.torque = (int) carDetailMap.get("torque");
        var fuelTypeStr = carDetailMap.get("fuelType").toString();
        this.fuelType = strToFuelType(fuelTypeStr);
        this.fuelEcoUrban = (float) carDetailMap.get("fuelEcoUrban");
        this.fuelEcoRural = (float) carDetailMap.get("fuelEcoRural");
        this.make = (String) carDetailMap.get("make");
        this.model = (String) carDetailMap.get("model");
        this.year = (int) carDetailMap.get("year");
        this.country = (String) carDetailMap.get("country");
    }

    /**
     * Converts a list of car detail mapped objects to a list of car detail objects
     * @param carDetails the list of car detail mapped objects
     * @return list of car detail objects
     */
    public static List<CarDetail> convertListCarDetailMapToObjects(List<Map<String, Object>> carDetails) {
        var carDetailsList = new ArrayList<CarDetail>();
        for (var carDetailMap: carDetails) {
            carDetailsList.add(new CarDetail(carDetailMap));
        }
        return carDetailsList;
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

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
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
        return String.format("%s %s %dHP %dnm %s %.1fL Engine, %.1fL/100km Urban, %.1fL/100km Rural",
                this.make, this.model, this.horsepower, this.torque, fuelTypeToStr(this.fuelType), this.engineSize, this.fuelEcoUrban, this.fuelEcoRural);
    }
}
