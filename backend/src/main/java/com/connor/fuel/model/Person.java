package com.connor.fuel.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String birthday;

    public Person(String email, String username, String password, String firstName, String middleName,
                  String lastName, int age, String birthday) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
    }

    /**
     * Creates a Person object from a map of said object.
     * @param personMap the map of a Person object
     */
    public Person(Map<String, Object> personMap) {
        this.email = (String) personMap.get("email");
        this.username = (String) personMap.get("username");
        this.password = (String) personMap.get("password");
        this.firstName = (String) personMap.get("firstName");
        this.middleName = (String) personMap.get("middleName");
        this.lastName = (String) personMap.get("lastName");
        this.age = (int) personMap.get("age");
        this.birthday = (String) personMap.get("birthday");
    }

    public Map<String, Object> getPersonMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("username", username);
        map.put("password", password);
        map.put("firstName", firstName);
        map.put("middleName", middleName);
        map.put("lastName", lastName);
        map.put("age", age);
        map.put("birthday", birthday);
        return map;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s %s %s, %d, %s",
                this.email, this.username, this.password, this.firstName, this.middleName, this.lastName, this.age, this.birthday);
    }
}
