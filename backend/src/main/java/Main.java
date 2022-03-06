import data.CarDetailsData;
import data.FuelPricesData;
import model.CarDetails;

import static controller.Logic.calcCostPer100km;

public class Main {

    public static void main(String[] args) {
        for (CarDetails car: CarDetailsData.allCars) {
            var costPer100km = calcCostPer100km(car, FuelPricesData.newZealand);
            System.out.printf("Fuel Cost: $%.2f " + car + "\n", costPer100km);
        }
    }
}
