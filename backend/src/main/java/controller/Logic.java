package controller;

import model.CarDetails;
import model.FuelPrices;

public class Logic {
    public static float calcCostPer100km(CarDetails carDetails, FuelPrices fuelPrices) {
        var costPer100km = 0.0f;
        var fuelType = carDetails.getFuelType();
        var fuelEcoUrban = carDetails.getFuelEcoUrban();
        var fuelEcoRural = carDetails.getFuelEcoRural();

        //Case 1: Petrol
        if (fuelType == CarDetails.FuelType.PETROL91 ||
            fuelType == CarDetails.FuelType.PETROL95 ||
            fuelType == CarDetails.FuelType.PETROL100) {
            costPer100km = calcCostPetrolPer100km(fuelPrices, fuelType, fuelEcoUrban, fuelEcoRural);
        } else if (fuelType == CarDetails.FuelType.DIESEL) {
            costPer100km = calcCostDieselPer100km(fuelPrices, fuelEcoUrban, fuelEcoRural);
        }

        //Case 2: Diesel
        return costPer100km;
        //TODO handle Electric
    }

    public static float calcCostPetrolPer100km(FuelPrices fuelPrices, CarDetails.FuelType fuelType, float fuelEcoUrban,
                                               float fuelEcoRural) {
        var fuelPrice = 0.0f;
        if (fuelType == CarDetails.FuelType.PETROL91) {
            fuelPrice = fuelPrices.getPetrol91();
        } else if (fuelType == CarDetails.FuelType.PETROL95) {
            fuelPrice = fuelPrices.getPetrol95();
        } else if (fuelType == CarDetails.FuelType.PETROL100) {
            fuelPrice = fuelPrices.getPetrol100();
        }

        var urbanCost100km = fuelPrice * fuelEcoUrban;
        var ruralCost100km = fuelPrice * fuelEcoRural;

        //Temporary just taking an average
        return (urbanCost100km + ruralCost100km) / 2;
    }

    public static float calcCostDieselPer100km(FuelPrices fuelPrices, float fuelEcoUrban, float fuelEcoRural) {
        var fuelPrice = fuelPrices.getDiesel();
        var ruc = fuelPrices.getRuc();

        var urbanCost100km = fuelPrice * fuelEcoUrban + ruc;
        var ruralCost100km = fuelPrice * fuelEcoRural + ruc;

        //Temporary just taking an average
        return (urbanCost100km + ruralCost100km) / 2;
    }
}
