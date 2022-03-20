package com.connor.fuel.controller;

import com.connor.fuel.model.CarDetail;
import com.connor.fuel.model.FuelPrice;

public class Logic {
    public static float calcCostPer100km(CarDetail carDetails, FuelPrice fuelPrices) {
        var costPer100km = 0.0f;
        var fuelType = carDetails.getFuelType();
        var fuelEcoUrban = carDetails.getFuelEcoUrban();
        var fuelEcoRural = carDetails.getFuelEcoRural();
        var urbanRuralRatio = 0.5f;

        if (fuelType == CarDetail.FuelType.PETROL91 ||
            fuelType == CarDetail.FuelType.PETROL95 ||
            fuelType == CarDetail.FuelType.PETROL100) {
            costPer100km = calcCostPetrolPer100km(fuelPrices, fuelType, fuelEcoUrban, fuelEcoRural, urbanRuralRatio);
        } else if (fuelType == CarDetail.FuelType.DIESEL) {
            costPer100km = calcCostDieselPer100km(fuelPrices, fuelEcoUrban, fuelEcoRural, urbanRuralRatio);
        }

        return costPer100km;
        //TODO handle Electric
    }

    public static float calcCostPetrolPer100km(FuelPrice fuelPrices, CarDetail.FuelType fuelType, float fuelEcoUrban,
                                               float fuelEcoRural, float urbanRuralRatio) {
        var fuelPrice = 0.0f;
        if (fuelType == CarDetail.FuelType.PETROL91) {
            fuelPrice = fuelPrices.getPetrol91();
        } else if (fuelType == CarDetail.FuelType.PETROL95) {
            fuelPrice = fuelPrices.getPetrol95();
        } else if (fuelType == CarDetail.FuelType.PETROL100) {
            fuelPrice = fuelPrices.getPetrol100();
        }

        var urbanCost = fuelPrice * (fuelEcoUrban * urbanRuralRatio);
        var ruralCost = fuelPrice * (fuelEcoRural * (1 - urbanRuralRatio));
        return urbanCost + ruralCost;
    }

    public static float calcCostDieselPer100km(FuelPrice fuelPrices, float fuelEcoUrban, float fuelEcoRural,
                                               float urbanRuralRatio) {
        var fuelPrice = fuelPrices.getDiesel();
        var ruc = fuelPrices.getRuc();

        var urbanCost = fuelPrice * (fuelEcoUrban * urbanRuralRatio);
        var ruralCost = fuelPrice * (fuelEcoRural * (1 - urbanRuralRatio));
        return urbanCost + ruralCost + ruc;
    }
}
