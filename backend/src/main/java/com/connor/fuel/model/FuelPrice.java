package com.connor.fuel.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuelPrice {
    private String country;
    private float petrol91; //currency per litre
    private float petrol95;
    private float petrol100;
    private float diesel;
    private float ruc; //currency per 100km (used in New Zealand)
    private float electric; //currency per kilowatt

    public FuelPrice(String country, float petrol91, float petrol95, float petrol100, float diesel, float ruc,
                     float electric) {
        this.country = country;
        this.petrol91 = petrol91;
        this.petrol95 = petrol95;
        this.petrol100 = petrol100;
        this.diesel = diesel;
        this.ruc = ruc;
        this.electric = electric;
    }

    /**
     * Creates a FuelPrice object from a map of said object.
     * @param fuelPriceMap the map of a FuelPrice object
     */
    public FuelPrice(Map<String, Object> fuelPriceMap) {
        this.country = (String) fuelPriceMap.get("country");
        this.petrol91 = (float) fuelPriceMap.get("petrol91");
        this.petrol95 = (float) fuelPriceMap.get("petrol95");
        this.petrol100 = (float) fuelPriceMap.get("petrol100");
        this.diesel = (float) fuelPriceMap.get("diesel");
        this.ruc = (float) fuelPriceMap.get("ruc");
        this.electric = (float) fuelPriceMap.get("electric");
    }

    /**
     * Converts a list of fuel price mapped objects to a list of fuel price objects
     * @param fuelPrices the list of car detail mapped objects
     * @return list of fuel price objects
     */
    public static List<FuelPrice> convertMapToList(List<Map<String, Object>> fuelPrices) {
        var fuelPriceList = new ArrayList<FuelPrice>();
        for (var fuelPriceMap: fuelPrices) {
            fuelPriceList.add(new FuelPrice(fuelPriceMap));
        }
        return fuelPriceList;
    }

    public Map<String, Object> getFuelPriceMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("country", country);
        map.put("petrol91", petrol91);
        map.put("petrol95", petrol95);
        map.put("petrol100", petrol100);
        map.put("diesel", diesel);
        map.put("ruc", ruc);
        map.put("electric", electric);
        return map;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getPetrol91() {
        return petrol91;
    }

    public void setPetrol91(float petrol91) {
        this.petrol91 = petrol91;
    }

    public float getPetrol95() {
        return petrol95;
    }

    public void setPetrol95(float petrol95) {
        this.petrol95 = petrol95;
    }

    public float getPetrol100() {
        return petrol100;
    }

    public void setPetrol100(float petrol100) {
        this.petrol100 = petrol100;
    }

    public float getDiesel() {
        return diesel;
    }

    public void setDiesel(float diesel) {
        this.diesel = diesel;
    }

    public float getRuc() {
        return this.ruc;
    }

    public void setRuc(float ruc) {
        this.ruc = ruc;
    }

    public float getElectric() {
        return electric;
    }

    public void setElectric(float electric) {
        this.electric = electric;
    }

    @Override
    public String toString() {
        return String.format("%s, Petrol 91: $%.2f, Petrol 95: $%.2f, Petrol 100: $%.2f, Diesel: $%.2f, RUC/100km: $%.2f, Electricity: $%.2f kWh",
                this.country, this.petrol91, this.petrol95, this.petrol100, this.diesel, this.ruc, this.electric);
    }
}
