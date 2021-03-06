package com.connor.fuel;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.connor.fuel.authentication.JWTHandler;
import com.connor.fuel.authentication.PasswordHash;
import com.connor.fuel.controller.DatabaseController;
import com.connor.fuel.model.CarDetail;
import com.connor.fuel.model.FuelPrice;
import com.connor.fuel.model.Person;
import com.connor.fuel.model.PersonCar;

import java.util.HashMap;

public class Main {

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

//    public static void databaseTesting() {
//        var carDetailResults = DatabaseController.getAllCarDetailsFromDB();
//        System.out.println("All Car Details:");
//        for (CarDetail carDetail: carDetailResults) {
//            System.out.println(carDetail);
//        }
//        System.out.println("-----------------------------------------------------------------------------------------");
//        var fuelPriceDetails = DatabaseController.getAllFuelPricesFromDB();
//        System.out.println("All Fuel Price Details:");
//        for (FuelPrice fuelPrice: fuelPriceDetails) {
//            System.out.println(fuelPrice);
//        }
//        System.out.println("-----------------------------------------------------------------------------------------");
//        var personDetails = DatabaseController.getAllPeopleFromDB();
//        System.out.println("All Person Details:");
//        for (Person person: personDetails) {
//            System.out.println(person);
//        }
//        System.out.println("-----------------------------------------------------------------------------------------");
//        var personCarDetails = DatabaseController.getAllPersonCarsFromDBList();
//        System.out.println("All Person Car Details:");
//        for (PersonCar personCar: personCarDetails) {
//            System.out.println(personCar);
//        }
//        System.out.println("-----------------------------------------------------------------------------------------");
//    }

    public static void databaseTesting() {
        var personDetails = DatabaseController.getAllPeopleFromDB(true, true, true);
        for (var personMap: personDetails) {
            var person = new Person(personMap);
            System.out.println(person);
        }
        System.out.println("\n-----------------------------------------------------------------------------------------");

        var personCarDetails = DatabaseController.getAllPersonCarsFromDB(null, true, true);
        System.out.println("All Person Car Details:");
        for (var personCarMap: personCarDetails) {
            var personCar = new PersonCar(personCarMap);
            System.out.println(personCar);
        }
        System.out.println("\n-----------------------------------------------------------------------------------------");

        var carDetailDetails = DatabaseController.getAllCarDetailsFromDB(null, true);
        System.out.println("All Car Details:");
        for (var carDetailMap: carDetailDetails) {
            var carDetail = new CarDetail(carDetailMap);
            System.out.println(carDetail);
        }
        System.out.println("\n-----------------------------------------------------------------------------------------");

        var fuelPriceDetails = DatabaseController.getAllFuelPricesFromDB(null);
        for (var fuelPriceMap: fuelPriceDetails) {
            var fuelPrice = new FuelPrice(fuelPriceMap);
            System.out.println(fuelPrice);
        }
        System.out.println("\n-----------------------------------------------------------------------------------------");

    }

    public static void main(String[] args) {
        databaseTesting();
    }
}
