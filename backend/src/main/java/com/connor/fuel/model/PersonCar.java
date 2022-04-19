package com.connor.fuel.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    /**
     * Creates a PersonCar object from a map of said object.
     * @param personCarMap the map of a PersonCar object
     */
    public PersonCar(Map<String, Object> personCarMap) {
        this.email = (String) personCarMap.get("email");
        this.licensePlate = (String) personCarMap.get("licensePlate");
        this.urbanRuralRatio = (float) personCarMap.get("urbanRuralRatio");
        this.fuelCost100km = (float) personCarMap.get("fuelCost100km");
    }

    /**
     * Converts a list of person car mapped objects to a list of person car objects
     * @param personCars the list of person car mapped objects
     * @return list of person car objects
     */
    public static List<PersonCar> convertMapToList(List<Map<String, Object>> personCars) {
        var personCarsList = new ArrayList<PersonCar>();
        for (var personCarMap: personCars) {
            personCarsList.add(new PersonCar(personCarMap));
        }
        return personCarsList;
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

    @Override
    public String toString() {
        return String.format("%s, %s, Urban/Rural ratio: %.2f, Cost/100km: $%.2f",
                this.email, this.licensePlate, this.urbanRuralRatio, this.fuelCost100km);
    }
}
