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
     * Sends a query to the SQLite db to retrieve all available entries inside the Person table as mapped objects.
     * @return a list of Person mapped objects.
     */
    public static List<Map<String, Object>> getAllPeopleFromDB(boolean getOwnedCars, boolean getCar, boolean getFuelPrice) {
        var conn = connect();
        var query = "Select * From Person";
        var people = new ArrayList<Map<String, Object>>();
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                var personMap = convertResultSetToPersonMap(rs);
                if (getOwnedCars) {
                    var ownedCars = getAllPersonCarsFromDB((String) personMap.get("email"), getCar, getFuelPrice);
                    personMap.put("ownedCars", ownedCars);
                }
                people.add(personMap);
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
    public static List<Map<String, Object>> getAllPersonCarsFromDB(String email, boolean getCar, boolean getFuelPrice) {
        var conn = connect();
        var query = "Select * From PersonCar";
        if (email != null) {
            query += String.format(" Where email = '%s'", email); //TODO vulnerable to SQL injection
        }
        var personCars = new ArrayList<Map<String, Object>>();
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                var personCarMap = convertResultSetToPersonCarMap(rs);
                if (getCar) {
                    var car = getAllCarDetailsFromDB((String) personCarMap.get("licensePlate"), getFuelPrice).get(0);
                    personCarMap.put("car", car);
                }
                personCars.add(personCarMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return personCars;
    }

    /**
     * Sends a query to the SQLite db to retrieve all available entries inside the CarDetail table as mapped objects.
     * @return a list of CarDetail mapped objects.
     */
    public static List<Map<String, Object>> getAllCarDetailsFromDB(String licensePlate, boolean getFuelPrice) {
        var conn = connect();
        var query = "Select * From CarDetail";
        if (licensePlate != null) {
            query += String.format(" Where licensePlate = '%s'", licensePlate); //TODO vulnerable to SQL injection
        }
        var carDetails = new ArrayList<Map<String, Object>>();
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                var carDetailsMap = convertResultSetToCarDetailMap(rs);
                if (getFuelPrice) {
                    var fuelPrice = getAllFuelPricesFromDB((String) carDetailsMap.get("country")).get(0);
                    carDetailsMap.put("fuelPrice", fuelPrice);
                }
                carDetails.add(carDetailsMap);
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
    public static List<Map<String, Object>> getAllFuelPricesFromDB(String country) {
        var conn = connect();
        var query = "Select * From FuelPrice";
        if (country != null) {
            query += String.format(" Where country = '%s'", country); //TODO vulnerable to SQL injection
        }
        var fuelPrices = new ArrayList<Map<String, Object>>();
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                fuelPrices.add(convertResultSetToFuelPriceMap(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return fuelPrices;
    }

    /**
     * Converts a results set containing a person object to a map of said object.
     * @param rs the result set
     * @return a map of a person object
     */
    public static Map<String, Object> convertResultSetToPersonMap(ResultSet rs) {
        var map = new HashMap<String, Object>();
        try {
            map.put("email", rs.getString("email"));
            map.put("username", rs.getString("username"));
            map.put("password", rs.getString("password"));
            map.put("firstName", rs.getString("firstName"));
            map.put("middleName", rs.getString("middleName"));
            map.put("lastName", rs.getString("lastName"));
            map.put("age", rs.getInt("age"));
            map.put("birthday", rs.getString("birthday"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Converts a results set containing a person car object to a map of said object.
     * @param rs the result set
     * @return a map of a person car object
     */
    public static Map<String, Object> convertResultSetToPersonCarMap(ResultSet rs) {
        var map = new HashMap<String, Object>();
        try {
            map.put("email", rs.getString("email"));
            map.put("licensePlate", rs.getString("licensePlate"));
            map.put("urbanRuralRatio", rs.getFloat("urbanRuralRatio"));
            map.put("fuelCost100km", rs.getFloat("fuelCost100km"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Converts a results set containing a car detail object to a map of said object.
     * @param rs the result set
     * @return a map of a car detail object
     */
    public static Map<String, Object> convertResultSetToCarDetailMap(ResultSet rs) {
        var map = new HashMap<String, Object>();
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Converts a results set containing a fuel price object to a map of said object.
     * @param rs the result set
     * @return a map of a fuel price object
     */
    public static Map<String, Object> convertResultSetToFuelPriceMap(ResultSet rs) {
        var map = new HashMap<String, Object>();
        try {
            map.put("country", rs.getString("country"));
            map.put("petrol91", rs.getFloat("petrol91"));
            map.put("petrol95", rs.getFloat("petrol95"));
            map.put("petrol100", rs.getFloat("petrol100"));
            map.put("diesel", rs.getFloat("diesel"));
            map.put("ruc", rs.getFloat("ruc"));
            map.put("electric", rs.getFloat("electric"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Updates the fuel costs of all the vehicles based on the most recent data. Supposed to be run when the GraphQL API
     * firsts starts
     */
    public static void updateFuelCosts() {
        var conn = connect();
        var allPersonCars = PersonCar.convertMapToList(DatabaseController.getAllPersonCarsFromDB(null, false, false));
        try {
            var stmt = conn.createStatement();
            for (var personCar: allPersonCars) {
                var getCarQuery = String.format("SELECT * FROM CarDetail WHERE CarDetail.licensePlate == \"%s\"",
                        personCar.getLicensePlate()); //TODO Change! SQL injection is possible
                var rs = stmt.executeQuery(getCarQuery);
                if (!rs.next()) { throw new NullPointerException("No license plate"); }
                var carDetail = new CarDetail(convertResultSetToCarDetailMap(rs));
                var getFuelPriceQuery = String.format("SELECT * FROM FuelPrice WHERE FuelPrice.country == \"%s\"",
                        carDetail.getCountry()); //TODO Change! SQL injection is possible
                rs = stmt.executeQuery(getFuelPriceQuery);
                if (!rs.next()) { throw new NullPointerException("No country"); }
                var fuelPrice = new FuelPrice(convertResultSetToFuelPriceMap(rs));
                var costPer100km = Logic.calcCostPer100km(carDetail, fuelPrice, personCar.getUrbanRuralRatio());
                var newFuelPriceSQL = String.format("UPDATE PersonCar SET fuelCost100km = %.2f "
                        + "WHERE email == \"%s\" AND licensePlate == \"%s\"",
                        costPer100km, personCar.getEmail(), personCar.getLicensePlate());
                stmt.execute(newFuelPriceSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
    }
}
