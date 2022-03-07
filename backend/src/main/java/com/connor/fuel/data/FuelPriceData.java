package com.connor.fuel.data;

import com.connor.fuel.model.FuelPrice;

import java.util.List;
import java.util.Map;

public class FuelPriceData {
    public static FuelPrice newZealand = new FuelPrice(
            "New Zealand",
            2.62f,
            2.70f,
            2.89f,
            1.87f,
            7.6f,
            0.2631f
    );

    public static List<FuelPrice> allFuelPrices = List.of(
            newZealand
    );

    public static List<Map<String, Object>> allFuelPricesMapped = List.of(
            newZealand.getFuelPriceMap()
    );
}
