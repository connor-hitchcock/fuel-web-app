package com.connor.fuel.data;

import com.connor.fuel.model.PersonCar;
import com.connor.fuel.controller.Logic;

import java.util.List;
import java.util.Map;

public class PersonCarData {
    public static PersonCar connorsCorolla = new PersonCar(
            1,
            "AAA111",
            0.7f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar connorsAudiA4 = new PersonCar(
            1,
            "BBB222",
            0.3f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar connorsDemio = new PersonCar(
            1,
            "CCC333",
            0.5f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar connorsJetta = new PersonCar(
            1,
            "DDD444",
            0.2f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar fathersBigHorn = new PersonCar(
            2,
            "EEE555",
            0.05f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar fathersCorolla = new PersonCar(
            2,
            "FFF666",
            0.05f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar alexsSwift = new PersonCar(
            3,
            "GGG777",
            0.9f,
            0.0f //TODO call login to calculate
    );

    public static List<PersonCar> allPersonCars = List.of(
            connorsCorolla, connorsAudiA4, connorsDemio, connorsJetta, fathersBigHorn, fathersCorolla, alexsSwift
    );

    public static List<Map<String, Object>> allPersonCarsMapped = List.of(
            connorsCorolla.getPersonCarsMap(), connorsAudiA4.getPersonCarsMap(), connorsDemio.getPersonCarsMap(),
            connorsJetta.getPersonCarsMap(), fathersBigHorn.getPersonCarsMap(), fathersCorolla.getPersonCarsMap(),
            alexsSwift.getPersonCarsMap()
    );
}
