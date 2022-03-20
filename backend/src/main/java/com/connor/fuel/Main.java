package com.connor.fuel;

import com.connor.fuel.data.CarDetailData;
import com.connor.fuel.data.FuelPriceData;
import com.connor.fuel.model.CarDetail;

import static com.connor.fuel.controller.Logic.calcCostPer100km;

public class Main {

    public static void main(String[] args) {
        for (CarDetail car: CarDetailData.allCarsDetails) {
            var costPer100km = calcCostPer100km(car, FuelPriceData.newZealand, 0.5f);
            System.out.printf("Fuel Cost: $%.2f " + car + "\n", costPer100km);
        }
    }
}
