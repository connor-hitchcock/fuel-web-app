package com.connor.fuel.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private int personID;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String birthday;
    private List<PersonCar> personCars;

    public Person(int personID, String firstName, String middleName, String lastName, int age, String birthday,
                  List<PersonCar> personCars) {
        this.personID = personID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
        this.personCars = personCars;
    }

    public Map<String, Object> getPersonMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("personID", personID);
        map.put("firstName", firstName);
        map.put("middleName", middleName);
        map.put("lastName", lastName);
        map.put("age", age);
        map.put("birthday", birthday);
        map.put("personCars", personCars);
        return map;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<PersonCar> getPersonCars() {
        return personCars;
    }

    public void setPersonCars(List<PersonCar> personCars) {
        this.personCars = personCars;
    }
}
