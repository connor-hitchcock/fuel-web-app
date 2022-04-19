package com.connor.fuel.controller;

import com.connor.fuel.model.CarDetail;
import com.connor.fuel.model.FuelPrice;
import com.connor.fuel.model.Person;
import com.connor.fuel.model.PersonCar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {
    /**
     * Sets up a connection to the local SQLite database
     * @return a active connection to the db.
     */
    public static Connection connect() {
        String url = "jdbc:sqlite:src/main/resources/database/fueldb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Closes the active connection to the database
     * @param conn the database
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Queries a database and returns the result of said query
     * @param query the sql query
     * @return the results of the query
     */
    public static ResultSet executeQuery(String query) {
        Connection conn = connect();
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return rs;
    }

    /**
     * Exectures sql on the database (usually to create a table or insert an entry)
     * @param sql the sql to be executed
     */
    public static void executeSQL(String sql) {
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
    }

    //-- Get Objects From DB -------------------------------------------------------------------------------------------
    /**
     * Sends a query to the SQLite db to retrieve all available entries inside the CarDetail table as objects.
     * @return a list of CarDetail objects.
     */
    public static List<CarDetail> getAllCarDetailsFromDB() {
        var conn = connect();
        String query = "Select * From CarDetail";
        var carDetails = new ArrayList<CarDetail>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                carDetails.add(new CarDetail(
                        rs.getString("licensePlate"),
                        rs.getFloat("engineSize"),
                        rs.getInt("horsepower"),
                        rs.getInt("torque"),
                        CarDetail.strToFuelType(rs.getString("fuelType")),
                        rs.getFloat("fuelEcoUrban"),
                        rs.getFloat("fuelEcoRural"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("country")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return carDetails;
    }

    /**
     * Sends a query to the SQLite db to retrieve all available entries inside the FuelPrice table as objects.
     * @return a list of FuelPrice objects.
     */
    public static List<FuelPrice> getAllFuelPricesFromDB() {
        var conn = connect();
        String query = "Select * From FuelPrice";
        var fuelPrices = new ArrayList<FuelPrice>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                fuelPrices.add(new FuelPrice(
                        rs.getString("country"),
                        rs.getFloat("petrol91"),
                        rs.getFloat("petrol95"),
                        rs.getFloat("petrol100"),
                        rs.getFloat("diesel"),
                        rs.getFloat("ruc"),
                        rs.getFloat("electric")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return fuelPrices;
    }

    /**
     * Sends a query to the SQLite db to retrieve all available entries inside the Person table as objects.
     * @return a list of Person objects.
     */
    public static List<Person> getAllPeopleFromDB() {
        var conn = connect();
        String query = "Select * From Person";
        var people = new ArrayList<Person>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                people.add(new Person(
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("middleName"),
                        rs.getString("lastName"),
                        rs.getInt("age"),
                        rs.getString("birthday")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return people;
    }

    /**
     * Sends a query to the SQLite db to retrieve all available entries inside the PersonCar table as objects.
     * @return a list of PersonCar objects.
     */
    public static List<PersonCar> getAllPersonCarsFromDB() {
        var conn = connect();
        String query = "Select * From PersonCar";
        var personCars = new ArrayList<PersonCar>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                personCars.add(new PersonCar(
                        rs.getString("email"),
                        rs.getString("licensePlate"),
                        rs.getFloat("urbanRuralRatio"),
                        rs.getFloat("fuelCost100km")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return personCars;
    }
}
