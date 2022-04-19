package com.connor.fuel.data;

import com.connor.fuel.model.Person;

import java.util.List;
import java.util.Map;

import static com.connor.fuel.data.PersonCarData.*;

public class PersonData {
    public static Person connorHitchcock = new Person(
            "fergus.hitchcock@gmail.com",
            "guchii",
            "null",
            "Connor",
            "Fergus",
            "Hitchcock",
            23,
            "17-07-1999"
    );

    public static Person connorsFather = new Person(
            "fergus.hitchcock@xtra.co.nz",
            "fergusHitchcock",
            "null",
            "Fergus",
            "Paul",
            "Hitchcock",
            49,
            "29-04-1973"
    );

    public static Person alexHobson = new Person(
            "alex.hobson@gmail.com",
            "alexHobson",
            "null",
            "Alex",
            "Middlename",
            "Hobson",
            23,
            "01-01-1999"
    );

    public static List<Person> allPeople = List.of(
            connorHitchcock, connorsFather, alexHobson
    );

    public static List<Map<String, Object>> allPeopleMapped = List.of(
            connorHitchcock.getPersonMap(), connorsFather.getPersonMap(), alexHobson.getPersonMap()
    );
}
