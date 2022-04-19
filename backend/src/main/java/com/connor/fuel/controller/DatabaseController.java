package com.connor.fuel.controller;

import com.connor.fuel.model.CarDetail;
import com.connor.fuel.model.FuelPrice;
import com.connor.fuel.model.Person;
import com.connor.fuel.model.PersonCar;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Sends a query to the SQLite db to retrieve all available entries inside the CarDetail table as mapped objects.
     * @return a list of CarDetail mapped objects.
     */
    public static List<Map<String, Object>> getAllCarDetailsFromDB() {
        var conn = connect();
        var query = "Select * From CarDetail";
        var carDetails = new ArrayList<Map<String, Object>>();
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                var map = new HashMap<String, Object>();
                map.put("licensePlate", rs.getString("licensePlate"));
                map.put("engineSize", rs.getFloat("engineSize"));
                map.put("horsepower", rs.getInt("horsepower"));
                map.put("torque", rs.getInt("torque"));
                map.put("fuelType", CarDetail.strToFuelType(rs.getString("fuelType")));
                map.put("fuelEcoUrban", rs.getFloat("fuelEcoUrban"));
                map.put("fuelEcoRural", rs.getFloat("fuelEcoRural"));
                map.put("make", rs.getString("make"));
                map.put("model", rs.getString("model"));
                map.put("year", rs.getInt("year"));
                map.put("country", rs.getString("country"));
                carDetails.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return carDetails;
    }

    /**
     * Sends a query to the SQLite db to retrieve all available entries inside the FuelPrice table as mapped objects.
     * @return a list of FuelPrice mapped objects.
     */
    public static List<Map<String, Object>> getAllFuelPricesFromDB() {
        var conn = connect();
        var query = "Select * From FuelPrice";
        var fuelPrices = new ArrayList<Map<String, Object>>();
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                var map = new HashMap<String, Object>();
                map.put("country", rs.getString("country"));
                map.put("petrol91", rs.getFloat("petrol91"));
                map.put("petrol95", rs.getFloat("petrol95"));
                map.put("petrol100", rs.getFloat("petrol100"));
                map.put("diesel", rs.getFloat("diesel"));
                map.put("ruc", rs.getFloat("ruc"));
                map.put("electric", rs.getFloat("electric"));
                fuelPrices.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return fuelPrices;
    }

    /**
     * Sends a query to the SQLite db to retrieve all available entries inside the Person table as mapped objects.
     * @return a list of Person mapped objects.
     */
    public static List<Map<String, Object>> getAllPeopleFromDB() {
        var conn = connect();
        var query = "Select * From Person";
        var people = new ArrayList<Map<String, Object>>();
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                var map = new HashMap<String, Object>();
                map.put("email", rs.getString("email"));
                map.put("username", rs.getString("username"));
                map.put("password", rs.getString("password"));
                map.put("firstName", rs.getString("firstName"));
                map.put("middleName", rs.getString("middleName"));
                map.put("lastName", rs.getString("lastName"));
                map.put("age", rs.getInt("age"));
                map.put("birthday", rs.getString("birthday"));
                people.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return people;
    }

    /**
     * Sends a query to the SQLite db to retrieve all available entries inside the PersonCar table as mapped objects.
     * @return a list of PersonCar mapped objects.
     */
    public static List<Map<String, Object>> getAllPersonCarsFromDB() {
        var conn = connect();
        var query = "Select * From PersonCar";
        var personCars = new ArrayList<Map<String, Object>>();
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                var map = new HashMap<String, Object>();
                map.put("email", rs.getString("email"));
                map.put("licensePlate", rs.getString("licensePlate"));
                map.put("urbanRuralRatio", rs.getFloat("urbanRuralRatio"));
                map.put("fuelCost100km", rs.getFloat("fuelCost100km"));
                personCars.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return personCars;
    }
}
