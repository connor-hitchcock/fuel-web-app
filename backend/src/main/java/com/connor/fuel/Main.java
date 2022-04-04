package com.connor.fuel;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.connor.fuel.authentication.JWTHandler;
import com.connor.fuel.authentication.PasswordHash;
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

    public static void jwtTesting() {
        JWTHandler jwtHandler = new JWTHandler();
        var payload = new HashMap<String, String>();
        payload.put("msg", "Hello World");
        String token = jwtHandler.createSignJWT(payload);
        System.out.printf("Created Token: %s\n", token);
        DecodedJWT verifiedToken = jwtHandler.verifyJWT(token);
        System.out.printf("Verified Token: %s\n", verifiedToken.getPayload());
        String decodedPayload = jwtHandler.decodeJWTPayload(verifiedToken);
        System.out.printf("Decoded Payload: %s\n", decodedPayload);
    }

    public static void passwordHashingTesting() {
        String badPassword = "ThisIsAGoodPassword69#";
        String hashedPassword = PasswordHash.hashPasswordSHA256(badPassword);
        System.out.printf("Original password: %s\n", badPassword);
        System.out.printf("Hashed password: %s\n", hashedPassword);
        boolean samePassword = PasswordHash.checkPasswordMatchesHash(badPassword, hashedPassword);
        System.out.printf("Same password (should be true): %s\n", samePassword);
        boolean samePasswordFalse = PasswordHash.checkPasswordMatchesHash("NotTheSamePassword", hashedPassword);
        System.out.printf("Same password 2 (should be false): %s\n", samePasswordFalse);
    }

    public static void main(String[] args) {
        passwordHashingTesting();
    }
}
