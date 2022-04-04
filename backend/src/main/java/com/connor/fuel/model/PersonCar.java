package com.connor.fuel.model;

import java.util.HashMap;
import java.util.Map;

public class PersonCar {
    private String email;
    private String licensePlate;
    private float urbanRuralRatio;
    private float fuelCost100km;

    public PersonCar(String email, String licensePlate, float urbanRuralRatio, float fuelCost100km) {
        this.email = email;
        this.licensePlate = licensePlate;
        this.urbanRuralRatio = urbanRuralRatio;
        this.fuelCost100km = fuelCost100km;
    }

    public Map<String, Object> getPersonCarsMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("licensePlate", licensePlate);
        map.put("urbanRuralRatio", urbanRuralRatio);
        map.put("fuelCost100km", fuelCost100km);
        return map;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getUrbanRuralRatio() {
        return urbanRuralRatio;
    }

    public void setUrbanRuralRatio(float urbanRuralRatio) {
        this.urbanRuralRatio = urbanRuralRatio;
    }

    public float getFuelCost100km() {
        return fuelCost100km;
    }

    public void setFuelCost100km(float fuelCost100km) {
        this.fuelCost100km = fuelCost100km;
    }
}
