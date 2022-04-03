package com.connor.fuel;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.connor.fuel.authentication.JWTHandler;
import com.connor.fuel.data.CarDetailData;
import com.connor.fuel.data.FuelPriceData;
import com.connor.fuel.model.CarDetail;

import java.util.HashMap;

import static com.connor.fuel.controller.Logic.calcCostPer100km;

public class Main {
    public static void printAllCarDetails() {
        for (CarDetail car: CarDetailData.allCarsDetails) {
            var costPer100km = calcCostPer100km(car, FuelPriceData.newZealand, 0.5f);
            System.out.printf("Fuel Cost: $%.2f " + car + "\n", costPer100km);
        }
    }

    public static void main(String[] args) {
        JWTHandler jwtHandler = new JWTHandler();
        var payload = new HashMap<String, String>();
        payload.put("msg", "Hello World");
        String token = jwtHandler.createSignJWT(payload);
        System.out.printf("Created Token: %s\n", token);
        DecodedJWT verifiedToken = jwtHandler.verifyJWT(token);
        System.out.printf("Verified Token: %s\n", verifiedToken.getPayload());
        DecodedJWT decodedToken = jwtHandler.decodeJWT(token);
        System.out.printf("Decoded Token: %s\n", decodedToken.getPayload());
    }
}
