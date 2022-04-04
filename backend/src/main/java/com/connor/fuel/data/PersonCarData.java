package com.connor.fuel.data;

import com.connor.fuel.model.PersonCar;
import com.connor.fuel.controller.Logic;

import java.util.List;
import java.util.Map;

public class PersonCarData {
    public static PersonCar connorsCorolla = new PersonCar(
            "fergus.hitchcock@gmail.com",
            "AAA111",
            0.7f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar connorsAudiA4 = new PersonCar(
            "fergus.hitchcock@gmail.com",
            "BBB222",
            0.3f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar connorsDemio = new PersonCar(
            "fergus.hitchcock@gmail.com",
            "CCC333",
            0.5f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar connorsJetta = new PersonCar(
            "fergus.hitchcock@gmail.com",
            "DDD444",
            0.2f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar fathersBigHorn = new PersonCar(
            "fergus.hitchcock@xtra.co.nz",
            "EEE555",
            0.05f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar fathersCorolla = new PersonCar(
            "fergus.hitchcock@xtra.co.nz",
            "FFF666",
            0.05f,
            0.0f //TODO call login to calculate
    );

    public static PersonCar alexsSwift = new PersonCar(
            "alex.hobson@gmail.com",
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
