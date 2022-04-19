package com.connor.fuel.controller;

import com.connor.fuel.model.CarDetail;
import com.connor.fuel.model.FuelPrice;
import com.connor.fuel.model.PersonCar;

import java.util.Objects;

public class Logic {
    public static float calcCostPer100km(CarDetail carDetails, FuelPrice fuelPrices, float urbanRuralRatio) {
        var costPer100km = 0.0f;
        var fuelType = carDetails.getFuelType();
        var fuelEcoUrban = carDetails.getFuelEcoUrban();
        var fuelEcoRural = carDetails.getFuelEcoRural();

        if (fuelType != CarDetail.FuelType.ELECTRIC) {
            costPer100km = calcCostFossilFuel100km(fuelPrices, fuelType, fuelEcoUrban, fuelEcoRural, urbanRuralRatio);
        } else {
            //TODO handle electric vehicles
        }
        return costPer100km;
    }

    public static float calcCostFossilFuel100km(FuelPrice fuelPrices, CarDetail.FuelType fuelType, float fuelEcoUrban,
                                          float fuelEcoRural, float urbanRuralRatio) {
        var fuelPrice = 0.0f;
        var costPer100km = 0.0f;
        if (fuelType == CarDetail.FuelType.DIESEL) {
            fuelPrice = fuelPrices.getDiesel();
            costPer100km += fuelPrices.getRuc();
        } else if (fuelType == CarDetail.FuelType.PETROL91) {
            fuelPrice = fuelPrices.getPetrol91();
        } else if (fuelType == CarDetail.FuelType.PETROL95) {
            fuelPrice = fuelPrices.getPetrol95();
        } else if (fuelType == CarDetail.FuelType.PETROL100) {
            fuelPrice = fuelPrices.getPetrol100();
        }

        var urbanCost = fuelPrice * (fuelEcoUrban * urbanRuralRatio);
        var ruralCost = fuelPrice * (fuelEcoRural * (1 - urbanRuralRatio));
        costPer100km += urbanCost + ruralCost;
        return costPer100km;
    }
}
