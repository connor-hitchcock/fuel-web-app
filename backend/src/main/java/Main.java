import data.CarDetailData;
import data.FuelPriceData;
import model.CarDetail;

import static controller.Logic.calcCostPer100km;

public class Main {

    public static void main(String[] args) {
        for (CarDetail car: CarDetailData.allCarsDetails) {
            var costPer100km = calcCostPer100km(car, FuelPriceData.newZealand);
            System.out.printf("Fuel Cost: $%.2f " + car + "\n", costPer100km);
        }
    }
}
